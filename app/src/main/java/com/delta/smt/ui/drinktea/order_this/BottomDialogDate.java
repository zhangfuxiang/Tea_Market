package com.delta.smt.ui.drinktea.order_this;

import android.util.Log;
import android.view.View;

import com.delta.smt.R;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.Calendar;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by wushufeng on 2017/4/16.
 */

public class BottomDialogDate extends BaseBottomDialog implements View.OnClickListener {

    AutoRelativeLayout btnClose;
    AutoRelativeLayout btnOk;
    WheelView mWheelViewYear;
    WheelView mWheelViewMonth;
    WheelView mWheelViewDay;
    int height;
    float dimAmount;
    boolean cancelOutside;
    String TAG = "BottomDialogRoomAmount";
    OnBottomDialogDateOKListener listener;
    String year;
    String month;
    String day;
    String init_year;
    String init_month;
    String init_day;
    private String[] yearArray;
    private String[] monthArray;
    private String[] day_lib;
    private String[] dayArray;

    public BottomDialogDate() {
        super();
    }

    public void setInit_year(String init_year) {
        this.init_year = init_year;
    }

    public void setInit_month(String init_month) {
        this.init_month = init_month;
    }

    public void setInit_day(String init_day) {
        this.init_day = init_day;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.bottom_dialog_date;
    }

    @Override
    public void bindView(View v) {
        Calendar c = Calendar.getInstance();//首先要获取日历对象
        int nowYear = c.get(Calendar.YEAR);
        yearArray = new String[30];
        for (int i = 0; i < yearArray.length; i++) {
            yearArray[i] = (nowYear + i) + "";
        }
        year = yearArray[0];
        monthArray = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        month = monthArray[0];
        day_lib = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10"
                , "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"
                , "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        btnClose = (AutoRelativeLayout) v.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        btnOk = (AutoRelativeLayout) v.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
        ArrayList<String> yearArrayList = new ArrayList<>();
        for (int i = 0; i < yearArray.length; i++) {
            yearArrayList.add(yearArray[i]);
        }

        ArrayList<String> monthArrayList = new ArrayList<>();
        for (int i = 0; i < monthArray.length; i++) {
            monthArrayList.add(monthArray[i]);
        }

        ArrayList<String> dayArrayList = new ArrayList<>();
        dayArray = day_lib.clone();
        dayArrayList.clear();
        for (int i = 0; i < dayArray.length; i++) {
            dayArrayList.add(dayArray[i]);
        }

        mWheelViewYear = (WheelView) v.findViewById(R.id.mWheelViewYear);
        mWheelViewMonth = (WheelView) v.findViewById(R.id.mWheelViewMonth);
        mWheelViewDay = (WheelView) v.findViewById(R.id.mWheelViewDay);
        mWheelViewYear.setData(yearArrayList);
        mWheelViewMonth.setData(monthArrayList);
        mWheelViewDay.setData(dayArrayList);
        mWheelViewYear.setDefault(0);
        mWheelViewMonth.setDefault(0);
        mWheelViewDay.setDefault(0);
        mWheelViewYear.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {

                Log.i(TAG, "endSelect: ");
                year = text;
                ArrayList<String> dayArrayList = new ArrayList<>();
                if (month.equals("01") || month.equals("03") || month.equals("05") || month.equals("07") || month.equals("08") || month.equals("10") || month.equals("12")) {
                    dayArray = day_lib.clone();
                    dayArrayList.clear();
                    for (int i = 0; i < dayArray.length; i++) {
                        dayArrayList.add(dayArray[i]);
                    }
                } else if (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) {
                    dayArray = new String[30];
                    System.arraycopy(day_lib, 0, dayArray, 0, dayArray.length);
                    dayArrayList.clear();
                    for (int i = 0; i < dayArray.length; i++) {
                        dayArrayList.add(dayArray[i]);
                    }
                } else {
                    if (Integer.parseInt(year) % 4 != 0) {
                        dayArray = new String[28];
                    } else {
                        if (Integer.parseInt(year) % 100 == 0) {
                            if (Integer.parseInt(year) % 400 == 0) {
                                dayArray = new String[29];
                            } else {
                                dayArray = new String[28];
                            }
                        } else {
                            dayArray = new String[29];
                        }
                    }
                    System.arraycopy(day_lib, 0, dayArray, 0, dayArray.length);
                    dayArrayList.clear();
                    for (int i = 0; i < dayArray.length; i++) {
                        dayArrayList.add(dayArray[i]);
                    }
                }
                mWheelViewDay.refreshData(dayArrayList);
            }

            @Override
            public void selecting(int id, String text) {
                Log.i(TAG, "selecting: ");

            }
        });

        mWheelViewMonth.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                Log.i(TAG, "endSelect: ");
                month = text;
                ArrayList<String> dayArrayList = new ArrayList<>();
                if (month.equals("01") || month.equals("03") || month.equals("05") || month.equals("07") || month.equals("08") || month.equals("10") || month.equals("12")) {
                    dayArray = day_lib.clone();
                    dayArrayList.clear();
                    for (int i = 0; i < dayArray.length; i++) {
                        dayArrayList.add(dayArray[i]);
                    }
                } else if (month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) {
                    dayArray = new String[30];
                    System.arraycopy(day_lib, 0, dayArray, 0, dayArray.length);
                    dayArrayList.clear();
                    for (int i = 0; i < dayArray.length; i++) {
                        dayArrayList.add(dayArray[i]);
                    }
                } else {
                    if (Integer.parseInt(year) % 4 != 0) {
                        dayArray = new String[28];
                    } else {
                        if (Integer.parseInt(year) % 100 == 0) {
                            if (Integer.parseInt(year) % 400 == 0) {
                                dayArray = new String[29];
                            } else {
                                dayArray = new String[28];
                            }
                        } else {
                            dayArray = new String[29];
                        }
                    }
                    System.arraycopy(day_lib, 0, dayArray, 0, dayArray.length);
                    dayArrayList.clear();
                    for (int i = 0; i < dayArray.length; i++) {
                        dayArrayList.add(dayArray[i]);
                    }
                }
                mWheelViewDay.refreshData(dayArrayList);

            }

            @Override
            public void selecting(int id, String text) {
                Log.i(TAG, "selecting: ");

            }
        });


        mWheelViewDay.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                day = text;
            }

            @Override
            public void selecting(int id, String text) {

            }
        });

        mWheelViewYear.setDefault(init_year.equals(yearArray[0]) ? 0 : 1);
        mWheelViewMonth.setDefault(Integer.parseInt(init_month) - 1);
        mWheelViewDay.setDefault(Integer.parseInt(init_day) - 1);

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
                listener.onDateOK(mWheelViewYear.getSelectedText(), mWheelViewMonth.getSelectedText(), mWheelViewDay.getSelectedText());
                this.dismiss();
                break;
        }
    }

    public void setOnBottomDialogDateOKListener(OnBottomDialogDateOKListener listener) {
        this.listener = listener;
    }

    public interface OnBottomDialogDateOKListener {
        void onDateOK(String year, String month, String day);
    }

}
