package com.delta.smt.ui.Personal.setting.person_information;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemUserInformation;
import com.delta.smt.ui.Personal.setting.person_information.change_name.ChangeNameBottomDialog;
import com.delta.smt.ui.Personal.setting.person_information.change_sex.ChangeSexBottomDialog;
import com.delta.smt.ui.Personal.setting.person_information.di.DaggerPersonInformationComponent;
import com.delta.smt.ui.Personal.setting.person_information.di.PersonInformationModule;
import com.delta.smt.ui.Personal.setting.person_information.mvp.PersonInformationContract;
import com.delta.smt.ui.Personal.setting.person_information.mvp.PersonInformationPresenter;
import com.delta.smt.ui.Personal.setting.person_information.receive_address.ReceiveAddressActivity;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.utils.MapUtils;
import com.luck.picture.lib.compress.Luban;
import com.luck.picture.lib.model.FunctionConfig;
import com.luck.picture.lib.model.FunctionOptions;
import com.luck.picture.lib.model.PictureConfig;
import com.yalantis.ucrop.entity.LocalMedia;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static com.delta.smt.base.BaseApplication.getContext;


/**
 * Created by Fuxiang.Zhang on 2017/5/7.
 */

public class PersonInformationActivity extends BaseActivity<PersonInformationPresenter> implements PersonInformationContract.View {


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
    @BindView(R.id.iv_head_image)
    CircleImageView mIvHeadImage;
    @BindView(R.id.textView11)
    TextView mTextView11;
    @BindView(R.id.ll_head_image)
    AutoRelativeLayout mLlHeadImage;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.ll_name)
    AutoLinearLayout mLlName;
    @BindView(R.id.tv_sex)
    TextView mTvSex;
    @BindView(R.id.ll_sex)
    AutoLinearLayout mLlSex;
    @BindView(R.id.tv_receiver_address)
    TextView mTvReceiverAddress;

    private String token;
    private Map<String, String> queryMap;
    private FunctionOptions options;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerPersonInformationComponent.builder()
                .appComponent(appComponent)
                .personInformationModule(new PersonInformationModule(this)) //请将PersonInformationModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {
        token = SpUtil.getStringSF(PersonInformationActivity.this, Constant.TOKEN);
        getPresenter().getPersonInformation(token);

        options = new FunctionOptions.Builder()
                .setType(FunctionConfig.TYPE_IMAGE)
                .setMaxB(202400)
                .setEnablePixelCompress(true) //是否启用像素压缩
                .setEnableQualityCompress(true) //是否启质量压缩
                .setCompress(true)
                .setEnableCrop(true) // 是否打开剪切选项
                .setCircularCut(true)
                .setSelectMode(FunctionConfig.MODE_SINGLE)
                .setGrade(Luban.THIRD_GEAR)
                .create();
    }

    @Override
    protected void initView() {
        mToolbarTitle.setText("个人资料");
        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);


    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_person_information;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.ll_head_image, R.id.ll_name, R.id.ll_sex, R.id.tv_receiver_address})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.ll_head_image:
                PictureConfig.getInstance().init(options).openPhoto(this, new PictureConfig.OnSelectResultCallback() {
                    @Override
                    public void onSelectSuccess(List<LocalMedia> list) {

                    }

                    @Override
                    public void onSelectSuccess(LocalMedia localMedia) {

                        Glide.with(getContext()).load(localMedia.getCompressPath()).into(mIvHeadImage);
                        String path = localMedia.getCompressPath();
                        Map<String, File> params = new HashMap<>();
                        File mFile = new File(path);
                        Log.e(TAG, "onSelectSuccess: " + mFile);
/*                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), mFile);
                        params.put("image", mFile);*/

                        // 创建 RequestBody，用于封装 请求RequestBody
                        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), mFile);
                        try {
                            long size = requestFile.contentLength();
                            Log.i(TAG, "upLoadFile size: " + size);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // MultipartBody.Part is used to send also the actual file name
                        MultipartBody.Part body = MultipartBody.Part.createFormData("image", mFile.getName(), requestFile);

                        getPresenter().submitImage(token, body);
                    }
                });
                break;
            case R.id.ll_name:
/*                Bundle mBundle=new Bundle();
//                mBundle.putString();
                IntentUtils.showIntent(this,ChangeNameActivity.class);*/
                ChangeNameBottomDialog mDialog1 = new ChangeNameBottomDialog(getWindowManager().getDefaultDisplay().getHeight() * 545 / 1920, 0.8f, true, mTvName.getText().toString());
                mDialog1.show(getSupportFragmentManager());
                mDialog1.setOnBottomDialogDimissListener(new ChangeNameBottomDialog.OnBottomDialogDimissListener() {
                    @Override
                    public void onDismiss(String content) {
//                        mTvName.setText(content);
                        queryMap = MapUtils.CreateQueryMap(getContext());
                        queryMap.put("name", content.toString());
                        if (mTvSex.getText().equals("男")) {

                            queryMap.put("sex", "1");
                            getPresenter().updatePersonInformation(queryMap);
                        } else {
                            queryMap.put("sex", "2");
                            getPresenter().updatePersonInformation(queryMap);
                        }
                    }
                });
                break;
            case R.id.ll_sex:
                final ChangeSexBottomDialog mDialog = new ChangeSexBottomDialog(getWindowManager().getDefaultDisplay().getHeight() * 545 / 1920, 0.8f, true);
                mDialog.show(getSupportFragmentManager());
                mDialog.setOnBottomDialogDimissListener(new ChangeSexBottomDialog.OnBottomDialogDimissListener() {

                    @Override
                    public void onDismiss(String content) {
//                        mTvSex.setText(content);
                        queryMap = MapUtils.CreateQueryMap(getContext());
                        queryMap.put("name", mTvName.getText().toString());
                        if (content.equals("男")) {
                            queryMap.put("sex", "1");
                            getPresenter().updatePersonInformation(queryMap);
                        } else {
                            queryMap.put("sex", "2");
                            getPresenter().updatePersonInformation(queryMap);
                        }
                    }
                });
                break;
            case R.id.tv_receiver_address:
                IntentUtils.showIntent(this, ReceiveAddressActivity.class);
                break;
        }
    }

    @Override
    public void showMessage(String message) {
        ToastUtils.showMessage(this, message);
    }

    @Override
    public void getPersonInformation(ItemUserInformation.ResultBean.UserBean personInformation) {
//        this.personInformation=personInformation;
        Glide.with(this).load(personInformation.getImage_url()).into(mIvHeadImage);
        mTvName.setText(personInformation.getName());
        if (personInformation.getSex() == 1) {
            mTvSex.setText("男");
        } else {
            mTvSex.setText("女");
        }


    }

    @Override
    public void submitImage(int id) {
        queryMap = MapUtils.CreateQueryMap(getContext());
        queryMap.put("name", mTvName.getText().toString());
        queryMap.put("image_id", String.valueOf(id));

        if (mTvSex.getText().equals("男")) {
            queryMap.put("sex", "1");
            getPresenter().updatePersonInformation(queryMap);
        } else {
            queryMap.put("sex", "2");
            getPresenter().updatePersonInformation(queryMap);
        }

    }

    @Override
    public void updatePersonInformation() {
        getPresenter().getPersonInformation(token);
    }


}