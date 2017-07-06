package com.delta.smt.ui.find.systemShop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.entity.home_page.home_page_ads.classify_goods.ProductCategoryListResult;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shufeng.Wu on 2017/3/24.
 */

public class ClassifyPopupWindow extends PopupWindow implements View.OnClickListener {
    Context context;
    View anchor;
    ProductCategoryListResult productCategoryListResult;

    View popupView_classify;
    OnClassifyWindowDismissListener onClassifyWindowDismissListener;
    RecyclerView rvCommodityBigClassify;
    RecyclerView rvCommoditySmallClassify;
    String TAG = "ClassifyPopupWindow";
    int big_check_position = 0;
    int big_check_position_temp = 0;
    int small_check_position = 0;
    int small_check_position_temp = 0;
    int clickBigItem=0;
    AutoLinearLayout popupOtherRegion;
    private List<ProductCategoryListResult.ResultBean.ListBean> dataSourceBig = new ArrayList<>();
    private CommonBaseAdapter<ProductCategoryListResult.ResultBean.ListBean> mAdapterBig;
    private List<ProductCategoryListResult.ResultBean.ListBean.SubBean> dataSourceSmall = new ArrayList<>();
    private CommonBaseAdapter<ProductCategoryListResult.ResultBean.ListBean.SubBean> mAdapterSmall;

    private String teaClassify;

    private boolean first_time = false;

    public ClassifyPopupWindow(Context context, View anchor, final ProductCategoryListResult productCategoryListResult, String tea_classify) {
        first_time = true;
        this.context = context;
        this.anchor = anchor;
        this.productCategoryListResult = productCategoryListResult;
        this.teaClassify = tea_classify;

        LayoutInflater inflater = LayoutInflater.from(context);
        popupView_classify = inflater.inflate(R.layout.popupwindow_commdity_classify, null);
        rvCommodityBigClassify = (RecyclerView) popupView_classify.findViewById(R.id.rvCommodityBigClassify);
        rvCommoditySmallClassify = (RecyclerView) popupView_classify.findViewById(R.id.rvCommoditySmallClassify);
        mAdapterBig = new CommonBaseAdapter<ProductCategoryListResult.ResultBean.ListBean>(context, dataSourceBig) {
            @Override
            protected void convert(CommonViewHolder holder, ProductCategoryListResult.ResultBean.ListBean item, int position) {
                //AutoUtils.autoSize(holder.itemView);
                holder.setText(R.id.tv_content, item.getName());
                TextView tvContent = holder.getView(R.id.tv_content);
                if (big_check_position == position) {
                    tvContent.setTextColor(Color.rgb(48, 113, 66));
                    clickBigItem=position;
                } else {
                    tvContent.setTextColor(Color.rgb(153, 153, 153));
                }
            }

            @Override
            protected int getItemViewLayoutId(int position, ProductCategoryListResult.ResultBean.ListBean item) {
                return R.layout.item_rv_classify;
            }
        };
        rvCommodityBigClassify.setLayoutManager(new LinearLayoutManager(context));
        rvCommodityBigClassify.setAdapter(mAdapterBig);
        mAdapterBig.setOnItemClickListener(new CommonBaseAdapter.OnItemClickListener<ProductCategoryListResult.ResultBean.ListBean>() {
            @Override
            public void onItemClick(View view, ProductCategoryListResult.ResultBean.ListBean item, int position) {
                clickBigItem=position;
                if (item.getName().equals("所有商品")) {
                    onClassifyWindowDismissListener.onClassifyWindowDismiss("所有商品", "所有商品");
                    dismissPopupWindow();
                } else {
                    if (big_check_position != position) {
                        small_check_position = 0;
                    }
                    big_check_position = position;
                    mAdapterBig.notifyDataSetChanged();
                    refreshSmallList(big_check_position);
                }
            }
        });

        refreshBigList();

        mAdapterSmall = new CommonBaseAdapter<ProductCategoryListResult.ResultBean.ListBean.SubBean>(context, dataSourceSmall) {
            @Override
            protected void convert(CommonViewHolder holder, ProductCategoryListResult.ResultBean.ListBean.SubBean item, int position) {
                //AutoUtils.autoSize(holder.itemView);
                holder.setText(R.id.tv_content, item.getName());
                TextView tvContent = holder.getView(R.id.tv_content);
                if (small_check_position == position) {
                    tvContent.setTextColor(Color.rgb(48, 113, 66));
                } else {
                    tvContent.setTextColor(Color.rgb(153, 153, 153));
                }
            }

            @Override
            protected int getItemViewLayoutId(int position, ProductCategoryListResult.ResultBean.ListBean.SubBean item) {
                return R.layout.item_rv_classify;

            }
        };
        rvCommoditySmallClassify.setLayoutManager(new GridLayoutManager(context, 2));
        rvCommoditySmallClassify.setAdapter(mAdapterSmall);
        mAdapterSmall.setOnItemClickListener(new CommonBaseAdapter.OnItemClickListener<ProductCategoryListResult.ResultBean.ListBean.SubBean>() {
            @Override
            public void onItemClick(View view, ProductCategoryListResult.ResultBean.ListBean.SubBean item, int position) {
                small_check_position = position;
                //暂存
                big_check_position_temp = big_check_position;
                small_check_position_temp = small_check_position;
                mAdapterSmall.notifyDataSetChanged();
                if(item.getName().equals("全部")){
                    onClassifyWindowDismissListener.onClassifyWindowDismiss(dataSourceBig.get(big_check_position).getName() + "/" + "全部", dataSourceBig.get(clickBigItem).getId());
                }else {
                    if (onClassifyWindowDismissListener != null) {
                        onClassifyWindowDismissListener.onClassifyWindowDismiss(dataSourceBig.get(big_check_position).getName() + "/" + dataSourceSmall.get(small_check_position).getName(), dataSourceSmall.get(small_check_position).getId());
                    }
                }
                dismissPopupWindow();

            }
        });

        refreshSmallList(big_check_position);
        initPopupWindow();

        popupOtherRegion = (AutoLinearLayout) popupView_classify.findViewById(R.id.popup_other_region);
        popupOtherRegion.setOnClickListener(this);

    }

