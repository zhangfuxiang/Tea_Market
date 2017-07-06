package com.delta.smt.ui.Personal.Balance.BalanceDetail.order;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseFragment;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.BlanceDetailResult;
import com.delta.smt.entity.Order;
import com.delta.smt.entity.UserInfo;
import com.delta.smt.ui.Personal.Balance.BalanceDetail.order.di.BlanceDetailModule;
import com.delta.smt.ui.Personal.Balance.BalanceDetail.order.di.DaggerBlanceDetailComponent;
import com.delta.smt.ui.Personal.Balance.BalanceDetail.order.mvp.BlanceDetailContract;
import com.delta.smt.ui.Personal.Balance.BalanceDetail.order.mvp.BlanceDetailPresenter;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;
import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by Shaoqiang.Zhang on 2017/3/31.
 */

public class BalanceDetailFragment extends BaseFragment<BlanceDetailPresenter> implements BlanceDetailContract.View, SuperBaseAdapter.OnItemClickListener<BlanceDetailResult.ResultEntity.ListEntity>, SuperRecyclerView.LoadingListener {

    @BindView(R.id.purchase_rv)
    SuperRecyclerView purchase_rv;
    private List<Order> list = new ArrayList<>();
    private SuperBaseAdapter<BlanceDetailResult.ResultEntity.ListEntity> adapter;
    private int page = 1;
    private int size = 10;
    private List<BlanceDetailResult.ResultEntity.ListEntity> datas = new ArrayList<>();
    private int type;
    private String token;
    private String merchanId;
    private int total;

    @Override
    protected void initView() {
        list.clear();
        for (int i = 0; i < 6; i++) {
            list.add(new Order());
        }

        adapter = new SuperBaseAdapter<BlanceDetailResult.ResultEntity.ListEntity>(getContext(), datas) {


            @Override
            protected void convert(BaseViewHolder holder, BlanceDetailResult.ResultEntity.ListEntity item, int position) {
                holder.setText(R.id.tv_status, item.getComment());
                holder.setText(R.id.tv_time, item.getCreate_time());
                holder.setText(R.id.tv_merchant, "余额：" + item.getTotal());
                holder.setText(R.id.tv_money, item.getChange_money());
            }

            @Override
            protected int getItemViewLayoutId(int position, BlanceDetailResult.ResultEntity.ListEntity item) {
                return R.layout.item_balance_detail;
            }

        };


        adapter.setOnItemClickListener(this);

        purchase_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        purchase_rv.setAdapter(adapter);
        purchase_rv.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        purchase_rv.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        purchase_rv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
        purchase_rv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//可以自定义上拉加载的样式
        // superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);//设置下拉箭头
        purchase_rv.setLoadingListener(this);
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

        DaggerBlanceDetailComponent.builder().appComponent(appComponent).blanceDetailModule(new BlanceDetailModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {

        Bundle arguments = getArguments();
        type = arguments.getInt(Constant.BLANCETYPE);
        token = SpUtil.getStringSF(getActivity(), Constant.TOKEN);
        merchanId = SpUtil.getStringSF(getActivity(), Constant.MERCHANTID);
        getPresenter().getBlanceDetail(token, merchanId, type, page, size, Constant.NOMAL);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_appointment;
    }


    @Override
    public void ShowUserInfoSuccess(UserInfo userInfo) {

    }

    @Override
    public void showUserInfoError() {

    }

    @Override
    public void getBlanceDetailSuccess(BlanceDetailResult.ResultEntity result) {
        datas.clear();
        refresh(result);

    }

    private void refresh(BlanceDetailResult.ResultEntity result) {


        datas.addAll(result.getList());
        total = result.getTotal();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getBlanceDetailFaild(String app_msg) {

        ToastUtils.showMessage(getActivity(), app_msg);
    }

    @Override
    public void RefershSucess(BlanceDetailResult.ResultEntity result) {
        datas.clear();
        refresh(result);
        purchase_rv.completeRefresh();
    }

    @Override
    public void loadSucess(BlanceDetailResult.ResultEntity result) {
        refresh(result);
        purchase_rv.completeLoadMore();
    }


    @Override
    public void onItemClick(View view, BlanceDetailResult.ResultEntity.ListEntity item, int position) {

    }

    @Override
    public void onRefresh() {
        page = 1;
        getPresenter().getBlanceDetail(token, merchanId, type, page, size, Constant.PUllTOREFRESH);
    }

    @Override
    public void onLoadMore() {

        if (total == datas.size()) {
            ToastUtils.showMessage(getActivity(), "没有更多了");
            purchase_rv.completeLoadMore();
            return;
        }
        getPresenter().getBlanceDetail(token, merchanId, type, ++page, size, Constant.UPLOADMORE);
    }
}
