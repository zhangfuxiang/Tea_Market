package com.delta.smt.ui.buycar.confirmOrder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.cart.CartResult;
import com.delta.smt.entity.cart.ComfirmOrderListItem;
import com.delta.smt.entity.cart.DefaultAddressResult;
import com.delta.smt.entity.cart.DefaultAddressResultBean;
import com.delta.smt.entity.cart.MyCartList;
import com.delta.smt.entity.cart.PayOrder;
import com.delta.smt.entity.cart.SubmitOrder;
import com.delta.smt.entity.cart.SubmitOrderResult;
import com.delta.smt.ui.buycar.confirmOrder.di.ConfirmOrderModule;
import com.delta.smt.ui.buycar.confirmOrder.di.DaggerConfirmOrderComponent;
import com.delta.smt.ui.buycar.confirmOrder.mvp.ConfirmOrderContract;
import com.delta.smt.ui.buycar.confirmOrder.mvp.ConfirmOrderPresenter;
import com.delta.smt.ui.buycar.myAddressList.MyAddressListActivity;
import com.delta.smt.ui.find.FindToolBar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.makeramen.roundedimageview.RoundedImageView;
import com.zhy.autolayout.AutoRelativeLayout;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/3/29.
 */

public class ConfirmOrderActivity extends BaseActivity<ConfirmOrderPresenter> implements ConfirmOrderContract.View, InputPasswordBottomDialog.OnDismissListener {

    @BindView(R.id.toolbar)
    FindToolBar toolbar;
    @BindView(R.id.btn_settle)
    TextView btnSettle;

    @BindView(R.id.rvAuctionRecord)
    RecyclerView rvAuctionRecord;
    @BindView(R.id.arl_buy_mode)
    AutoRelativeLayout autoRelativeLayout;
    @BindView(R.id.tv_buy_mode)
    TextView tvBuyMode;
    //@BindView(R.id.tv_total_amount)
    //TextView tvTotalAmount;
    //@BindView(R.id.tv_up_total_price)
    //TextView tvUpTotalPrice;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @BindView(R.id.tv_goods_receipt_person)
    TextView tvGoodsReceiptPerson;
    @BindView(R.id.tv_goods_receipt_person_phone)
    TextView tvGoodsReceiptPersonPhone;
    @BindView(R.id.tv_goods_receipt_address)
    TextView tvGoodsReceiptAddress;
    @BindView(R.id.btn_goods_receipt_address)
    AutoRelativeLayout btnGoodsReceiptAddress;
    MyCartList myCartList;
    CommonBaseAdapter<CartResult.CartBean> mAdapterSmall;
    Gson gson = new GsonBuilder().
            registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

