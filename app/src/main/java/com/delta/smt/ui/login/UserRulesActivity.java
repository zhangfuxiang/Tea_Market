package com.delta.smt.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.delta.smt.R;
import com.delta.smt.ui.find.FindToolBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shufeng.Wu on 2017/4/26.
 */

public class UserRulesActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    FindToolBar toolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_rules);
        ButterKnife.bind(this);
        toolBar.setToolbarTitle("用户服务协议");
        toolBar.setToolbarLeftButton(R.mipmap.ic_back);
    }

    @OnClick({R.id.toolbar_left_button_arl})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                UserRulesActivity.this.finish();
                break;
        }
    }
}
