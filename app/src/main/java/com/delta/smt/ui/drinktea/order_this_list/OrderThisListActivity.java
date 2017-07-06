package com.delta.smt.ui.drinktea.order_this_list;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.drinktea.ShopList;
import com.delta.smt.entity.drinktea.ShopListResult;
import com.delta.smt.ui.drinktea.order_this.OrderThisActivity;
import com.delta.smt.ui.drinktea.order_this_list.di.DaggerOrderThisListComponent;
import com.delta.smt.ui.drinktea.order_this_list.di.OrderThisListModule;
import com.delta.smt.ui.drinktea.order_this_list.mvp.OrderThisListContract;
import com.delta.smt.ui.drinktea.order_this_list.mvp.OrderThisListPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.makeramen.roundedimageview.RoundedImageView;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;
import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/5/14.
 */

public class OrderThisListActivity extends BaseActivity<OrderThisListPresenter> implements OrderThisListContract.View, SuperBaseAdapter.OnItemClickListener<ShopListResult.ListBean>, SuperRecyclerView.LoadingListener {

    @BindView(R.id.toolbar)
    FindToolBar toolBar;
    @BindView(R.id.mRecyclerView)
    SuperRecyclerView mRecyclerView;
    Gson gson = new GsonBuilder().
            registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

                @Override
                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src == src.longValue())
                        return new JsonPrimitive(src.longValue());
                    return new JsonPrimitive(src);
                }
            }).create();
    int indexPage = 2;
    private List<ShopListResult.ListBean> dataSource = new ArrayList<>();
    private SuperBaseAdapter<ShopListResult.ListBean> mAdapter;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerOrderThisListComponent.builder()
                .appComponent(appComponent)
                .orderThisListModule(new OrderThisListModule(this)) //请将OrderThisListModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolBar.setToolbarTitle("预约本店");
        toolBar.setToolbarLeftButton(R.mipmap.start_page_exit);
        mAdapter = new SuperBaseAdapter<ShopListResult.ListBean>(this, dataSource) {
            @Override
            protected void convert(BaseViewHolder holder, ShopListResult.ListBean item, int position) {
                holder.setText(R.id.tv_order_other_name, item.getMerchant().getShop_title());
                holder.setText(R.id.tv_order_other_status, "本店");
                holder.setText(R.id.tv_other_address, item.getMerchant().getShop_address());
                holder.setText(R.id.tv_other_distance, "<100m");
                holder.setText(R.id.tv_order_other_price, item.getPrice());
                RoundedImageView iv = holder.getView(R.id.iv_order_other_item_picture);
                //iv.setCornerRadius((float) 10);
                //iv.setBorderWidth((float) 0);
                Glide.with(OrderThisListActivity.this).load(dataSource.get(position).getImage_url()).thumbnail(0.1f).placeholder(R.mipmap.picture).crossFade().into(iv);
            }

            @Override
            protected int getItemViewLayoutId(int position, ShopListResult.ListBean item) {

                return R.layout.item_order_other_list;

            }
        };
        //mAdapter.setOnItemClickListener(OrderOtherListActivity.this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(OrderThisListActivity.this));
        mRecyclerView.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        mRecyclerView.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义上拉加载的样式
        // superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);//设置下拉箭头
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLoadingListener(this);
        mAdapter.setOnItemClickListener(this);
        getPresenter().getShopList(SpUtil.getStringSF(OrderThisListActivity.this, Constant.TOKEN), SpUtil.getStringSF(OrderThisListActivity.this, Constant.MERCHANTID), "1", "10", "", "1", Constant.NOMAL);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_order_this_list;
    }


    @Override
    public void onGetShopListSuccess(ShopList shopList) {
        dataSource.clear();
        ShopListResult shopListResult = gson.fromJson(gson.toJson(shopList.getResult()), ShopListResult.class);
        dataSource.addAll(shopListResult.getList());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetShopListFailed(ShopList shopList) {
        if (!TextUtils.isEmpty(shopList.getApp_msg())) {
            ToastUtils.showMessage(OrderThisListActivity.this, shopList.getApp_msg());
        }
    }

    @Override
    public void onGetShopListFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(OrderThisListActivity.this, throwable.getMessage());
        }
        mRecyclerView.completeLoadMore();
        mRecyclerView.completeRefresh();
    }

    @Override
    public void onGetShopListLoadMoreSuccess(ShopList shopList) {
        indexPage++;
        ShopListResult shopListResult = gson.fromJson(gson.toJson(shopList.getResult()), ShopListResult.class);
        dataSource.addAll(shopListResult.getList());
        mAdapter.notifyDataSetChanged();
        mRecyclerView.completeLoadMore();
        if (shopListResult.getList().size() == 0) {
            ToastUtils.showMessage(this, "已经到达最底部！");
            indexPage--;
        }
    }

    @Override
    public void onGetShopListLoadMorefailed(ShopList shopList) {
        ToastUtils.showMessage(this, "加载更多失败！");
        mRecyclerView.completeLoadMore();
    }

    @Override
    public void onGetShopListRefreshSuccess(ShopList shopList) {
        indexPage = 2;
        dataSource.clear();
        ShopListResult shopListResult = gson.fromJson(gson.toJson(shopList.getResult()), ShopListResult.class);
        dataSource.addAll(shopListResult.getList());
        mAdapter.notifyDataSetChanged();
        mRecyclerView.completeRefresh();
    }

    @Override
    public void onGetShopListRefreshfailed(ShopList shopList) {
        ToastUtils.showMessage(this, "列表刷新失败！");
        mRecyclerView.completeRefresh();
    }

    @OnClick({R.id.toolbar_left_button_arl})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                OrderThisListActivity.this.finish();
                break;
        }
    }

    @Override
    public void onItemClick(View view, ShopListResult.ListBean item, int position) {
        IntentUtils.showIntent(OrderThisListActivity.this, OrderThisActivity.class, new String[]{"shop_id"}, new String[]{item.getId() + ""});
    }

    @Override
    public void onRefresh() {
        getPresenter().getShopList(SpUtil.getStringSF(OrderThisListActivity.this, Constant.TOKEN), SpUtil.getStringSF(OrderThisListActivity.this, Constant.MERCHANTID), "1", "10", "", "1", Constant.PUllTOREFRESH);
    }

    @Override
    public void onLoadMore() {
        getPresenter().getShopList(SpUtil.getStringSF(OrderThisListActivity.this, Constant.TOKEN), SpUtil.getStringSF(OrderThisListActivity.this, Constant.MERCHANTID), indexPage + "", "10", "", "1", Constant.UPLOADMORE);
    }
}