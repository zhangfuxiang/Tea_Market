package com.delta.smt.ui.find.systemShop;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ShopCommodityListItem;
import com.delta.smt.entity.home_page.home_page_ads.classify_goods.ProductCategoryListResult;
import com.delta.smt.ui.HomePage.c_search_goods.SearchGoodsActivity;
import com.delta.smt.ui.HomePage.more.MoreActivity;
import com.delta.smt.ui.find.productDetail.ProductDetailActivity;
import com.delta.smt.ui.find.systemShop.di.DaggerSystemShopComponent;
import com.delta.smt.ui.find.systemShop.di.SystemShopModule;
import com.delta.smt.ui.find.systemShop.mvp.SystemShopContract;
import com.delta.smt.ui.find.systemShop.mvp.SystemShopPresenter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Shufeng.Wu on 2017/3/23.
 */

public class SystemShopActivity extends BaseActivity<SystemShopPresenter> implements SystemShopContract.View, SortPopupWindow.OnSortWindowDismissListener, ClassifyPopupWindow.OnClassifyWindowDismissListener, CommonBaseAdapter.OnItemClickListener<ShopCommodityListItem.ResultBean.ListBean> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbar_left_button_arl)
    AutoLinearLayout toolbar_left_button_arl;

    @BindView(R.id.rvCommodityList)
    RecyclerView rvCommodityList;

    @BindView(R.id.btn_sort)
    AutoRelativeLayout btnSort;
    @BindView(R.id.btn_classify)
    AutoRelativeLayout btnClassify;

    @BindView(R.id.iv_sort_icon)
    ImageView ivSortIcon;
    @BindView(R.id.tv_sort_type)
    TextView tvSortType;
    @BindView(R.id.iv_dropdown_icon)
    ImageView ivDropdownIcon;

    @BindView(R.id.iv_classify_icon)
    ImageView ivClassifyIcon;
    @BindView(R.id.tv_classify_type)
    TextView tvClassifyType;

    @BindView(R.id.btn_shoppingcart)
    FloatingActionButton btnShoppingcart;

    SortPopupWindow mSortPopupWindow;
    String sort_status = "默认排序（按销量）";
    ClassifyPopupWindow mClassifyPopupWindow = null;
    private List<ShopCommodityListItem.ResultBean.ListBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<ShopCommodityListItem.ResultBean.ListBean> mAdapter;

    private String tea_classify = "";
    private boolean onAllGoodsSelect = false;
    private ProductCategoryListResult productCategoryListResult;
    private String category_id;
    private String sortWay;
    private String sort;
    private int page = 1;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerSystemShopComponent.builder()
                .appComponent(appComponent)
                .systemShopModule(new SystemShopModule(this)) //请将SystemShopModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {

        mAdapter = new CommonBaseAdapter<ShopCommodityListItem.ResultBean.ListBean>(this, dataSource) {
            @Override
            protected void convert(CommonViewHolder holder, ShopCommodityListItem.ResultBean.ListBean item, int position) {
                holder.setText(R.id.tv_show_commdity_name, item.getTitle());
                holder.setText(R.id.tv_showNowPrice, "当前价：¥" + item.getPrice());
                holder.setText(R.id.tv_sale_amount, "销量" + item.getSales());
                ImageView iv = holder.getView(R.id.iv_commdity_picture);
                Glide.with(SystemShopActivity.this).load(item.getImages().get(0).getUrl()).crossFade().into(iv);
            }

            @Override
            protected int getItemViewLayoutId(int position, ShopCommodityListItem.ResultBean.ListBean item) {
                if (position % 2 == 0) {
                    return R.layout.item_system_shop_list_left;
                } else {
                    return R.layout.item_system_shop_list_right;
                }

            }
        };
        rvCommodityList.setLayoutManager(new GridLayoutManager(this, 2));
        rvCommodityList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        setSortButtonStatus(false);
        mSortPopupWindow = new SortPopupWindow(this, btnSort, toolbar.getHeight());
        mSortPopupWindow.setOnSortWindowDismissListener(this);
        setClassifyButtonStatus(false);

        findViewById(R.id.head_search_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setClass(SystemShopActivity.this, SearchGoodsActivity.class);
                startActivity(i);

            }
        });

        findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(SystemShopActivity.this, MoreActivity.class);
                startActivity(i);
            }
        });
        toolbar_left_button_arl.setVisibility(View.VISIBLE);
    }

    @Override
    protected void initData() {
        getPresenter().getCommodityClassify("product", "1");
        //getPresenter().getCommodityList();
        tea_classify = getIntent().getStringExtra("tea_classify");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_system_shop;
    }

    @Override
    public void onCommodityListSuccess(ShopCommodityListItem item) {
        List<ShopCommodityListItem.ResultBean.ListBean> list = item.getResult().getList();
        dataSource.addAll(list);
        if (item.getResult().getList().size() == 0) {
            mAdapter.notifyDataSetChanged();
            page = 1;
        } else {
            getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                    page + "",
                    10 + "",
                    -1 + "",
                    this.category_id,
                    this.sortWay,
                    this.sort);
            page++;
        }
    }

    @Override
    public void onCommodityListFailed(ShopCommodityListItem item) {

    }

    @Override
    public void onCommodityListFailed(Throwable throwable) {

    }

    @Override
    public void onCommodityClassifySuccess(ProductCategoryListResult item) {
        Log.i(TAG, "onCommodityClassifySuccess: " + item.toString());
        productCategoryListResult = item;
        if (!isContainClassify(tea_classify, productCategoryListResult)) {
            ToastUtils.showMessage(SystemShopActivity.this, "暂无此商品类型！");
        }
        if (mClassifyPopupWindow == null) {
            mClassifyPopupWindow = new ClassifyPopupWindow(this, btnClassify, item, tea_classify);
            mClassifyPopupWindow.setOnClassifyWindowDismissListener(this);
            //tvClassifyType.setText(getFristSmallCheckName(tea_classify));
            tvClassifyType.setText(tea_classify + "/全部");
            category_id = getFristBigCheckId(tea_classify);
            if (getIntent().getStringExtra("tea_classify").equals("商品搜索")) {
                getPresenter().searhGoods(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        100 + "",
                        getIntent().getStringExtra("key_word"));
            } else {
                this.sortWay = "sales";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        category_id,
                        this.sortWay,
                        this.sort);

            }
        }

    }

    @Override
    public void onCommodityClassifyFailed(ProductCategoryListResult item) {

    }

    @Override
    public void onCommodityClassifyFailed(Throwable throwable) {

    }

    @OnClick({R.id.btn_sort, R.id.btn_classify, R.id.toolbar_left_button_arl, R.id.btn_shoppingcart})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sort:

                if (!mSortPopupWindow.isShowing() && mSortPopupWindow != null) {
                    mSortPopupWindow.showPopupWindow(btnSort);
                    setSortButtonStatus(true);
                } else {
                    mSortPopupWindow.dismissPopupWindow();
                }

                break;
            case R.id.btn_classify:

                if (mClassifyPopupWindow != null) {
                    if (!mClassifyPopupWindow.isShowing()) {
                        mClassifyPopupWindow.showPopupWindow(btnClassify);
                        setClassifyButtonStatus(true);
                    } else {
                        mClassifyPopupWindow.dismissPopupWindow();
                    }
                }
                break;
            case R.id.toolbar_left_button_arl:
                SystemShopActivity.this.finish();
                break;
            case R.id.btn_shoppingcart:
                //ToastUtils.showMessage(this,"购物车");
                SpUtil.SetStringSF(this, "BayCar", "goto");
                finish();
                break;

        }
    }


    public void setSortButtonStatus(boolean status) {
        if (status) {
            ivSortIcon.setImageResource(R.drawable.ic_cha_sort_check);
            tvSortType.setTextColor(Color.rgb(48, 113, 66));
            ivDropdownIcon.setImageResource(R.mipmap.ic_dropdown_check);
        } else {
            ivSortIcon.setImageResource(R.drawable.ic_cha_sort);
            tvSortType.setTextColor(Color.rgb(102, 102, 102));
            ivDropdownIcon.setImageResource(R.mipmap.ic_dropdown);
        }
    }

    public void setClassifyButtonStatus(boolean status) {
        if (status) {
            ivClassifyIcon.setImageResource(R.drawable.ic_cha_filtrate_check);
            tvClassifyType.setTextColor(Color.rgb(48, 113, 66));
        } else {
            ivClassifyIcon.setImageResource(R.drawable.ic_cha_filtrate);
            tvClassifyType.setTextColor(Color.rgb(102, 102, 102));
        }
    }

    @Override
    public void onSortWindowDismiss(String sort_name) {
        setSortButtonStatus(false);
        tvSortType.setText(sort_name);
        sort_status = sort_name;
        dataSource.clear();
        mAdapter.notifyDataSetChanged();
        //需要根据排序刷新列表
        if (sort_status.startsWith("默认")) {
            if (onAllGoodsSelect) {
                //根据种类刷新列表
                this.category_id = "";
                this.sortWay = "sales";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        "",
                        this.sortWay,
                        this.sort);
            } else {
                //根据种类刷新列表getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                this.sortWay = "sales";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        this.category_id,
                        this.sortWay,
                        this.sort);
            }
        } else if (sort_status.equals("价格从低到高")) {
            if (onAllGoodsSelect) {
                //根据种类刷新列表
                this.category_id = "";
                this.sortWay = "price";
                this.sort = "asc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        "",
                        this.sortWay,
                        this.sort);
            } else {
                //根据种类刷新列表
                this.sortWay = "price";
                this.sort = "asc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        this.category_id,
                        this.sortWay,
                        this.sort);
            }
        } else if (sort_status.equals("价格从高到低")) {
            if (onAllGoodsSelect) {
                //根据种类刷新列表
                this.category_id = "";
                this.sortWay = "price";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        "",
                        this.sortWay,
                        this.sort);
            } else {
                //根据种类刷新列表
                this.sortWay = "price";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        this.category_id,
                        this.sortWay,
                        this.sort);
            }
        }

    }

    @Override
    public void onClassifyWindowDismiss(String classify_name, String category_id) {
        Log.e("classify_name", classify_name);
        Log.e("category_id", category_id);
        setClassifyButtonStatus(false);
        tvClassifyType.setText(classify_name);
        dataSource.clear();
        mAdapter.notifyDataSetChanged();
        this.category_id = category_id;
        if (sort_status.startsWith("默认")) {
            if (classify_name.equals("所有商品")) {
                this.category_id = "";
                this.sortWay = "sales";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        this.category_id,
                        this.sortWay,
                        this.sort);
                onAllGoodsSelect = true;
            } else {
                //根据种类刷新列表
                this.sortWay = "sales";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        this.category_id,
                        this.sortWay,
                        this.sort);
                onAllGoodsSelect = false;
            }
        } else if (sort_status.equals("价格从低到高")) {
            if (classify_name.equals("所有商品")) {
                this.category_id = "";
                this.sortWay = "price";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        "",
                        this.sortWay,
                        this.sort);
                onAllGoodsSelect = true;
            } else {
                //根据种类刷新列表
                this.sortWay = "price";
                this.sort = "asc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        this.category_id,
                        this.sortWay,
                        this.sort);
                onAllGoodsSelect = false;
            }
        } else if (sort_status.equals("价格从高到低")) {
            if (classify_name.equals("所有商品")) {
                this.category_id = "";
                this.sortWay = "price";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        "",
                        this.sortWay,
                        this.sort);
                onAllGoodsSelect = true;
            } else {
                //根据种类刷新列表
                this.sortWay = "price";
                this.sort = "desc";
                getPresenter().getCommodityList(SpUtil.getStringSF(SystemShopActivity.this, Constant.TOKEN),
                        1 + "",
                        10 + "",
                        -1 + "",
                        this.category_id,
                        this.sortWay,
                        this.sort);
                onAllGoodsSelect = false;
            }
        }

    }

    @Override
    public void onItemClick(View view, ShopCommodityListItem.ResultBean.ListBean item, int position) {
        IntentUtils.showIntent(SystemShopActivity.this, ProductDetailActivity.class, new String[]{"product_id", "shop_address"}, new String[]{item.getId(), item.getMerchant().getShop_title()});
    }

    public String getFristSmallCheckName(String big_name) {
        String res = "";
        for (int i = 0; i < productCategoryListResult.getResult().getList().size(); i++) {
            if (big_name.equals(productCategoryListResult.getResult().getList().get(i).getName())) {
                res = productCategoryListResult.getResult().getList().get(i).getSub().get(0).getName();
                break;
            }
        }
        return res;
    }

    public String getFristSmallCheckId(String big_name) {
        String res = "";
        for (int i = 0; i < productCategoryListResult.getResult().getList().size(); i++) {
            if (big_name.equals(productCategoryListResult.getResult().getList().get(i).getName())) {
                res = productCategoryListResult.getResult().getList().get(i).getSub().get(0).getId();
                break;
            }
        }
        return res;
    }

    public String getFristBigCheckId(String big_name) {
        String res = "";
        for (int i = 0; i < productCategoryListResult.getResult().getList().size(); i++) {
            if (big_name.equals(productCategoryListResult.getResult().getList().get(i).getName())) {
                res = productCategoryListResult.getResult().getList().get(i).getId();
                break;
            }
        }
        return res;
    }

    public boolean isContainClassify(String str, ProductCategoryListResult productCategoryListResult) {
        boolean res = false;
        for (int i = 0; i < productCategoryListResult.getResult().getList().size(); i++) {
            if (str.equals(productCategoryListResult.getResult().getList().get(i).getName())) {
                res = true;
                break;
            }
            if (str.equals("商品搜索")) {
                res = true;
                break;
            }
        }
        return res;
    }
}