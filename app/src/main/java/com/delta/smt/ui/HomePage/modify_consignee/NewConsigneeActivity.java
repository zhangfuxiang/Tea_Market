package com.delta.smt.ui.HomePage.modify_consignee;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Shaoqiang.Zhang on 2017/3/29.
 */

public class NewConsigneeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.choose_adress)
    TextView choose_adress;

    @OnClick(R.id.toolbar_left_button)
    void back() {
        finish();
    }

    @OnClick(R.id.choose_adress)
    void choose() {

        Intent i = new Intent();
        i.setClass(this, AddessPickerActivity.class);
        startActivityForResult(i, 1);

    }

    @Override
    protected void initView() {

        toolbarTitle.setText("修改收货人信息");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_close2);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data!=null) {
            choose_adress.setText(data.getStringExtra("address"));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_new_consignee;
    }
}
