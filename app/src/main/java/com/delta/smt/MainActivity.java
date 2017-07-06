package com.delta.smt;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.TabEntity;
import com.delta.smt.entity.drinktea.ShopList;
import com.delta.smt.entity.drinktea.ShopListResult;
import com.delta.smt.ui.HomePage.HomeFragment;
import com.delta.smt.ui.HomePage.c_search_goods.SearchGoodsActivity;
import com.delta.smt.ui.HomePage.more.MoreActivity;
import com.delta.smt.ui.Personal.PersonalFragment;
import com.delta.smt.ui.TeaCircle.TeaCircleFragment;
import com.delta.smt.ui.buycar.BuyCarFragment;
import com.delta.smt.ui.buycar.BuyCarToolBar;
import com.delta.smt.ui.drinktea.DrinkTeaBottomDialog;
import com.delta.smt.ui.drinktea.order_this.OrderThisActivity;
import com.delta.smt.ui.drinktea.order_this_list.OrderThisListActivity;
import com.delta.smt.ui.main.di.DaggerMainComponent;
import com.delta.smt.ui.main.di.MainModule;
import com.delta.smt.ui.main.mvp.MainContract;
import com.delta.smt.ui.main.mvp.MainPresenter;
import com.delta.smt.utils.ViewFindUtils;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenter> implements CommonBaseAdapter.OnItemClickListener<String>, View.OnClickListener, DialogInterface.OnDismissListener, MainContract.View {
    public BuyCarToolBar buyCarToolBar;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"首页", "圈子", "去喝茶", "购物车", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_tea_circle_unselect, R.mipmap.tab_drinktea_unselect,
            R.mipmap.tab_buycar_unselect, R.mipmap.tab_my_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_tea_circle_select, R.mipmap.tab_drinktea_select,
            R.mipmap.tab_buycar_select, R.mipmap.tab_my_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private View mDecorView;
    private ViewPager mViewPager;
    private CommonTabLayout mTabLayout_1;
    private Toolbar toolbar;
    private View searchTV;
    private TeaCircleFragment teaCircleFragment;
    private BuyCarFragment buyCarFragment;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this)) //请将OrderThisListModule()第一个首字母改为小写
                .build()
                .inject(this);

    }

    @Override
    protected void initView() {

        mDecorView = getWindow().getDecorView();
        mTabLayout_1 = ViewFindUtils.find(mDecorView, R.id.tl_1);
        mViewPager = ViewFindUtils.find(mDecorView, R.id.vp);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        buyCarToolBar = (BuyCarToolBar) findViewById(R.id.buycar_toolbar);
        buyCarToolBar.setVisibility(View.GONE);
        buyCarToolBar.setToolbarLeftButtonOnClickListener(this);
        buyCarToolBar.setToolbarRightButtonIvArlOnClickListener(this);
        //mSpinner = (Spinner) findViewById(R.id.spinner);
        // 建立数据源
        String[] mItems = {"老开心茶楼1店", "老开心茶楼2店"};
        // 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        /** with nothing */
        mTabLayout_1 = ViewFindUtils.find(mDecorView, R.id.tl_1);
        searchTV= findViewById(R.id.head_search_tv);
        searchTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent();
                i.setClass(MainActivity.this, SearchGoodsActivity.class);
                startActivity(i);

            }
        });
        findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(MainActivity.this, MoreActivity.class);
                startActivity(i);
            }
        });
        mTabLayout_1.setTabData(mTabEntities);
        mTabLayout_1.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int i) {
                if (i != 2) {
                    if (i < 2) {
                        mViewPager.setCurrentItem(i);
                    } else {
                        mViewPager.setCurrentItem(i - 1);
                    }

                } else {
                    //DrinkTeaBottomDialog dialog = new DrinkTeaBottomDialog(getWindowManager().getDefaultDisplay().getHeight() * 545 / 1920, 0.8f, true);
                    DrinkTeaBottomDialog dialog = new DrinkTeaBottomDialog();
                    dialog.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 545 / 1920);
                    dialog.setDimAmount(0.8f);
                    dialog.setCancelOutside(true);
                    dialog.show(getSupportFragmentManager());
                    dialog.setOnBottomDialogDimissListener(new DrinkTeaBottomDialog.OnBottomDialogDimissListener() {
                        @Override
                        public void onDismiss() {
                            if (mViewPager.getCurrentItem() < 2) {
                                mTabLayout_1.setCurrentTab(mViewPager.getCurrentItem());
                            } else {
                                mTabLayout_1.setCurrentTab(mViewPager.getCurrentItem() + 1);
                            }

                        }
                    });
                }


            }

            @Override
            public void onTabReselect(int i) {

            }
        });

        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setMainActivity(this);
        mFragments.add(homeFragment);
        teaCircleFragment=new TeaCircleFragment();
        mFragments.add(teaCircleFragment);
        buyCarFragment = new BuyCarFragment();
        mFragments.add(buyCarFragment);
        mFragments.add(new PersonalFragment());

        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //
                if (position == 0) {
                    toolbar.setVisibility(View.VISIBLE);
                    buyCarToolBar.setVisibility(View.GONE);
                    mTabLayout_1.setCurrentTab(position);
                } else if (position == 1) {
                    toolbar.setVisibility(View.GONE);
                    buyCarToolBar.setVisibility(View.GONE);
                    mTabLayout_1.setCurrentTab(position);
                } else if (position == 2) {
                    toolbar.setVisibility(View.GONE);
                    buyCarToolBar.setVisibility(View.VISIBLE);
                    mTabLayout_1.setCurrentTab(position + 1);
                } else if (position == 3) {
                    toolbar.setVisibility(View.GONE);
                    buyCarToolBar.setVisibility(View.GONE);
                    mTabLayout_1.setCurrentTab(position + 1);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(0);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    public void onItemClick(View view, String item, int position) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.toolbar_right_button_iv_arl) {

        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {

    }

    public void getThisShopList() {
        getPresenter().getShopList(SpUtil.getStringSF(MainActivity.this, Constant.TOKEN), SpUtil.getStringSF(MainActivity.this, Constant.MERCHANTID), "1", "30", "", "1");
    }

    @Override
    public void onGetShopListSuccess(ShopList shopList) {
        ShopListResult shopListResult = new Gson().fromJson(new Gson().toJson(shopList.getResult()), ShopListResult.class);
        if (shopListResult.getTotal() > 1) {
            IntentUtils.showIntent(MainActivity.this, OrderThisListActivity.class);
        } else if (shopListResult.getTotal() == 1) {
            IntentUtils.showIntent(MainActivity.this, OrderThisActivity.class, new String[]{"shop_id"}, new String[]{shopListResult.getList().get(0).getId() + ""});
        } else {
            ToastUtils.showMessage(MainActivity.this, "无本店列表");
        }
    }

    @Override
    public void onGetShopListFailed(ShopList shopList) {

    }

    @Override
    public void onGetShopListFailed(Throwable throwable) {

    }

    public void setViewPagerPosition(int position,long id,boolean schame){
        mViewPager.setCurrentItem(position);
        if(schame){
            teaCircleFragment.loadUrl(id);
        }
    }

    public void dreakTea(){
        //DrinkTeaBottomDialog dialog = new DrinkTeaBottomDialog(getWindowManager().getDefaultDisplay().getHeight() * 545 / 1920, 0.8f, true);
        DrinkTeaBottomDialog dialog = new DrinkTeaBottomDialog();
        dialog.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 545 / 1920);
        dialog.setDimAmount(0.8f);
        dialog.setCancelOutside(true);
        dialog.show(getSupportFragmentManager());
        dialog.setOnBottomDialogDimissListener(new DrinkTeaBottomDialog.OnBottomDialogDimissListener() {
            @Override
            public void onDismiss() {
                if (mViewPager.getCurrentItem() < 2) {
                    mTabLayout_1.setCurrentTab(mViewPager.getCurrentItem());
                } else {
                    mTabLayout_1.setCurrentTab(mViewPager.getCurrentItem() + 1);
                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        String action = SpUtil.getStringSF(this, "BayCar");
        if (action!=null) {
            if (action.equals("goto")) {
                this.setViewPagerPosition(2, 2, false);
                SpUtil.SetStringSF(this, "BayCar", "");
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 1) {
            buyCarFragment.onMessageEvent("支付成功");
        } else if (resultCode == 2) {
            buyCarFragment.onMessageEvent("其他");
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



