package com.delta.smt.ui.find.systemShop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.delta.smt.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * 排序PopupWindow
 * Created by Shufeng.Wu on 2017/3/24.
 */

public class SortPopupWindow extends PopupWindow implements View.OnClickListener {
    Context context;
    View popupView_sort;

    AutoRelativeLayout btnSortBySaleAmount;
    AutoRelativeLayout btnSortByPriceUp;
    AutoRelativeLayout btnSortByPriceDown;

    TextView tvSortBySaleAmount;
    TextView tvSortByPriceUp;
    TextView tvSortByPriceDown;

    ImageView ivSaleAmountCheck;
    ImageView ivPriceUpCheck;
    ImageView ivPriceDownCheck;

    AutoLinearLayout popupOtherRegion;
    String sort_status = "默认排序（按销量）";

    OnSortWindowDismissListener onSortWindowDismissListener;

    View anchor;
    int height;

    String tea_classify;

    public SortPopupWindow(Context context, View anchor, int height) {
        super(context);
        this.context = context;
        this.anchor = anchor;
        this.height = height;
        this.tea_classify = tea_classify;
        LayoutInflater inflater = LayoutInflater.from(context);
        popupView_sort = inflater.inflate(R.layout.popupwindow_commdity_sort, null);
        btnSortBySaleAmount = (AutoRelativeLayout) popupView_sort.findViewById(R.id.btn_sort_by_sale_amount);
        btnSortBySaleAmount.setOnClickListener(this);

        btnSortByPriceUp = (AutoRelativeLayout) popupView_sort.findViewById(R.id.btn_sort_by_price_up);
        btnSortByPriceUp.setOnClickListener(this);

        btnSortByPriceDown = (AutoRelativeLayout) popupView_sort.findViewById(R.id.btn_sort_by_price_down);
        btnSortByPriceDown.setOnClickListener(this);

        tvSortBySaleAmount = (TextView) popupView_sort.findViewById(R.id.tv_sort_by_sale_amount);
        tvSortByPriceUp = (TextView) popupView_sort.findViewById(R.id.tv_sort_by_price_up);
        tvSortByPriceDown = (TextView) popupView_sort.findViewById(R.id.tv_sort_by_price_down);

        ivSaleAmountCheck = (ImageView) popupView_sort.findViewById(R.id.iv_sale_amount_check);
        ivPriceUpCheck = (ImageView) popupView_sort.findViewById(R.id.iv_price_up_check);
        ivPriceDownCheck = (ImageView) popupView_sort.findViewById(R.id.iv_price_down_check);

        popupOtherRegion = (AutoLinearLayout) popupView_sort.findViewById(R.id.popup_other_region);
        popupOtherRegion.setOnClickListener(this);

        this.setContentView(popupView_sort);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setTouchable(true);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));

        this.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                /*if (onSortWindowDismissListener != null) {
                    if ("默认排序（按销量）".equals(sort_status)) {
                        onSortWindowDismissListener.onSortWindowDismiss("默认排序");
                    } else {
                        onSortWindowDismissListener.onSortWindowDismiss(sort_status);
                    }
                }*/
            }
        });
        setSortBySaleAmount();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sort_by_sale_amount:
                sort_status = "默认排序（按销量）";
                setSortBySaleAmount();
                if (onSortWindowDismissListener != null) {
                    if ("默认排序（按销量）".equals(sort_status)) {
                        onSortWindowDismissListener.onSortWindowDismiss("默认排序");
                    } else {
                        onSortWindowDismissListener.onSortWindowDismiss(sort_status);
                    }
                }
                dismissPopupWindow();
                break;
            case R.id.btn_sort_by_price_down:
                sort_status = "价格从高到低";
                setSortByPriceDown();
                if (onSortWindowDismissListener != null) {
                    if ("默认排序（按销量）".equals(sort_status)) {
                        onSortWindowDismissListener.onSortWindowDismiss("默认排序");
                    } else {
                        onSortWindowDismissListener.onSortWindowDismiss(sort_status);
                    }
                }
                dismissPopupWindow();
                break;
            case R.id.btn_sort_by_price_up:
                sort_status = "价格从低到高";
                setSortByPriceUp();
                if (onSortWindowDismissListener != null) {
                    if ("默认排序（按销量）".equals(sort_status)) {
                        onSortWindowDismissListener.onSortWindowDismiss("默认排序");
                    } else {
                        onSortWindowDismissListener.onSortWindowDismiss(sort_status);
                    }
                }
                dismissPopupWindow();
                break;
            case R.id.popup_other_region:
                dismissPopupWindow();
                break;
        }
    }

    public void setOnSortWindowDismissListener(OnSortWindowDismissListener listener) {
        this.onSortWindowDismissListener = listener;
    }

    public void setSortBySaleAmount() {
        tvSortBySaleAmount.setTextColor(Color.rgb(48, 113, 66));
        tvSortByPriceDown.setTextColor(Color.rgb(153, 153, 153));
        tvSortByPriceUp.setTextColor(Color.rgb(153, 153, 153));
        ivSaleAmountCheck.setVisibility(View.VISIBLE);
        ivPriceUpCheck.setVisibility(View.INVISIBLE);
        ivPriceDownCheck.setVisibility(View.INVISIBLE);
    }

    public void setSortByPriceUp() {
        tvSortBySaleAmount.setTextColor(Color.rgb(153, 153, 153));
        tvSortByPriceDown.setTextColor(Color.rgb(153, 153, 153));
        tvSortByPriceUp.setTextColor(Color.rgb(48, 113, 66));
        ivSaleAmountCheck.setVisibility(View.INVISIBLE);
        ivPriceUpCheck.setVisibility(View.VISIBLE);
        ivPriceDownCheck.setVisibility(View.INVISIBLE);
    }

    public void setSortByPriceDown() {
        tvSortBySaleAmount.setTextColor(Color.rgb(153, 153, 153));
        tvSortByPriceDown.setTextColor(Color.rgb(48, 113, 66));
        tvSortByPriceUp.setTextColor(Color.rgb(153, 153, 153));
        ivSaleAmountCheck.setVisibility(View.INVISIBLE);
        ivPriceUpCheck.setVisibility(View.INVISIBLE);
        ivPriceDownCheck.setVisibility(View.VISIBLE);
    }

    public void showPopupWindow(View anchor) {
        if (!this.isShowing()) {
            if (Build.VERSION.SDK_INT < 24) {
                this.showAsDropDown(anchor);
            } else {
                // 适配 android 7.0
                int[] location = new int[2];
                anchor.getLocationOnScreen(location);
                int x = location[0];
                int y = location[1];
                this.showAtLocation(anchor, Gravity.NO_GRAVITY, 0, y + getHeight() + anchor.getHeight());
            }

        }
    }

    public void dismissPopupWindow() {
        if (this.isShowing()) {
            this.dismiss();
        }
    }

    private int getStatusBarHeight() {
        try {
            Resources resource = context.getResources();
            int resourceId = resource.getIdentifier("status_bar_height", "dimen", "Android");
            if (resourceId != 0) {
                return resource.getDimensionPixelSize(resourceId);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public interface OnSortWindowDismissListener {
        void onSortWindowDismiss(String sort_name);
    }

}