                @Override
                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src == src.longValue())
                        return new JsonPrimitive(src.longValue());
                    return new JsonPrimitive(src);
                }
            }).create();
    String address_id = "";
    MyCartList newMyCartList;
    InputPasswordBottomDialog dialogPwd;
    /*private ArrayList<CartListResult.ResultBean.CartBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<CartListResult.ResultBean.CartBean> mAdapter;*/
    private ArrayList<MyCartList.ListBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<MyCartList.ListBean> mAdapter;

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
        //ToastUtils.showMessage(this,"确认订单");
        toolbar.setToolbarTitle("确认订单");
        toolbar.setToolbarLeftButton(R.mipmap.start_page_exit);

        mAdapter = new CommonBaseAdapter<MyCartList.ListBean>(this, dataSource) {
            @Override
            protected void convert(CommonViewHolder big_holder, final MyCartList.ListBean big_item, final int big_position) {
                big_holder.setText(R.id.tv_title_label, big_item.getMerchant_title());

                RecyclerView smallRecyclerView = big_holder.getView(R.id.smallRecyclerView);
                final List<CartResult.CartBean> smallDataSource = big_item.getCart();
                mAdapterSmall = new CommonBaseAdapter<CartResult.CartBean>(ConfirmOrderActivity.this, smallDataSource) {

                    @Override
                    protected void convert(final CommonViewHolder small_holder, final CartResult.CartBean small_item, final int small_position) {

                        small_holder.setText(R.id.tv_confirm_order_item_name, small_item.getProduct().getTitle());
                        small_holder.setText(R.id.tv_confirm_orde_item_price, "¥" + small_item.getProduct().getPrice());
                        small_holder.setText(R.id.tv_amount, "×" + small_item.getNum());
                        RoundedImageView ivv = small_holder.getView(R.id.iv_confirm_order_item_picture);
                        //ivv.setCornerRadius((float) 10);
                        //ivv.setBorderWidth((float) 0);
                        Glide.with(ConfirmOrderActivity.this).load(small_item.getProduct().getImages().get(0).getUrl()).placeholder(R.mipmap.picture).crossFade().into(ivv);

                    }

                    @Override
                    protected int getItemViewLayoutId(int position, CartResult.CartBean item) {
                        return R.layout.item_comfirm_order_list;
                    }
                };

                big_holder.setText(R.id.tv_total_amount, "共" + getCheckedAmountInOneCart(big_item) + "件商品");
                big_holder.setText(R.id.tv_up_total_price, makeOneCartTotalResult(big_item) + "");
                smallRecyclerView.setLayoutManager(new LinearLayoutManager(ConfirmOrderActivity.this));
                smallRecyclerView.setAdapter(mAdapterSmall);


            }

            @Override
            protected int getItemViewLayoutId(int position, MyCartList.ListBean item) {
                return R.layout.item_big_buy_car_list;
            }
        };
        rvAuctionRecord.setLayoutManager(new LinearLayoutManager(this));
        rvAuctionRecord.setAdapter(mAdapter);
        MyCartList myCartList = gson.fromJson(getIntent().getStringExtra("cart_list"), MyCartList.class);
        newMyCartList = new MyCartList();
        List<MyCartList.ListBean> list = myCartList.getList();
        List<MyCartList.ListBean> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            MyCartList.ListBean listBean = list.get(i);
            MyCartList.ListBean newListBean = new MyCartList.ListBean();
            List<CartResult.CartBean> newCart = new ArrayList<>();
            for (int j = 0; j < listBean.getCart().size(); j++) {
                CartResult.CartBean cartBean = listBean.getCart().get(j);
                if (cartBean.isChecked()) {
                    newCart.add(cartBean);
                }
            }
            if (newCart.size() > 0) {
                newListBean.setCart(newCart);
                newListBean.setMerchant_title(listBean.getMerchant_title());
                newListBean.setMerchant_id(listBean.getMerchant_id());
                newList.add(newListBean);
            }

        }
        newMyCartList.setList(newList);
        dataSource.clear();

        dataSource.addAll(newMyCartList.getList());
        mAdapter.notifyDataSetChanged();

        //tvTotalAmount.setText("共" + dataSource.size() + "件商品");
        //tvUpTotalPrice.setText("¥" + getIntent().getStringExtra("total_price"));
        tvTotalPrice.setText("¥" + getIntent().getStringExtra("total_price"));
        getPresenter().getDefaultAddress(SpUtil.getStringSF(ConfirmOrderActivity.this, Constant.TOKEN), SpUtil.getStringSF(ConfirmOrderActivity.this, Constant.MERCHANTID));
    }

    @Override
    protected void initData() {
        //getPresenter().getComfirmOrderList();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_confirm_order;
    }


    @Override
    public void onComfirmOrderListSuccess(ComfirmOrderListItem comfirmOrderListItem) {
        /*dataSource.clear();
        ReferList<ComfirmOrderListItem.Result> list = comfirmOrderListItem.getResult();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();*/
    }

    @Override
    public void onComfirmOrderListFailed(ComfirmOrderListItem comfirmOrderListItem) {

    }

    @Override
    public void onComfirmOrderListFailed(Throwable throwable) {

    }

    @Override

    public void onGetDefaultAddressSuccess(DefaultAddressResult defaultAddressResult) {
        DefaultAddressResultBean defaultAddressResultBean = gson.fromJson(gson.toJson(defaultAddressResult.getResult()), DefaultAddressResultBean.class);
        tvGoodsReceiptPerson.setText("收货人：" + defaultAddressResultBean.getName());
        tvGoodsReceiptPersonPhone.setText(defaultAddressResultBean.getPhone());
        tvGoodsReceiptAddress.setText("收货地址：" + defaultAddressResultBean.getProvince()
                + defaultAddressResultBean.getCity()
                + defaultAddressResultBean.getArea()
                + defaultAddressResultBean.getAddress());
        address_id = defaultAddressResultBean.getId();
    }

    @Override
    public void onGetDefaultAddressFailed(DefaultAddressResult defaultAddressResult) {
        tvGoodsReceiptPerson.setText("收货人：" + "无");
        tvGoodsReceiptPersonPhone.setText("");
        tvGoodsReceiptAddress.setText("收货地址：" + "无");
    }

    @Override
    public void onGetDefaultAddressFailed(Throwable throwable) {
        Log.i(TAG, "onGetDefaultAddressFailed: ");
    }

    @Override
    public void onSubmitOrderSuccess(final SubmitOrder submitOrder) {
        if (tvBuyMode.getText().toString().equals("余额支付")) {
            ToastUtils.showMessage(ConfirmOrderActivity.this, "已经提交订单");
            dialogPwd = new InputPasswordBottomDialog();
            dialogPwd.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 1250 / 1920);
            dialogPwd.setDimAmount(0.8f);
            dialogPwd.setCancelOutside(true);
            dialogPwd.show(getSupportFragmentManager());
            dialogPwd.setOnSignUpListener(new InputPasswordBottomDialog.OnSignUpListener() {
                @Override
                public void onSignUp(String pwd) {
                    SubmitOrderResult submitOrderResult = gson.fromJson(gson.toJson(submitOrder.getResult()), SubmitOrderResult.class);
                    String order_ids = "";
                    for (int i = 0; i < submitOrderResult.getOrder_list().size(); i++) {
                        order_ids += "," + submitOrderResult.getOrder_list().get(i).getId();
                    }
                    getPresenter().payOrder(SpUtil.getStringSF(ConfirmOrderActivity.this, Constant.TOKEN), SpUtil.getStringSF(ConfirmOrderActivity.this, Constant.MERCHANTID), order_ids.substring(1), "3", pwd);
                }
            });
            dialogPwd.setOnDismissListener(this);
            dialogPwd.setCloseListener(new InputPasswordBottomDialog.OnCloseListener() {
                @Override
                public void onClose() {
                    setResult(2);
                    ConfirmOrderActivity.this.finish();
                }
            });


        } else if (tvBuyMode.getText().toString().equals("支付宝支付")) {
            ToastUtils.showMessage(ConfirmOrderActivity.this, "已经提交订单，支付宝支付功能暂不能使用");
            ConfirmOrderActivity.this.finish();
        } else if (tvBuyMode.getText().toString().equals("微信支付")) {
            ToastUtils.showMessage(ConfirmOrderActivity.this, "已经提交订单，微信支付功能暂不能使用");
            ConfirmOrderActivity.this.finish();
        }

    }

    @Override
    public void onSubmitOrderFailed(SubmitOrder submitOrder) {
        ToastUtils.showMessage(this, submitOrder.getApp_msg());
    }

    @Override
    public void onSubmitOrderFailed(Throwable throwable) {
        ToastUtils.showMessage(this, throwable.getMessage());
    }

    @Override
    public void onPayOrderSuccess(PayOrder payOrder) {
        ToastUtils.showMessage(ConfirmOrderActivity.this, "支付成功！");
        //EventBus.getDefault().post("支付成功");
        setResult(1);
        ConfirmOrderActivity.this.finish();
    }

    @Override
    public void onPayOrderFailed(PayOrder payOrder) {
        if (!TextUtils.isEmpty(payOrder.getApp_msg())) {
            ToastUtils.showMessage(ConfirmOrderActivity.this, payOrder.getApp_msg());
            //EventBus.getDefault().post("其他");
            setResult(2);
            ConfirmOrderActivity.this.finish();
        }
    }

    @Override
    public void onPayOrderFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(ConfirmOrderActivity.this, throwable.getMessage());
            //EventBus.getDefault().post("其他");
            setResult(2);
            ConfirmOrderActivity.this.finish();
        }
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.btn_settle, R.id.arl_buy_mode, R.id.btn_goods_receipt_address})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                this.finish();
                break;
            case R.id.btn_settle:
                if (tvBuyMode.getText().toString().equals("支付宝支付")) {
                    ToastUtils.showMessage(ConfirmOrderActivity.this, "暂不支持支付宝支付");
                    return;
                }
                if (tvBuyMode.getText().toString().equals("微信支付")) {
                    ToastUtils.showMessage(ConfirmOrderActivity.this, "暂不支持微信支付");
                    return;
                }
                //确认提交
                if (TextUtils.isEmpty(address_id)) {
                    ToastUtils.showMessage(ConfirmOrderActivity.this, "地址不能为空");
                    return;
                }
                String url = "/api/order/submit?token=" + SpUtil.getStringSF(ConfirmOrderActivity.this, Constant.TOKEN);
                url = url + "&merchant_id=" + SpUtil.getStringSF(ConfirmOrderActivity.this, Constant.MERCHANTID);
                url = url + "&address_id=" + address_id;

                for (int i = 0; i < newMyCartList.getList().size(); i++) {
                    MyCartList.ListBean listBean = newMyCartList.getList().get(i);
                    for (int j = 0; j < listBean.getCart().size(); j++) {
                        url = url + "&products%5Bid%5D%5B%5D=" + listBean.getCart().get(j).getProduct_id() + "";
                        url = url + "&products%5Bnum%5D%5B%5D=" + listBean.getCart().get(j).getNum();
                    }
                }

                getPresenter().submitOrder(url);
                break;
            case R.id.arl_buy_mode:
                PayMethodBottomDialog dialog = new PayMethodBottomDialog();
                dialog.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 570 / 1920);
                dialog.setDimAmount(0.8f);
                dialog.setCancelOutside(true);
                dialog.show(getSupportFragmentManager());
                dialog.setOnBottomDialogMethodListener(new PayMethodBottomDialog.OnBottomDialogMethodListener() {
                    @Override
                    public void onMethodOK(String method) {
                        tvBuyMode.setText(method);
                    }
                });
                break;
            case R.id.btn_goods_receipt_address:
                Intent intent = new Intent(ConfirmOrderActivity.this, MyAddressListActivity.class);
                startActivityForResult(intent, 12);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 12) {
            if (resultCode == 21) {
                Bundle bundle = data.getExtras();
                address_id = bundle.getString("address_id");
                String name = bundle.getString("name");
                String address = bundle.getString("address");
                String phone = bundle.getString("phone");
                String province = bundle.getString("province");
                String city = bundle.getString("city");
                String area = bundle.getString("area");
                tvGoodsReceiptPerson.setText("收货人：" + name);
                tvGoodsReceiptPersonPhone.setText(phone);
                tvGoodsReceiptAddress.setText("收货地址：" + province
                        + city
                        + area
                        + address);
            }
        }
    }

    //一个店铺下商品的数量
    public int getCheckedAmountInOneCart(MyCartList.ListBean listBean) {
        int amount = 0;
        List<CartResult.CartBean> cartBeanList = listBean.getCart();
        for (int j = 0; j < cartBeanList.size(); j++) {
            amount += 1;
        }
        return amount;
    }

    //一个店铺下商品总价
    public String makeOneCartTotalResult(MyCartList.ListBean listBean) {
        String res = "0.00";
        double d = 0;
        List<CartResult.CartBean> cartBeanList = listBean.getCart();
        for (int j = 0; j < cartBeanList.size(); j++) {
            d += Integer.parseInt(cartBeanList.get(j).getNum()) * Double.parseDouble(cartBeanList.get(j).getProduct().getPrice());
        }
        res = new java.text.DecimalFormat("#.00").format(d);
        if (res.startsWith(".")) {
            res = "0" + res;
        }
        return res;
    }

    @Override
    public void onDismiss() {
        //EventBus.getDefault().post("其他");
        //ConfirmOrderActivity.this.finish();
        setResult(2);
        ConfirmOrderActivity.this.finish();

    }
}