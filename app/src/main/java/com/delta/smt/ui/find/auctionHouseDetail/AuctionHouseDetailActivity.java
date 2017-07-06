package com.delta.smt.ui.find.auctionHouseDetail;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.AuctionDetailItem;
import com.delta.smt.entity.AuctionDetailPriceRule;
import com.delta.smt.entity.AuctionDetailRecordItem;
import com.delta.smt.entity.StringTabEntity;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.auctionHouseDetail.di.AuctionHouseDetailModule;
import com.delta.smt.ui.find.auctionHouseDetail.di.DaggerAuctionHouseDetailComponent;
import com.delta.smt.ui.find.auctionHouseDetail.mvp.AuctionHouseDetailContract;
import com.delta.smt.ui.find.auctionHouseDetail.mvp.AuctionHouseDetailPresenter;
import com.delta.smt.ui.find.myGivePrice.MyGivePriceActivity;
import com.delta.smt.ui.find.priceRecord.PriceRecordActivity;
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
 * Created by wushufeng on 2017/3/20.
 */

public class AuctionHouseDetailActivity extends BaseActivity<AuctionHouseDetailPresenter> implements AuctionHouseDetailContract.View, OnBannerListener, CommonBaseAdapter.OnItemClickListener, OnTabSelectListener {

    @BindView(R.id.toolbar)
    FindToolBar toolbar;
    /*@BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;*/


    @BindView(R.id.my_give_price)
    TextView myGivePrice;
    @BindView(R.id.rvAuctionRecord)
    RecyclerView rvAuctionRecord;
    Banner banner;
    String[] urls;
    @BindView(R.id.tv_after_price_delay)
    TextView afterPriceDelay;
    @BindView(R.id.tv_bottom_price)
    TextView bottomPrice;
    @BindView(R.id.tv_every_add_price)
    TextView everyAddPrice;
    @BindView(R.id.tl_1)
    CommonTabLayout mTabLayout_1;
    @BindView(R.id.vp)
    AdaptiveViewPager mViewPager;
    @BindView(R.id.btn_auction_refer_buy)
    FloatingActionButton btn_auction_refer_buy;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"图文详情", "产品参数","购买咨询"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private View mDecorView;
    private List<AuctionDetailRecordItem.ResultBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<AuctionDetailRecordItem.ResultBean> mAdapter;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerAuctionHouseDetailComponent.builder()
                .appComponent(appComponent)
                .auctionHouseDetailModule(new AuctionHouseDetailModule(this)) //请将AuctionHouseDetailModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolbar.setToolbarLeftButton(R.mipmap.ic_back);
        toolbar.setToolbarTitle("拍品详情");

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
        ProductPicTxtDetailFragment productPicTxtDetailFragment = new ProductPicTxtDetailFragment();
        productPicTxtDetailFragment.setAdaptiveViewPager(mViewPager);
        ProductParaFragment productParaFragment = new ProductParaFragment();
        productParaFragment.setAdaptiveViewPager(mViewPager);
        AuctionReferFragment auctionReferFragment=new AuctionReferFragment();
        auctionReferFragment.setAdaptiveViewPager(mViewPager);
        mFragments.add(productPicTxtDetailFragment);
        mFragments.add(productParaFragment);
        mFragments.add(auctionReferFragment);

        mViewPager.setAdapter(new AuctionHouseDetailActivity.MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                mTabLayout_1.setCurrentTab(position);
                mViewPager.resetHeight(position);

                if(position==2){
                    btn_auction_refer_buy.setVisibility(View.VISIBLE);
                }else {
                    btn_auction_refer_buy.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(0);
        mViewPager.resetHeight(0);

        mAdapter = new CommonBaseAdapter<AuctionDetailRecordItem.ResultBean>(this, dataSource) {
            @Override
            protected void convert(CommonViewHolder holder, AuctionDetailRecordItem.ResultBean item, int position) {

                TextView tv = holder.getView(R.id.tv_auction_price);
                if (position == 0) {
                    tv.setTextColor(Color.rgb(255, 96, 0));
                }else{
                    tv.setTextColor(Color.rgb(153, 153, 153));
                }
                holder.setText(R.id.tv_auction_price_time, item.getPrice_time());
                holder.setText(R.id.tv_auction_price, item.getPrice());
                holder.setText(R.id.tv_auction_person_name, item.getPerson_name());

                ImageView iv = holder.getView(R.id.iv_auction_head_image);
                //ToastUtils.showMessage(AuctionHouseDetailActivity.this, dataSource.get(position).getHead_image() + "");
                Glide.with(AuctionHouseDetailActivity.this).load(dataSource.get(position).getHead_image()).crossFade().into(iv);
            }

            @Override
            protected int getItemViewLayoutId(int position, AuctionDetailRecordItem.ResultBean item) {
                return R.layout.item_auction_record;
            }
        };
        mAdapter.setOnItemClickListener(this);
        rvAuctionRecord.setLayoutManager(new LinearLayoutManager(this));
        rvAuctionRecord.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        getPresenter().getAuctionDetialList();
        getPresenter().getAuctionRecordList();
        getPresenter().getPriceRule();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_auction_detail_page;
    }

    @Override
    public void onAuctionDetailSuccess(AuctionDetailItem item) {
        List<String > list_urls = item.getResult().getPicture_urls();
        urls = new String[list_urls.size()];
        for(int i=0;i<urls.length;i++){
            urls[i] = list_urls.get(i);
            //Log.i(TAG, "onAuctionDetailSuccess: "+urls[i]);
        }
        showAuctionHouseDetail(urls);
    }

    @Override
    public void onAuctionDetailfailed(AuctionDetailItem item) {

    }

    @Override
    public void onAuctionDetailfailed(Throwable throwable) {

    }

    @Override
    public void onAuctionRecordSuccess(AuctionDetailRecordItem item) {
        dataSource.clear();
        List<AuctionDetailRecordItem.ResultBean> list = item.getResult();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAuctionRecordfailed(AuctionDetailRecordItem item) {

    }

    @Override
    public void onAuctionRecordfailed(Throwable throwable) {

    }

    @Override
    public void onPriceRuleSuccess(AuctionDetailPriceRule item) {
        afterPriceDelay.setText("叫价后延时：" + item.getResult().getAfter_price_delay());
        bottomPrice.setText("底价：¥" + item.getResult().getBottom_price());
        everyAddPrice.setText("叫价涨幅：¥" + item.getResult().getEvery_add_price());
    }

    @Override
    public void onPriceRulefailed(AuctionDetailPriceRule item) {

    }

    @Override
    public void onPriceRulefailed(Throwable throwable) {

    }

    @Override
    public void OnBannerClick(int position) {
        ToastUtils.showMessage(this, position + "");
    }

    public void showAuctionHouseDetail(String[] strs) {
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
    public void onItemClick(View view, Object item, int position) {
        //跳转
        IntentUtils.showIntent(AuctionHouseDetailActivity.this, PriceRecordActivity.class);
    }

    @Override
    public void onTabSelect(int position) {
        mViewPager.setCurrentItem(position);
    }

    @Override
    public void onTabReselect(int position) {

    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.my_give_price})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                AuctionHouseDetailActivity.this.finish();
                break;
            case R.id.my_give_price:
                IntentUtils.showIntent(AuctionHouseDetailActivity.this, MyGivePriceActivity.class);
                break;
        }
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