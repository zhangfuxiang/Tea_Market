package com.delta.smt.ui.drinktea.choose_address;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.drinktea.UserAddress;
import com.delta.smt.entity.drinktea.UserAddressResult;
import com.delta.smt.ui.drinktea.choose_address.di.ChooseAddressModule;
import com.delta.smt.ui.drinktea.choose_address.di.DaggerChooseAddressComponent;
import com.delta.smt.ui.drinktea.choose_address.mvp.ChooseAddressContract;
import com.delta.smt.ui.drinktea.choose_address.mvp.ChooseAddressPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/4/22.
 */

public class ChooseAddressActivity extends BaseActivity<ChooseAddressPresenter> implements ChooseAddressContract.View, CommonBaseAdapter.OnItemClickListener<String> {

    @BindView(R.id.toolbar)
    FindToolBar toolBar;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private List<UserAddressResult.ListBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<UserAddressResult.ListBean> mAdapter;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerChooseAddressComponent.builder()
                .appComponent(appComponent)
                .chooseAddressModule(new ChooseAddressModule(this)) //请将ChooseAddressModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolBar.setToolbarTitle("选择地址");
        toolBar.setToolbarLeftButton(R.mipmap.ic_back);
        mAdapter = new CommonBaseAdapter<UserAddressResult.ListBean>(this, dataSource) {
            @Override
            protected void convert(CommonViewHolder holder, UserAddressResult.ListBean item, int position) {
                holder.setText(R.id.tv_receiving_address_listitem, item.getProvince() + item.getCity() + item.getArea() + item.getAddress());
            }

            @Override
            protected int getItemViewLayoutId(int position, UserAddressResult.ListBean item) {

                return R.layout.item_receiving_address_list;

            }
        };
        //mAdapter.setOnItemClickListener(OrderOtherListActivity.this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ChooseAddressActivity.this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
        getPresenter().getUserAddressList(SpUtil.getStringSF(ChooseAddressActivity.this, Constant.TOKEN), SpUtil.getStringSF(ChooseAddressActivity.this, Constant.MERCHANTID));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.acitivity_choose_address;
    }


    /*@Override
    public void onReceivingAddressSuccess(List<String> address) {
        dataSource.clear();
        List<String> list = address;
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onReceivingAddressFailed(List<String> address) {

    }

    @Override
    public void onReceivingAddressFailed(Throwable throwable) {

    }*/

    @OnClick({R.id.toolbar_left_button_arl})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                ChooseAddressActivity.this.finish();
                break;
        }
    }

    @Override
    public void onItemClick(View view, String item, int position) {

    }

    @Override
    public void onGetUserAddressListSuccess(UserAddress userAddress) {
        dataSource.clear();
        UserAddressResult userAddressResult = new Gson().fromJson(new Gson().toJson(userAddress.getResult()), UserAddressResult.class);
        List<UserAddressResult.ListBean> list = userAddressResult.getList();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetUserAddressListFailed(UserAddress userAddress) {
        if (!TextUtils.isEmpty(userAddress.getApp_msg())) {
            ToastUtils.showMessage(ChooseAddressActivity.this, userAddress.getApp_msg());
        }
    }

    @Override
    public void onGetUserAddressListFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(ChooseAddressActivity.this, throwable.getMessage());
        }
    }
}