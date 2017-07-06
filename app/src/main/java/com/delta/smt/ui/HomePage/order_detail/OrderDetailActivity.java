package com.delta.smt.ui.HomePage.order_detail;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.Order;
import com.delta.smt.ui.HomePage.BottomPopupOption;
import com.delta.smt.ui.HomePage.modify_consignee.ModifyConsigneeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Shaoqiang.Zhang on 2017/3/28.
 */

public class OrderDetailActivity extends BaseActivity implements CommonBaseAdapter.OnItemClickListener<Order>,BottomPopupOption.onPopupWindowItemClickListener{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    BottomPopupOption bottomPopupOption;
    @BindView(R.id.order_detail_rv)
    RecyclerView order_detail_rv;
    private List<Order> list = new ArrayList<>();
    private CommonBaseAdapter<Order> adapter;

    @OnClick(R.id.toolbar_left_button)
    void back() {
        finish();
    }

    @OnClick(R.id.confrim_push)
    void confirm(){
        bottomPopupOption = new BottomPopupOption(this);
        bottomPopupOption.setItemText("收货人信息为当前信息","修改收货人信息");
        bottomPopupOption.setItemClickListener(this);
        bottomPopupOption.showPopupWindow(R.id.layout_popup_add, R.layout.popwindow_order_detail_item);
    }

    @Override
    protected void initView() {

        toolbarTitle.setText("订单详情");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        list.clear();
        for (int i = 0; i < 6; i++) {
            list.add(new Order());
        }

        adapter=new CommonBaseAdapter<Order>(this,list) {
            @Override
            protected void convert(CommonViewHolder holder, Order item, int position) {

            }

            @Override
            protected int getItemViewLayoutId(int position, Order item) {
                return R.layout.item_order_detail;
            }
        };

        adapter.setOnItemClickListener(this);
        order_detail_rv.setLayoutManager(new LinearLayoutManager(this));
        order_detail_rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void onItemClick(View view, Order item, int position) {

    }

    @Override
    public void onItemClick(int position) {

        ToastUtils.showMessage(this,position);
        if (position==1){

            Intent i=new Intent();
            i.setClass(this, ModifyConsigneeActivity.class);
            startActivity(i);
            bottomPopupOption.dismiss();

        }

    }
}
