package com.delta.smt.ui.buycar.addNewAddress;

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
import com.delta.smt.entity.cart.NewAddressResult;
import com.delta.smt.ui.buycar.addNewAddress.di.AddNewAddressModule;
import com.delta.smt.ui.buycar.addNewAddress.di.DaggerAddNewAddressComponent;
import com.delta.smt.ui.buycar.addNewAddress.mvp.AddNewAddressContract;
import com.delta.smt.ui.buycar.addNewAddress.mvp.AddNewAddressPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.google.gson.Gson;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/5/7.
 */

public class AddNewAddressActivity extends BaseActivity<AddNewAddressPresenter> implements AddNewAddressContract.View {

    @BindView(R.id.toolbar)
    FindToolBar findToolBar;
    @BindView(R.id.arl_address_area)
    AutoRelativeLayout arlAddressArea;
    AddressAreaResult addressAreaResult;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.et_person_name)
    EditText etPersonName;
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @BindView(R.id.et_detail_address)
    EditText etDetailAddress;
    @BindView(R.id.tb_check_default_address)
    ToggleButton tbCheckDefaultAddress;
    String location_id = "";

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerAddNewAddressComponent.builder()
                .appComponent(appComponent)
                .addNewAddressModule(new AddNewAddressModule(this)) //请将AddNewAddressModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        findToolBar.setToolbarTitle("添加新地址");
        findToolBar.setToolbarLeftButton(R.mipmap.start_page_exit);
        findToolBar.setToolbarRightButton("保存");
        //getPresenter().getAddressArea("1");
    }

    @Override
    protected void initData() {
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
        return R.layout.activity_add_new_address;
    }


    @Override
    public void onAddUserAddressSuccess(NewAddressResult newAddressResult) {
        ToastUtils.showMessage(AddNewAddressActivity.this, "保存成功！");
        AddNewAddressActivity.this.finish();
    }

    @Override
    public void onAddUserAddressFailed(NewAddressResult newAddressResult) {
        if (!TextUtils.isEmpty(newAddressResult.getApp_msg())) {
            ToastUtils.showMessage(AddNewAddressActivity.this, newAddressResult.getApp_msg());
        }
    }

    @Override
    public void onAddUserAddressFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(AddNewAddressActivity.this, throwable.getMessage());
        }
    }

    @Override
    public void onAddressAreaSuccess(AddressAreaResult addressAreaResult) {
        this.addressAreaResult = addressAreaResult;
    }

    @Override
    public void onAddressAreaFailed(AddressAreaResult addressAreaResult) {

    }

    @Override
    public void onAddressAreaFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(AddNewAddressActivity.this, throwable.getMessage());
        }
    }

    @OnClick({R.id.toolbar_right_button, R.id.toolbar_left_button_arl, R.id.arl_address_area})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_right_button:
                if (TextUtils.isEmpty(etPersonName.getText().toString())) {
                    ToastUtils.showMessage(AddNewAddressActivity.this, "收货人不能为空！");
                    return;
                }
                if (TextUtils.isEmpty(etPhoneNumber.getText().toString())) {
                    ToastUtils.showMessage(AddNewAddressActivity.this, "手机号码不能为空！");
                    return;
                }
                if (tvArea.getText().toString().equals("请选择")) {
                    ToastUtils.showMessage(AddNewAddressActivity.this, "请选择所在地区！");
                    return;
                }
                if (TextUtils.isEmpty(etDetailAddress.getText().toString())) {
                    ToastUtils.showMessage(AddNewAddressActivity.this, "详细地址不能空！");
                    return;
                }
                if (tbCheckDefaultAddress.isChecked()) {
                    getPresenter().addUserAddress(SpUtil.getStringSF(AddNewAddressActivity.this, Constant.TOKEN)
                            , SpUtil.getStringSF(AddNewAddressActivity.this, Constant.MERCHANTID)
                            , location_id
                            , etPhoneNumber.getText().toString()
                            , etPersonName.getText().toString()
                            , etDetailAddress.getText().toString()
                            , "1");
                } else {
                    getPresenter().addUserAddress(SpUtil.getStringSF(AddNewAddressActivity.this, Constant.TOKEN)
                            , SpUtil.getStringSF(AddNewAddressActivity.this, Constant.MERCHANTID)
                            , location_id
                            , etPhoneNumber.getText().toString()
                            , etPersonName.getText().toString()
                            , etDetailAddress.getText().toString()
                            , "0");
                }

                break;
            case R.id.toolbar_left_button_arl:
                AddNewAddressActivity.this.finish();
                break;
            case R.id.arl_address_area:
                BottomDialogArea dialogArea = new BottomDialogArea(getWindowManager().getDefaultDisplay().getHeight() * 765 / 1920, 0.8f, true, addressAreaResult);
                dialogArea.show(getSupportFragmentManager());
                dialogArea.setOnBottomDialogDateOKListener(new BottomDialogArea.OnBottomDialogDateOKListener() {
                    @Override
                    public void onDateOK(String province, String city, String area, String location_id) {
                        tvArea.setText(province + " " + city + " " + area);
                        AddNewAddressActivity.this.location_id = location_id;
                    }
                    /*@Override
                    public void onDateOK(String year, String month, String day) {
                        tvArea.setText(year + "-" + month + "-" + day);
                    }*/
                });
                break;
        }

    }
}