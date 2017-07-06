package com.delta.smt.ui.Personal.setting.advice_response;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.ui.Personal.setting.advice_response.change_response_type.ChangeTypeBottomDialog;
import com.delta.smt.ui.Personal.setting.advice_response.di.AdviceResponseModule;
import com.delta.smt.ui.Personal.setting.advice_response.di.DaggerAdviceResponseComponent;
import com.delta.smt.ui.Personal.setting.advice_response.mvp.AdviceResponseContract;
import com.delta.smt.ui.Personal.setting.advice_response.mvp.AdviceResponsePresenter;
import com.delta.smt.ui.Personal.setting.person_information.PersonInformationActivity;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.QueryMap;

import static com.delta.smt.base.BaseApplication.getContext;


/**
 * Created by Fuxiang.Zhang on 2017/5/20.
 */

public class AdviceResponseActivity extends BaseActivity<AdviceResponsePresenter> implements AdviceResponseContract.View {


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
    @BindView(R.id.tv_response_type)
    TextView mTvResponseType;
    @BindView(R.id.ll_response_type)
    AutoLinearLayout mLlResponseType;
    @BindView(R.id.et_input_content)
    EditText mEtInputContent;
    @BindView(R.id.iv_add_image)
    ImageView mIvAddImage;
    @BindView(R.id.ll_picture)
    AutoLinearLayout mLlPicture;

    private Map<String,String> queryMap;
    private String type,token;
    private FunctionOptions option;
    private int image_id;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerAdviceResponseComponent.builder()
                .appComponent(appComponent)
                .adviceResponseModule(new AdviceResponseModule(this)) //请将AdviceResponseModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {

        token = SpUtil.getStringSF(AdviceResponseActivity.this, Constant.TOKEN);
        option = new FunctionOptions.Builder()
                .setType(FunctionConfig.TYPE_IMAGE)
                .setMaxB(202400)
                .setEnablePixelCompress(true) //是否启用像素压缩
                .setEnableQualityCompress(true) //是否启质量压缩
                .setCompress(true)
                .setSelectMode(FunctionConfig.MODE_SINGLE)
                .setGrade(Luban.THIRD_GEAR)
                .create();

    }

    @Override
    protected void initView() {
        mToolbarTitle.setText("意见反馈");
        mToolbarRightButton.setText("提交");
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_advice_response;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button, R.id.ll_response_type, R.id.iv_add_image})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.toolbar_right_button:

                if (!TextUtils.isEmpty(mEtInputContent.getText())) {
                    if (!mTvResponseType.getText().equals("请选择")) {
                        switch (mTvResponseType.getText().toString()){
                            case "商品质量":
                                type="2";
                                break;
                            case "其他":
                                type="1";
                                break;
                            case "产品功能建议":
                                type="3";
                                break;
                        }
                        queryMap= MapUtils.CreateQueryMap(this);
                        queryMap.put("comment",mEtInputContent.getText().toString());
                        queryMap.put("type",type);
                        queryMap.put("image_id",String.valueOf(image_id));
                        getPresenter().submitAdvice(queryMap);

                    }else {
                        showMessage("请选择反馈类型！");
                    }
                }else {
                    showMessage("内容不能为空！");
                }
                break;
            case R.id.ll_response_type:
                final ChangeTypeBottomDialog mDialog = new ChangeTypeBottomDialog(getWindowManager().getDefaultDisplay().getHeight() * 545 / 1920, 0.8f, true);
                mDialog.show(getSupportFragmentManager());
                mDialog.setOnBottomDialogDimissListener(new ChangeTypeBottomDialog.OnBottomDialogDimissListener() {

                    @Override
                    public void onDismiss(String content) {
                        mTvResponseType.setText(content);
                    }
                });
                break;
            case R.id.iv_add_image:
                PictureConfig.getInstance().init(option).openPhoto(this, new PictureConfig.OnSelectResultCallback() {
                    @Override
                    public void onSelectSuccess(List<LocalMedia> list) {

                    }

                    @Override
                    public void onSelectSuccess(LocalMedia localMedia) {
                        Glide.with(getContext()).load(localMedia.getCompressPath()).into(mIvAddImage);

                        String path = localMedia.getCompressPath();
                        File mFile = new File(path);
/*                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), mFile);
                        params.put("image", mFile);*/

                        // 创建 RequestBody，用于封装 请求RequestBody
                        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), mFile);
                        // MultipartBody.Part is used to send also the actual file name
                        MultipartBody.Part body = MultipartBody.Part.createFormData("image", mFile.getName(), requestFile);

                        getPresenter().submitImage(token, body);
                    }
                });
                break;
        }
    }

    @Override
    public void showMessage(String message) {
        ToastUtils.showMessage(this,message);
    }

    @Override
    public void submitAdvice(String message) {
        showMessage(message);
        finish();
/*        mEtInputContent.setText("");
        mTvResponseType.setText("请选择");
        mIvAddImage.setImageResource(R.mipmap.iv_add_image);*/
    }

    @Override
    public void submitImage(int id) {
        image_id=id;
    }


}