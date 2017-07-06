package com.delta.smt.ui.Personal.PersonalActivities.order;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.commonlibs.widget.statusLayout.StatusLayout;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseFragment;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.MyActivity;
import com.delta.smt.entity.Order;
import com.delta.smt.entity.UserInfo;
import com.delta.smt.ui.Personal.PersonalActivities.order.di.DaggerPersonalActivityComponent;
import com.delta.smt.ui.Personal.PersonalActivities.order.di.PersonalActivityModule;
import com.delta.smt.ui.Personal.PersonalActivities.order.mvp.PersonalActivityContract;
import com.delta.smt.ui.Personal.PersonalActivities.order.mvp.PersonalActivityPresenter;
import com.delta.smt.utils.DataUtils;
import com.delta.smt.utils.GlideUtils;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;
import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;


/**
 * Created by Shaoqiang.Zhang on 2017/3/31.
 */

public class PersonalActivityFragment extends BaseFragment<PersonalActivityPresenter> implements PersonalActivityContract.View, SuperBaseAdapter.OnItemClickListener<MyActivity.ResultEntity.ListEntity>, SuperRecyclerView.LoadingListener {

    @BindView(R.id.purchase_rv)
    SuperRecyclerView purchase_rv;

    Unbinder unbinder;
    @BindView(R.id.vs_nd_root)
    AutoLinearLayout vsNdRoot;
    @BindView(R.id.sl)
    StatusLayout sl;
    Unbinder unbinder1;

    private List<Order> list = new ArrayList<>();
    private SuperBaseAdapter<MyActivity.ResultEntity.ListEntity> adapter;
    private int page = 1;
    private int size = 10;
    private List<MyActivity.ResultEntity.ListEntity> datas = new ArrayList<>();
    private int type;
    private String token;
    private String merchanId;
    private int total;

    @Override
    protected void initView() {

        adapter = new SuperBaseAdapter<MyActivity.ResultEntity.ListEntity>(getContext(), datas) {


            @Override
            protected void convert(BaseViewHolder holder, MyActivity.ResultEntity.ListEntity item, int position) {

                holder.setText(R.id.tv_shop_name, item.getActivity().getMerchant().getShop_title());
                String isself = item.getActivity().getMerchant_id() == Integer.parseInt(merchanId) ? "本店" : "";

                holder.setText(R.id.tv_iself, isself);
                String status = "";
                switch (item.getStatus()) {
                    case 0:
                        status = "已预约";
                        break;
                    case 1:
                        status = "已报名";
                        break;
                    case 3:
                        status = "已取消";
                        break;
                }
                holder.setText(R.id.tv_status, status);
                ImageView view = holder.getView(R.id.push_able_act_image);
                GlideUtils.loadImageViewLoding(PersonalActivityFragment.this.getActivity(), item.getActivity().getImage_url(), view, R.mipmap.person, R.mipmap.person);
                holder.setText(R.id.push_able_act_sub_tv, item.getActivity().getTitle());
                String bespeak_time = DataUtils.timeStamp2Date(item.getActivity().getStart_time(), "MM/dd");
                String to_time = DataUtils.timeStamp2Date(item.getActivity().getEnd_time(), "MM/dd");
                holder.setText(R.id.push_able_act_content, "已报名/限定人数：" + item.getActivity().getSign_num() + "/" + item.getActivity().getNumber()
                        + "|" + "时间：" + bespeak_time + "-" + to_time);
            }

            @Override
            protected int getItemViewLayoutId(int position, MyActivity.ResultEntity.ListEntity item) {
                return R.layout.item_personal_activity;
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
        //  purchase_rv.setEmptyView(vsNdRoot);

    }

    @Override
    protected void componentInject(AppComponent appComponent) {

        DaggerPersonalActivityComponent.builder().appComponent(appComponent).personalActivityModule(new PersonalActivityModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {

        Bundle arguments = getArguments();
        type = arguments.getInt(Constant.BLANCETYPE);
        token = SpUtil.getStringSF(getActivity(), Constant.TOKEN);
        merchanId = SpUtil.getStringSF(getActivity(), Constant.MERCHANTID);
        getPresenter().getPersonalActivity(token, merchanId, type, page, size, Constant.NOMAL);
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
    public void getBlanceDetailSuccess(MyActivity.ResultEntity result) {
        total = result.getTotal();
        refresh(result);
        if (result.getList().size() == 0) {

            sl.showEmptyView();
            sl.setEmptyClick(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPresenter().getPersonalActivity(token, merchanId, type, page, size, Constant.NOMAL);
                }
            });
        } else {
            sl.showContentView();
        }
    }

    private void refresh(MyActivity.ResultEntity result) {
        datas.clear();
        datas.addAll(result.getList());

        adapter.notifyDataSetChanged();
    }

    @Override
    public void getBlanceDetailFaild(String app_msg) {

        ToastUtils.showMessage(getActivity(), app_msg);
    }

    @Override
    public void RefershSucess(MyActivity.ResultEntity result) {
        refresh(result);
        purchase_rv.completeRefresh();
    }

    @Override
    public void loadSucess(MyActivity.ResultEntity result) {
        refresh(result);
        purchase_rv.completeLoadMore();
    }


    @Override
    public void onItemClick(View view, MyActivity.ResultEntity.ListEntity item, int position) {


    }

    @Override
    public void onRefresh() {
        page = 1;
        getPresenter().getPersonalActivity(token, merchanId, type, page, size, Constant.PUllTOREFRESH);
    }

    @Override
    public void onLoadMore() {
        if (datas.size() == total) {
            ToastUtils.showMessage(getActivity(), "没有更多了");
            purchase_rv.completeLoadMore();
            return;
        }
        getPresenter().getPersonalActivity(token, merchanId, type, ++page, size, Constant.UPLOADMORE);

    }


}
