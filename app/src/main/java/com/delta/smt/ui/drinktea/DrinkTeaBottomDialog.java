package com.delta.smt.ui.drinktea;

import android.view.View;
import android.widget.TextView;

import com.delta.commonlibs.utils.IntentUtils;
import com.delta.smt.MainActivity;
import com.delta.smt.R;
import com.delta.smt.ui.drinktea.order_other_list.OrderOtherListActivity;

import me.shaohui.bottomdialog.BaseBottomDialog;

/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

public class DrinkTeaBottomDialog extends BaseBottomDialog implements View.OnClickListener {

    TextView tvDrinkteaOrderThis;
    TextView tvDrinkTeaOrderOther;
    TextView tvDrinkteaCancel;
    int height;
    float dimAmount;
    boolean cancelOutside;
    OnBottomDialogDimissListener listener;


    /*@SuppressLint("ValidFragment")
    public DrinkTeaBottomDialog(int height, float dimAmount, boolean cancelOutside) {
        this.height = height;
        this.dimAmount = dimAmount;
        this.cancelOutside = cancelOutside;
    }*/

    public DrinkTeaBottomDialog() {
        super();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.drinktea_bottom_dialog;
    }

    @Override
    public void bindView(View v) {
        tvDrinkteaOrderThis = (TextView) v.findViewById(R.id.tv_drinktea_order_this);
        tvDrinkteaOrderThis.setOnClickListener(this);
        tvDrinkTeaOrderOther = (TextView) v.findViewById(R.id.tv_drinktea_order_other);
        tvDrinkTeaOrderOther.setOnClickListener(this);
        tvDrinkteaCancel = (TextView) v.findViewById(R.id.tv_drinktea_cancel);
        tvDrinkteaCancel.setOnClickListener(this);

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
            case R.id.tv_drinktea_order_this:

                listener.onDismiss();
                //IntentUtils.showIntent(getActivity(), OrderThisActivity.class);
                ((MainActivity) getActivity()).getThisShopList();
                this.dismiss();
                break;
            case R.id.tv_drinktea_order_other:
                listener.onDismiss();
                IntentUtils.showIntent(getActivity(), OrderOtherListActivity.class);
                this.dismiss();
                break;
            case R.id.tv_drinktea_cancel:
                listener.onDismiss();
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
        listener.onDismiss();
    }

    public interface OnBottomDialogDimissListener {
        void onDismiss();
    }
}
