package com.delta.smt.ui.find.myGivePrice;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.MyGivePriceResult;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.myGivePrice.di.DaggerMyGivePriceComponent;
import com.delta.smt.ui.find.myGivePrice.di.MyGivePriceModule;
import com.delta.smt.ui.find.myGivePrice.mvp.MyGivePriceContract;
import com.delta.smt.ui.find.myGivePrice.mvp.MyGivePricePresenter;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/3/21.
 */

public class MyGivePriceActivity extends BaseActivity<MyGivePricePresenter> implements MyGivePriceContract.View {

    @BindView(R.id.toolbar)
    FindToolBar toolbar;
    /*@BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;*/
    @BindView(R.id.et_my_price)
    EditText etMyPrice;
    @BindView(R.id.iv_delete_my_price)
    ImageView ivDeleteMyPrice;
    @BindView(R.id.iv_tea_picture)
    RoundedImageView ivTeaPicture;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerMyGivePriceComponent.builder()
                .appComponent(appComponent)
                .myGivePriceModule(new MyGivePriceModule(this)) //请将MyGivePriceModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        ivTeaPicture.setCornerRadius((float) 10);
        ivTeaPicture.setBorderWidth((float) 0);
        toolbar.setToolbarRightButton("出价");
        toolbar.setToolbarTitle("我要出价");
        toolbar.setToolbarLeftButton(R.mipmap.start_page_exit);
        Glide.with(MyGivePriceActivity.this).load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg").crossFade().into(ivTeaPicture);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_give_price;
    }


    @Override
    public void onGivePriceSuccess(MyGivePriceResult myGivePriceResult) {
        MyGivePriceActivity.this.finish();
    }

    @Override
    public void onGivePriceFailed(MyGivePriceResult myGivePriceResult) {

    }

    @Override
    public void onGivePriceFailed(Throwable throwable) {

    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button, R.id.iv_delete_my_price})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                MyGivePriceActivity.this.finish();
                break;
            case R.id.toolbar_right_button:
                String my_price = etMyPrice.getText().toString();
                if (!TextUtils.isEmpty(my_price)) {
                    getPresenter().getGivePriceResult(my_price);
                } else {
                    ToastUtils.showMessage(MyGivePriceActivity.this, "出价不能为空！");
                }

                break;
            case R.id.iv_delete_my_price:
                etMyPrice.setText("");
                break;
        }
    }
}