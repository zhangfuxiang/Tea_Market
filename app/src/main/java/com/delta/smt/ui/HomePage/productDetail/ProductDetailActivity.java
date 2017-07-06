package com.delta.smt.ui.HomePage.productDetail;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ProductDetailItem;
import com.delta.smt.entity.StringTabEntity;
import com.delta.smt.ui.HomePage.productDetail.di.ProductDetailModule;
import com.delta.smt.ui.HomePage.productDetail.mvp.ProductDetailContract;
import com.delta.smt.ui.HomePage.productDetail.mvp.ProductDetailPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.auctionHouseDetail.AdaptiveViewPager;
import com.delta.smt.ui.find.auctionHouseDetail.ProductParaFragment;
import com.delta.smt.ui.find.viewtools.GlideImageLoader;
import com.delta.smt.utils.ViewFindUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
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

    @BindView(R.id.btn_product_refer_buy)
    FloatingActionButton btn_product_refer_buy;

    @BindView(R.id.tl_1)
    CommonTabLayout mTabLayout_1;
    @BindView(R.id.vp)
    AdaptiveViewPager mViewPager;
    Banner banner;
    String[] urls;
    ProductDetailItem pItem;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"图文详情", "产品参数", "购买咨询"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private View mDecorView;

    @Override
    protected void componentInject(AppComponent appComponent) {
        com.delta.smt.ui.HomePage.productDetail.di.DaggerProductDetailComponent.
                builder().
                appComponent(appComponent).
                productDetailModule(new ProductDetailModule(this)).
                build().
                inject(this);
    }

    @Override
    protected void initView() {
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
        com.delta.smt.ui.find.auctionHouseDetail.ProductPicTxtDetailFragment productPicTxtDetailFragment = new com.delta.smt.ui.find.auctionHouseDetail.ProductPicTxtDetailFragment();
        productPicTxtDetailFragment.setAdaptiveViewPager(mViewPager);
        ProductParaFragment productParaFragment = new ProductParaFragment();
        productParaFragment.setAdaptiveViewPager(mViewPager);
        BuyReferFragment buyReferFragment = new BuyReferFragment();
        buyReferFragment.setAdaptiveViewPager(mViewPager);
        mFragments.add(productPicTxtDetailFragment);
        mFragments.add(productParaFragment);
        mFragments.add(buyReferFragment);

        mViewPager.setAdapter(new ProductDetailActivity.MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                mTabLayout_1.setCurrentTab(position);
                mViewPager.resetHeight(position);

                if (position == 2) {
                    btn_product_refer_buy.setVisibility(View.VISIBLE);
                } else {
                    btn_product_refer_buy.setVisibility(View.GONE);
                }
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
        getPresenter().getProductDetail();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_product_detail_page;
    }


    @Override
    public void onProductDetailSuccess(ProductDetailItem productDetailItem) {
        pItem = productDetailItem;
        List<String> list_urls = productDetailItem.getResult().getPicture_urls();
        urls = new String[list_urls.size()];
        for (int i = 0; i < urls.length; i++) {
            urls[i] = list_urls.get(i);
            //Log.i(TAG, "onAuctionDetailSuccess: "+urls[i]);
        }
        showProductDetail(urls);
        tvProductName.setText(productDetailItem.getResult().getProduct_name());
        tvProductSystemPrice.setText("¥" + productDetailItem.getResult().getSystem_price());
        tvProductSource.setText(productDetailItem.getResult().getSource());
        tvProductSaleAmount.setText("销量" + productDetailItem.getResult().getSale_amount());
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
    public void onProductDetailFailed(ProductDetailItem productDetailItem) {

    }

    @Override
    public void onProductDetailFailed(Throwable throwable) {

    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.btn_add_my_buy_car, R.id.btn_buy_now, R.id.toolbar_right_button_iv_arl})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                ProductDetailActivity.this.finish();
                break;
            case R.id.btn_add_my_buy_car:
                break;
            case R.id.btn_buy_now:
                BuyNowBottomDialog dialog = new BuyNowBottomDialog(getWindowManager().getDefaultDisplay().getHeight() * 883 / 1920, 0.8f, true, pItem.getResult().getPicture_urls().get(0), "¥" + pItem.getResult().getSystem_price(), pItem.getResult().getProduct_name());
                dialog.show(getSupportFragmentManager());
                break;
            case R.id.toolbar_right_button_iv_arl:
                break;
        }
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