package com.delta.smt.ui.Personal.my_order.no_payment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.commonlibs.widget.statusLayout.StatusLayout;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseFragment;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemNOPayment;
import com.delta.smt.ui.Personal.my_order.no_payment.di.DaggerNoPaymentComponent;
import com.delta.smt.ui.Personal.my_order.no_payment.di.NoPaymentModule;
import com.delta.smt.ui.Personal.my_order.no_payment.mvp.NoPaymentContract;
import com.delta.smt.ui.Personal.my_order.no_payment.mvp.NoPaymentPresenter;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.OrderDetailActivity;
import com.delta.smt.utils.MapUtils;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;
import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

public class NoPaymentFragment extends BaseFragment<NoPaymentPresenter> implements NoPaymentContract.View, SuperRecyclerView.LoadingListener, SuperBaseAdapter.OnItemClickListener<ItemNOPayment.ResultBean.ListBean> {


/*    @BindView(R.id.ry_no_pay)
    RecyclerView mRyNoPayout;*/
    @BindView(R.id.ry_no_pay)
    SuperRecyclerView mRyNoPay;
    @BindView(R.id.sl)
    StatusLayout mSl;

    private List<ItemNOPayment.ResultBean.ListBean> datas_out = new ArrayList<>();
    private SuperBaseAdapter<ItemNOPayment.ResultBean.ListBean> mAdapter_out;
    private List<ItemNOPayment.ResultBean.ListBean.OrderProductBean> datas_in = new ArrayList<>();
    private SuperBaseAdapter<ItemNOPayment.ResultBean.ListBean.OrderProductBean> mAdapter_in;

