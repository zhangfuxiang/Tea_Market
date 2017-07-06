package com.delta.smt.ui.find.productDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.AddMyShopResult;
import com.delta.smt.entity.AddToCartResult;
import com.delta.smt.entity.ProductDetail;
import com.delta.smt.entity.StringTabEntity;
import com.delta.smt.entity.cart.CartResult;
import com.delta.smt.entity.cart.MyCartList;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.auctionHouseDetail.AdaptiveViewPager;
import com.delta.smt.ui.find.confirmOrder.ConfirmOrderActivity;
import com.delta.smt.ui.find.productDetail.di.DaggerProductDetailComponent;
import com.delta.smt.ui.find.productDetail.di.ProductDetailModule;
import com.delta.smt.ui.find.productDetail.mvp.ProductDetailContract;
import com.delta.smt.ui.find.productDetail.mvp.ProductDetailPresenter;
import com.delta.smt.ui.find.viewtools.GlideImageLoader;
import com.delta.smt.utils.ViewFindUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/3/25.
 */

public class ProductDetailActivity extends BaseActivity<ProductDetailPresenter> implements ProductDetailContract.View, OnBannerListener, OnTabSelectListener {

    @BindView(R.id.toolbar)
    FindToolBar toolbar;

    @BindView(R.id.tv_product_name)
    TextView tvProductName;

    @BindView(R.id.tv_product_system_price)
    TextView tvProductSystemPrice;

    @BindView(R.id.tv_product_source)
    TextView tvProductSource;

    @BindView(R.id.tv_product_sale_amount)
    TextView tvProductSaleAmount;

    @BindView(R.id.btn_add_my_buy_car)
    TextView btnAddMyBuyCar;

    @BindView(R.id.btn_buy_now)
    TextView btnBuyNow;

    @BindView(R.id.tl_1)
    CommonTabLayout mTabLayout_1;
    @BindView(R.id.vp)
    AdaptiveViewPager mViewPager;
    Banner banner;
    String[] urls;
    ProductDetail pItem;
    ProductPicTxtDetailFragment productPicTxtDetailFragment;
    ProductParaFragment productParaFragment;
    Gson gson = new GsonBuilder().
            registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

