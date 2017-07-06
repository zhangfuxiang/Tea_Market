package com.delta.smt.ui.HomePage.subjectActivityDetail;

import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.home_page.activity.ActivityCancelResult;
import com.delta.smt.entity.home_page.activity.ActivityDetail;
import com.delta.smt.entity.home_page.activity.ActivityDetailResult;
import com.delta.smt.entity.home_page.activity.ActivitySignUpResult;
import com.delta.smt.ui.HomePage.subjectActivityDetail.di.DaggerSubjectActivityDetailComponent;
import com.delta.smt.ui.HomePage.subjectActivityDetail.di.SubjectActivityDetailModule;
import com.delta.smt.ui.HomePage.subjectActivityDetail.mvp.SubjectActivityDetailContract;
import com.delta.smt.ui.HomePage.subjectActivityDetail.mvp.SubjectActivityDetailPresenter;
import com.delta.smt.ui.HomePage.viewtools.GlideImageLoader;
import com.delta.smt.ui.find.FindToolBar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

public class SubjectActivityDetailActivity extends BaseActivity<SubjectActivityDetailPresenter> implements SubjectActivityDetailContract.View, OnBannerListener, PayBottomDialog.OnSignUpPayListener {

    @BindView(R.id.toolbar)
    FindToolBar toolbar;

    Banner banner;
    @BindView(R.id.tv_show_subject_name)
    TextView tvShowActivityName;
    @BindView(R.id.tv_showNowPrice)
    TextView tvShowNowPrice;
    @BindView(R.id.tv_showShowPersonAmount)
    TextView tvShowShowPersonAmount;
    @BindView(R.id.tv_subject_period)
    TextView tvSubjectPeriod;
    @BindView(R.id.tv_subject_place)
    TextView tvSubjectPlace;
    //@BindView(R.id.tv_subject_content)
    //TextView tvSubjectContent;
    @BindView(R.id.wv_subject_content)
    WebView wvSubjectContent;

    /*@BindView(R.id.tv_add_sbject)
    TextView tvAddSubject;*/
    @BindView(R.id.tv_sign_up)
    TextView tvSignUp;
    @BindView(R.id.tv_cancel_sign_up)
    TextView tvCancelSignUp;

    @BindView(R.id.tv_show_suject_status)
    TextView tvShowSujectStatus;


    //BottomDialog bottomDialog;

    ActivityDetail result;
    String name;
    String price;

