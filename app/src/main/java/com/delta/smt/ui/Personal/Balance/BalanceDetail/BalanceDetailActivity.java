package com.delta.smt.ui.Personal.Balance.BalanceDetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.TabEntity;
import com.delta.smt.ui.Personal.Balance.BalanceDetail.order.BalanceDetailFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Shaoqiang.Zhang on 2017/3/31.
 */

public class BalanceDetailActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;

    @BindView(R.id.purchase_vp)
    ViewPager purchase_vp;

    @BindView(R.id.order_ctl)
    CommonTabLayout order_ctl;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"全部", "收入", "支出"};

    @OnClick(R.id.toolbar_left_button_arl)
    void back() {
        finish();
    }

    @Override
    protected void initView() {

        toolbarTitle.setText("余额明细");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], 0, 0));
        }

        order_ctl.setTabData(mTabEntities);
        order_ctl.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int i) {
                purchase_vp.setCurrentItem(i);
            }

            @Override
            public void onTabReselect(int i) {

            }
        });
        BalanceDetailFragment all = new BalanceDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.BLANCETYPE,0);
        all.setArguments(bundle);
        mFragments.add(all);
        BalanceDetailFragment type1 = new BalanceDetailFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt(Constant.BLANCETYPE,2);
        type1.setArguments(bundle1);
        mFragments.add(type1);
        BalanceDetailFragment type2 = new BalanceDetailFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(Constant.BLANCETYPE,1);
        type2.setArguments(bundle2);
        mFragments.add(type2);

        purchase_vp.setAdapter(new BalanceDetailActivity.MyPagerAdapter(getSupportFragmentManager()));
        purchase_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                order_ctl.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        purchase_vp.setCurrentItem(0);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_purchase;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

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
