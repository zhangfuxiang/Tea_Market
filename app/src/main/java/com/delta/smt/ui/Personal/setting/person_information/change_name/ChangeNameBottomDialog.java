package com.delta.smt.ui.Personal.setting.person_information.change_name;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.delta.smt.R;

import java.security.spec.DSAPrivateKeySpec;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public class ChangeNameBottomDialog extends BaseBottomDialog implements View.OnClickListener {

    int height;
    float dimAmount;
    boolean cancelOutside;
    OnBottomDialogDimissListener listener;
    private String name;
    EditText mEtName;
    TextView mTvConfirm;
    TextView mTvCancel;

    @SuppressLint("ValidFragment")
    public ChangeNameBottomDialog(int height, float dimAmount, boolean cancelOutside, String name) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
        this.name=name;
    }

    public ChangeNameBottomDialog() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_change_name;
    }

    @Override
    public void bindView(View v) {
        mEtName=(EditText) v.findViewById(R.id.et_name);
        mEtName.setOnClickListener(this);
        mTvConfirm= (TextView) v.findViewById(R.id.tv_confirm);
        mTvConfirm.setOnClickListener(this);
        mTvCancel=(TextView) v.findViewById(R.id.tv_cancel);
        mTvCancel.setOnClickListener(this);

        mEtName.setText(name);

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
            case R.id.tv_confirm:
                listener.onDismiss(mEtName.getText().toString());
                this.dismiss();
                break;
            case R.id.tv_cancel:
                this.dismiss();
                break;
        }
    }

    public void setOnBottomDialogDimissListener(OnBottomDialogDimissListener listener) {
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
