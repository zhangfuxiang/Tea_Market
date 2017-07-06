package com.delta.smt.ui.HomePage.productDetail;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.makeramen.roundedimageview.RoundedImageView;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

public class BuyNowBottomDialog extends BaseBottomDialog implements View.OnClickListener {

    float dimAmount;
    boolean cancelOutside;
    String pictrue_url;
    String pay_price;
    String name;
    ImageView ivDialogClose;
    RoundedImageView ivDialogProductPicture;
    TextView tvDialogProductName;
    TextView tvDialogProductPrice;
    EditText etBuyAmount;
    ImageView btnAddBuyAmount;
    ImageView btnReduceBuyAmount;
    TextView btnDialogCommitBuy;
    private int height;

    @SuppressLint("ValidFragment")
    public BuyNowBottomDialog(int height, float dimAmount, boolean cancelOutside, String pictrue_url, String pay_price, String name) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
        this.pictrue_url = pictrue_url;
        this.pay_price = pay_price;
        this.name = name;
    }

    public BuyNowBottomDialog() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_product_buy_now;
    }

    @Override
    public void bindView(View v) {
        etBuyAmount = (EditText) v.findViewById(R.id.et_buy_amount);
        btnAddBuyAmount = (ImageView) v.findViewById(R.id.btn_add_buy_amount);
        btnAddBuyAmount.setOnClickListener(this);
        btnReduceBuyAmount = (ImageView) v.findViewById(R.id.btn_reduce_buy_amount);
        btnReduceBuyAmount.setOnClickListener(this);
        ivDialogClose = (ImageView) v.findViewById(R.id.iv_dialog_close);
        ivDialogClose.setOnClickListener(this);
        ivDialogProductPicture = (RoundedImageView) v.findViewById(R.id.iv_dialog_product_picture);
        ivDialogProductPicture.setCornerRadius((float) 10);
        ivDialogProductPicture.setBorderWidth((float) 0);
        tvDialogProductName = (TextView) v.findViewById(R.id.tv_dialog_product_name);
        tvDialogProductName.setText(name);
        tvDialogProductPrice = (TextView) v.findViewById(R.id.tv_dialog_product_price);
        tvDialogProductPrice.setText(pay_price);
        btnDialogCommitBuy = (TextView) v.findViewById(R.id.btn_dialog_commit_buy);
        btnDialogCommitBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Glide.with(this).load(pictrue_url).crossFade().into(ivDialogProductPicture);
        setBtnReduceBuyAmountEnable(false);

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
            case R.id.iv_dialog_close:
                this.dismiss();
                break;
            case R.id.btn_add_buy_amount:
                String s1 = etBuyAmount.getText().toString();
                if (!TextUtils.isEmpty(s1)) {
                    try {
                        int num = Integer.parseInt(s1);
                        etBuyAmount.setText((num + 1) + "");
                        if (num == 1) {
                            setBtnReduceBuyAmountEnable(true);
                        }
                    } catch (Exception e) {
                        ToastUtils.showMessage(getActivity(), "数量格式不正确，请重新输入");
                    }

                } else {
                    ToastUtils.showMessage(getActivity(), "数量不能为空");
                }
                break;
            case R.id.btn_reduce_buy_amount:
                String s2 = etBuyAmount.getText().toString();
                if (!TextUtils.isEmpty(s2)) {
                    try {
                        int num = Integer.parseInt(s2);
                        etBuyAmount.setText((num - 1) + "");
                        if (num == 2) {
                            setBtnReduceBuyAmountEnable(false);
                        }

                    } catch (Exception e) {
                        ToastUtils.showMessage(getActivity(), "数量格式不正确，请重新输入");
                    }

                } else {
                    ToastUtils.showMessage(getActivity(), "数量不能为空");
                }
                break;
        }
    }

    public void setBtnAddBuyAmountEnable(boolean status) {
        if (status) {
            btnAddBuyAmount.setEnabled(true);
            btnAddBuyAmount.setImageResource(R.drawable.ic_cha_add_red);
        } else {
            btnAddBuyAmount.setEnabled(false);
            btnAddBuyAmount.setImageResource(R.drawable.ic_cha_add_red_press);
        }
    }

    public void setBtnReduceBuyAmountEnable(boolean status) {
        if (status) {
            btnReduceBuyAmount.setEnabled(true);
            btnReduceBuyAmount.setImageResource(R.drawable.ic_cha_add_red);
        } else {
            btnReduceBuyAmount.setEnabled(false);
            btnReduceBuyAmount.setImageResource(R.drawable.ic_cha_add_red_press);
        }
    }
}
