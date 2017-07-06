package com.delta.smt.ui.drinktea.write_order_info;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.drinktea.OrderThis;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.PersonAppointmentActivity;
import com.delta.smt.ui.drinktea.order_this.BottomDialogDate;
import com.delta.smt.ui.drinktea.order_this.BottomDialogRoomAmount;
import com.delta.smt.ui.drinktea.order_this.BottomDialogTime;
import com.delta.smt.ui.drinktea.write_order_info.di.DaggerWriteOrderInfoComponent;
import com.delta.smt.ui.drinktea.write_order_info.di.WriteOrderInfoModule;
import com.delta.smt.ui.drinktea.write_order_info.mvp.WriteOrderInfoContract;
import com.delta.smt.ui.drinktea.write_order_info.mvp.WriteOrderInfoPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhy.autolayout.AutoRelativeLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/4/21.
 */

public class WriteOrderInfoActivity extends BaseActivity<WriteOrderInfoPresenter> implements WriteOrderInfoContract.View {

    @BindView(R.id.toolbar)
    FindToolBar toolBar;
    @BindView(R.id.iv_order_other_item_picture)
    RoundedImageView ivOrderOtherItemPicture;
    @BindView(R.id.tv_order_other_name)
    TextView tvOrderOtherName;
    @BindView(R.id.tv_order_other_status)
    TextView tvOrderOtherStatus;
    @BindView(R.id.tv_other_address)
    TextView tvOtherAddress;
    @BindView(R.id.tv_other_distance)
    TextView tvOtherDistance;
    @BindView(R.id.tv_order_other_price)
    TextView tvOrderOtherPrice;

    @BindView(R.id.arl_order_this_room_amount)
    AutoRelativeLayout arlOrderThisRoomAmount;
    @BindView(R.id.arl_order_this_date)
    AutoRelativeLayout arlOrderThisDate;
    @BindView(R.id.arl_order_this_time)
    AutoRelativeLayout arlOrderThisTime;

    @BindView(R.id.tv_order_this_room_amount)
    TextView tvOrderThisRoomAmount;
    @BindView(R.id.tv_order_this_date)
    TextView tvOrderThisDate;
    @BindView(R.id.tv_order_this_time)
    TextView tvOrderThisTime;
    @BindView(R.id.tv_order_this_now)
    TextView tvOrderThisNow;
    @BindView(R.id.et_order_this_remarks)
    EditText etOrderThisRemarks;

    String image_url;
    String tea_shop_name;
    String this_shop;
    String address;
    String distance;
    String price;
    String year;
    String month;
    String day;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerWriteOrderInfoComponent.builder()
                .appComponent(appComponent)
                .writeOrderInfoModule(new WriteOrderInfoModule(this)) //请将WriteOrderInfoModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolBar.setToolbarLeftButton(R.mipmap.ic_back);
        toolBar.setToolbarTitle("填写预约信息");
        ivOrderOtherItemPicture.setCornerRadius((float) 10);
        ivOrderOtherItemPicture.setBorderWidth((float) 0);
        Glide.with(WriteOrderInfoActivity.this).load(image_url).placeholder(R.mipmap.picture).crossFade().into(ivOrderOtherItemPicture);
        tvOrderOtherName.setText(tea_shop_name);
        /*if (this_shop) {
            tvOrderOtherStatus.setText("本店");
        } else {
            tvOrderOtherStatus.setText("");
        }*/
        tvOrderOtherStatus.setText("");
        tvOtherAddress.setText(address);
        tvOtherDistance.setText("<100m");
        /*if (Integer.parseInt(distance) < 100) {
            tvOtherDistance.setText("<100m");
        } else if (Integer.parseInt(distance) >= 100 && Integer.parseInt(distance) < 1000) {
            tvOtherDistance.setText(distance + "m");
        } else {
            String d = String.format("%.1f", (double) Integer.parseInt(distance) / 1000);
            tvOtherDistance.setText(d + "m");
        }*/
        tvOrderOtherPrice.setText(price);

