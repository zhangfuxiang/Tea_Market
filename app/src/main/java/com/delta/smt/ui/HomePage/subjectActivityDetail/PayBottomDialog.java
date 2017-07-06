package com.delta.smt.ui.HomePage.subjectActivityDetail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.smt.R;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhy.autolayout.AutoRelativeLayout;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

public class PayBottomDialog extends BaseBottomDialog implements View.OnClickListener, InputPasswordBottomDialog.OnSignUpListener {

    float dimAmount;
    boolean cancelOutside;
    String pictrue_url;
    String pay_price;
    String name;
    ImageView ivDialogClose;
    RoundedImageView ivDialogSubjectPicture;
    TextView tvDialogSubjectName;
    TextView tvDialogPaymentMethod;
    TextView tvDialogPaymentPrice;
    TextView btnDialogSurePay;
    AutoRelativeLayout arlDialogPaymentMethod;
    OnSignUpPayListener listener;
    String pay_type;
    private int height;


    /*public PayBottomDialog(int height, float dimAmount, boolean cancelOutside, String pictrue_url, String pay_price, String name) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
        this.pictrue_url = pictrue_url;
        this.pay_price = pay_price;
        this.name = name;
    }*/

    public PayBottomDialog() {
        super();
    }

    public void setPictrue_url(String pictrue_url) {
        this.pictrue_url = pictrue_url;
    }

    public void setPay_price(String pay_price) {
        this.pay_price = pay_price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_sign_up_subject;
    }

    @Override
    public void bindView(View v) {
        ivDialogClose = (ImageView) v.findViewById(R.id.iv_dialog_close_dialog);
        ivDialogClose.setOnClickListener(this);
        ivDialogSubjectPicture = (RoundedImageView) v.findViewById(R.id.iv_dialog_subject_picture);
        ivDialogSubjectPicture.setCornerRadius((float) 10);
        ivDialogSubjectPicture.setBorderWidth((float) 0);
        tvDialogSubjectName = (TextView) v.findViewById(R.id.tv_dialog_subject_name);
        tvDialogSubjectName.setText(name);
        tvDialogPaymentMethod = (TextView) v.findViewById(R.id.tv_dialog_payment_method);
        tvDialogPaymentMethod.setOnClickListener(this);
        tvDialogPaymentPrice = (TextView) v.findViewById(R.id.tv_dialog_payment_price);
        tvDialogPaymentPrice.setText(pay_price);
        arlDialogPaymentMethod = (AutoRelativeLayout) v.findViewById(R.id.arl_dialog_payment_method);
        arlDialogPaymentMethod.setOnClickListener(this);
        btnDialogSurePay = (TextView) v.findViewById(R.id.btn_dialog_sure_pay);
        btnDialogSurePay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputPasswordBottomDialog dialog = new InputPasswordBottomDialog();
                dialog.setHeight(getActivity().getWindowManager().getDefaultDisplay().getHeight() * 1250 / 1920);
                dialog.setDimAmount(0.8f);
                dialog.setCancelOutside(true);
                dialog.show(getActivity().getSupportFragmentManager());
                //PayBottomDialog.this.dismiss();
                dialog.setOnSignUpListener(PayBottomDialog.this);
            }
        });
        Glide.with(this).load(pictrue_url).crossFade().thumbnail(0.1f).into(ivDialogSubjectPicture);

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
            case R.id.iv_dialog_close_dialog:
                this.dismiss();
                break;
            case R.id.arl_dialog_payment_method:
                //PayMethodBottomDialog dialog = new PayMethodBottomDialog(getActivity().getWindowManager().getDefaultDisplay().getHeight() * 570 / 1920, 0.8f, true);
                PayMethodBottomDialog dialog = new PayMethodBottomDialog();
                dialog.setHeight(getActivity().getWindowManager().getDefaultDisplay().getHeight() * 570 / 1920);
                dialog.setDimAmount(0.8f);
                dialog.setCancelOutside(true);
                dialog.show(getActivity().getSupportFragmentManager());
                dialog.setOnBottomDialogMethodListener(new PayMethodBottomDialog.OnBottomDialogMethodListener() {
                    @Override
                    public void onMethodOK(String method) {
                        tvDialogPaymentMethod.setText(method);
                    }
                });

                break;
        }
    }

    @Override
    public void onSignUp(String pwd) {
        if (tvDialogPaymentMethod.getText().equals("余额支付")) {
            pay_type = "3";
        } else if (tvDialogPaymentMethod.getText().equals("支付宝支付")) {
            pay_type = "1";
        } else if (tvDialogPaymentMethod.getText().equals("微信支付")) {
            pay_type = "2";
        }
        listener.onSignUpPay(pwd, pay_type);
        this.dismiss();
    }

    public void setOnSignUpPayListener(OnSignUpPayListener listener) {
        this.listener = listener;
    }

    interface OnSignUpPayListener {
        void onSignUpPay(String pwd, String pay_type);
    }


}
