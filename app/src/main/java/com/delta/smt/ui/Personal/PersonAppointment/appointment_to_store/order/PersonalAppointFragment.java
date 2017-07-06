package com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.delta.commonlibs.utils.GsonTools;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.commonlibs.widget.statusLayout.StatusLayout;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseFragment;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.MyAppointResult;
import com.delta.smt.entity.UserInfo;
import com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.PersonAppointmentDetailActivity;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.di.DaggerPersonalAppointComponent;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.di.PersonalAppointModule;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.mvp.PersonalAppointContract;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.mvp.PersonalAppointPresenter;
import com.delta.smt.utils.DataUtils;
import com.delta.smt.utils.GlideUtils;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;
import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Shaoqiang.Zhang on 2017/3/31.
 */

public class PersonalAppointFragment extends BaseFragment<PersonalAppointPresenter> implements SuperBaseAdapter.OnItemClickListener<MyAppointResult.ResultEntity.ListEntity>, SuperRecyclerView.LoadingListener, PersonalAppointContract.View {

    @BindView(R.id.purchase_rv)
    SuperRecyclerView purchase_rv;

    Unbinder unbinder;
    @BindView(R.id.vs_nd_root)
    LinearLayout vsNdRoot;
    @BindView(R.id.sl)
    StatusLayout sl;
    Unbinder unbinder1;

    private SuperBaseAdapter<MyAppointResult.ResultEntity.ListEntity> adapter;
    private int page = 1;
    private int size = 10;
    private List<MyAppointResult.ResultEntity.ListEntity> datas = new ArrayList<>();
    private int type;
    private String token;
    private String merchanId;
    private int total;

    @Override
    protected void initView() {


        adapter = new SuperBaseAdapter<MyAppointResult.ResultEntity.ListEntity>(getContext(), datas) {


            @Override
            protected void convert(BaseViewHolder holder, MyAppointResult.ResultEntity.ListEntity item, int position) {

                ImageView view = holder.getView(R.id.personal_headportrait);
                GlideUtils.loadImageViewLoding(PersonalAppointFragment.this.getActivity(), item.getUser().getImage_url(), view, R.mipmap.person, R.mipmap.person);
                holder.setText(R.id.tv_shop, item.getUser_merchant().getShop_title());
                String isself = item.getMerchant_id() == Integer.parseInt(merchanId) ? "本店" : "";
                holder.setText(R.id.tv_iself, isself);
                holder.setText(R.id.tv_room, "包间数：" + item.getRoom_num() + "间");
                holder.setText(R.id.tv_name, item.getName() + " " + item.getPhone());
                String bespeak_time = DataUtils.timeStamp2Date(item.getBespeak_time(), "MM月dd日 HH:mm");
                String to_time = DataUtils.timeStamp2Date(item.getTo_time(), "HH:mm");
                holder.setText(R.id.tv_time, "预约时间段：" + bespeak_time + "-" + to_time);
                holder.setText(R.id.tv_remark, "备注：" + item.getRemarks());
                String status = "";
                switch (item.getStatus()) {
                    case 0:
                        status = "已取消";
                        break;
                    case 1:
                        status = "已预约";
                        break;
                    case 2:
                        status = "到店";
                        break;
                }

                holder.setText(R.id.tv_status, status);
            }

            @Override
            protected int getItemViewLayoutId(int position, MyAppointResult.ResultEntity.ListEntity item) {
                return R.layout.item_personal_appointment;
            }

        };

        adapter.setOnItemClickListener(this);
        purchase_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        purchase_rv.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        purchase_rv.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        purchase_rv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
        purchase_rv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//可以自定义上拉加载的样式
        // superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);//设置下拉箭头
        purchase_rv.setLoadingListener(this);
        purchase_rv.setAdapter(adapter);
        //purchase_rv.setEmptyView(vsNdRoot);

    }

    @Override
    protected void componentInject(AppComponent appComponent) {

        DaggerPersonalAppointComponent.builder().appComponent(appComponent).personalAppointModule(new PersonalAppointModule(this)).build().inject(this);
        //  daggerperson.builder().appComponent(appComponent).personalActivityModule(new PersonalActivityModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {

        Bundle arguments = getArguments();
        type = arguments.getInt(Constant.BLANCETYPE);
        token = SpUtil.getStringSF(getActivity(), Constant.TOKEN);
        merchanId = SpUtil.getStringSF(getActivity(), Constant.MERCHANTID);

    }

    @Override
    public void onResume() {
        getPresenter().getPersonalAppoint(token, merchanId, type, page, size, Constant.NOMAL);
        super.onResume();
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
    public void getBlanceDetailSuccess(MyAppointResult.ResultEntity result) {
        total = result.getTotal();
        datas.clear();
        refresh(result);
        if (result.getList().size() == 0) {
            sl.showEmptyView();
            sl.setEmptyClick(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPresenter().getPersonalAppoint(token, merchanId, type, page, size, Constant.NOMAL);
                }
            });
        } else {
            sl.showContentView();
        }
    }

    private void refresh(MyAppointResult.ResultEntity result) {
//        switch (type) {
//            case 0:
//                datas.addAll(result.getList());
//                break;
//            case 1:
//                for (MyAppointResult.ResultEntity.ListEntity listEntity : result.getList()) {
//
//                    if (listEntity.getStatus() == 1) {
//                        datas.add(listEntity);
//                    }
//                }
//                break;
//            case 2:
//                for (MyAppointResult.ResultEntity.ListEntity listEntity : result.getList()) {
//
//                    if (listEntity.getStatus() == 0) {
//                        datas.add(listEntity);
//                    }
//                }
//                break;
//        }
        datas.addAll(result.getList());

        adapter.notifyDataSetChanged();
    }

    @Override
    public void getBlanceDetailFaild(String app_msg) {

        ToastUtils.showMessage(getActivity(), app_msg);
    }

    @Override
    public void RefershSucess(MyAppointResult.ResultEntity result) {
        datas.clear();
        refresh(result);
        purchase_rv.completeRefresh();

    }

    @Override
    public void loadSucess(MyAppointResult.ResultEntity result) {

        refresh(result);
        purchase_rv.completeLoadMore();
    }


    @Override
    public void onItemClick(View view, MyAppointResult.ResultEntity.ListEntity item, int position) {

        if (item.getStatus() == 1) {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.APPOINTMENT, GsonTools.createGsonString(item));
            IntentUtils.showIntent(getActivity(), PersonAppointmentDetailActivity.class, bundle);
        } else if (item.getStatus() == 0) {
            ToastUtils.showMessage(getActivity(), "已取消");
        } else if (item.getStatus() == 2) {
            ToastUtils.showMessage(getActivity(), "已到店");
        }
    }

    @Override
    public void onRefresh() {
        page = 1;
        getPresenter().getPersonalAppoint(token, merchanId, type, page, size, Constant.PUllTOREFRESH);
    }

    @Override
    public void onLoadMore() {

        if (datas.size() == total) {
            ToastUtils.showMessage(getActivity(), "没有更多了");
            purchase_rv.completeLoadMore();
            return;
        }
        getPresenter().getPersonalAppoint(token, merchanId, type, ++page, size, Constant.UPLOADMORE);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }
}
