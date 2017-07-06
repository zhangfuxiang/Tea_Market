package com.delta.smt.ui.Personal.setting.person_information.change_sex;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.delta.smt.R;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public class ChangeSexBottomDialog extends BaseBottomDialog implements View.OnClickListener {

    TextView tvWoman;
    TextView tvMan;
    TextView tvClearCacher;
    int height;
    float dimAmount;
    boolean cancelOutside;
    ChangeSexBottomDialog.OnBottomDialogDimissListener listener;

    @SuppressLint("ValidFragment")
    public ChangeSexBottomDialog(int height, float dimAmount, boolean cancelOutside) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
    }

    public ChangeSexBottomDialog() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_change_sex;
    }

    @Override
    public void bindView(View v) {
        tvMan = (TextView) v.findViewById(R.id.tv_man);
        tvMan.setOnClickListener(this);
        tvWoman = (TextView) v.findViewById(R.id.tv_woman);
        tvWoman.setOnClickListener(this);
        tvClearCacher = (TextView) v.findViewById(R.id.tv_cancel);
        tvClearCacher.setOnClickListener(this);

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
            case R.id.tv_man:
                listener.onDismiss("男");
                this.dismiss();
                break;
            case R.id.tv_woman:
                listener.onDismiss("女");
                this.dismiss();
                break;
            case R.id.tv_cancel:
                this.dismiss();
                break;
        }
    }

    public void setOnBottomDialogDimissListener(ChangeSexBottomDialog.OnBottomDialogDimissListener listener) {
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
