package com.delta.smt.ui.HomePage.appointment_to_store;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.AppointmentStoreDetail;
import com.delta.smt.entity.ArriveResoult;
import com.delta.smt.ui.HomePage.HomePageAPIService;
import com.delta.smt.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shaoqiang.Zhang on 2017/3/30.
 */

public class AppointmentStoreActivity extends BaseActivity implements CommonBaseAdapter.OnItemClickListener<AppointmentStoreDetail.Result.MList> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.appointment_rv)
    RecyclerView appointment_rv;
    private List<AppointmentStoreDetail.Result.MList> list = new ArrayList<>();
    private CommonBaseAdapter<AppointmentStoreDetail.Result.MList> adapter;
    private AppointmentStoreDetail detail;

    @OnClick(R.id.toolbar_left_button)
    void back() {
        finish();
    }

    @Override
    protected void initView() {

        toolbarTitle.setText("新预约到店");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        adapter = new CommonBaseAdapter<AppointmentStoreDetail.Result.MList>(this, list) {
            @Override
            protected void convert(CommonViewHolder holder, final AppointmentStoreDetail.Result.MList item, int position) {

                holder.setText(R.id.appointment_order_numb_tv, "预约单号：" + item.getNumber());
                holder.setText(R.id.name_number_tv, item.getName() + "：" + item.getPhone());
                switch (item.getStatus()) {
                    case 0:
                        holder.setText(R.id.appoint_status_tv, "取消");
                        break;
                    case 1:
                        holder.setText(R.id.appoint_status_tv, "客人已预约");
                        break;
                    case 2:
                        holder.setText(R.id.appoint_status_tv, "客人已到店");
                        break;
                    default:
                        holder.setText(R.id.appoint_status_tv, "状态未知");
                        break;
                }
                holder.setText(R.id.appointment_room_number_tv, "包间数：" + item.getRoom_num() + "间");
                holder.setText(R.id.appointment_remark_tv, "备注：" + item.getRemarks());
                holder.setText(R.id.appointment_time_tv,"时段："+ DataUtils.timeStamp2Date(String.valueOf(item.getStart_time()),"MM月dd日 HH:mm")
                        +"-"+DataUtils.timeStamp2Date(String.valueOf(item.getEnd_time()),"HH:mm"));

                holder.getView(R.id.appoint_status_tv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new HomePageAPIService().arriveResoultCall(SpUtil.getStringSF(AppointmentStoreActivity.this, Constant.TOKEN),item.getId()).
                                enqueue(new Callback<ArriveResoult>() {
                                    @Override
                                    public void onResponse(Call<ArriveResoult> call, Response<ArriveResoult> response) {

                                        if (!response.body().getResult()) {
                                            ToastUtils.showMessage(AppointmentStoreActivity.this, response.body().getApp_msg());
                                        }else {
                                            ToastUtils.showMessage(AppointmentStoreActivity.this, "设置成功！");
                                        }

                                    }
                                    @Override
                                    public void onFailure(Call<ArriveResoult> call, Throwable t) {

                                    }
                                });
                    }
                });

            }

            @Override
            protected int getItemViewLayoutId(int position, AppointmentStoreDetail.Result.MList item) {
                return R.layout.item_appointment_store;
            }
        };

        adapter.setOnItemClickListener(this);
        appointment_rv.setLayoutManager(new LinearLayoutManager(this));
        appointment_rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {

        new HomePageAPIService().getAppointmentDetailCall(SpUtil.getStringSF(this, Constant.TOKEN)).enqueue(new Callback<AppointmentStoreDetail>() {
            @Override
            public void onResponse(Call<AppointmentStoreDetail> call, Response<AppointmentStoreDetail> response) {

                list.clear();
                ToastUtils.showMessage(AppointmentStoreActivity.this, response.body().getResult().getList().size());
                detail = response.body();
                for (AppointmentStoreDetail.Result.MList l:detail.getResult().getList()){
                    list.add(l);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<AppointmentStoreDetail> call, Throwable t) {

            }
        });

    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_appointment_store;
    }

    @Override
    public void onItemClick(View view, final AppointmentStoreDetail.Result.MList item, int position) {

    }

}
