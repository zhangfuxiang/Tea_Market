package com.delta.smt.ui.find.priceRecord;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.AuctionDetailRecordItem;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.priceRecord.di.DaggerPriceRecordComponent;
import com.delta.smt.ui.find.priceRecord.di.PriceRecordModule;
import com.delta.smt.ui.find.priceRecord.mvp.PriceRecordContract;
import com.delta.smt.ui.find.priceRecord.mvp.PriceRecordPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Shufeng.Wu on 2017/3/21.
 */

public class PriceRecordActivity extends BaseActivity<PriceRecordPresenter> implements PriceRecordContract.View {

    @BindView(R.id.toolbar)
    FindToolBar toolbar;

    @BindView(R.id.rvAuctionRecord)
    RecyclerView rvAuctionRecord;

    private List<AuctionDetailRecordItem.ResultBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<AuctionDetailRecordItem.ResultBean> mAdapter;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerPriceRecordComponent.builder()
                .appComponent(appComponent)
                .priceRecordModule(new PriceRecordModule(this)) //请将PriceRecordModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolbar.setToolbarTitle("出价信息");
        toolbar.setToolbarLeftButton(R.mipmap.ic_back);
        toolbar.setTvLeftButtonName("拍品详情");

        mAdapter = new CommonBaseAdapter<AuctionDetailRecordItem.ResultBean>(this, dataSource) {
            @Override
            protected void convert(CommonViewHolder holder, AuctionDetailRecordItem.ResultBean item, int position) {
                TextView tv = holder.getView(R.id.tv_auction_price);
                if (position == 0) {
                    tv.setTextColor(Color.rgb(255, 96, 0));
                } else {
                    tv.setTextColor(Color.rgb(153, 153, 153));
                }
                holder.setText(R.id.tv_auction_price_time, item.getPrice_time());
                holder.setText(R.id.tv_auction_price, item.getPrice());
                holder.setText(R.id.tv_auction_person_name, item.getPerson_name());


                ImageView iv = holder.getView(R.id.iv_auction_head_image);
                //ToastUtils.showMessage(PriceRecordActivity.this, dataSource.get(position).getHead_image() + "");
                Glide.with(PriceRecordActivity.this).load(dataSource.get(position).getHead_image()).crossFade().into(iv);
            }

            @Override
            protected int getItemViewLayoutId(int position, AuctionDetailRecordItem.ResultBean item) {
                return R.layout.item_auction_record;
            }
        };
        rvAuctionRecord.setLayoutManager(new LinearLayoutManager(this));
        rvAuctionRecord.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        getPresenter().getPriceRecordList();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_price_record;
    }

    @Override
    public void onPriceRecordSuccess(AuctionDetailRecordItem item) {
        dataSource.clear();
        List<AuctionDetailRecordItem.ResultBean> list = item.getResult();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPriceRecordFailed(AuctionDetailRecordItem item) {

    }

    @Override
    public void onPriceRecordFailed(Throwable throwable) {

    }

    @OnClick(R.id.toolbar_left_button_arl)
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                PriceRecordActivity.this.finish();
                break;
        }
    }
}