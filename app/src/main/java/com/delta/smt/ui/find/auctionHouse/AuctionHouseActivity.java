package com.delta.smt.ui.find.auctionHouse;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.AuctionHouseListItem;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.auctionHouse.di.AuctionHouseModule;
import com.delta.smt.ui.find.auctionHouse.di.DaggerAuctionHouseComponent;
import com.delta.smt.ui.find.auctionHouse.mvp.AuctionHouseContract;
import com.delta.smt.ui.find.auctionHouse.mvp.AuctionHousePresenter;
import com.delta.smt.ui.find.auctionHouseDetail.AuctionHouseDetailActivity;
import com.delta.smt.ui.find.collectionInfo.UploadCollectionInfoActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.iwgang.countdownview.CountdownView;


/**
 * Created by wushufeng on 2017/3/18.
 */

public class AuctionHouseActivity extends BaseActivity<AuctionHousePresenter> implements AuctionHouseContract.View, CommonBaseAdapter.OnItemClickListener, View.OnClickListener {

    @BindView(R.id.rvAuctionList)
    RecyclerView rvAuctionList;
    /*@BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_left_button_arl)
    AutoRelativeLayout toolbarLeftButtonArl;*/
    @BindView(R.id.toolbar)
    FindToolBar toolBar;

    private List<AuctionHouseListItem.ResultBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<AuctionHouseListItem.ResultBean> mAdapter;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerAuctionHouseComponent.builder()
                .appComponent(appComponent)
                .auctionHouseModule(new AuctionHouseModule(this)) //请将AuctionHouseModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolBar.setToolbarTitle("拍卖行");
        toolBar.setToolbarLeftButton(R.mipmap.ic_back);
        toolBar.setToolbarRightButton("我有藏品想拍卖");
        toolBar.setTvLeftButtonName("发现");
        toolBar.setToolbarLeftButtonOnClickListener(this);
        toolBar.setToolbarRightButtonOnClickListener(this);
        mAdapter = new CommonBaseAdapter<AuctionHouseListItem.ResultBean>(this, dataSource) {
            @Override
            protected void convert(CommonViewHolder holder, AuctionHouseListItem.ResultBean item, int position) {
                holder.setText(R.id.tv_show_tea_name, item.getTea_name());
                Log.i(TAG, "convert: " + item.getTea_name());
                long t1 = 0;
                try {
                    t1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(item.getEnd_time()).getTime();
                    Log.i(TAG, "convert: " + t1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long t2 = System.currentTimeMillis();
                Log.i(TAG, "convert: " + t2);
                CountdownView mCvCountdownView = holder.getView(R.id.countdownView);
                mCvCountdownView.start(t1 - t2);
                holder.setText(R.id.tv_showNowPrice, "当前价：" + item.getNow_price());
                holder.setText(R.id.tv_showShowPriceTimes, "出价" + item.getShow_price_times());
                ImageView iv = holder.getView(R.id.iv_auction_product);
                Glide.with(AuctionHouseActivity.this).load(dataSource.get(position).getPicture_url()).crossFade().into(iv);
            }

            @Override
            protected int getItemViewLayoutId(int position, AuctionHouseListItem.ResultBean item) {
                if(position%2==0){
                    return R.layout.item_auction_house_list_left;
                }else {
                    return R.layout.item_auction_house_list_right;
                }

            }
        };
        mAdapter.setOnItemClickListener(this);
        rvAuctionList.setLayoutManager(new GridLayoutManager(this, 2));
        rvAuctionList.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        getPresenter().getAuctionList();
        Log.i(TAG, "initData: ");
    }

    /*@OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                this.finish();
                break;
            case R.id.toolbar_right_button:
                IntentUtils.showIntent(AuctionHouseActivity.this, UploadCollectionInfoActivity.class);
                break;
        }
    }*/


    @Override
    public void onAuctionListSuccess(AuctionHouseListItem item) {
        dataSource.clear();
        List<AuctionHouseListItem.ResultBean> list = item.getResult();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAuctionListfailed(AuctionHouseListItem item) {

    }

    @Override
    public void onAuctionListfailed(Throwable throwable) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_auction_list_page;
    }


    @Override
    public void onItemClick(View view, Object item, int position) {
        IntentUtils.showIntent(AuctionHouseActivity.this, AuctionHouseDetailActivity.class);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.toolbar_left_button_arl) {
            this.finish();
        } else if (v.getId() == R.id.toolbar_right_button) {
            IntentUtils.showIntent(AuctionHouseActivity.this, UploadCollectionInfoActivity.class);
        }
    }
}