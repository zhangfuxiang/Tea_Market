package com.delta.smt.ui.Personal.my_order.no_payment.order_detail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ItemMyorderIn;
import com.delta.smt.entity.ItemOrderDetail;
import com.delta.smt.entity.cart.SubmitOrderResult;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.change_payway.ChangePayWayDialog;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.di.DaggerOrderDetailComponent;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.di.OrderDetailModule;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.mvp.OrderDetailContract;
import com.delta.smt.ui.Personal.my_order.no_payment.order_detail.mvp.OrderDetailPresenter;
import com.delta.smt.ui.buycar.confirmOrder.ConfirmOrderActivity;
import com.delta.smt.ui.buycar.confirmOrder.InputPasswordBottomDialog;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.utils.MapUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.http.QueryMap;

import static com.delta.smt.base.BaseApplication.getContext;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter> implements OrderDetailContract.View {


    @BindView(R.id.toolbar_left_button)
    ImageView mToolbarLeftButton;
    @BindView(R.id.tv_left_button_name)
    TextView mTvLeftButtonName;
    @BindView(R.id.toolbar_left_button_arl)
    AutoRelativeLayout mToolbarLeftButtonArl;
    @BindView(R.id.toolbarTitle)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar_right_button)
    TextView mToolbarRightButton;
    @BindView(R.id.toolbar_right_button_iv)
    ImageView mToolbarRightButtonIv;
    @BindView(R.id.toolbar_right_button_iv_arl)
    AutoRelativeLayout mToolbarRightButtonIvArl;
    @BindView(R.id.toolbar)
    FindToolBar mToolbar;
    @BindView(R.id.iv_adress)
    ImageView mIvAdress;
    @BindView(R.id.tv_receiver)
    TextView mTvReceiver;
    @BindView(R.id.tv_telephone)
    TextView mTvTelephone;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.tv_shop_name)
    TextView mTvShopName;
    @BindView(R.id.tv1)
    TextView mTv1;
    @BindView(R.id.tv_all_goods_price)
    TextView mTvAllGoodsPrice;
    @BindView(R.id.tv2)
    TextView mTv2;
    @BindView(R.id.tv_send_price)
    TextView mTvSendPrice;
    @BindView(R.id.tv3)
    TextView mTv3;
    @BindView(R.id.tv_count_price)
    TextView mTvCountPrice;
    @BindView(R.id.tv4)
    TextView mTv4;
    @BindView(R.id.tv_pay_way)
    TextView mTvPayWay;
    @BindView(R.id.tv_order_num)
    TextView mTvOrderNum;
    @BindView(R.id.tv_down_time)
    TextView mTvDownTime;
    @BindView(R.id.tv_pay_time)
    TextView mTvPayTime;
    @BindView(R.id.tv_left_button)
    TextView mTvLeftButton;
    @BindView(R.id.tv_right_button)
    TextView mTvRightButton;
    @BindView(R.id.ry_item)
    RecyclerView mRyItem;

    private String id;
    private String token;
    private Map<String,String> queryMap;

    private ItemOrderDetail.ResultBean mItemOrderDetail=new ItemOrderDetail.ResultBean();
    private List<ItemOrderDetail.ResultBean.OrderProductBean> datas_in = new ArrayList<>();
    private CommonBaseAdapter<ItemOrderDetail.ResultBean.OrderProductBean> mAdapter_in;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerOrderDetailComponent.builder()
                .appComponent(appComponent)
                .orderDetailModule(new OrderDetailModule(this)) //请将OrderDetailModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initData() {

        token= SpUtil.getStringSF(getContext(), Constant.TOKEN);;
        Bundle bundle=getIntent().getExtras();
        id=bundle.getString("order_id");
        Log.e(TAG, "initData: "+id );
        getPresenter().getOrderDetail(token,id);


    }

    @Override
    protected void initView() {


        mToolbarTitle.setText("订单详情");
        mToolbarRightButton.setVisibility(View.INVISIBLE);
        mToolbarLeftButton.setImageResource(R.mipmap.ic_back);


        mAdapter_in = new CommonBaseAdapter<ItemOrderDetail.ResultBean.OrderProductBean>(getContext(), datas_in) {
            @Override
            protected void convert(CommonViewHolder holder, ItemOrderDetail.ResultBean.OrderProductBean item, int position) {
//                holder.setText(R.id.tv_name,item.getName());
                holder.setText(R.id.tv_price,"￥ "+item.getPrice());
                holder.setText(R.id.tv_num,"X "+item.getNum());
                holder.setText(R.id.tv_name,item.getProduct().getTitle());
                ImageView image=holder.getView(R.id.iv_image);
                Glide.with(getContext()).load(item.getProduct().getImages().get(0).getUrl()).into(image);
            }

            @Override
            protected int getItemViewLayoutId(int position, ItemOrderDetail.ResultBean.OrderProductBean item) {
                return R.layout.item_order_detail;
            }
        };

        mRyItem.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRyItem.setAdapter(mAdapter_in);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_order_detail;
    }




    @OnClick({R.id.toolbar_left_button_arl, R.id.tv_left_button, R.id.tv_right_button,R.id.ll_pay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
            case R.id.tv_left_button:
                getPresenter().cancelOrder(token,id);
                break;
            case R.id.tv_right_button:
                if (mTvPayWay.getText().toString().equals("余额支付")) {
                    InputPasswordBottomDialog dialog = new InputPasswordBottomDialog();
                    dialog.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 1250 / 1920);
                    dialog.setDimAmount(0.8f);
                    dialog.setCancelOutside(true);
                    dialog.show(getSupportFragmentManager());
                    dialog.setOnSignUpListener(new InputPasswordBottomDialog.OnSignUpListener() {
                        @Override
                        public void onSignUp(String pwd) {
                            queryMap = MapUtils.CreateQueryMap(getContext());
                            queryMap.put("order_ids", id);
                            queryMap.put("pay_type", "3");
                            queryMap.put("pay_pwd", pwd);
                            getPresenter().payOrder(queryMap);
                        }
                    });
                    dialog.setOnDismissListener(new InputPasswordBottomDialog.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                        }
                    });
                }else if (mTvPayWay.getText().toString().equals("支付宝支付")){
                    showMessage("支付宝支付功能暂不能使用");
                }else if (mTvPayWay.getText().toString().equals("微信支付")){
                    showMessage("微信支付功能暂不能使用");
                }
                break;
            case  R.id.ll_pay:
                final ChangePayWayDialog mDialog = new ChangePayWayDialog(getWindowManager().getDefaultDisplay().getHeight() * 545 / 1920, 0.8f, true);
                mDialog.show(getSupportFragmentManager());
                mDialog.setOnBottomDialogDimissListener(new ChangePayWayDialog.OnBottomDialogDimissListener() {

                    @Override
                    public void onDismiss(String content) {

                        mTvPayWay.setText(content);
                    }
                });
                break;

        }
    }

    @Override
    public void showMessage(String message) {
        ToastUtils.showMessage(this,message);
    }

    @Override
    public void getOrderDetail(ItemOrderDetail.ResultBean mItemOrderDetail) {

        mTvReceiver.setText("收件人："+mItemOrderDetail.getDelivery_name());
        mTvTelephone.setText("电话："+mItemOrderDetail.getDelivery_phone());
        mTvAddress.setText("收货地址："+mItemOrderDetail.getDelivery_address());
        mTvShopName.setText(mItemOrderDetail.getMerchant_title());
        mTvAllGoodsPrice.setText("￥"+String.valueOf(mItemOrderDetail.getProduct_total_money()));
        mTvSendPrice.setText("+￥"+mItemOrderDetail.getDeliver_fee());
        mTvCountPrice.setText("￥"+mItemOrderDetail.getOrder_money());
        mTvOrderNum.setText("订单号："+mItemOrderDetail.getOrder_no());
        mTvDownTime.setText("下单时间："+mItemOrderDetail.getCreate_time());
        mTvPayTime.setText("付款时间：");


        datas_in.clear();

        datas_in.addAll(mItemOrderDetail.getOrder_product());

        mAdapter_in.notifyDataSetChanged();
    }

    @Override
    public void cancelOrder(String message) {
        showMessage(message);
        finish();

    }

    @Override
    public void payOrder(String message) {
        showMessage(message);
        finish();
    }
}