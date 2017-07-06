package com.delta.smt.ui.drinktea.order_this;

import android.view.View;

import com.delta.smt.R;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by wushufeng on 2017/4/16.
 */

public class BottomDialogRoomAmount extends BaseBottomDialog implements View.OnClickListener {

    AutoRelativeLayout btnClose;
    AutoRelativeLayout btnOk;
    WheelView mWheelView;
    int height;
    float dimAmount;
    boolean cancelOutside;
    String TAG = "BottomDialogRoomAmount";
    OnBottomDialogOKListener listener;
    private String[] PLANETS;

    /*@SuppressLint("ValidFragment")
    public BottomDialogRoomAmount(int height, float dimAmount, boolean cancelOutside) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
    }*/

    public BottomDialogRoomAmount() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.bottom_dialog_room_amount;
    }

    @Override
    public void bindView(View v) {
        PLANETS = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        btnClose = (AutoRelativeLayout) v.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);
        btnOk = (AutoRelativeLayout) v.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
        mWheelView = (WheelView) v.findViewById(R.id.mWheelView);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < PLANETS.length; i++) {
            arrayList.add(PLANETS[i]);
        }
        mWheelView.setData(arrayList);
        mWheelView.setCyclic(false);
        /*mWheelView.setOffset(1);
        mWheelView.setItems(Arrays.asList(PLANETS));
        mWheelView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                Log.d(TAG, "selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });*/
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
                listener.onOK(mWheelView.getSelectedText());
                this.dismiss();
                break;
        }
    }

    public void setOnBottomDialogOKListener(OnBottomDialogOKListener listener) {
        this.listener = listener;
    }

    public interface OnBottomDialogOKListener {
        void onOK(String amount);
    }

}
