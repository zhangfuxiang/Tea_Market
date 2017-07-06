package com.delta.smt.ui.drinktea.order_this;

import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.drinktea.OrderThis;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.PersonAppointmentActivity;
import com.delta.smt.ui.drinktea.order_this.di.DaggerOrderThisComponent;
import com.delta.smt.ui.drinktea.order_this.di.OrderThisModule;
import com.delta.smt.ui.drinktea.order_this.mvp.OrderThisContract;
import com.delta.smt.ui.drinktea.order_this.mvp.OrderThisPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.zhy.autolayout.AutoRelativeLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/5/14.
 */

public class OrderThisActivity extends BaseActivity<OrderThisPresenter> implements OrderThisContract.View {


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
    FindToolBar toolBar;
    private String year;
    private String month;
    private String day;
    private DatePickerDialog.OnDateSetListener Datelistener = new DatePickerDialog.OnDateSetListener() {
        /**params：view：该事件关联的组件
         * params：myyear：当前选择的年
         * params：monthOfYear：当前选择的月
         * params：dayOfMonth：当前选择的日
         */
        @Override
        public void onDateSet(DatePicker view, int myyear, int monthOfYear, int dayOfMonth) {


            //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
            year = myyear + "";
            month = monthOfYear + "";
            day = dayOfMonth + "";
            //更新日期
            updateDate();

        }

        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate() {
            //在TextView上显示日期
            //showdate.setText("当前日期："+year+"-"+(month+1)+"-"+day);
        }
    };

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerOrderThisComponent.builder()
                .appComponent(appComponent)
                .orderThisModule(new OrderThisModule(this)) //请将OrderThis2Module()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {

        //初始化Calendar日历对象
        //Calendar mycalendar = Calendar.getInstance();

        //year = mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        //month = mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        //day = mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天

        toolBar = (FindToolBar) findViewById(R.id.toolbar);
        toolBar.setToolbarTitle("预约本店");
        toolBar.setToolbarLeftButton(R.mipmap.start_page_exit);

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

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_order_this;
    }


    @Override
    public void onBespeakShopSuccess(OrderThis orderThis) {
        //// TODO: 2017/5/31 预约跳转
        ToastUtils.showMessage(OrderThisActivity.this, "预约成功");
        OrderThisActivity.this.finish();
        IntentUtils.showIntentWithInt(this, PersonAppointmentActivity.class,new String[]{"appoint_type"},new int[]{1});
    }

    @Override
    public void onBespeakShopFailed(OrderThis orderThis) {
        if (!TextUtils.isEmpty(orderThis.getApp_msg())) {
            ToastUtils.showMessage(OrderThisActivity.this, orderThis.getApp_msg());
        }
    }

    @Override
    public void onBespeakShopFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(OrderThisActivity.this, throwable.getMessage());
        }
    }

    @OnClick({R.id.arl_order_this_room_amount, R.id.arl_order_this_date, R.id.arl_order_this_time, R.id.toolbar_left_button_arl, R.id.tv_order_this_now})
    public void onClick(View v) {
        if (v.getId() == R.id.arl_order_this_room_amount) {
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
        } else if (v.getId() == R.id.arl_order_this_date) {
            //BottomDialogDate dialogDate = new BottomDialogDate(getWindowManager().getDefaultDisplay().getHeight() * 765 / 1920, 0.8f, true);
            BottomDialogDate dialogDate = new BottomDialogDate();
            dialogDate.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 765 / 1920);
            dialogDate.setDimAmount(0.8f);
            dialogDate.setCancelOutside(true);
            dialogDate.setInit_year(year + "");
            dialogDate.setInit_month(month + "");
            dialogDate.setInit_day(day + "");
            dialogDate.show(getSupportFragmentManager());
            dialogDate.setOnBottomDialogDateOKListener(new BottomDialogDate.OnBottomDialogDateOKListener() {
                @Override
                public void onDateOK(String year, String month, String day) {
                    tvOrderThisDate.setText(year + "-" + month + "-" + day);
                }
            });

        } else if (v.getId() == R.id.arl_order_this_time) {
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
        } else if (v.getId() == R.id.toolbar_left_button_arl) {
            OrderThisActivity.this.finish();
        } else if (v.getId() == R.id.tv_order_this_now) {
            if (tvOrderThisRoomAmount.getText().toString().length() == 0) {
                ToastUtils.showMessage(OrderThisActivity.this, "预约包间数不能为空！");
                return;
            }
            if (tvOrderThisDate.getText().toString().length() == 0) {
                ToastUtils.showMessage(OrderThisActivity.this, "预约日期不能为空！");
                return;
            }
            if (tvOrderThisTime.getText().toString().length() == 0) {
                ToastUtils.showMessage(OrderThisActivity.this, "预约时段不能为空！");
                return;
            }
            String[] timeStr = tvOrderThisTime.getText().toString().split("-");
            String[] dateArr = tvOrderThisDate.getText().toString().split("-");
            String[] timeArr1 = timeStr[0].split(":");
            String[] timeArr2 = timeStr[1].split(":");
            getPresenter().bespeakShop(SpUtil.getStringSF(OrderThisActivity.this, Constant.TOKEN)
                    , SpUtil.getStringSF(OrderThisActivity.this, Constant.MERCHANTID)
                    , tvOrderThisRoomAmount.getText().toString().substring(0, tvOrderThisRoomAmount.getText().toString().length() - 1)
                    , getIntent().getStringExtra("shop_id")
                    //,dateArr[0]+dateArr[1]+dateArr[2]+timeArr1[0]+timeArr1[1]+"00"
                    //,dateArr[0]+dateArr[1]+dateArr[2]+timeArr2[0]+timeArr2[1]+"00"
                    , tvOrderThisDate.getText().toString() + " " + timeStr[0] + ":00"
                    , tvOrderThisDate.getText().toString() + " " + timeStr[1] + ":00"
                    , etOrderThisRemarks.getText().toString()

            );

        }
    }
}