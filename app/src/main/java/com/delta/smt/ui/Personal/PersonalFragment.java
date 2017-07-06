package com.delta.smt.ui.Personal;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseFragment;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.UserInfo;
import com.delta.smt.ui.Personal.Balance.BalanceActivity;
import com.delta.smt.ui.Personal.PayMerchant.PayMerchantActivity;
import com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.PersonAppointmentActivity;
import com.delta.smt.ui.Personal.PersonalActivities.PersonActivitiesActivity;
import com.delta.smt.ui.Personal.di.DaggerPresonalComponent;
import com.delta.smt.ui.Personal.di.PresonalModule;
import com.delta.smt.ui.Personal.mvp.PersonalContract;
import com.delta.smt.ui.Personal.mvp.PresonalPresenter;
import com.delta.smt.ui.Personal.my_order.MyOrderActivity;
import com.delta.smt.ui.Personal.setting.SettingActivity;
import com.delta.smt.ui.Personal.setting.person_information.PersonInformationActivity;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.zhy.autolayout.AutoLinearLayout;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;


public class PersonalFragment extends BaseFragment<PresonalPresenter> implements PersonalContract.View {


    private static final int REQUEST_CODE = 100;
    @BindView(R.id.personal_headportrait)
    CircleImageView personalHeadportrait;
    @BindView(R.id.personal_name)
    TextView personalName;
    @BindView(R.id.personal_phoneNumber)
    TextView personalPhoneNumber;
    @BindView(R.id.personals_payment)
    Button personalsPayment;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.personals_shopmanage)
    AutoLinearLayout personalsShopmanage;
    @BindView(R.id.personal_unpay)
    TextView personalUnpay;
    @BindView(R.id.personal_un_send)
    TextView personalUnSend;
    @BindView(R.id.personal_unReceived)
    TextView personalUnReceived;
    @BindView(R.id.person_appointment)
    AutoLinearLayout personAppointment;
    @BindView(R.id.personals_participationactivity)
    AutoLinearLayout personalsParticipationactivity;
    @BindView(R.id.My_Points)
    AutoLinearLayout MyPoints;
    @BindView(R.id.personal_setting)
    AutoLinearLayout personalSetting;
    @BindView(R.id.fragment)
    FrameLayout fragment;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.ll_merchant)
    AutoLinearLayout llMerchant;
    @BindView(R.id.tv_score)
    TextView tvScore;
    Unbinder unbinder;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Bundle mBundle;
    private String token;
    private String merchant_id;
    private UserInfo.ResultEntity.UserEntity user;


    @Override
    protected void initView() {
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerPresonalComponent.builder().appComponent(appComponent).presonalModule(new PresonalModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {

        token = SpUtil.getStringSF(getActivity(), Constant.TOKEN);

        merchant_id = SpUtil.getStringSF(getActivity(), Constant.MERCHANTID);

    }

    @Override
    public void onResume() {
        getPresenter().getUseInfo(token, merchant_id);
        super.onResume();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_personals;
    }


    @OnClick({R.id.ll_merchant, R.id.ll_person,R.id.personals_payment, R.id.textView2,  R.id.textView8, R.id.personals_shopmanage, R.id.personal_unpay, R.id.personal_un_send, R.id.personal_unReceived, R.id.person_appointment, R.id.personals_participationactivity, R.id.My_Points, R.id.personal_setting, R.id.fragment})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_person:
                IntentUtils.showIntent(getActivity(), PersonInformationActivity.class);
                break;
            case R.id.ll_merchant:
                mBundle =new Bundle();
                mBundle.putString(Constant.BLANCE,user.getBalance());
               IntentUtils.showIntent(getActivity(),BalanceActivity.class,mBundle);
                break;
            case R.id.personals_payment:
                Intent intent = new Intent(getMainActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.textView2:
                break;
            case R.id.textView8:
                mBundle = new Bundle();
                mBundle.putInt(Constant.SELECT_YTPE, 0);
                IntentUtils.showIntent(getActivity(), MyOrderActivity.class, mBundle);
                break;
            case R.id.personals_shopmanage:
                break;
            case R.id.personal_unpay:
                mBundle = new Bundle();
                mBundle.putInt(Constant.SELECT_YTPE, 1);
                IntentUtils.showIntent(getActivity(), MyOrderActivity.class, mBundle);
                break;
            case R.id.personal_un_send:
                mBundle = new Bundle();
                mBundle.putInt(Constant.SELECT_YTPE, 2);
                IntentUtils.showIntent(getActivity(), MyOrderActivity.class, mBundle);
                break;
            case R.id.personal_unReceived:
                mBundle = new Bundle();
                mBundle.putInt(Constant.SELECT_YTPE, 3);
                IntentUtils.showIntent(getActivity(), MyOrderActivity.class, mBundle);
                break;
            case R.id.person_appointment:
                Intent intent3 = new Intent(getMainActivity(), PersonAppointmentActivity.class);
                startActivity(intent3);
                break;
            case R.id.personals_participationactivity:
                Intent intent2 = new Intent(getMainActivity(), PersonActivitiesActivity.class);
                startActivity(intent2);
                break;
            case R.id.My_Points:
                break;
            case R.id.personal_setting:
                IntentUtils.showIntent(getActivity(), SettingActivity.class);
                break;
            case R.id.fragment:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);

                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        int merchant_id = jsonObject.getInt("merchant_id");
                        Intent intent = new Intent(getMainActivity(), PayMerchantActivity.class);
                        intent.putExtra(Constant.MERCHANTID, merchant_id);
                        intent.putExtra(Constant.BLANCE,user.getBalance());
                        startActivity(intent);


                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getMainActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                    }

                    Toast.makeText(getMainActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {

                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void ShowUserInfoSuccess(UserInfo userInfo) {

        user = userInfo.getResult().getUser();
        Glide.with(getActivity()).load(user.getImage_url()).centerCrop().into(personalHeadportrait);
        personalName.setText(user.getName());
        personalPhoneNumber.setText(user.getPhone());
        tvAccount.setText("￥" + user.getBalance());
        tvScore.setText(user.getScore());


    }

    @Override
    public void showUserInfoError() {

        ToastUtils.showMessage(getActivity(), "获取用户信息失败！");
    }

    @Override
    public void resetPasswordSuccess() {

    }

    @Override
    public void resetPasswordFailed(String app_msg) {

    }

    @Override
    public void checkPasswordSuccess() {

    }

    @Override
    public void checkPasswordFailed(String app_msg) {

    }


}