    private String token;
    private String pay_status="1";
    private String order_id;
    private Bundle mBundle = new Bundle();
    private Map<String, String> queryMap;
    private int page = 1;
    private int size = 10;
    private int total;
    @Override
    protected void initData() {
        token = SpUtil.getStringSF(getContext(), Constant.TOKEN);
        getPresenter().getUnpaymentList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);


    }

    @Override
    public void onResume() {
        Log.e("aaa", "onResume:nopayment ");
        page=1;
        getPresenter().getUnpaymentList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);
        super.onResume();
    }

    @Override
    public void onStop() {
        Log.e("aaa", "onStop: ");
        super.onStop();
    }

    @Override
    public void onStart() {
        Log.e("aaa", "onStart: ");
        super.onStart();
    }

    @Override
    protected void initView() {
        mAdapter_out=new SuperBaseAdapter<ItemNOPayment.ResultBean.ListBean>(getContext(), datas_out) {
            @Override
            protected void convert(BaseViewHolder holder, final ItemNOPayment.ResultBean.ListBean item, int position) {
                int num = 0;
                for (ItemNOPayment.ResultBean.ListBean.OrderProductBean mOrderProductBean : item.getOrder_product()) {
                    num += mOrderProductBean.getNum();
                }


                holder.setText(R.id.tv_stats, " 等待付款");
                holder.setText(R.id.tv_count_number, "共" + num + "件商品 合计:");
                holder.setText(R.id.tv_money, "￥" + item.getProduct_total_money());
                holder.setText(R.id.tv_shop_name, item.getMerchant_title());

                /*holder.getView(R.id.ly_out).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        order_id = String.valueOf(item.getId());
                        Log.e("aaa", "onClick: " + order_id);
                        mBundle.putString("order_id", order_id);
                        IntentUtils.showIntent(getActivity(), OrderDetailActivity.class, mBundle);

                    }
                });*/

                holder.getView(R.id.tv_left_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        order_id = String.valueOf(item.getId());
                        getPresenter().cancelOrder(token, order_id);
                    }
                });

                holder.getView(R.id.tv_right_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        order_id = String.valueOf(item.getId());
                       /* queryMap= MapUtils.CreateQueryMap(getContext());
                        queryMap.put("order_ids",order_id);
                        queryMap.put("pay_type","3");
                        queryMap.put("pay_pwd","");
                        getPresenter().payOrder(queryMap);*/
                        Log.e("aaa", "onClick: " + order_id);
                        mBundle.putString("order_id", order_id);
                        IntentUtils.showIntent(getActivity(), OrderDetailActivity.class, mBundle);
                    }
                });

                datas_in.clear();
                datas_in.addAll(item.getOrder_product());
                createInRv(holder);
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemNOPayment.ResultBean.ListBean item) {
                return R.layout.item_my_order_out;
            }
        };

        mAdapter_out.setOnItemClickListener(this);
        mRyNoPay.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRyNoPay.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        mRyNoPay.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        mRyNoPay.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
        mRyNoPay.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//可以自定义上拉加载的样式
        // superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);//设置下拉箭头
        mRyNoPay.setLoadingListener(this);
        mRyNoPay.setAdapter(mAdapter_out);




    }

    private void createInRv(BaseViewHolder holder) {

        RecyclerView mRyNoPayin = holder.getView(R.id.purchase_in_rv);

        mAdapter_in = new SuperBaseAdapter<ItemNOPayment.ResultBean.ListBean.OrderProductBean>(getContext(), datas_in) {



            @Override
            protected void convert(BaseViewHolder holder, ItemNOPayment.ResultBean.ListBean.OrderProductBean item, int position) {
                holder.setText(R.id.tv_price, "￥ " + item.getPrice());
                holder.setText(R.id.tv_num, "X " + item.getNum());
                holder.setText(R.id.tv_name, item.getProduct().getTitle());
                ImageView image = holder.getView(R.id.iv_image);
                Glide.with(getContext()).load(item.getProduct().getImages().get(0).getUrl()).into(image);
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemNOPayment.ResultBean.ListBean.OrderProductBean item) {
                return R.layout.item_order_detail;
            }
        };

        mRyNoPayin.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRyNoPayin.setAdapter(mAdapter_in);
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerNoPaymentComponent.builder()
                .appComponent(appComponent)
                .noPaymentModule(new NoPaymentModule(this)) //请将NoPaymentModule()第一个首字母改为小写
                .build()
                .inject(this);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_no_payment;
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
    public void getUnpaymentList(ItemNOPayment.ResultBean Unpaymentdata) {

        datas_out.clear();

        total=Unpaymentdata.getTotal();

        loadData(Unpaymentdata.getList());

        mRyNoPay.completeRefresh();
    }

    @Override
    public void loadSucess(ItemNOPayment.ResultBean Unpaymentdata) {

        loadData(Unpaymentdata.getList());
        mRyNoPay.completeLoadMore();
    }

    public void loadData(List<ItemNOPayment.ResultBean.ListBean> UnpaymentList){

        datas_out.addAll(UnpaymentList);

        //对adapter刷新改变
        mAdapter_out.notifyDataSetChanged();
    }

    @Override
    public void cancelOrder(String message) {
        showMessage(message);
        page=1;
        getPresenter().getUnpaymentList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);

    }

    @Override
    public void payOrder(String message) {
        showMessage(message);
        page=1;
        getPresenter().getUnpaymentList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);
    }


    @Override
    public void onRefresh() {
        page=1;
        getPresenter().getUnpaymentList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);

    }

    @Override
    public void onLoadMore() {

        if (datas_out.size() == total) {
            showMessage("没有更多");
            mRyNoPay.completeLoadMore();
            return;
        }
        page++;
        getPresenter().getUnpaymentList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.UPLOADMORE);

    }


    @Override
    public void onItemClick(View view, ItemNOPayment.ResultBean.ListBean item, int position) {
        order_id = String.valueOf(item.getId());
        Log.e("aaa", "onClick: " + order_id);
        mBundle.putString("order_id", order_id);
        IntentUtils.showIntent(getActivity(), OrderDetailActivity.class, mBundle);
    }
}