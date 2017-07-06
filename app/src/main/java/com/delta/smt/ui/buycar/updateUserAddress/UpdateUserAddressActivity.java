package com.delta.smt.ui.buycar.updateUserAddress;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.cart.AddressAreaResult;
import com.delta.smt.entity.cart.DeleteUserAddress;
import com.delta.smt.entity.cart.UpdateUserAddress;
import com.delta.smt.ui.buycar.addNewAddress.BottomDialogArea;
import com.delta.smt.ui.buycar.updateUserAddress.di.UpdateUserAddressModule;
import com.delta.smt.ui.buycar.updateUserAddress.mvp.UpdateUserAddressContract;
import com.delta.smt.ui.buycar.updateUserAddress.mvp.UpdateUserAddressPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.updateUserAddress.di.DaggerUpdateUserAddressComponent;
import com.google.gson.Gson;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/5/11.
 */

public class UpdateUserAddressActivity extends BaseActivity<UpdateUserAddressPresenter> implements UpdateUserAddressContract.View {

    @BindView(R.id.toolbar)
    FindToolBar findToolBar;
    @BindView(R.id.et_person_name)
    EditText etPersonName;
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.et_detail_address)
    EditText etDetailAddress;
    @BindView(R.id.arl_address_area)
    AutoRelativeLayout arlAddressArea;
    @BindView(R.id.tb_check_default_address)
    ToggleButton tbCheckDefaultAddress;
    @BindView(R.id.tv_area)
    TextView tvArea;

    String id;
    String area;
    String location_id;

    AddressAreaResult addressAreaResult;

    @BindView(R.id.btn_delete)
    TextView btnDelete;


    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerUpdateUserAddressComponent.builder()
                .appComponent(appComponent)
                .updateUserAddressModule(new UpdateUserAddressModule(this)) //请将UpdateUserAddressModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        findToolBar.setToolbarTitle("编辑地址");
        findToolBar.setToolbarLeftButton(R.mipmap.start_page_exit);
        findToolBar.setToolbarRightButton("保存");
        etPersonName.setText(getIntent().getStringExtra("person_name"));
        etPhoneNumber.setText(getIntent().getStringExtra("phone_number"));
        tvArea.setText(getIntent().getStringExtra("area_str"));
        etDetailAddress.setText(getIntent().getStringExtra("detail_address"));
        if (getIntent().getStringExtra("default_address").equals("1")) {
            tbCheckDefaultAddress.setChecked(true);
        } else {
            tbCheckDefaultAddress.setChecked(false);
        }
    }

    @Override
    protected void initData() {
        area = getIntent().getStringExtra("area");
        id = getIntent().getStringExtra("id");

        try {
            InputStreamReader isr = new InputStreamReader(getAssets().open("area.json"), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            br.close();
            isr.close();
            addressAreaResult = new Gson().fromJson(builder.toString(), AddressAreaResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_update_user_address;
    }


    @Override
    public void onUpdateUserAddressSuccess(UpdateUserAddress updateUserAddress) {
        ToastUtils.showMessage(UpdateUserAddressActivity.this, "修改成功");
        UpdateUserAddressActivity.this.finish();
    }

    @Override
    public void onUpdateUserAddressFailed(UpdateUserAddress updateUserAddress) {
        if (!TextUtils.isEmpty(updateUserAddress.getApp_msg())) {
            ToastUtils.showMessage(UpdateUserAddressActivity.this, updateUserAddress.getApp_msg());
        }

    }

    @Override
    public void onUpdateUserAddressFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(UpdateUserAddressActivity.this, throwable.getMessage());
        }
    }

    @Override
    public void onDeleteUserAddressSuccess(DeleteUserAddress deleteUserAddress) {
        ToastUtils.showMessage(UpdateUserAddressActivity.this, "删除成功");
        UpdateUserAddressActivity.this.finish();
    }

    @Override
    public void onDeleteUserAddressFailed(DeleteUserAddress deleteUserAddress) {
        if (!TextUtils.isEmpty(deleteUserAddress.getApp_msg())) {
            ToastUtils.showMessage(UpdateUserAddressActivity.this, deleteUserAddress.getApp_msg());
        }
    }

    @Override
    public void onDeleteUserAddressFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(UpdateUserAddressActivity.this, throwable.getMessage());
        }
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button, R.id.arl_address_area, R.id.btn_delete})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                UpdateUserAddressActivity.this.finish();
                break;
            case R.id.toolbar_right_button:
                if (tbCheckDefaultAddress.isChecked()) {
                    getPresenter().updateUserAddress(SpUtil.getStringSF(UpdateUserAddressActivity.this, Constant.TOKEN)
                            , SpUtil.getStringSF(UpdateUserAddressActivity.this, Constant.MERCHANTID)
                            , location_id
                            , etPersonName.getText().toString()
                            , etPhoneNumber.getText().toString()
                            , etDetailAddress.getText().toString()
                            , "1"
                            , id
                    );
                } else {
                    getPresenter().updateUserAddress(SpUtil.getStringSF(UpdateUserAddressActivity.this, Constant.TOKEN)
                            , SpUtil.getStringSF(UpdateUserAddressActivity.this, Constant.MERCHANTID)
                            , location_id
                            , etPersonName.getText().toString()
                            , etPhoneNumber.getText().toString()
                            , etDetailAddress.getText().toString()
                            , "0"
                            , id
                    );
                }


                break;
            case R.id.arl_address_area:
                BottomDialogArea dialogArea = new BottomDialogArea(getWindowManager().getDefaultDisplay().getHeight() * 765 / 1920, 0.8f, true, addressAreaResult);
                dialogArea.show(getSupportFragmentManager());
                dialogArea.setOnBottomDialogDateOKListener(new BottomDialogArea.OnBottomDialogDateOKListener() {
                    @Override
                    public void onDateOK(String province, String city, String area, String location_id) {
                        tvArea.setText(province + " " + city + " " + area);
                        UpdateUserAddressActivity.this.location_id = location_id;
                    }
                    /*@Override
                    public void onDateOK(String year, String month, String day) {
                        tvArea.setText(year + "-" + month + "-" + day);
                    }*/
                });
                break;
            case R.id.btn_delete:
                getPresenter().deleteUserAddress(SpUtil.getStringSF(UpdateUserAddressActivity.this, Constant.TOKEN), SpUtil.getStringSF(UpdateUserAddressActivity.this, Constant.TOKEN), id);
                break;
        }
    }

}