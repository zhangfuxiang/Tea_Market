package com.delta.smt.ui.Personal.my_order.no_receive;

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
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseFragment;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemNOReceive;
import com.delta.smt.ui.Personal.my_order.no_receive.di.DaggerNoReceiveComponent;
import com.delta.smt.ui.Personal.my_order.no_receive.di.NoReceiveModule;
import com.delta.smt.ui.Personal.my_order.no_receive.mvp.NoReceiveContract;
import com.delta.smt.ui.Personal.my_order.no_receive.mvp.NoReceivePresenter;
import com.delta.smt.utils.MapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

public class NoReceiveFragment extends BaseFragment<NoReceivePresenter> implements NoReceiveContract.View {


    @BindView(R.id.ry_no_receive)
    RecyclerView mRyNoReceive;

    private List<ItemNOReceive.ResultBean.ListBean> datas_out = new ArrayList<>();
    private CommonBaseAdapter<ItemNOReceive.ResultBean.ListBean> mAdapter_out;
    private List<ItemNOReceive.ResultBean.ListBean.OrderProductBean> datas_in = new ArrayList<>();
    private CommonBaseAdapter<ItemNOReceive.ResultBean.ListBean.OrderProductBean> mAdapter_in;


    private String token;
    private String pay_status;
    private Map<String,String> queryMap;
    @Override
    protected void initData() {

        token= SpUtil.getStringSF(getContext(), Constant.TOKEN);;
        pay_status="2";


        getPresenter().getNoReceiveList(token,pay_status);


    }

    @Override
    protected void initView() {
        mAdapter_out=new CommonBaseAdapter<ItemNOReceive.ResultBean.ListBean>(getContext(),datas_out) {
            @Override
            protected void convert(CommonViewHolder holder, final ItemNOReceive.ResultBean.ListBean item, int position) {

                int num=0;
                for (ItemNOReceive.ResultBean.ListBean.OrderProductBean mOrderProductBean : item.getOrder_product()) {
                    num+=mOrderProductBean.getNum();
                }
                holder.setText(R.id.tv_stats," 商家已发货");
                holder.setText(R.id.tv_count_number,"共"+num+"件商品 合计:");
                holder.setText(R.id.tv_money,"￥"+item.getProduct_total_money());
                holder.setText(R.id.tv_shop_name,item.getMerchant_title());


                TextView tv_left=holder.getView(R.id.tv_left_button);
                TextView tv_right=holder.getView(R.id.tv_right_button);
                tv_left.setVisibility(View.INVISIBLE);
                tv_right.setVisibility(View.VISIBLE);
                tv_right.setText("确认收货");

                tv_right.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        queryMap= MapUtils.CreateQueryMap(getContext());
                        queryMap.put("order_id",String.valueOf(item.getId()));
                        getPresenter().confirmReceive(queryMap);
                    }
                });


                datas_in.clear();
                datas_in.addAll(item.getOrder_product());
                createInRv(holder);
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemNOReceive.ResultBean.ListBean item) {
                return R.layout.item_my_order_out;
            }
        };
        mRyNoReceive.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRyNoReceive.setAdapter(mAdapter_out);

    }

    private void createInRv(CommonViewHolder holder) {
        RecyclerView mRyNoPayin= holder.getView(R.id.purchase_in_rv);

        mAdapter_in=new CommonBaseAdapter<ItemNOReceive.ResultBean.ListBean.OrderProductBean>(getContext(),datas_in) {
            @Override
            protected void convert(CommonViewHolder holder, ItemNOReceive.ResultBean.ListBean.OrderProductBean item, int position) {

                holder.setText(R.id.tv_price,"￥ "+item.getPrice());
                holder.setText(R.id.tv_num,"X "+item.getNum());
                holder.setText(R.id.tv_name,item.getProduct().getTitle());
                ImageView image=holder.getView(R.id.iv_image);
                Glide.with(getContext()).load(item.getProduct().getImages().get(0).getUrl()).into(image);
                Log.e("aaa", "noReceive: "+item.getProduct().getImages().get(0).getUrl());
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemNOReceive.ResultBean.ListBean.OrderProductBean item) {
                return R.layout.item_order_detail;
            }
        };

        mRyNoPayin.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRyNoPayin.setAdapter(mAdapter_in);
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerNoReceiveComponent.builder()
                .appComponent(appComponent)
                .noReceiveModule(new NoReceiveModule(this)) //请将NoReceiveModule()第一个首字母改为小写
                .build()
                .inject(this);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_no_receive;
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
        ToastUtils.showMessage(getActivity(),message);
    }

    @Override
    public void getNoReceiveList(List<ItemNOReceive.ResultBean.ListBean> NoReceiveList) {

        datas_out.clear();
        datas_out.addAll(NoReceiveList);
        //对adapter刷新改变
        mAdapter_out.notifyDataSetChanged();
    }

    @Override
    public void confirmReceive(String message) {
        showMessage(message);
        getPresenter().getNoReceiveList(token,pay_status);
    }
}