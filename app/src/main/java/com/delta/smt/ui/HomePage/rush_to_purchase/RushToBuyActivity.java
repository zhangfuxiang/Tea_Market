package com.delta.smt.ui.HomePage.rush_to_purchase;

import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.IntentUtils;
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
 * Created by Shaoqiang.Zhang on 2017/4/21.
 */

public class RushToBuyActivity extends BaseActivity implements CommonBaseAdapter.OnItemClickListener<Order>{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;

    @OnClick(R.id.toolbar_left_button)
    void back() {
        finish();
    }

    @BindView(R.id.rush_buy_rv)
    RecyclerView rush_buy_rv;

    private List<Order> list=new ArrayList<>();
    private CommonBaseAdapter<Order> adapter;

    @Override
    protected void initView() {

        toolbarTitle.setText("秒杀抢购");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        for(int i=0;i<5;i++){
            list.add(new Order());
        }

        adapter=new CommonBaseAdapter<Order>(this,list) {
            @Override
            protected void convert(CommonViewHolder holder, Order item, int position) {

                TextView price=holder.getView(R.id.sale_price_tv);
                price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);//中间横线
            }

            @Override
            protected int getItemViewLayoutId(int position, Order item) {
                return R.layout.item_rush_purchase;
            }

        };

        adapter.setOnItemClickListener(this);
        rush_buy_rv.setLayoutManager(new LinearLayoutManager(this));
        rush_buy_rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_rush_purchase;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    public void onItemClick(View view, Order item, int position) {

        IntentUtils.showIntent(this,RushToBuyDetailActivity.class);

    }
}
