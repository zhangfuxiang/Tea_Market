package com.delta.smt.ui.Personal.store_manager;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemStoreName;
import com.delta.smt.ui.Personal.store_manager.di.DaggerStoreManagerComponent;
import com.delta.smt.ui.Personal.store_manager.di.StoreManagerModule;
import com.delta.smt.ui.Personal.store_manager.mvp.StoreManagerContract;
import com.delta.smt.ui.Personal.store_manager.mvp.StoreManagerPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.delta.smt.base.BaseApplication.getContext;


/**
 * Created by Fuxiang.Zhang on 2017/4/24.
 */

public class StoreManagerActivity extends BaseActivity<StoreManagerPresenter> implements StoreManagerContract.View {


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
    @BindView(R.id.ry_store_name)
    RecyclerView mRyStoreName;

    private List<ItemStoreName> datas = new ArrayList<>();
    private CommonBaseAdapter<ItemStoreName> mAdapter;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerStoreManagerComponent.builder()
                .appComponent(appComponent)
                .storeManagerModule(new StoreManagerModule(this)) //请将StoreManagerModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {
        datas.add(new ItemStoreName("老开心茶楼1店","北京市朝阳区顺雨大街16号嘉美中心写字楼1221室"));
        datas.add(new ItemStoreName("老开心茶楼2店","北京市朝阳区顺雨大街16号嘉美中心写字楼1221室"));

    }

    @Override
    protected void initView() {
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);
        mTvLeftButtonName.setText("我的");
        mToolbarTitle.setText("店铺管理");
        mToolbarRightButton.setText("添加新的店铺");

        mAdapter = new CommonBaseAdapter<ItemStoreName>(this,datas) {
            @Override
            protected void convert(CommonViewHolder holder, ItemStoreName item, int position) {
                holder.setText(R.id.tv_store_name,item.getStore_name());
                holder.setText(R.id.tv_address,item.getAddress());
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemStoreName item) {
                return R.layout.item_store_name_list;
            }
        };
        mRyStoreName.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRyStoreName.setAdapter(mAdapter);


    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_store_manager;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toolbar_left_button, R.id.tv_left_button_name, R.id.toolbar_right_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button:
                finish();
                break;

            case R.id.tv_left_button_name:
                finish();
                break;

            case R.id.toolbar_right_button:
                break;
        }
    }


}