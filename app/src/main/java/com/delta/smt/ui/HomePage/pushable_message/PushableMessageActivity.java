package com.delta.smt.ui.HomePage.pushable_message;

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
import com.delta.smt.entity.Order;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Shaoqiang.Zhang on 2017/4/5.
 */

public class PushableMessageActivity extends BaseActivity implements CommonBaseAdapter.OnItemClickListener<Order>{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.push_able_message_rv)
    RecyclerView push_able_message_rv;
    private List<Order> list = new ArrayList<>();
    private CommonBaseAdapter<Order> adapter;

    @OnClick(R.id.toolbar_left_button)
    void back() {
        finish();
    }

    @Override
    protected void initView() {

        toolbarTitle.setText("可推送消息(4)");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        list.clear();
        for (int i = 0; i < 4; i++) {
            list.add(new Order());
        }

        adapter=new CommonBaseAdapter<Order>(this,list) {
            @Override
            protected void convert(CommonViewHolder holder, Order item, int position) {

            }

            @Override
            protected int getItemViewLayoutId(int position, Order item) {
                return R.layout.item_pushable_message;
            }
        };

        adapter.setOnItemClickListener(this);
        push_able_message_rv.setLayoutManager(new LinearLayoutManager(this));
        push_able_message_rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_pushable_message;
    }

    @Override
    public void onItemClick(View view, Order item, int position) {

    }
}
