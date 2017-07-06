package com.delta.smt.ui.Personal.my_order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.TabEntity;
import com.delta.smt.ui.Personal.my_order.all_content.AllContentFragment;
import com.delta.smt.ui.Personal.my_order.di.DaggerMyOrderComponent;
import com.delta.smt.ui.Personal.my_order.di.MyOrderModule;
import com.delta.smt.ui.Personal.my_order.mvp.MyOrderContract;
import com.delta.smt.ui.Personal.my_order.mvp.MyOrderPresenter;
import com.delta.smt.ui.Personal.my_order.no_payment.NoPaymentFragment;
import com.delta.smt.ui.Personal.my_order.no_receive.NoReceiveFragment;
import com.delta.smt.ui.Personal.my_order.no_send.NoSendFragment;
import com.delta.smt.ui.find.FindToolBar;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

public class MyOrderActivity extends BaseActivity<MyOrderPresenter> implements MyOrderContract.View {


    @BindView(R.id.toolbar_left_button)
    ImageView mToolbarLeftButton;
    @BindView(R.id.tv_left_button_name)
    TextView mTvLeftButtonName;
    @BindView(R.id.toolbar_left_button_arl)
    AutoRelativeLayout mToolbarLeftButtonArl;
    @BindView(R.id.toolbarTitle)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar_right_button)
    TextView mToolbarRightButton;
    @BindView(R.id.toolbar_right_button_iv)
    ImageView mToolbarRightButtonIv;
    @BindView(R.id.toolbar_right_button_iv_arl)
    AutoRelativeLayout mToolbarRightButtonIvArl;
    @BindView(R.id.toolbar)
    FindToolBar mToolbar;
    @BindView(R.id.order_ctl)
    CommonTabLayout mOrderCtl;
    @BindView(R.id.vp)
    ViewPager mVp;

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"全部", "待付款", "待发货", "待收货"};
    private int select_type = 0;

    private String token;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerMyOrderComponent.builder()
                .appComponent(appComponent)
                .myOrderModule(new MyOrderModule(this)) //请将MyOrderModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {
        token=SpUtil.getStringSF(MyOrderActivity.this, Constant.TOKEN);
        select_type = getIntent().getExtras().getInt(Constant.SELECT_YTPE);


    }

    @Override
    protected void initView() {
        mToolbarTitle.setText("我的订单");
        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], 0, 0));
        }

        mOrderCtl.setTabData(mTabEntities);
        mOrderCtl.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int i) {
                mVp.setCurrentItem(i);
            }

            @Override
            public void onTabReselect(int i) {

            }
        });
        mFragments.add(new AllContentFragment());
        mFragments.add(new NoPaymentFragment());
        mFragments.add(new NoSendFragment());
        mFragments.add(new NoReceiveFragment());

        mVp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mOrderCtl.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mVp.setCurrentItem(select_type);

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_order;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.toolbar_left_button_arl)
    public void onClick() {
        finish();
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