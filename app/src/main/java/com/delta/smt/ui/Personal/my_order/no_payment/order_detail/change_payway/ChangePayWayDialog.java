package com.delta.smt.ui.Personal.my_order.no_payment.order_detail.change_payway;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.delta.smt.R;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public class ChangePayWayDialog extends BaseBottomDialog implements View.OnClickListener {

    TextView tv_black;
    TextView tv_zhifubao;
    TextView tv_weixin;
    int height;
    float dimAmount;
    boolean cancelOutside;
    ChangePayWayDialog.OnBottomDialogDimissListener listener;

    @SuppressLint("ValidFragment")
    public ChangePayWayDialog(int height, float dimAmount, boolean cancelOutside) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
    }

    public ChangePayWayDialog() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_change_payway;
    }

    @Override
    public void bindView(View v) {
        tv_black = (TextView) v.findViewById(R.id.tv_black);
        tv_black.setOnClickListener(this);
        tv_zhifubao = (TextView) v.findViewById(R.id.tv_zhifubao);
        tv_zhifubao.setOnClickListener(this);
        tv_weixin = (TextView) v.findViewById(R.id.tv_weixin);
        tv_weixin.setOnClickListener(this);

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
            case R.id.tv_black:
                listener.onDismiss("余额支付");
                this.dismiss();
                break;
            case R.id.tv_zhifubao:
                listener.onDismiss("支付宝支付");
                this.dismiss();
                break;
            case R.id.tv_weixin:
                listener.onDismiss("微信支付");
                this.dismiss();
                break;
        }
    }

    public void setOnBottomDialogDimissListener(ChangePayWayDialog.OnBottomDialogDimissListener listener) {
        this.listener = listener;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }




    public interface OnBottomDialogDimissListener {
        void onDismiss(String content);
    }
}
