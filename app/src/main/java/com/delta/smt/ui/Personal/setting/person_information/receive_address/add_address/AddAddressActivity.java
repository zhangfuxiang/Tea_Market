package com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address;

import android.content.Context;
import android.content.Loader;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemLocation;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.di.AddAddressModule;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.di.DaggerAddAddressComponent;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.mvp.AddAddressContract;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.mvp.AddAddressPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.delta.smt.R.color.base_color;
import static com.delta.smt.R.color.grey;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public class AddAddressActivity extends BaseActivity<AddAddressPresenter> implements AddAddressContract.View {


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
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_telephone)
    EditText mEtTelephone;
    @BindView(R.id.et_address)
    EditText mEtAddress;
    @BindView(R.id.sw_default_address)
    Switch mSwDefaultAddress;
    @BindView(R.id.ll_shake)
    AutoRelativeLayout mLlShake;
    @BindView(R.id.et_location)
    EditText mEtLocation;
    @BindView(R.id.tv_location)
    TextView mTvLocation;

    private String token;
    private CityPicker mCityPickerp;
    private String province, city, district,defaultAddress;
    private int code;
    private InputMethodManager imm;
    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerAddAddressComponent.builder()
                .appComponent(appComponent)
                .addAddressModule(new AddAddressModule(this)) //请将AddAddressModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {
        token = SpUtil.getStringSF(AddAddressActivity.this, Constant.TOKEN);
        Log.e("aaa", "initData: " + token);
        imm =  (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);


        mCityPickerp = new CityPicker.Builder(AddAddressActivity.this)
                .textSize(15)
                .title("地区选择")
                .backgroundPop(0xa0000000)
                .titleBackgroundColor("#f2f2f4")
                .titleTextColor("#000000")
                .backgroundPop(0xa0000000)
                .confirTextColor("#307142")
                .cancelTextColor("#666666")
                .province("北京市")
                .city("北京市")
                .district("昌平区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();


    }


    @Override
    protected void initView() {

        mToolbarTitle.setText("添加新地址");
        mToolbarRightButton.setText("保存");
        mToolbarLeftButton.setImageResource(R.mipmap.start_page_exit);

        mCityPickerp.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... strings) {
                //省份
                province = strings[0];
                //城市
                city = strings[1];
                //区县（如果设定了两级联动，那么该项返回空）
                district = strings[2];
                mEtLocation.setText(province+" "+city+" "+district);
                ToastUtils.showMessage(AddAddressActivity.this,"选择地区："+province+" "+city+" "+district);
                getPresenter().getLocation(province,city,district);
            }

            @Override
            public void onCancel() {
                ToastUtils.showMessage(AddAddressActivity.this, "已经取消");
            }
        });


        mSwDefaultAddress.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    defaultAddress="1";
                    Log.e(TAG, "onCheckedChanged: "+defaultAddress );
                }else {
                    defaultAddress="0";
                    Log.e(TAG, "onCheckedChanged: "+defaultAddress );
                }
            }
        });
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_add_address;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button,R.id.ll_location,R.id.et_location})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.toolbar_right_button:
                if (!TextUtils.isEmpty(mEtName.getText())&&!TextUtils.isEmpty(mEtTelephone.getText())&&
                        !TextUtils.isEmpty(mEtLocation.getText())&&!TextUtils.isEmpty(mEtAddress.getText())) {

                    getPresenter().addReceiveAddress(token, String.valueOf(code), mEtTelephone.getText().toString()
                            , mEtName.getText().toString(), mEtAddress.getText().toString(), defaultAddress);

                } else {
                    ToastUtils.showMessage(this, "内容不能为空！");
                }
/*                ToastUtils.showMessage(this,code);*/
                break;
            case R.id.ll_location:
                if (imm!=null) {
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }
                mCityPickerp.show();
                break;
            case R.id.et_location:
                if (imm!=null) {
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }
                mCityPickerp.show();
                break;
        }
    }


    @Override
    public void addReceiveAddress() {
        mEtName.setText("");
        mEtLocation.setText("");
        mEtAddress.setText("");
        mEtTelephone.setText("");
        mSwDefaultAddress.setChecked(false);
        ToastUtils.showMessage(this, "添加成功");

    }

    @Override
    public void showMessage(String message) {
        ToastUtils.showMessage(this, message);
    }

    @Override
    public void getLocation(int code) {
        this.code=code;
    }


}