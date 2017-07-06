package com.delta.smt.ui.find.confirmOrder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ComfirmOrderListItem;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.confirmOrder.di.ConfirmOrderModule;
import com.delta.smt.ui.find.confirmOrder.di.DaggerConfirmOrderComponent;
import com.delta.smt.ui.find.confirmOrder.mvp.ConfirmOrderContract;
import com.delta.smt.ui.find.confirmOrder.mvp.ConfirmOrderPresenter;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/3/29.
 */

public class ConfirmOrderActivity extends BaseActivity<ConfirmOrderPresenter> implements ConfirmOrderContract.View {

    @BindView(R.id.toolbar)
    FindToolBar toolbar;
    @BindView(R.id.btn_settle)
    TextView btnSettle;

    @BindView(R.id.rvAuctionRecord)
    RecyclerView rvAuctionRecord;

    private List<ComfirmOrderListItem.Result> dataSource = new ArrayList<>();
    private CommonBaseAdapter<ComfirmOrderListItem.Result> mAdapter;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerConfirmOrderComponent.builder()
                .appComponent(appComponent)
                .confirmOrderModule(new ConfirmOrderModule(this)) //请将ConfirmOrderModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolbar.setToolbarTitle("确认订单");
        toolbar.setToolbarLeftButton(R.mipmap.start_page_exit);
        mAdapter = new CommonBaseAdapter<ComfirmOrderListItem.Result>(this, dataSource) {
            @Override
            protected void convert(CommonViewHolder holder, ComfirmOrderListItem.Result item, int position) {
                holder.setText(R.id.tv_confirm_order_item_name,item.getName());
                holder.setText(R.id.tv_confirm_orde_item_price,"¥"+item.getPrice());
                holder.setText(R.id.tv_amount,"×"+item.getAmount());
                RoundedImageView ivv = holder.getView(R.id.iv_confirm_order_item_picture);
                ivv.setCornerRadius((float) 10);
                ivv.setBorderWidth((float) 0);
                Glide.with(ConfirmOrderActivity.this).load(dataSource.get(position).getUrl()).crossFade().into(ivv);
            }

            @Override
            protected int getItemViewLayoutId(int position, ComfirmOrderListItem.Result item) {
                return R.layout.item_comfirm_order_list;
            }
        };
        rvAuctionRecord.setLayoutManager(new LinearLayoutManager(this));
        rvAuctionRecord.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        getPresenter().getComfirmOrderList();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_confirm_order;
    }


    @Override
    public void onComfirmOrderListSuccess(ComfirmOrderListItem comfirmOrderListItem) {
        dataSource.clear();
        List<ComfirmOrderListItem.Result> list = comfirmOrderListItem.getResult();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onComfirmOrderListFailed(ComfirmOrderListItem comfirmOrderListItem) {

    }

    @Override
    public void onComfirmOrderListFailed(Throwable throwable) {

    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.btn_settle})
    void onClick(View v){
        switch (v.getId()){
            case R.id.toolbar_left_button_arl:
                this.finish();
                break;
            case R.id.btn_settle:
                PayMethodBottomDialog dialog = new PayMethodBottomDialog(getWindowManager().getDefaultDisplay().getHeight() * 570 / 1920, 0.8f, true);
                dialog.show(getSupportFragmentManager());
                break;
        }
    }
}