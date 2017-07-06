package com.delta.smt.ui.HomePage.subjectActivityDetail;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.R;
import com.zhy.autolayout.AutoRelativeLayout;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

public class InputPasswordBottomDialog extends BaseBottomDialog implements View.OnClickListener {

    float dimAmount;
    boolean cancelOutside;
    TextView tvPassword1;
    TextView tvPassword2;
    TextView tvPassword3;
    TextView tvPassword4;
    TextView tvPassword5;
    TextView tvPassword6;
    TextView tvNumber1;
    TextView tvNumber2;
    TextView tvNumber3;
    TextView tvNumber4;
    TextView tvNumber5;
    TextView tvNumber6;
    TextView tvNumber7;
    TextView tvNumber8;
    TextView tvNumber9;
    TextView tvNumber0;
    AutoRelativeLayout arlNumberBackspace;
    ImageView ivClose;
    OnSignUpListener listener;
    //OnForgetPwdListener onForgetPwdListener;
    private int height;
    private TextView tvForgetPassword;

    /*public InputPasswordBottomDialog(int height, float dimAmount, boolean cancelOutside) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
    }*/

    public InputPasswordBottomDialog() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.input_password_bottom_dialog;
    }

    @Override
    public void bindView(View v) {
        tvPassword1 = (TextView) v.findViewById(R.id.tv_password_1);
        tvPassword2 = (TextView) v.findViewById(R.id.tv_password_2);
        tvPassword3 = (TextView) v.findViewById(R.id.tv_password_3);
        tvPassword4 = (TextView) v.findViewById(R.id.tv_password_4);
        tvPassword5 = (TextView) v.findViewById(R.id.tv_password_5);
        tvPassword6 = (TextView) v.findViewById(R.id.tv_password_6);

        tvNumber1 = (TextView) v.findViewById(R.id.tv_number_1);
        tvNumber2 = (TextView) v.findViewById(R.id.tv_number_2);
        tvNumber3 = (TextView) v.findViewById(R.id.tv_number_3);
        tvNumber4 = (TextView) v.findViewById(R.id.tv_number_4);
        tvNumber5 = (TextView) v.findViewById(R.id.tv_number_5);
        tvNumber6 = (TextView) v.findViewById(R.id.tv_number_6);
        tvNumber7 = (TextView) v.findViewById(R.id.tv_number_7);
        tvNumber8 = (TextView) v.findViewById(R.id.tv_number_8);
        tvNumber9 = (TextView) v.findViewById(R.id.tv_number_9);
        tvNumber0 = (TextView) v.findViewById(R.id.tv_number_0);
        tvNumber1.setOnClickListener(this);
        tvNumber2.setOnClickListener(this);
        tvNumber3.setOnClickListener(this);
        tvNumber4.setOnClickListener(this);
        tvNumber5.setOnClickListener(this);
        tvNumber6.setOnClickListener(this);
        tvNumber7.setOnClickListener(this);
        tvNumber8.setOnClickListener(this);
        tvNumber9.setOnClickListener(this);
        tvNumber0.setOnClickListener(this);

        arlNumberBackspace = (AutoRelativeLayout) v.findViewById(R.id.arl_number_backspace);
        arlNumberBackspace.setOnClickListener(this);

        ivClose = (ImageView) v.findViewById(R.id.iv_close);
        ivClose.setOnClickListener(this);

        tvForgetPassword = (TextView) v.findViewById(R.id.tv_forget_password);
        tvForgetPassword.setOnClickListener(this);
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
            case R.id.iv_close:
                this.dismiss();
                break;
            case R.id.arl_number_backspace:
                deleteWords();
                break;
            case R.id.tv_number_1:
                inputWords("1");
                break;
            case R.id.tv_number_2:
                inputWords("2");
                break;
            case R.id.tv_number_3:
                inputWords("3");
                break;
            case R.id.tv_number_4:
                inputWords("4");
                break;
            case R.id.tv_number_5:
                inputWords("5");
                break;
            case R.id.tv_number_6:
                inputWords("6");
                break;
            case R.id.tv_number_7:
                inputWords("7");
                break;
            case R.id.tv_number_8:
                inputWords("8");
                break;
            case R.id.tv_number_9:
                inputWords("9");
                break;
            case R.id.tv_number_0:
                inputWords("0");
                break;
            case R.id.tv_forget_password:
                //onForgetPwdListener.forgetPwd();
                //Bundle bundle = new Bundle();
                //bundle.putInt(Constant.CHANGEPHONESTATUE, CONFIRMPHONE);
                //IntentUtils.showIntent(getActivity(), ChangeNewPhoneActivity.class, bundle);
                //IntentUtils.showIntent(getActivity(), ResetChargePasswordActivity.class);
                break;
        }
    }

    public void deleteWords() {
        if (!TextUtils.isEmpty(tvPassword6.getText().toString())) {
            tvPassword6.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword5.getText().toString())) {
            tvPassword5.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword4.getText().toString())) {
            tvPassword4.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword3.getText().toString())) {
            tvPassword3.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword2.getText().toString())) {
            tvPassword2.setText("");
            return;
        }
        if (!TextUtils.isEmpty(tvPassword1.getText().toString())) {
            tvPassword1.setText("");
            return;
        }
    }

    public void inputWords(String s) {
        if (TextUtils.isEmpty(tvPassword1.getText().toString())) {
            tvPassword1.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword2.getText().toString())) {
            tvPassword2.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword3.getText().toString())) {
            tvPassword3.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword4.getText().toString())) {
            tvPassword4.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword5.getText().toString())) {
            tvPassword5.setText(s);
            return;
        }
        if (TextUtils.isEmpty(tvPassword6.getText().toString())) {
            tvPassword6.setText(s);
            listener.onSignUp(
                    tvPassword1.getText().toString() +
                            tvPassword2.getText().toString() +
                            tvPassword3.getText().toString() +
                            tvPassword4.getText().toString() +
                            tvPassword5.getText().toString() +
                            tvPassword6.getText().toString()
            );
            this.dismiss();
            return;
        }
    }

    public void setOnSignUpListener(OnSignUpListener listener) {
        this.listener = listener;
    }

    /*public void setOnForgetPwdListener(OnForgetPwdListener onForgetPwdListener) {
        this.onForgetPwdListener = onForgetPwdListener;
    }*/

    public interface OnSignUpListener {
        void onSignUp(String pwd);
    }

    /*public interface OnForgetPwdListener {
        void forgetPwd();
    }*/

}