        //获取明天日期
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        year = dateString.substring(0, 4);
        month = dateString.substring(5, 7);
        day = dateString.substring(8, 10);
        tvOrderThisDate.setText(dateString);
        tvOrderThisRoomAmount.setText("1间");
    }

    @Override
    protected void initData() {
        Intent intent = this.getIntent();
        image_url = intent.getStringExtra("image_url");
        tea_shop_name = intent.getStringExtra("tea_shop_name");
        this_shop = intent.getStringExtra("this_shop");
        address = intent.getStringExtra("address");
        distance = intent.getStringExtra("distance");
        price = intent.getStringExtra("price");

    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.arl_order_this_room_amount, R.id.arl_order_this_date, R.id.arl_order_this_time, R.id.tv_order_this_now})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                WriteOrderInfoActivity.this.finish();
                break;
            case R.id.arl_order_this_room_amount:
                //BottomDialogRoomAmount dialog = new BottomDialogRoomAmount(getWindowManager().getDefaultDisplay().getHeight() * 765 / 1920, 0.8f, true);
                BottomDialogRoomAmount dialog = new BottomDialogRoomAmount();
                dialog.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 765 / 1920);
                dialog.setDimAmount(0.8f);
                dialog.setCancelOutside(true);
                dialog.show(getSupportFragmentManager());
                dialog.setOnBottomDialogOKListener(new BottomDialogRoomAmount.OnBottomDialogOKListener() {
                    @Override
                    public void onOK(String amount) {
                        tvOrderThisRoomAmount.setText(amount + "间");
                    }
                });
                break;
            case R.id.arl_order_this_date:
                BottomDialogDate dialogDate = new BottomDialogDate();
                dialogDate.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 765 / 1920);
                dialogDate.setDimAmount(0.8f);
                dialogDate.setCancelOutside(true);
                dialogDate.setInit_day(day);
                dialogDate.setInit_month(month);
                dialogDate.setInit_year(year);
                dialogDate.show(getSupportFragmentManager());
                dialogDate.setOnBottomDialogDateOKListener(new BottomDialogDate.OnBottomDialogDateOKListener() {
                    @Override
                    public void onDateOK(String year, String month, String day) {
                        tvOrderThisDate.setText(year + "-" + month + "-" + day);
                    }
                });
                break;
            case R.id.arl_order_this_time:
                //BottomDialogTime dialogTime = new BottomDialogTime(getWindowManager().getDefaultDisplay().getHeight() * 765 / 1920, 0.8f, true);
                BottomDialogTime dialogTime = new BottomDialogTime();
                dialogTime.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 765 / 1920);
                dialogTime.setDimAmount(0.8f);
                dialogTime.setCancelOutside(true);
                dialogTime.show(getSupportFragmentManager());
                dialogTime.setOnBottomDialogTimeOKListener(new BottomDialogTime.OnBottomDialogTimeOKListener() {
                    @Override
                    public void onTimeOK(String startHour, String startMinute, String endHour, String endMinute) {


                        String result = startHour + ":" + startMinute + "-" + endHour + ":" + endMinute;
                        tvOrderThisTime.setText(result);

                    }
                });
                break;
            case R.id.tv_order_this_now:
                if (tvOrderThisRoomAmount.getText().toString().length() == 0) {
                    ToastUtils.showMessage(WriteOrderInfoActivity.this, "预约包间数不能为空！");
                    return;
                }
                if (tvOrderThisDate.getText().toString().length() == 0) {
                    ToastUtils.showMessage(WriteOrderInfoActivity.this, "预约日期不能为空！");
                    return;
                }
                if (tvOrderThisTime.getText().toString().length() == 0) {
                    ToastUtils.showMessage(WriteOrderInfoActivity.this, "预约时段不能为空！");
                    return;
                }
                String[] timeStr = tvOrderThisTime.getText().toString().split("-");
                getPresenter().bespeakShop(SpUtil.getStringSF(WriteOrderInfoActivity.this, Constant.TOKEN)
                        , SpUtil.getStringSF(WriteOrderInfoActivity.this, Constant.MERCHANTID)
                        , tvOrderThisRoomAmount.getText().toString().substring(0, tvOrderThisRoomAmount.getText().toString().length() - 1)
                        , getIntent().getStringExtra("shop_id")
                        , tvOrderThisDate.getText().toString() + " " + timeStr[0] + ":00"
                        , tvOrderThisDate.getText().toString() + " " + timeStr[1] + ":00"
                        , etOrderThisRemarks.getText().toString()

                );
                //WriteOrderInfoActivity.this.finish();
                break;

        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_write_order_info;
    }


    @Override
    public void onBespeakShopSuccess(OrderThis orderThis) {
        //// TODO: 2017/5/31 预约跳转
        ToastUtils.showMessage(WriteOrderInfoActivity.this, "预约成功");
        IntentUtils.showIntentWithInt(this, PersonAppointmentActivity.class, new String[]{"appoint_type"}, new int[]{1});
        WriteOrderInfoActivity.this.finish();

    }

    @Override
    public void onBespeakShopFailed(OrderThis orderThis) {
        if (!TextUtils.isEmpty(orderThis.getApp_msg())) {
            ToastUtils.showMessage(WriteOrderInfoActivity.this, orderThis.getApp_msg());
        }
    }

    @Override
    public void onBespeakShopFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(WriteOrderInfoActivity.this, throwable.getMessage());
        }
    }
}