                @Override
                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src == src.longValue())
                        return new JsonPrimitive(src.longValue());
                    return new JsonPrimitive(src);
                }
            }).create();
    @BindView(R.id.tv_left_button_name)
    TextView tvLeftButtonName;
    @BindView(R.id.toolbar_left_button_arl)
    AutoRelativeLayout toolbarLeftButtonArl;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_right_button)
    TextView toolbarRightButton;
    @BindView(R.id.toolbar_right_button_iv)
    ImageView toolbarRightButtonIv;
    @BindView(R.id.toolbar_right_button_iv_arl)
    AutoRelativeLayout toolbarRightButtonIvArl;
    @BindView(R.id.bottom_layout)
    AutoLinearLayout bottomLayout;
    @BindView(R.id.btn_product_refer_buy)
    FloatingActionButton btnProductReferBuy;
    @BindView(R.id.tv_product_system_price_label)
    TextView tvProductSystemPriceLabel;
    @BindView(R.id.tv_product_source_label)
    TextView tvProductSourceLabel;
    @BindView(R.id.sv)
    ScrollView sv;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"图文详情", "产品参数"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private View mDecorView;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerProductDetailComponent.builder()
                .appComponent(appComponent)
                .productDetailModule(new ProductDetailModule(this)) //请将ProductDetailModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolbarTitle.setText("商品详情");
        toolbar.setToolbarLeftButton(R.mipmap.ic_back);
        toolbar.setToolbarRightButtonIv(R.mipmap.ic_share);
        mDecorView = getWindow().getDecorView();
        mTabLayout_1 = ViewFindUtils.find(mDecorView, R.id.tl_1);
        mViewPager = ViewFindUtils.find(mDecorView, R.id.vp);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new StringTabEntity(mTitles[i]));
        }
        /** with nothing */
        mTabLayout_1 = ViewFindUtils.find(mDecorView, R.id.tl_1);
        mTabLayout_1.setTabData(mTabEntities);
        mTabLayout_1.setOnTabSelectListener(this);
        productPicTxtDetailFragment = new ProductPicTxtDetailFragment();
        productPicTxtDetailFragment.setAdaptiveViewPager(mViewPager);
        productParaFragment = new ProductParaFragment();
        productParaFragment.setAdaptiveViewPager(mViewPager);
        mFragments.add(productPicTxtDetailFragment);
        mFragments.add(productParaFragment);

        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                mTabLayout_1.setCurrentTab(position);
                mViewPager.resetHeight(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        mViewPager.setCurrentItem(0);
        mViewPager.resetHeight(0);
    }

    @Override
    protected void initData() {

        getPresenter().getProductDetail(SpUtil.getStringSF(ProductDetailActivity.this, Constant.TOKEN), getIntent().getStringExtra("product_id"), SpUtil.getStringSF(this, Constant.MERCHANTID));
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_product_detail_page;
    }


    @Override
    public void onProductDetailSuccess(ProductDetail ProductDetail) {
        pItem = ProductDetail;
        //UserAddressItem<String> list_urls = ProductDetail.getResult().getPicture_urls();
        List<String> list_urls = new ArrayList<>();
        for (int i = 0; i < ProductDetail.getResult().getProduct().getImages().size(); i++) {
            list_urls.add(ProductDetail.getResult().getProduct().getImages().get(i).getUrl());
        }
        urls = new String[list_urls.size()];
        for (int i = 0; i < urls.length; i++) {
            urls[i] = list_urls.get(i);
            //Log.i(TAG, "onAuctionDetailSuccess: "+urls[i]);
        }
        showProductDetail(urls);
        tvProductName.setText(ProductDetail.getResult().getProduct().getTitle());
        tvProductSystemPrice.setText("¥" + ProductDetail.getResult().getProduct().getPrice());
        tvProductSource.setText(ProductDetail.getResult().getProduct().getMerchant().getShop_title());
        tvProductSaleAmount.setText("销量" + ProductDetail.getResult().getProduct().getSales());
        productPicTxtDetailFragment.wvPicTxtDetail.loadDataWithBaseURL(null, getNewContent(ProductDetail.getResult().getProduct().getDetails()), "text/html", "UTF-8", null);
        productParaFragment.setParamDataSource(ProductDetail.getResult().getProduct().getParam());
    }

    private String getNewContent(String htmltext) {

        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width", "100%").attr("height", "auto");
        }

        return doc.toString();
    }

    public void showProductDetail(String[] strs) {
        List<?> images = new ArrayList<>();
        List list = Arrays.asList(strs);
        images = new ArrayList(list);
        banner = (Banner) findViewById(R.id.banner);
        banner.setOnBannerListener(this);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片集合
        banner.setImages(images);
        banner.start();
        //banner设置方法全部调用完毕时最后调用

    }

    @Override
    public void onProductDetailFailed(ProductDetail ProductDetail) {

    }

    @Override
    public void onProductDetailFailed(Throwable throwable) {

    }

    @Override
    public void onAddMyShopSuccess(AddMyShopResult addMyShopResult) {
        String result = addMyShopResult.getResult().toString();
        String msg = "";
        try {
            JSONObject jsonObject = new JSONObject(result);
            msg = jsonObject.getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (!TextUtils.isEmpty(msg)) {
            ToastUtils.showMessage(ProductDetailActivity.this, msg);
        }
    }

    @Override
    public void onAddMyShopFailed(AddMyShopResult addMyShopResult) {
        String msg = addMyShopResult.getApp_msg();
        if (!TextUtils.isEmpty(msg)) {
            ToastUtils.showMessage(ProductDetailActivity.this, msg);
        }
    }

    @Override
    public void onAddMyShopFailed(Throwable throwable) {
        String msg = throwable.getMessage();
        if (!TextUtils.isEmpty(msg)) {
            ToastUtils.showMessage(ProductDetailActivity.this, msg);
        }
    }

    @Override
    public void onAddToCartSuccess(AddToCartResult addToCartResult) {
        if (!TextUtils.isEmpty(addToCartResult.getResult())) {
            ToastUtils.showMessage(ProductDetailActivity.this, addToCartResult.getResult());
        }
    }

    @Override
    public void onAddToCartFailed(AddToCartResult addToCartResult) {
        if (!TextUtils.isEmpty(addToCartResult.getResult())) {
            ToastUtils.showMessage(ProductDetailActivity.this, addToCartResult.getApp_msg());
        }
    }

    @Override
    public void onAddToCartFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(ProductDetailActivity.this, throwable.getMessage());
        }
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.btn_add_my_buy_car, R.id.btn_buy_now, R.id.toolbar_right_button_iv_arl})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                ProductDetailActivity.this.finish();
                break;
            case R.id.btn_add_my_buy_car:
                getPresenter().addToCart(SpUtil.getStringSF(ProductDetailActivity.this, Constant.TOKEN), getIntent().getStringExtra("product_id"), 1 + "");
                break;
