package com.delta.smt.ui.Personal.setting.person_information.receive_address;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
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
import com.delta.smt.entity.ItemReceiveAddress;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.add_address.AddAddressActivity;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.di.DaggerReceiveAddressComponent;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.di.ReceiveAddressModule;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.edit_address.EditAddressActivity;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.mvp.ReceiveAddressContract;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.mvp.ReceiveAddressPresenter;
import com.delta.smt.ui.find.FindToolBar;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.delta.smt.base.BaseApplication.getContext;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public class ReceiveAddressActivity extends BaseActivity<ReceiveAddressPresenter> implements ReceiveAddressContract.View {


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
    @BindView(R.id.ry_address)
    RecyclerView mRyAddress;
    @BindView(R.id.btn_add_address)
    Button mBtnLogout;

    private List<ItemReceiveAddress.ResultBean.ListBean> datas = new ArrayList<>();
    private CommonBaseAdapter<ItemReceiveAddress.ResultBean.ListBean> mAdapter;
    private String token;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerReceiveAddressComponent.builder()
                .appComponent(appComponent)
                .receiveAddressModule(new ReceiveAddressModule(this)) //请将ReceiveAddressModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {
        token = SpUtil.getStringSF(ReceiveAddressActivity.this, Constant.TOKEN);

        getPresenter().getReceiveAddress(token);


    }

    @Override
    protected void initView() {
        mToolbarTitle.setText("我的收货地址");
        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);

        mAdapter=new CommonBaseAdapter<ItemReceiveAddress.ResultBean.ListBean>(this, datas) {
            @Override
            protected void convert(CommonViewHolder holder, final ItemReceiveAddress.ResultBean.ListBean item, int position) {

                holder.setText(R.id.tv_name,item.getName());
                holder.setText(R.id.tv_telephone,item.getPhone());
                holder.setText(R.id.tv_address,item.getProvince()+item.getCity()+item.getArea()+item.getAddress());

                CheckBox cd_default=holder.getView(R.id.cb_default_address);

                if (item.getStatus()==1) {
                    cd_default.setChecked(true);
                    cd_default.setText("默认地址");
                    cd_default.setTextColor(getResources().getColor(R.color.base_color));
                }else {
                    cd_default.setChecked(false);
                    cd_default.setText("设为默认地址");
                    cd_default.setTextColor(getResources().getColor(R.color.c_333333));
                }

                cd_default.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            getPresenter().editDefaultAddress(token,"1",item.getId());
                        }else {
                            getPresenter().editDefaultAddress(token,"0",item.getId());
                        }
                    }
                });


                holder.getView(R.id.btn_edit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle mBundle = new Bundle();
                        mBundle.putInt("id",item.getId());
                        IntentUtils.showIntent(ReceiveAddressActivity.this, EditAddressActivity.class,mBundle);
                    }
                });
                holder.getView(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().deleteAddress(token,item.getId());
                    }
                });
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemReceiveAddress.ResultBean.ListBean item) {
                return R.layout.item_receive_address;
            }
        };


        mRyAddress.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRyAddress.setAdapter(mAdapter);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_receive_address;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().getReceiveAddress(token);
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.btn_add_address})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.btn_add_address:
                IntentUtils.showIntent(this, AddAddressActivity.class);
                break;
        }
    }

    @Override
    public void getReceiveAddress(List<ItemReceiveAddress.ResultBean.ListBean> itemReceiveAddress) {
        datas.clear();
        datas.addAll(itemReceiveAddress);
        //对adapter刷新改变
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        ToastUtils.showMessage(this,message);
    }

    @Override
    public void deleteAddress() {
        ToastUtils.showMessage(this,"操作成功");
        getPresenter().getReceiveAddress(token);
    }

    @Override
    public void editDefaultAddress() {
        getPresenter().getReceiveAddress(token);
    }
}