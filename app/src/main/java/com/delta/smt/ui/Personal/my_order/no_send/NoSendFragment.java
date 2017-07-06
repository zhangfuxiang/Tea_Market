package com.delta.smt.ui.Personal.my_order.no_send;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.commonlibs.widget.statusLayout.StatusLayout;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseFragment;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemNOSend;
import com.delta.smt.ui.Personal.my_order.no_send.di.DaggerNoSendComponent;
import com.delta.smt.ui.Personal.my_order.no_send.di.NoSendModule;
import com.delta.smt.ui.Personal.my_order.no_send.mvp.NoSendContract;
import com.delta.smt.ui.Personal.my_order.no_send.mvp.NoSendPresenter;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;
import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

public class NoSendFragment extends BaseFragment<NoSendPresenter> implements NoSendContract.View, SuperRecyclerView.LoadingListener {



    @BindView(R.id.ry_no_send)
    SuperRecyclerView mRyNoSend;
    @BindView(R.id.sl)
    StatusLayout mSl;

    private List<ItemNOSend.ResultBean.ListBean> datas_out = new ArrayList<>();
    private SuperBaseAdapter<ItemNOSend.ResultBean.ListBean> mAdapter_out;
    private List<ItemNOSend.ResultBean.ListBean.OrderProductBean> datas_in = new ArrayList<>();
    private SuperBaseAdapter<ItemNOSend.ResultBean.ListBean.OrderProductBean> mAdapter_in;

    private String token;
    private String pay_status= "2";
    private int page = 1;
    private int size = 10;
    private int total;
    @Override
    public void onResume() {
        Log.e("aaa", "onResume:Nosend ");
        page = 1;
        getPresenter().getNoSendList(token,pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);
        super.onResume();
    }


    @Override
    protected void initData() {
        token = SpUtil.getStringSF(getContext(), Constant.TOKEN);
        getPresenter().getNoSendList(token,pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);

    }

    @Override
    protected void initView() {

        mAdapter_out = new SuperBaseAdapter<ItemNOSend.ResultBean.ListBean>(getContext(), datas_out) {
            @Override
            protected void convert(BaseViewHolder holder, ItemNOSend.ResultBean.ListBean item, int position) {
                int num = 0;
                for (ItemNOSend.ResultBean.ListBean.OrderProductBean mOrderProductBean : item.getOrder_product()) {
                    num += mOrderProductBean.getNum();
                }

                holder.setText(R.id.tv_stats, " 等待商家发货");
                holder.setText(R.id.tv_count_number, "共" + num + "件商品 合计:");
                holder.setText(R.id.tv_money, "￥" + item.getProduct_total_money());
                holder.setText(R.id.tv_shop_name, item.getMerchant_title());


                TextView tv_left = holder.getView(R.id.tv_left_button);
                TextView tv_right = holder.getView(R.id.tv_right_button);
                tv_left.setVisibility(View.INVISIBLE);
                tv_right.setVisibility(View.INVISIBLE);


                datas_in.clear();
                datas_in.addAll(item.getOrder_product());
                createInRv(holder);
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemNOSend.ResultBean.ListBean item) {
                return R.layout.item_my_order_out;
            }
        };
        mRyNoSend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRyNoSend.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        mRyNoSend.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        mRyNoSend.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
        mRyNoSend.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//可以自定义上拉加载的样式
        // superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);//设置下拉箭头
        mRyNoSend.setLoadingListener(this);
        mRyNoSend.setAdapter(mAdapter_out);
    }


    private void createInRv(BaseViewHolder holder) {
        RecyclerView mRyNoPayin = holder.getView(R.id.purchase_in_rv);

        mAdapter_in = new SuperBaseAdapter<ItemNOSend.ResultBean.ListBean.OrderProductBean>(getContext(), datas_in) {
            @Override
            protected void convert(BaseViewHolder holder, ItemNOSend.ResultBean.ListBean.OrderProductBean item, int position) {
                holder.setText(R.id.tv_price, "￥ " + item.getPrice());
                holder.setText(R.id.tv_num, "X " + item.getNum());
                holder.setText(R.id.tv_name, item.getProduct().getTitle());
                ImageView image = holder.getView(R.id.iv_image);
                Glide.with(getContext()).load(item.getProduct().getImages().get(0).getUrl()).into(image);
                Log.e("aaa", "NoSend: " + item.getProduct().getImages().get(0).getUrl());
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemNOSend.ResultBean.ListBean.OrderProductBean item) {
                return R.layout.item_order_detail;
            }
        };

        mRyNoPayin.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRyNoPayin.setAdapter(mAdapter_in);
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerNoSendComponent.builder()
                .appComponent(appComponent)
                .noSendModule(new NoSendModule(this)) //请将NoSendModule()第一个首字母改为小写
                .build()
                .inject(this);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_no_send;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showMessage(String message) {
        ToastUtils.showMessage(getActivity(), message);
    }

    @Override
    public void getNoSendList(ItemNOSend.ResultBean NOsendData) {

        datas_out.clear();

        total=NOsendData.getTotal();

        loadData(NOsendData.getList());

        mRyNoSend.completeRefresh();
    }

    @Override
    public void loadSucess(ItemNOSend.ResultBean NOsendData) {

        loadData(NOsendData.getList());
        mRyNoSend.completeLoadMore();
    }

    public void loadData(List<ItemNOSend.ResultBean.ListBean> NOsendList){

        datas_out.addAll(NOsendList);

        //对adapter刷新改变
        mAdapter_out.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        page = 1;
        getPresenter().getNoSendList(token,pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);
    }

    @Override
    public void onLoadMore() {
        if (datas_out.size() == total) {
            showMessage("没有更多");
            mRyNoSend.completeLoadMore();
            return;
        }
        page++;
        getPresenter().getNoSendList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.UPLOADMORE);
    }
}