package com.delta.smt.ui.buycar.confirmOrder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.delta.smt.R;
import com.zhy.autolayout.AutoRelativeLayout;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

public class PayMethodBottomDialog extends BaseBottomDialog implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    AutoRelativeLayout btnBalancePay;
    AutoRelativeLayout btnAlipayPay;
    AutoRelativeLayout btnWechatPay;
    CheckBox cbCheckBalancePay;
    CheckBox cbCheckAlipayPay;
    CheckBox cbCheckWechatPay;
    int height;
    float dimAmount;
    boolean cancelOutside;

    OnBottomDialogMethodListener listener;

    /*public PayMethodBottomDialog(int height, float dimAmount, boolean cancelOutside) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
    }*/

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDimAmount(float dimAmount) {
        this.dimAmount = dimAmount;
    }

    public void setCancelOutside(boolean cancelOutside) {
        this.cancelOutside = cancelOutside;
    }

    public PayMethodBottomDialog() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.bottomdialog_pay_method;
    }

    @Override
    public void bindView(View v) {
        btnBalancePay = (AutoRelativeLayout) v.findViewById(R.id.btn_balance_pay);
        btnBalancePay.setOnClickListener(this);
        btnAlipayPay = (AutoRelativeLayout) v.findViewById(R.id.btn_alipay_pay);
        btnAlipayPay.setOnClickListener(this);
        btnWechatPay = (AutoRelativeLayout) v.findViewById(R.id.btn_wechat_pay);
        btnWechatPay.setOnClickListener(this);
        cbCheckBalancePay = (CheckBox) v.findViewById(R.id.cb_check_balance_pay);
        cbCheckBalancePay.setOnCheckedChangeListener(this);
        cbCheckAlipayPay = (CheckBox) v.findViewById(R.id.cb_check_alipay_pay);
        cbCheckAlipayPay.setOnCheckedChangeListener(this);
        cbCheckWechatPay = (CheckBox) v.findViewById(R.id.cb_check_wechat_pay);
        cbCheckWechatPay.setOnCheckedChangeListener(this);

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
            case R.id.btn_balance_pay:
                if (cbCheckBalancePay.isChecked()) {
                    cbCheckBalancePay.setChecked(false);
                } else {
                    cbCheckBalancePay.setChecked(true);
                }
                break;
            case R.id.btn_alipay_pay:
                if (cbCheckAlipayPay.isChecked()) {
                    cbCheckAlipayPay.setChecked(false);
                } else {
                    cbCheckAlipayPay.setChecked(true);
                }
                break;
            case R.id.btn_wechat_pay:
                if (cbCheckWechatPay.isChecked()) {
                    cbCheckWechatPay.setChecked(false);
                } else {
                    cbCheckWechatPay.setChecked(true);
                }
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cb_check_balance_pay:
                if (isChecked) {
                    //ToastUtils.showMessage(getContext(), "余额支付");
                    cbCheckAlipayPay.setChecked(false);
                    cbCheckWechatPay.setChecked(false);
                    listener.onMethodOK("余额支付");
                    this.dismiss();
                }

                break;
            case R.id.cb_check_alipay_pay:
                if (isChecked) {
                    //ToastUtils.showMessage(getContext(), "支付宝支付");
                    cbCheckBalancePay.setChecked(false);
                    cbCheckWechatPay.setChecked(false);
                    listener.onMethodOK("支付宝支付");
                    this.dismiss();
                }
                break;
            case R.id.cb_check_wechat_pay:
                if (isChecked) {
                    //ToastUtils.showMessage(getContext(), "微信支付");
                    cbCheckAlipayPay.setChecked(false);
                    cbCheckBalancePay.setChecked(false);
                    listener.onMethodOK("微信支付");
                    this.dismiss();
                }
                break;
        }
    }

    public void setOnBottomDialogMethodListener(OnBottomDialogMethodListener listener) {
        this.listener = listener;
    }

    public interface OnBottomDialogMethodListener {
        void onMethodOK(String method);
    }
}
