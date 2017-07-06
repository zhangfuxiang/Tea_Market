package com.delta.smt.ui.Personal.setting.clear_cache;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.delta.smt.R;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Fuxiang.Zhang on 2017/5/2.
 */

public class ClearCacheBottomDialog extends BaseBottomDialog implements View.OnClickListener {
    TextView tvClearCacher;
    TextView tvDrinkteaCancel;
    int height;
    float dimAmount;
    boolean cancelOutside;
    ClearCacheBottomDialog.OnBottomDialogDimissListener listener;

    @SuppressLint("ValidFragment")
    public ClearCacheBottomDialog(int height, float dimAmount, boolean cancelOutside) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
    }

    public ClearCacheBottomDialog() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_clear_cacher;
    }

    @Override
    public void bindView(View v) {
        tvClearCacher = (TextView) v.findViewById(R.id.tv_clear_cacher);
        tvClearCacher.setOnClickListener(this);
        tvDrinkteaCancel = (TextView) v.findViewById(R.id.tv_cancel);
        tvDrinkteaCancel.setOnClickListener(this);

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
            case R.id.tv_clear_cacher:
                listener.onDismiss();
                this.dismiss();
                break;
            case R.id.tv_cancel:
                listener.onDismiss();
                this.dismiss();
                break;
        }
    }

    public void setOnBottomDialogDimissListener(ClearCacheBottomDialog.OnBottomDialogDimissListener listener) {
        this.listener = listener;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        listener.onDismiss();
    }




    public interface OnBottomDialogDimissListener {
        void onDismiss();
    }
}
