package com.delta.smt.ui.drinktea.order_other_list;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

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
import com.delta.smt.ui.drinktea.choose_address.ChooseAddressActivity;
import com.delta.smt.ui.drinktea.order_other_list.di.DaggerOrderOtherListComponent;
import com.delta.smt.ui.drinktea.order_other_list.di.OrderOtherListModule;
import com.delta.smt.ui.drinktea.order_other_list.mvp.OrderOtherListContract;
import com.delta.smt.ui.drinktea.order_other_list.mvp.OrderOtherListPresenter;
import com.delta.smt.ui.drinktea.write_order_info.WriteOrderInfoActivity;
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
import com.zhy.autolayout.AutoRelativeLayout;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/4/20.
 */

public class OrderOtherListActivity extends BaseActivity<OrderOtherListPresenter> implements OrderOtherListContract.View, SuperBaseAdapter.OnItemClickListener<ShopListResult.ListBean>, SuperRecyclerView.LoadingListener {

    @BindView(R.id.mRecyclerView)
    SuperRecyclerView mRecyclerView;

    @BindView(R.id.toolbar)
    FindToolBar toolBar;

    @BindView(R.id.arl_now_address)
    AutoRelativeLayout arlNowAddress;

    @BindView(R.id.et_shop_name_search)
    EditText etShopNameSearch;
    int indexPage = 2;
    Gson gson = new GsonBuilder().
            registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

                @Override
                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src == src.longValue())
                        return new JsonPrimitive(src.longValue());
                    return new JsonPrimitive(src);
                }
            }).create();
    private List<ShopListResult.ListBean> dataSource = new ArrayList<>();
    private SuperBaseAdapter<ShopListResult.ListBean> mAdapter;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerOrderOtherListComponent.builder()
                .appComponent(appComponent)
                .orderOtherListModule(new OrderOtherListModule(this)) //请将OrderOtherListModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolBar.setToolbarTitle("预约其他店");
        toolBar.setToolbarLeftButton(R.mipmap.start_page_exit);
        mAdapter = new SuperBaseAdapter<ShopListResult.ListBean>(this, dataSource) {
            @Override
            protected void convert(BaseViewHolder holder, ShopListResult.ListBean item, int position) {
                holder.setText(R.id.tv_order_other_name, item.getMerchant().getShop_title());
                holder.setText(R.id.tv_order_other_status, "");
                holder.setText(R.id.tv_other_address, item.getMerchant().getShop_address());
                holder.setText(R.id.tv_other_distance, "<100m");
                holder.setText(R.id.tv_order_other_price, item.getPrice());
                RoundedImageView iv = holder.getView(R.id.iv_order_other_item_picture);
                //iv.setCornerRadius((float) 10);
                //iv.setBorderWidth((float) 0);
                Glide.with(OrderOtherListActivity.this).load(dataSource.get(position).getImage_url()).thumbnail(0.1f).placeholder(R.mipmap.picture).crossFade().into(iv);
            }

            @Override
            protected int getItemViewLayoutId(int position, ShopListResult.ListBean item) {

                return R.layout.item_order_other_list;

            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(OrderOtherListActivity.this));
        mRecyclerView.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        mRecyclerView.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义上拉加载的样式
        // superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);//设置下拉箭头
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLoadingListener(this);
        mAdapter.setOnItemClickListener(this);

        etShopNameSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER /*&& !etShopNameSearch.getText().toString().equals("") */ && event.getAction() == KeyEvent.ACTION_UP) {
                    getPresenter().getShopList(SpUtil.getStringSF(OrderOtherListActivity.this, Constant.TOKEN), SpUtil.getStringSF(OrderOtherListActivity.this, Constant.MERCHANTID), "1", "10", etShopNameSearch.getText().toString(), "0", Constant.NOMAL);
                    return true;
                }
                return false;
            }
        });

        etShopNameSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    getPresenter().getShopList(SpUtil.getStringSF(OrderOtherListActivity.this, Constant.TOKEN), SpUtil.getStringSF(OrderOtherListActivity.this, Constant.MERCHANTID), "1", "10", etShopNameSearch.getText().toString(), "0", Constant.NOMAL);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        getPresenter().getShopList(SpUtil.getStringSF(OrderOtherListActivity.this, Constant.TOKEN), SpUtil.getStringSF(OrderOtherListActivity.this, Constant.MERCHANTID), "1", "10", etShopNameSearch.getText().toString(), "0", Constant.NOMAL);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_order_other;
    }


    @OnClick({R.id.toolbar_left_button_arl, R.id.arl_now_address})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                OrderOtherListActivity.this.finish();
                break;
            case R.id.arl_now_address:
                IntentUtils.showIntent(OrderOtherListActivity.this, ChooseAddressActivity.class);
                break;
        }
    }

    @Override
    public void onItemClick(View view, ShopListResult.ListBean item, int position) {
        Intent intent = new Intent(OrderOtherListActivity.this, WriteOrderInfoActivity.class);
        intent.putExtra("image_url", item.getImage_url());
        intent.putExtra("tea_shop_name", item.getMerchant().getShop_title());
        //
        intent.putExtra("this_shop", "");
        intent.putExtra("address", item.getMerchant().getShop_address());
        intent.putExtra("distance", "<100m");
        intent.putExtra("price", item.getPrice());
        intent.putExtra("shop_id", item.getId() + "");
        startActivity(intent);
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
            ToastUtils.showMessage(OrderOtherListActivity.this, shopList.getApp_msg());
        }
    }

    @Override
    public void onGetShopListFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(OrderOtherListActivity.this, throwable.getMessage());
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

    @Override
    public void onRefresh() {
        getPresenter().getShopList(SpUtil.getStringSF(OrderOtherListActivity.this, Constant.TOKEN), SpUtil.getStringSF(OrderOtherListActivity.this, Constant.MERCHANTID), "1", "10", etShopNameSearch.getText().toString(), "0", Constant.PUllTOREFRESH);
    }

    @Override
    public void onLoadMore() {
        getPresenter().getShopList(SpUtil.getStringSF(OrderOtherListActivity.this, Constant.TOKEN), SpUtil.getStringSF(OrderOtherListActivity.this, Constant.MERCHANTID), indexPage + "", "10", etShopNameSearch.getText().toString(), "0", Constant.UPLOADMORE);
    }
}