    String activity_id;
    String subject_activity_status;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd",
            Locale.CHINA);

    String[] image_urls;

    Gson gson = new GsonBuilder().
            registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

                @Override
                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src == src.longValue())
                        return new JsonPrimitive(src.longValue());
                    return new JsonPrimitive(src);
                }
            }).create();
    ActivityDetailResult activityDetailResult;

    String signUpId;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerSubjectActivityDetailComponent.builder()
                .appComponent(appComponent)
                .subjectActivityDetailModule(new SubjectActivityDetailModule(this)) //请将SubjectActivityDetailModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolbar.setToolbarLeftButton(R.mipmap.ic_back);
        toolbar.setToolbarRightButtonIv(R.mipmap.ic_share);

    }

    @Override
    protected void initData() {
        activity_id = getIntent().getStringExtra("activity_id");
        getPresenter().getSubjectActivityDetail(SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.TOKEN), activity_id, SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.MERCHANTID));
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_subject_activity_detail_page;
    }

    @Override
    public void onDetailSuccess(ActivityDetail result) {

        activityDetailResult = gson.fromJson(gson.toJson(result.getResult()), ActivityDetailResult.class);
        signUpId = activityDetailResult.getAct().getSign_id();
        image_urls = activityDetailResult.getAct().getImages().toArray(new String[activityDetailResult.getAct().getImages().size()]);
        showSubjectActivityDetail(image_urls);

        name = activityDetailResult.getAct().getTitle();
        tvShowActivityName.setText(name);
        subject_activity_status = activityDetailResult.getAct().getStatus();
        long now_time = System.currentTimeMillis();
        long start_time = Long.parseLong(activityDetailResult.getAct().getStart_time()) * 1000;
        long end_time = Long.parseLong(activityDetailResult.getAct().getEnd_time()) * 1000;

        if (activityDetailResult.getAct().getIs_signed() == 1 + "") {
            tvShowSujectStatus.setTextColor(getResources().getColor(R.color.base_color));
            tvShowSujectStatus.setText("已报名");
            tvSignUp.setVisibility(View.GONE);
            tvCancelSignUp.setVisibility(View.VISIBLE);
        } else {
            tvSignUp.setVisibility(View.VISIBLE);
            tvCancelSignUp.setVisibility(View.GONE);
            tvShowSujectStatus.setTextColor(Color.rgb(255, 96, 0));
            if (now_time < start_time) {
                tvShowSujectStatus.setText("报名中");
                if (activityDetailResult.getAct().getSign_num() == activityDetailResult.getAct().getNumber()) {
                    tvShowSujectStatus.setText("报名人数已满");
                } else {
                    tvShowSujectStatus.setText("报名中");
                }
            } else if (now_time >= end_time) {
                tvShowSujectStatus.setText("活动已结束");
            } else {
                tvShowSujectStatus.setText("活动进行中");
            }
        }

        price = "¥" + activityDetailResult.getAct().getPrice();
        tvShowNowPrice.setText(price);
        tvShowShowPersonAmount.setText("已报名/限定人数：" + activityDetailResult.getAct().getSign_num() + "/" + activityDetailResult.getAct().getNumber());
        //String start_time =
        tvSubjectPeriod.setText(simpleDateFormat.format(new Date(Long.parseLong(activityDetailResult.getAct().getStart_time()) * 1000))
                + "-" + simpleDateFormat.format(new Date(Long.parseLong(activityDetailResult.getAct().getEnd_time()) * 1000)));
        tvSubjectPlace.setText(activityDetailResult.getAct().getAddress());
        //tvSubjectContent.setText(Html.fromHtml(result.getResult().getActivity().getContent()));
        initWebView();
        wvSubjectContent.loadDataWithBaseURL(null, getNewContent(activityDetailResult.getAct().getContent()), "text/html", "UTF-8", null);
        this.result = result;

    }

    private String getNewContent(String htmltext) {

        Document doc = Jsoup.parse(htmltext);
        Elements elements = doc.getElementsByTag("img");
        for (Element element : elements) {
            element.attr("width", "100%").attr("height", "auto");
        }

        return doc.toString();
    }

    private void initWebView() {
        wvSubjectContent.getSettings().setJavaScriptEnabled(true);
        wvSubjectContent.getSettings().setBuiltInZoomControls(false);
        wvSubjectContent.getSettings().setDisplayZoomControls(false);
        wvSubjectContent.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
        wvSubjectContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        wvSubjectContent.getSettings().setDefaultTextEncodingName("UTF-8");
        wvSubjectContent.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wvSubjectContent.getSettings().setMixedContentMode(wvSubjectContent.getSettings().MIXED_CONTENT_ALWAYS_ALLOW);  //注意安卓5.0以上的权限
        }
    }

    @Override
    public void onDetailFailed(ActivityDetail activityDetail) {
        if (!TextUtils.isEmpty(activityDetail.getApp_msg())) {
            ToastUtils.showMessage(SubjectActivityDetailActivity.this, activityDetail.getApp_msg());
            tvSignUp.setBackgroundColor(Color.GRAY);
            tvSignUp.setEnabled(false);
        }
    }

    @Override
    public void onDetailFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(SubjectActivityDetailActivity.this, throwable.getMessage());
        }
    }

    @Override
    public void onSignUpSuccess(ActivitySignUpResult activitySignUpResult) {
        if (!TextUtils.isEmpty(activitySignUpResult.getResult().toString())) {
            ToastUtils.showMessage(SubjectActivityDetailActivity.this, activitySignUpResult.getResult().toString());
            getPresenter().getSubjectActivityDetail(SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.TOKEN), activity_id, SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.MERCHANTID));
        }
    }

    @Override
    public void onSignUpFailed(ActivitySignUpResult activitySignUpResult) {
        if (!TextUtils.isEmpty(activitySignUpResult.getApp_msg())) {
            ToastUtils.showMessage(SubjectActivityDetailActivity.this, activitySignUpResult.getApp_msg());
        }
    }

    @Override
    public void onSignUpFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(SubjectActivityDetailActivity.this, throwable.getMessage());
        }
    }

    @Override
    public void onCancelSuccess(ActivityCancelResult activityCancelResult) {
        if (!TextUtils.isEmpty(activityCancelResult.getResult().toString())) {
            ToastUtils.showMessage(SubjectActivityDetailActivity.this, activityCancelResult.getResult().toString());
            getPresenter().getSubjectActivityDetail(SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.TOKEN), activity_id, SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.MERCHANTID));
        }
    }

    @Override
    public void onCancelFailed(ActivityCancelResult activityCancelResult) {
        if (!TextUtils.isEmpty(activityCancelResult.getApp_msg())) {
            ToastUtils.showMessage(SubjectActivityDetailActivity.this, activityCancelResult.getApp_msg());
        }
    }

    @Override
    public void onCancelFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(SubjectActivityDetailActivity.this, throwable.getMessage());
        }
    }

    public void showSubjectActivityDetail(String[] strs) {
        List<?> images = new ArrayList<>();
        List list = Arrays.asList(strs);
        images = new ArrayList(list);
        banner = (Banner) findViewById(R.id.banner);
        banner.setOnBannerListener(this);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片集合
        banner.setImages(images);
        banner.start();
        //banner设置方法全部调用完毕时最后调用

    }

    @OnClick({R.id.toolbar_left_button_arl,/* R.id.tv_add_sbject,*/ R.id.tv_sign_up, R.id.toolbar_right_button_iv_arl, R.id.tv_cancel_sign_up})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                SubjectActivityDetailActivity.this.finish();
                break;
            /*case R.id.tv_add_sbject:
                //getPresenter().addSubjectToMy(SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.TOKEN), activity_id);
                break;*/
            case R.id.tv_sign_up:

                PayBottomDialog dialog = new PayBottomDialog();
                dialog.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 883 / 1920);
                dialog.setDimAmount(0.8f);
                dialog.setCancelOutside(true);
                dialog.setPictrue_url(activityDetailResult.getAct().getImage_url());
                dialog.setPay_price(price);
                dialog.setName(name);
                dialog.show(getSupportFragmentManager());
                //
                //
                dialog.setOnSignUpPayListener(this);
                break;
            case R.id.toolbar_right_button_iv_arl:
                break;
            case R.id.tv_cancel_sign_up:
                getPresenter().cancelActivity(SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.TOKEN), signUpId, SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.MERCHANTID));
                break;
        }
    }

    @Override
    public void OnBannerClick(int position) {

    }


    @Override
    public void onSignUpPay(String pwd, String pay_type) {
        //ToastUtils.showMessage(SubjectActivityDetailActivity.this,"paypwd");
        getPresenter().signUpActivity(SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.TOKEN), activity_id, pay_type, pwd, SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.MERCHANTID));
        //getPresenter().signUpSubjectActivity(SpUtil.getStringSF(SubjectActivityDetailActivity.this, Constant.TOKEN), activity_id, pay_type, pwd);
    }
}