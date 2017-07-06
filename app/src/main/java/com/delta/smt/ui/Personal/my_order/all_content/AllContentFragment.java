package com.delta.smt.ui.Personal.my_order.all_content;

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
import com.delta.smt.entity.ItemMyOrder;
import com.delta.smt.entity.ItemNOPayment;
import com.delta.smt.ui.Personal.my_order.all_content.di.AllContentModule;
import com.delta.smt.ui.Personal.my_order.all_content.di.DaggerAllContentComponent;
import com.delta.smt.ui.Personal.my_order.all_content.mvp.AllContentContract;
import com.delta.smt.ui.Personal.my_order.all_content.mvp.AllContentPresenter;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.OrderDetailActivity;
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

public class AllContentFragment extends BaseFragment<AllContentPresenter> implements AllContentContract.View, SuperRecyclerView.LoadingListener {



    @BindView(R.id.ry_all_content)
    SuperRecyclerView mRyAllContent;
    @BindView(R.id.sl)
    StatusLayout mSl;

    private List<ItemMyOrder.ResultBean.ListBean> datas_out = new ArrayList<>();
    private SuperBaseAdapter<ItemMyOrder.ResultBean.ListBean> mAdapter_out;
    private List<ItemMyOrder.ResultBean.ListBean.OrderProductBean> datas_in = new ArrayList<>();
    private SuperBaseAdapter<ItemMyOrder.ResultBean.ListBean.OrderProductBean> mAdapter_in;
    private String token;
    private String pay_status= "0";
    private String order_id;
    private Bundle mBundle = new Bundle();
    private int page = 1;
    private int size = 10;
    private int total;
    @Override
    public void onResume() {
        Log.e("aaa", "onResume:allcontent ");
        page = 1;
        getPresenter().getMyOrderList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);
        super.onResume();
    }

    @Override
    protected void initData() {
        token = SpUtil.getStringSF(getContext(), Constant.TOKEN);
        getPresenter().getMyOrderList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);


    }


    @Override
    protected void initView() {
        mAdapter_out = new SuperBaseAdapter<ItemMyOrder.ResultBean.ListBean>(getContext(), datas_out) {
            @Override
            protected void convert(BaseViewHolder holder, final ItemMyOrder.ResultBean.ListBean item, int position) {


                int num = 0;
                for (ItemMyOrder.ResultBean.ListBean.OrderProductBean mOrderProductBean : item.getOrder_product()) {
                    num += mOrderProductBean.getNum();
                }
                holder.setText(R.id.tv_count_number, "共" + num + "件商品 合计:");
                holder.setText(R.id.tv_money, "￥" + item.getProduct_total_money());
                holder.setText(R.id.tv_shop_name, item.getMerchant_title());
                TextView tv_left = holder.getView(R.id.tv_left_button);
                TextView tv_right = holder.getView(R.id.tv_right_button);

                if (item.getPay_status() == 1) {

                    holder.setText(R.id.tv_stats, "等待付款");
                    tv_left.setVisibility(View.VISIBLE);
                    tv_right.setVisibility(View.VISIBLE);
                    tv_left.setText("取消订单");
                    tv_right.setText("付款");
                    holder.getView(R.id.ly_out).setClickable(true);
                    holder.getView(R.id.ly_out).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            order_id = String.valueOf(item.getId());
                            Log.e("aaa", "onClick: " + order_id);
                            mBundle.putString("order_id", order_id);
                            IntentUtils.showIntent(getActivity(), OrderDetailActivity.class, mBundle);
                        }
                    });
                    tv_left.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            order_id = String.valueOf(item.getId());
                            getPresenter().cancelOrder(token, order_id);
                        }
                    });


                } else if (item.getPay_status() == 2 && item.getDeliver_status() == 1) {
                    holder.setText(R.id.tv_stats, "等待商家发货");
                    tv_left.setVisibility(View.GONE);
                    tv_right.setVisibility(View.GONE);
                    holder.getView(R.id.ly_out).setClickable(false);

                } else if (item.getPay_status() == 2 && item.getDeliver_status() == 2) {
                    holder.setText(R.id.tv_stats, "商家已发货");
                    tv_left.setVisibility(View.INVISIBLE);
                    tv_right.setVisibility(View.VISIBLE);
                    tv_right.setText("确认收货");
                    holder.getView(R.id.ly_out).setClickable(false);
                }


                datas_in.clear();
                datas_in.addAll(item.getOrder_product());
                createInRv(holder);
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemMyOrder.ResultBean.ListBean item) {
                return R.layout.item_my_order_out;
            }
        };
        mRyAllContent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRyAllContent.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        mRyAllContent.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        mRyAllContent.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
        mRyAllContent.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//可以自定义上拉加载的样式
        // superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);//设置下拉箭头
        mRyAllContent.setLoadingListener(this);
        mRyAllContent.setAdapter(mAdapter_out);
    }

    private void createInRv(BaseViewHolder holder) {
        RecyclerView mRyNoPayin = holder.getView(R.id.purchase_in_rv);

        mAdapter_in = new SuperBaseAdapter<ItemMyOrder.ResultBean.ListBean.OrderProductBean>(getContext(), datas_in) {
            @Override
            protected void convert(BaseViewHolder holder, ItemMyOrder.ResultBean.ListBean.OrderProductBean item, int position) {
                holder.setText(R.id.tv_price, "￥ " + item.getPrice());
                holder.setText(R.id.tv_num, "X " + item.getNum());
                holder.setText(R.id.tv_name, item.getProduct().getTitle());
                ImageView image = holder.getView(R.id.iv_image);
                Glide.with(getContext()).load(item.getProduct().getImages().get(0).getUrl()).into(image);
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemMyOrder.ResultBean.ListBean.OrderProductBean item) {
                return R.layout.item_order_detail;
            }
        };

        mRyNoPayin.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRyNoPayin.setAdapter(mAdapter_in);
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerAllContentComponent.builder()
                .appComponent(appComponent)
                .allContentModule(new AllContentModule(this)) //请将AllContentModule()第一个首字母改为小写
                .build()
                .inject(this);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_all_content;
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
    public void getMyOrderList(ItemMyOrder.ResultBean MyOrderdata) {

        datas_out.clear();
        total=MyOrderdata.getTotal();
        loadData(MyOrderdata.getList());

        mRyAllContent.completeRefresh();
    }

    @Override
    public void loadSucess(ItemMyOrder.ResultBean MyOrderdata) {

        loadData(MyOrderdata.getList());
        mRyAllContent.completeLoadMore();
    }

    @Override
    public void cancelOrder(String message) {
        showMessage(message);
        page=1;
        getPresenter().getMyOrderList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);
    }

    public void loadData(List<ItemMyOrder.ResultBean.ListBean> MyOrderList){

        datas_out.addAll(MyOrderList);

        //对adapter刷新改变
        mAdapter_out.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        page = 1;
        getPresenter().getMyOrderList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.NOMAL);
    }

    @Override
    public void onLoadMore() {
        if (datas_out.size() == total) {
            showMessage("没有更多");
            mRyAllContent.completeLoadMore();
            return;
        }
        page++;
        getPresenter().getMyOrderList(token, pay_status,String.valueOf(page),String.valueOf(size),Constant.UPLOADMORE);
    }
}