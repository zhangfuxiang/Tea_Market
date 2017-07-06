package com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.GsonTools;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.MyAppointResult;
import com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.di.DaggerPersonalAppointmentDetailComponent;
import com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.di.PersonalAppointmentDetailModule;
import com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.mvp.PersonalAppointmentDetailContract;
import com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.mvp.PersonalAppointmentDetailPresenter;
import com.delta.smt.utils.DataUtils;
import com.delta.smt.utils.MapUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public class PersonAppointmentDetailActivity extends BaseActivity<PersonalAppointmentDetailPresenter> implements PersonalAppointmentDetailContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.tv_left_button_name)
    TextView tvLeftButtonName;
    @BindView(R.id.toolbar_left_button_arl)
    AutoRelativeLayout toolbarLeftButtonArl;
    @BindView(R.id.toolbar_right_button_iv)
    ImageView toolbarRightButtonIv;
    @BindView(R.id.toolbar_right_button_iv_arl)
    AutoRelativeLayout toolbarRightButtonIvArl;
    @BindView(R.id.personal_headportrait)
    CircleImageView personalHeadportrait;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_chalou)
    TextView tvChalou;
    @BindView(R.id.tv_houseNum)
    TextView tvHouseNum;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    @BindView(R.id.tv_appoint_order)
    TextView tvAppointOrder;
    @BindView(R.id.tv_appoint_time)
    TextView tvAppointTime;
    @BindView(R.id.action_appoint_cancel)
    Button actionAppointCancel;
    @BindView(R.id.bt_arrive)
    Button btArrive;
    @BindView(R.id.tv_self)
    TextView tvSelf;
    private MyAppointResult.ResultEntity.ListEntity listEntity;
    private int id;
    private String merchant_id;
    private String token;


    @Override
    protected void initView() {

        toolbarTitle.setText("预约详情");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);
        if (listEntity != null) {
            tvName.setText(listEntity.getName());
            String merchanId = SpUtil.getStringSF(this, Constant.MERCHANTID);
            String isself = listEntity.getMerchant_id() == Integer.parseInt(merchanId) ? "本店" : "";
            String bespeak_time = DataUtils.timeStamp2Date(listEntity.getBespeak_time(), "MM月dd日 HH:mm");
            String to_time = DataUtils.timeStamp2Date(listEntity.getTo_time(), "HH:mm");
            Glide.with(this).load(listEntity.getUser().getImage_url()).centerCrop().into(personalHeadportrait);
            tvPhone.setText(listEntity.getPhone());
            tvChalou.setText(listEntity.getUser_merchant().getShop_title() + "");
            tvHouseNum.setText("预约包间数量：" + listEntity.getRoom_num() + "");
            tvTime.setText("预约时间段:" + bespeak_time + "-" + to_time);
            tvRemark.setText("备注：" + listEntity.getRemarks());
            tvAppointOrder.setText("预约号：" + listEntity.getNumber());
            tvAppointTime.setText("预约时间：" + bespeak_time);
            tvSelf.setText(isself);
        }
    }

    @Override
    protected void initData() {

        token = SpUtil.getStringSF(this, Constant.TOKEN);
        merchant_id = SpUtil.getStringSF(this, Constant.MERCHANTID);

        Bundle extras = getIntent().getExtras();
        String jason = extras.getString(Constant.APPOINTMENT, "");
        if (!TextUtils.isEmpty(jason)) {
            listEntity = GsonTools.changeGsonToBean(jason, MyAppointResult.ResultEntity.ListEntity.class);
            id = listEntity.getId();
        }


    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_appointment_detail;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

        DaggerPersonalAppointmentDetailComponent.builder().appComponent(appComponent).personalAppointmentDetailModule(new PersonalAppointmentDetailModule(this)).build().inject(this);
    }


    @OnClick({R.id.action_appoint_cancel, R.id.bt_arrive, R.id.toolbar_left_button_arl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.action_appoint_cancel:
                Map<String, String> queryMap = MapUtils.CreateQueryMap(this);
                queryMap.put("bespeak_id", id + "");

                getPresenter().cancelAppointMent(queryMap);
                break;
            case R.id.bt_arrive:
                Map<String, String> queryMap1 = MapUtils.CreateQueryMap(this);
                queryMap1.put("bespeak_id", id + "");
                getPresenter().arrive(queryMap1);
                break;
            case R.id.toolbar_left_button_arl:
                finish();
                break;

        }
    }

    @Override
    public void showCancelSuccess() {
        ToastUtils.showMessage(this, "取消预约成功！");
        finish();
    }

    @Override
    public void showCancelFailed(String app_msg) {

        ToastUtils.showMessage(this, app_msg);
    }

    @Override
    public void arriveSuccess() {
        ToastUtils.showMessage(this, "操作成功！");
    }

    @Override
    public void arriveFailed(String app_msg) {
        ToastUtils.showMessage(this, app_msg);
    }


}