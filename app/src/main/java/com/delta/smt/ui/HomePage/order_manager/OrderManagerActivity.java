package com.delta.smt.ui.HomePage.order_manager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.TabEntity;
import com.delta.smt.ui.HomePage.order_manager.all_order.AllOrderFragment;
import com.delta.smt.ui.HomePage.order_manager.waiting_todo.OrderWaitTODOFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Shaoqiang.Zhang on 2017/3/26.
 */

public class OrderManagerActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;

    @BindView(R.id.ording_manager_vp)
    ViewPager order_manager_vp;

    @BindView(R.id.order_ctl)
    CommonTabLayout order_ctl;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"未处理（3）", "全部订单"};

    @OnClick(R.id.toolbar_left_button)
    void back() {
        finish();
    }

    @Override
    protected void initView() {

        mTitles[0]="未处理（"+getIntent().getExtras().getString("count")+")";
        toolbarTitle.setText("订单管理");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], 0, 0));
        }

        order_ctl.setTabData(mTabEntities);
        order_ctl.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int i) {
                order_manager_vp.setCurrentItem(i);
            }

            @Override
            public void onTabReselect(int i) {

            }
        });
        mFragments.add(new OrderWaitTODOFragment());
        mFragments.add(new AllOrderFragment());

        order_manager_vp.setAdapter(new OrderManagerActivity.MyPagerAdapter(getSupportFragmentManager()));
        order_manager_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        order_manager_vp.setCurrentItem(0);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_order_manager;
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
