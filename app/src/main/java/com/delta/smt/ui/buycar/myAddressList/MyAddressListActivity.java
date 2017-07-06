package com.delta.smt.ui.buycar.myAddressList;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.cart.DeleteUserAddress;
import com.delta.smt.entity.cart.UpdateUserAddress;
import com.delta.smt.entity.cart.UserAddressList;
import com.delta.smt.entity.cart.UserAddressListResult;
import com.delta.smt.ui.buycar.addNewAddress.AddNewAddressActivity;
import com.delta.smt.ui.buycar.myAddressList.di.DaggerMyAddressListComponent;
import com.delta.smt.ui.buycar.myAddressList.di.MyAddressListModule;
import com.delta.smt.ui.buycar.myAddressList.mvp.MyAddressListContract;
import com.delta.smt.ui.buycar.myAddressList.mvp.MyAddressListPresenter;
import com.delta.smt.ui.buycar.updateUserAddress.UpdateUserAddressActivity;
import com.delta.smt.ui.find.FindToolBar;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/5/5.
 */

public class MyAddressListActivity extends BaseActivity<MyAddressListPresenter> implements MyAddressListContract.View, CommonBaseAdapter.OnItemClickListener<UserAddressListResult.ListBean> {


    @BindView(R.id.toolbar)
    FindToolBar findToolBar;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.btn_new_address)
    TextView btnNewAddress;


    private List<UserAddressListResult.ListBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<UserAddressListResult.ListBean> mAdapter;
    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerMyAddressListComponent.builder()
                .appComponent(appComponent)
                .myAddressListModule(new MyAddressListModule(this)) //请将MyAddressListModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        findToolBar.setToolbarLeftButton(R.mipmap.ic_back);
        findToolBar.setToolbarTitle("我的收获地址");
        findToolBar.setTvLeftButtonName("确认订单");
        mAdapter = new CommonBaseAdapter<UserAddressListResult.ListBean>(this, dataSource) {
            @Override
            protected void convert(CommonViewHolder holder, final UserAddressListResult.ListBean item, int position) {

                holder.setText(R.id.tv_name, item.getName());
                holder.setText(R.id.tv_phone, item.getPhone());
                holder.setText(R.id.tv_address, item.getProvince() + item.getCity() + item.getArea() + item.getAddress());
                final CheckBox cbDefaultAddress = holder.getView(R.id.cb_default_address);
                cbDefaultAddress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cbDefaultAddress.isChecked()) {
                            getPresenter().updateUserAddress(SpUtil.getStringSF(MyAddressListActivity.this, Constant.TOKEN)
                                    , SpUtil.getStringSF(MyAddressListActivity.this, Constant.MERCHANTID)
                                    , item.getLocation_id() + ""
                                    , item.getName()
                                    , item.getPhone()
                                    , item.getAddress()
                                    , "1"
                                    , item.getId() + ""
                            );
                        } else {
                            getPresenter().updateUserAddress(SpUtil.getStringSF(MyAddressListActivity.this, Constant.TOKEN)
                                    , SpUtil.getStringSF(MyAddressListActivity.this, Constant.MERCHANTID)
                                    , item.getLocation_id() + ""
                                    , item.getName()
                                    , item.getPhone()
                                    , item.getAddress()
                                    , "0"
                                    , item.getId() + ""
                            );
                        }
                    }
                });

                if (item.getStatus() == 1) {
                    cbDefaultAddress.setChecked(true);
                    cbDefaultAddress.setText("默认地址");
                } else {
                    cbDefaultAddress.setChecked(false);
                    cbDefaultAddress.setText("设为默认地址");
                }

                TextView btnDelete = holder.getView(R.id.btn_delete);
                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().deleteUserAddress(SpUtil.getStringSF(MyAddressListActivity.this, Constant.TOKEN), SpUtil.getStringSF(MyAddressListActivity.this, Constant.MERCHANTID), item.getId() + "");
                    }
                });
                TextView btnEdit = holder.getView(R.id.btn_edit);
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        IntentUtils.showIntent(MyAddressListActivity.this, UpdateUserAddressActivity.class
                                , new String[]{"person_name", "phone_number", "area", "detail_address", "default_address", "area_str", "id"}
                                , new String[]{item.getName(), item.getPhone(), item.getLocation_id() + ""
                                        , item.getAddress(), item.getStatus() + "", item.getProvince() + " " + item.getCity() + " " + item.getArea(), item.getId() + ""});
                    }
                });
            }

            @Override
            protected int getItemViewLayoutId(int position, UserAddressListResult.ListBean item) {
                return R.layout.item_my_address_list;
            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().getMyAddressList(SpUtil.getStringSF(MyAddressListActivity.this, Constant.TOKEN), SpUtil.getStringSF(MyAddressListActivity.this, Constant.MERCHANTID));
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_address_list;
    }


    @Override
    public void onGetMyAddressListSuccess(UserAddressList userAddressList) {
        dataSource.clear();
        UserAddressListResult userAddressListResult = new Gson().fromJson(new Gson().toJson(userAddressList.getResult()), UserAddressListResult.class);
        List<UserAddressListResult.ListBean> list = userAddressListResult.getList();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetMyAddressListFailed(UserAddressList userAddressList) {
        if (!TextUtils.isEmpty(userAddressList.getApp_msg())) {
            ToastUtils.showMessage(MyAddressListActivity.this, userAddressList.getApp_msg());
        }

    }

    @Override
    public void onGetMyAddressListFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(MyAddressListActivity.this, throwable.getMessage());
        }
    }

    @Override
    public void onDeleteUserAddressSuccess(DeleteUserAddress deleteUserAddress) {
        ToastUtils.showMessage(MyAddressListActivity.this, "删除成功");
        getPresenter().getMyAddressList(SpUtil.getStringSF(MyAddressListActivity.this, Constant.TOKEN), SpUtil.getStringSF(MyAddressListActivity.this, Constant.MERCHANTID));
    }

    @Override
    public void onDeleteUserAddressFailed(DeleteUserAddress deleteUserAddress) {
        if (!TextUtils.isEmpty(deleteUserAddress.getApp_msg())) {
            ToastUtils.showMessage(MyAddressListActivity.this, deleteUserAddress.getApp_msg());
        }
    }

    @Override
    public void onDeleteUserAddressFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(MyAddressListActivity.this, throwable.getMessage());
        }
    }

    @Override
    public void onUpdateUserAddressSuccess(UpdateUserAddress updateUserAddress) {
        ToastUtils.showMessage(MyAddressListActivity.this, "设置成功");
        getPresenter().getMyAddressList(SpUtil.getStringSF(MyAddressListActivity.this, Constant.TOKEN), SpUtil.getStringSF(MyAddressListActivity.this, Constant.MERCHANTID));
        //MyAddressListActivity.this.finish();
    }

    @Override
    public void onUpdateUserAddressFailed(UpdateUserAddress updateUserAddress) {
        if (!TextUtils.isEmpty(updateUserAddress.getApp_msg())) {
            ToastUtils.showMessage(MyAddressListActivity.this, updateUserAddress.getApp_msg());
        }
    }

    @Override
    public void onUpdateUserAddressFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(MyAddressListActivity.this, throwable.getMessage());
        }
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.btn_new_address})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                MyAddressListActivity.this.finish();
                break;
            case R.id.btn_new_address:
                IntentUtils.showIntent(MyAddressListActivity.this, AddNewAddressActivity.class);
                break;
        }

    }

    @Override
    public void onItemClick(View view, UserAddressListResult.ListBean item, int position) {
        Intent intent = new Intent();
        intent.putExtra("name", item.getName());
        intent.putExtra("address", item.getAddress());
        intent.putExtra("phone", item.getPhone());
        intent.putExtra("province", item.getProvince());
        intent.putExtra("city", item.getCity());
        intent.putExtra("area", item.getArea());
        String address_id = item.getId() + "";
        intent.putExtra("address_id", address_id);
        setResult(21, intent);
        MyAddressListActivity.this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}