package com.delta.smt.ui.buycar.addNewAddress;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.delta.smt.R;
import com.delta.smt.entity.cart.AddressAreaResult;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by wushufeng on 2017/4/16.
 */

public class BottomDialogArea extends BaseBottomDialog implements View.OnClickListener {

    AutoRelativeLayout btnClose;
    AutoRelativeLayout btnOk;
    WheelView mWheelViewProvince;
    WheelView mWheelViewCity;
    WheelView mWheelViewArea;
    int height;
    float dimAmount;
    boolean cancelOutside;
    String TAG = "BottomDialogRoomAmount";
    OnBottomDialogDateOKListener listener;
    String province;
    String city;
    String area;
    String location_id;
    //private String[] provinceArray;
    //private String[] cityArray;
    //private String[] areaArray;
    AddressAreaResult addressAreaResult;

    ArrayList<String> provinceArrayList = new ArrayList<>();
    ArrayList<String> cityArrayList = new ArrayList<>();
    ArrayList<String> areaArrayList = new ArrayList<>();
    List<AddressAreaResult.ResultBean.ListBean.SubBeanX> subBeanX;
    List<AddressAreaResult.ResultBean.ListBean.SubBeanX.SubBean> subBean;

    @SuppressLint("ValidFragment")
    public BottomDialogArea(int height, float dimAmount, boolean cancelOutside, AddressAreaResult addressAreaResult) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
        this.addressAreaResult = addressAreaResult;
    }

    public BottomDialogArea() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.bottom_dialog_area;
    }

    @Override
    public void bindView(View v) {
        mWheelViewProvince = (WheelView) v.findViewById(R.id.mWheelViewProvince);
        mWheelViewCity = (WheelView) v.findViewById(R.id.mWheelViewCity);
        mWheelViewArea = (WheelView) v.findViewById(R.id.mWheelViewArea);

        btnClose = (AutoRelativeLayout) v.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        btnOk = (AutoRelativeLayout) v.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
        provinceArrayList.clear();
        for (int i = 0; i < addressAreaResult.getResult().getList().size(); i++) {
            provinceArrayList.add(addressAreaResult.getResult().getList().get(i).getName());
        }
        mWheelViewProvince.setData(provinceArrayList);
        mWheelViewProvince.setDefault(0);

        cityArrayList.clear();
        for (int i = 0; i < addressAreaResult.getResult().getList().get(0).getSub().size(); i++) {
            cityArrayList.add(addressAreaResult.getResult().getList().get(0).getSub().get(i).getName());
        }
        mWheelViewCity.setData(cityArrayList);
        mWheelViewCity.setDefault(0);
        subBeanX = addressAreaResult.getResult().getList().get(0).getSub();

        areaArrayList.clear();
        for (int i = 0; i < addressAreaResult.getResult().getList().get(0).getSub().get(0).getSub().size(); i++) {
            areaArrayList.add(addressAreaResult.getResult().getList().get(0).getSub().get(0).getSub().get(i).getName());
        }
        mWheelViewArea.setData(areaArrayList);
        mWheelViewArea.setDefault(0);
        subBean = subBeanX.get(0).getSub();


        mWheelViewProvince.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {

                Log.i(TAG, "endSelect: " + id);
                province = text;
                cityArrayList.clear();

                subBeanX = addressAreaResult.getResult().getList().get(id).getSub();
                for (int i = 0; i < subBeanX.size(); i++) {
                    cityArrayList.add(subBeanX.get(i).getName());
                }

                mWheelViewCity.setData(cityArrayList);

                if (subBeanX.size() > 0) {
                    mWheelViewCity.setDefault(0);
                    mWheelViewCity.refreshData(cityArrayList);

                    areaArrayList.clear();
                    for (int i = 0; i < subBeanX.get(0).getSub().size(); i++) {
                        areaArrayList.add(subBeanX.get(0).getSub().get(i).getName());
                    }
                    mWheelViewCity.setEnable(true);
                    mWheelViewArea.setData(areaArrayList);
                    if (subBeanX.get(0).getSub().size() > 0) {
                        mWheelViewArea.setDefault(0);
                        mWheelViewArea.refreshData(areaArrayList);
                        mWheelViewArea.setEnable(true);
                    } else {
                        areaArrayList = new ArrayList<>();
                        areaArrayList.add("");
                        mWheelViewArea.refreshData(areaArrayList);
                        mWheelViewArea.setEnable(false);
                    }
                } else {
                    cityArrayList = new ArrayList<>();
                    cityArrayList.add("");
                    mWheelViewCity.refreshData(cityArrayList);
                    mWheelViewCity.setEnable(false);

                    mWheelViewArea.setData(areaArrayList);
                    areaArrayList = new ArrayList<>();
                    areaArrayList.add("");
                    mWheelViewArea.refreshData(areaArrayList);
                    mWheelViewArea.setEnable(false);
                }
            }

            @Override
            public void selecting(int id, String text) {
                Log.i(TAG, "selecting: ");

            }
        });
        mWheelViewCity.setOnSelectListener(new WheelView.OnSelectListener() {

            @Override
            public void endSelect(int id, String text) {
                city = text;
                areaArrayList.clear();

                subBean = subBeanX.get(id).getSub();
                for (int i = 0; i < subBean.size(); i++) {
                    areaArrayList.add(subBean.get(i).getName());
                }

                mWheelViewArea.setData(areaArrayList);


                if (subBean.size() > 0) {
                    mWheelViewArea.setDefault(0);
                    mWheelViewArea.refreshData(areaArrayList);
                    mWheelViewArea.setEnable(true);
                } else {
                    areaArrayList = new ArrayList<>();
                    areaArrayList.add("");
                    mWheelViewArea.refreshData(areaArrayList);
                    mWheelViewArea.setEnable(false);
                }
            }

            @Override
            public void selecting(int id, String text) {

            }
        });
        mWheelViewArea.setOnSelectListener(new WheelView.OnSelectListener() {

            @Override
            public void endSelect(int id, String text) {
                area = text;

            }

            @Override
            public void selecting(int id, String text) {

            }
        });

    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public float getDimAmount() {
        return dimAmount;
    }

    @Override
    public boolean getCancelOutside() {
        return cancelOutside;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close:

                this.dismiss();
                break;
            case R.id.btn_ok:
                if (!TextUtils.isEmpty(mWheelViewArea.getSelectedText())) {
                    location_id = subBean.get(mWheelViewArea.getSelected()).getId();
                } else {
                    if (!TextUtils.isEmpty(mWheelViewCity.getSelectedText())) {
                        location_id = subBeanX.get(mWheelViewCity.getSelected()).getId();
                    } else {
                        location_id = addressAreaResult.getResult().getList().get(mWheelViewProvince.getSelected()).getId();
                    }
                }
                listener.onDateOK(mWheelViewProvince.getSelectedText(), mWheelViewCity.getSelectedText(), mWheelViewArea.getSelectedText(), location_id);
                this.dismiss();
                break;
        }
    }

    public void setOnBottomDialogDateOKListener(OnBottomDialogDateOKListener listener) {
        this.listener = listener;
    }

    public interface OnBottomDialogDateOKListener {
        void onDateOK(String province, String city, String area, String location_id);
    }

}
