package com.delta.smt.ui.HomePage.more.sys_pub;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Shaoqiang.Zhang on 2017/5/9.
 */

public class SystemPublicActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;

    @OnClick(R.id.toolbar_left_button_arl)
    void back() {
        finish();
    }

    @BindView(R.id.appointment_rv)
    RecyclerView appointment_rv;

    private CommonBaseAdapter<MyMessage> adapter;
    List<MyMessage> sysPubList=new ArrayList<>();

    @Override
    protected void initView() {

        toolbarTitle.setText("系统通告");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        sysPubList=getIntent().getParcelableArrayListExtra("message");

        adapter = new CommonBaseAdapter<MyMessage>(this, sysPubList) {
            @Override
            protected void convert(CommonViewHolder holder, final MyMessage item, int position) {

                holder.setText(R.id.time_tv,item.getTime());
                holder.setText(R.id.title_tv,item.getTitle());

            }

            @Override
            protected int getItemViewLayoutId(int position, MyMessage item) {
                return R.layout.item_system_pub;
            }
        };

        appointment_rv.setLayoutManager(new LinearLayoutManager(this));
        appointment_rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_system_pub;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }
}
