package com.delta.smt.ui.Personal.setting.advice_response.change_response_type;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.delta.smt.R;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public class ChangeTypeBottomDialog extends BaseBottomDialog implements View.OnClickListener {

    TextView tv_product_quality;
    TextView tv_function_advice;
    TextView tv_other;
    TextView tv_cancel;
    int height;
    float dimAmount;
    boolean cancelOutside;
    ChangeTypeBottomDialog.OnBottomDialogDimissListener listener;

    @SuppressLint("ValidFragment")
    public ChangeTypeBottomDialog(int height, float dimAmount, boolean cancelOutside) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
    }

    public ChangeTypeBottomDialog() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_response_type;
    }

    @Override
    public void bindView(View v) {
        tv_product_quality = (TextView) v.findViewById(R.id.tv_product_quality);
        tv_product_quality.setOnClickListener(this);
        tv_function_advice = (TextView) v.findViewById(R.id.tv_function_advice);
        tv_function_advice.setOnClickListener(this);
        tv_other = (TextView) v.findViewById(R.id.tv_other);
        tv_other.setOnClickListener(this);
        tv_cancel = (TextView) v.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(this);

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
            case R.id.tv_product_quality:
                listener.onDismiss("商品质量");
                this.dismiss();
                break;
            case R.id.tv_function_advice:
                listener.onDismiss("产品功能建议");
                this.dismiss();
                break;
            case R.id.tv_other:
                listener.onDismiss("其他");
                this.dismiss();
                break;
            case R.id.tv_cancel:
                this.dismiss();
                break;
        }
    }

    public void setOnBottomDialogDimissListener(ChangeTypeBottomDialog.OnBottomDialogDimissListener listener) {
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
