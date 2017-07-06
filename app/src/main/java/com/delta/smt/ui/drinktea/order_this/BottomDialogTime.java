package com.delta.smt.ui.drinktea.order_this;

import android.view.View;

import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by wushufeng on 2017/4/16.
 */

public class BottomDialogTime extends BaseBottomDialog implements View.OnClickListener {

    AutoRelativeLayout btnClose;
    AutoRelativeLayout btnOk;
    WheelView mWheelViewStartHour;
    WheelView mWheelViewStartMinute;
    WheelView mWheelViewEndMinute;
    WheelView mWheelViewEndHour;
    int height;
    float dimAmount;
    boolean cancelOutside;
    String TAG = "BottomDialogTime";
    OnBottomDialogTimeOKListener listener;
    private String[] startHourArray;
    private String[] startMinuteArray;
    private String[] endHourArray;
    private String[] endMinuteArray;

    /*@SuppressLint("ValidFragment")
    public BottomDialogTime(int height, float dimAmount, boolean cancelOutside) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
    }*/

    public BottomDialogTime() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.bottom_dialog_time;
    }

    @Override
    public void bindView(View v) {
        startHourArray = new String[]{"00", "01", "02", "03", "04",
                "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19",
                "20", "21", "22", "23"};
        startMinuteArray = new String[]{"00", "30"};
        endHourArray = new String[]{"00", "01", "02", "03", "04",
                "05", "06", "07", "08", "09",
                "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19",
                "20", "21", "22", "23"};
        endMinuteArray = new String[]{"00", "30"};
        btnClose = (AutoRelativeLayout) v.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        btnOk = (AutoRelativeLayout) v.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
        ArrayList<String> startHourArrayList = new ArrayList<>();
        for (int i = 0; i < startHourArray.length; i++) {
            startHourArrayList.add(startHourArray[i]);
        }

        ArrayList<String> startMinuteArrayList = new ArrayList<>();
        for (int i = 0; i < startMinuteArray.length; i++) {
            startMinuteArrayList.add(startMinuteArray[i]);
        }

        ArrayList<String> endHourArrayList = new ArrayList<>();
        for (int i = 0; i < endHourArray.length; i++) {
            endHourArrayList.add(endHourArray[i]);
        }

        ArrayList<String> endMinuteArrayList = new ArrayList<>();
        for (int i = 0; i < endMinuteArray.length; i++) {
            endMinuteArrayList.add(endMinuteArray[i]);
        }

        mWheelViewStartHour = (WheelView) v.findViewById(R.id.mWheelViewStartHour);
        mWheelViewStartMinute = (WheelView) v.findViewById(R.id.mWheelViewStartMinute);
        mWheelViewEndMinute = (WheelView) v.findViewById(R.id.mWheelViewEndMinute);
        mWheelViewEndHour = (WheelView) v.findViewById(R.id.mWheelViewEndHour);
        mWheelViewStartHour.setData(startHourArrayList);
        mWheelViewStartMinute.setData(startMinuteArrayList);
        mWheelViewEndHour.setData(endHourArrayList);
        mWheelViewEndMinute.setData(endMinuteArrayList);
        mWheelViewStartHour.setDefault(0);
        mWheelViewStartMinute.setDefault(0);
        mWheelViewEndHour.setDefault(0);
        mWheelViewEndMinute.setDefault(0);


    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public float getDimAmount() {
        return dimAmount;
    }

    public void setDimAmount(float dimAmount) {
        this.dimAmount = dimAmount;
    }

    @Override
    public boolean getCancelOutside() {
        return cancelOutside;
    }

    public void setCancelOutside(boolean cancelOutside) {
        this.cancelOutside = cancelOutside;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close:

                this.dismiss();
                break;
            case R.id.btn_ok:
                String startHour = mWheelViewStartHour.getSelectedText();
                String startMinute = mWheelViewStartMinute.getSelectedText();
                String endHour = mWheelViewEndHour.getSelectedText();
                String endMinute = mWheelViewEndMinute.getSelectedText();
                if (Integer.parseInt(startHour) > Integer.parseInt(endHour)) {
                    ToastUtils.showMessage(getActivity(), "开始时间必须早于结束时间！");
                } else if (Integer.parseInt(startHour) == Integer.parseInt(endHour)) {
                    if (Integer.parseInt(startMinute) >= Integer.parseInt(endMinute)) {
                        ToastUtils.showMessage(getActivity(), "开始时间必须早于结束时间！");
                    } else {
                        String result = startHour + ":" + startMinute + "-" + endHour + ":" + endMinute;
                        listener.onTimeOK(startHour, startMinute, endHour, endMinute);
                        this.dismiss();
                    }
                } else {
                    String result = startHour + ":" + startMinute + "-" + endHour + ":" + endMinute;
                    listener.onTimeOK(startHour, startMinute, endHour, endMinute);
                    this.dismiss();
                }

                break;
        }
    }

    public void setOnBottomDialogTimeOKListener(OnBottomDialogTimeOKListener listener) {
        this.listener = listener;
    }

    public interface OnBottomDialogTimeOKListener {
        void onTimeOK(String startHour, String startMinute, String endHour, String endMinute);
    }

}