    public void setOnClassifyWindowDismissListener(OnClassifyWindowDismissListener listener) {
        this.onClassifyWindowDismissListener = listener;
    }

    //显示PopupWindow
    public void showPopupWindow(View anchor) {
        if (!this.isShowing()) {
            if (first_time) {
                big_check_position = getBig_check_position(teaClassify);
                first_time = false;
            } else {
                big_check_position = big_check_position_temp;
            }

            small_check_position = small_check_position_temp;
            refreshBigList();
            refreshSmallList(big_check_position);
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

    //刷新BigList
    public void refreshBigList() {
        //TODO 添加所有商品的筛选
        dataSourceBig.clear();
        List<ProductCategoryListResult.ResultBean.ListBean> list_big = productCategoryListResult.getResult().getList();


        dataSourceBig.addAll(list_big);
        ProductCategoryListResult.ResultBean.ListBean bean = new ProductCategoryListResult.ResultBean.ListBean();
        bean.setName("所有商品");
        dataSourceBig.add(0, bean);
        mAdapterBig.notifyDataSetChanged();
    }

    //刷新SmallList
    public void refreshSmallList(int big_check_position) {
        dataSourceSmall.clear();
        if (big_check_position != 0) {
            List<ProductCategoryListResult.ResultBean.ListBean.SubBean> list_small = productCategoryListResult.getResult().getList().get(big_check_position-1).getSub();
            dataSourceSmall.addAll(list_small);
            ProductCategoryListResult.ResultBean.ListBean.SubBean bean=new ProductCategoryListResult.ResultBean.ListBean.SubBean();
            bean.setName("全部");
            dataSourceSmall.add(bean);
        } else {
            dataSourceSmall.add(new ProductCategoryListResult.ResultBean.ListBean.SubBean());
        }
        mAdapterSmall.notifyDataSetChanged();
    }

    //隐藏PopupWindow
    public void dismissPopupWindow() {
        if (this.isShowing()) {
            this.dismiss();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == popupOtherRegion) {
            dismissPopupWindow();
        }
    }

    //初始化popupwindow
    public void initPopupWindow() {
        this.setContentView(popupView_classify);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setTouchable(true);
        this.setOutsideTouchable(true);
        this.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));

        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                /*if (onClassifyWindowDismissListener != null) {
                    onClassifyWindowDismissListener.onClassifyWindowDismiss(dataSourceSmall.get(small_check_position).getName(),dataSourceSmall.get(small_check_position).getId());
                }*/
            }
        });
    }

    //根据分类名获取position
    public int getBig_check_position(String big_name) {
        int res = 0;
        for (int i = 0; i < dataSourceBig.size(); i++) {
            String n = dataSourceBig.get(i).getName();
            if (dataSourceBig.get(i).getName().equals(big_name)) {
                Log.i(TAG, "getBig_check_position: " + dataSourceBig.get(i).getName());
                res = i;
                break;
                //return i;
            }
        }
        return res;
    }

    public interface OnClassifyWindowDismissListener {
        void onClassifyWindowDismiss(String classify_name, String category_id);
    }


}