//            case R.id.btn_add_my_sale_list:
//                getPresenter().getAddMyShopResult(SpUtil.getStringSF(ProductDetailActivity.this, Constant.TOKEN), getIntent().getStringExtra("product_id"));
//                break;
            case R.id.btn_buy_now:
                BuyNowBottomDialog dialog = new BuyNowBottomDialog(getWindowManager().getDefaultDisplay().getHeight() * 883 / 1920, 0.8f, true, pItem.getResult().getProduct().getImages().get(0).getUrl(), "¥" + pItem.getResult().getProduct().getPrice(), pItem.getResult().getProduct().getTitle());
                dialog.show(getSupportFragmentManager());
                dialog.setBottomDialogOKListener(new BuyNowBottomDialog.OnBottomDialogOKListener() {
                    @Override
                    public void onOK(int amount) {
                        CartResult.CartBean cartBean = new CartResult.CartBean();
                        cartBean.setChecked(true);
                        cartBean.setNum(amount + "");
                        cartBean.setProduct_id(Integer.parseInt(getIntent().getStringExtra("product_id")));
                        cartBean.setProduct(gson.fromJson(gson.toJson(pItem.getResult().getProduct()), CartResult.CartBean.ProductBean.class));
                        cartBean.setMerchant_id(pItem.getResult().getProduct().getMerchant_id());
                        cartBean.setMerchant_title(getIntent().getStringExtra("shop_address"));
                        List<CartResult.CartBean> list_cart = new ArrayList<>();
                        list_cart.add(cartBean);
                        MyCartList.ListBean listBean = new MyCartList.ListBean();
                        listBean.setCart(list_cart);
                        listBean.setMerchant_title(getIntent().getStringExtra("shop_address"));
                        listBean.setMerchant_id(pItem.getResult().getProduct().getMerchant_id());
                        List<MyCartList.ListBean> list = new ArrayList<>();
                        list.add(listBean);
                        MyCartList myCartList = new MyCartList();
                        myCartList.setList(list);

                        Intent intent = new Intent(ProductDetailActivity.this, ConfirmOrderActivity.class);
                        intent.putExtra("cart_list", gson.toJson(myCartList));
                        intent.putExtra("total_price", makeTotalResult(amount));
                        startActivity(intent);
                    }
                });
                break;
            case R.id.toolbar_right_button_iv_arl:
                break;
        }
    }

    public String makeTotalResult(int amount) {
        String res = "0.00";
        double d = amount * Double.parseDouble(pItem.getResult().getProduct().getPrice());
        res = new DecimalFormat("#.00").format(d);
        if (res.startsWith(".")) {
            res = "0" + res;
        }
        return res;
    }

    @Override
    public void OnBannerClick(int position) {

    }

    @Override
    public void onTabSelect(int position) {
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void onTabReselect(int position) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}