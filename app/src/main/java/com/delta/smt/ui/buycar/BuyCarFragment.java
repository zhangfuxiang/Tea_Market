package com.delta.smt.ui.buycar;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.MainActivity;
import com.delta.smt.R;
import com.delta.smt.base.BaseFragment;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.cart.Cart;
import com.delta.smt.entity.cart.CartRemoveResult;
import com.delta.smt.entity.cart.CartResult;
import com.delta.smt.entity.cart.MyCartList;
import com.delta.smt.entity.cart.SetCartAmountResult;
import com.delta.smt.ui.Personal.my_order.MyOrderActivity;
import com.delta.smt.ui.buycar.buycar.di.BuyCarModule;
import com.delta.smt.ui.buycar.buycar.di.DaggerBuyCarComponent;
import com.delta.smt.ui.buycar.buycar.mvp.BuyCarContract;
import com.delta.smt.ui.buycar.buycar.mvp.BuyCarPresenter;
import com.delta.smt.ui.buycar.confirmOrder.ConfirmOrderActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.makeramen.roundedimageview.RoundedImageView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/4/23.
 */

public class BuyCarFragment extends BaseFragment<BuyCarPresenter> implements BuyCarContract.View {

    public static final String TAG = "BuyCarFragment";
    @BindView(R.id.bigRecyclerView)
    RecyclerView bigRecyclerView;
    @BindView(R.id.btn_settle)
    TextView btnSettle;
    @BindView(R.id.cb_all_check)
    CheckBox cbAllCheck;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;
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
    private Toast mToast;
    private ArrayList<MyCartList.ListBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<MyCartList.ListBean> mAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ((MainActivity) getActivity()).buyCarToolBar.setToolbarTitle("购物车(0)");

        mAdapter = new CommonBaseAdapter<MyCartList.ListBean>(getActivity(), dataSource) {
            @Override
            protected void convert(CommonViewHolder big_holder, final MyCartList.ListBean big_item, final int big_position) {
                big_holder.setText(R.id.tv_title_label, big_item.getMerchant_title());

                RecyclerView smallRecyclerView = big_holder.getView(R.id.smallRecyclerView);
                final List<CartResult.CartBean> smallDataSource = big_item.getCart();
                mAdapterSmall = new CommonBaseAdapter<CartResult.CartBean>(getActivity(), smallDataSource) {

                    @Override
                    protected void convert(final CommonViewHolder small_holder, final CartResult.CartBean small_item, final int small_position) {
                        small_holder.setText(R.id.tv_buy_car_item_name, small_item.getProduct().getTitle());
                        small_holder.setText(R.id.tv_buy_car_item_price, small_item.getProduct().getPrice());
                        small_holder.setText(R.id.et_buy_car_item_amount, small_item.getNum());
                        RoundedImageView ivv = small_holder.getView(R.id.iv_buy_car_item_picture);
                        //ivv.setCornerRadius((float) 10);
                        //ivv.setBorderWidth((float) 0);
                        Glide.with(getActivity()).load(small_item.getProduct().getImages().get(0).getUrl()).placeholder(R.mipmap.picture).crossFade().into(ivv);
                        CheckBox cbCheck = small_holder.getView(R.id.cb_check);
                        if (small_item.isChecked()) {
                            cbCheck.setChecked(true);
                        } else {
                            cbCheck.setChecked(false);
                        }
                        ((MainActivity) getActivity()).buyCarToolBar.setToolbarTitle("购物车(" + getCheckedItemAmount() + ")");

                        //用来选中商品的checkbox
                        cbCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (isChecked) {
                                    CartResult.CartBean cartBean = smallDataSource.get(small_position);
                                    cartBean.setChecked(true);
                                    smallDataSource.set(small_position, cartBean);
                                    MyCartList.ListBean listBean = dataSource.get(big_position);
                                    dataSource.set(big_position, listBean);
                                    myCartList.setList(dataSource);
                                } else {
                                    CartResult.CartBean cartBean = smallDataSource.get(small_position);
                                    cartBean.setChecked(false);
                                    smallDataSource.set(small_position, cartBean);
                                    MyCartList.ListBean listBean = dataSource.get(big_position);
                                    dataSource.set(big_position, listBean);
                                    myCartList.setList(dataSource);
                                }

                                ((MainActivity) getActivity()).buyCarToolBar.setToolbarTitle("购物车(" + getCheckedItemAmount() + ")");
                                if (getCheckedItemAmount() < getTotalAmount()) {
                                    cbAllCheck.setChecked(false);
                                } else {
                                    cbAllCheck.setChecked(true);
                                }
                                updateBtnSettle();
                                tvTotalPrice.setText("¥" + makeTotalResult());
                                //刷新列表
                                mAdapter.notifyDataSetChanged();


                            }
                        });

                        ImageView btnReduceBuyCarItemAmount = small_holder.getView(R.id.btn_reduce_buy_car_item_amount);
                        ImageView btnAddBuyCarItemAmount = small_holder.getView(R.id.btn_add_buy_car_item_amount);

                        /*if (Integer.parseInt(small_item.getNum()) < 2) {
                            btnReduceBuyCarItemAmount.setEnabled(false);
                            btnReduceBuyCarItemAmount.setImageResource(R.drawable.ic_cha_reduce_gey);
                        } else {
                            btnReduceBuyCarItemAmount.setEnabled(true);
                            btnReduceBuyCarItemAmount.setImageResource(R.drawable.btn_reduce_amount_selector);
                        }*/

                        btnReduceBuyCarItemAmount.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (Integer.parseInt(small_item.getNum()) > 1) {


                                    CartResult.CartBean cartBean = smallDataSource.get(small_position);
                                    cartBean.setNum(Integer.parseInt(smallDataSource.get(small_position).getNum()) - 1 + "");
                                    smallDataSource.set(small_position, cartBean);
                                    MyCartList.ListBean listBean = dataSource.get(big_position);
                                    dataSource.set(big_position, listBean);
                                    myCartList.setList(dataSource);
                                    //dataSource.get(position).setNum(Integer.parseInt(dataSource.get(position).getNum())-p1+"");
                                    mAdapterSmall.notifyDataSetChanged();
                                    mAdapter.notifyDataSetChanged();
                                    tvTotalPrice.setText("¥" + makeTotalResult());
                                    getPresenter().setCartAmount(SpUtil.getStringSF(getActivity(), Constant.TOKEN), SpUtil.getStringSF(getActivity(), Constant.MERCHANTID), smallDataSource.get(small_position).getProduct_id() + "", smallDataSource.get(small_position).getNum());
                                }else if (Integer.parseInt(small_item.getNum()) == 1) {
                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("确认删除")
                                            .setMessage("此商品最小购买数量为1，是否删除该商品？")
                                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                }
                                            })
                                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    getPresenter().removeCart(SpUtil.getStringSF(getActivity(), Constant.TOKEN)
                                                            , small_item.getProduct_id() + "", SpUtil.getStringSF(getActivity(), Constant.MERCHANTID));
                                                }
                                            })
                                            .create()
                                            .show();

                                }
                            }
                        });

                        btnAddBuyCarItemAmount.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                CartResult.CartBean cartBean = smallDataSource.get(small_position);
                                cartBean.setNum(Integer.parseInt(smallDataSource.get(small_position).getNum()) + 1 + "");
                                smallDataSource.set(small_position, cartBean);
                                MyCartList.ListBean listBean = dataSource.get(big_position);
                                dataSource.set(big_position, listBean);
                                myCartList.setList(dataSource);
                                //dataSource.get(position).setNum(Integer.parseInt(dataSource.get(position).getNum())+p1+"");
                                mAdapterSmall.notifyDataSetChanged();
                                mAdapter.notifyDataSetChanged();
                                tvTotalPrice.setText("¥" + makeTotalResult());
                                getPresenter().setCartAmount(SpUtil.getStringSF(getActivity(), Constant.TOKEN), SpUtil.getStringSF(getActivity(), Constant.MERCHANTID), smallDataSource.get(small_position).getProduct_id() + "", smallDataSource.get(small_position).getNum());
                            }
                        });


                    }

                    @Override
                    protected int getItemViewLayoutId(int position, CartResult.CartBean item) {
                        return R.layout.item_buy_car_list;
                    }
                };
                //设置每个店铺商品选中商品总数
                //TextView tv = big_holder.getView(R.id.tv_total_amount);
                big_holder.setText(R.id.tv_total_amount, "共" + getCheckedAmountInOneCart(big_item) + "件商品");
                big_holder.setText(R.id.tv_up_total_price, makeOneCartTotalResult(big_item));
                smallRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                smallRecyclerView.setAdapter(mAdapterSmall);

            }

            @Override
            protected int getItemViewLayoutId(int position, MyCartList.ListBean item) {
                return R.layout.item_big_buy_car_list;
            }
        };
        bigRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        bigRecyclerView.setAdapter(mAdapter);

        cbAllCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MyCartList.ListBean> listBeenList = myCartList.getList();
                for (int i = 0; i < listBeenList.size(); i++) {

                    MyCartList.ListBean listBean = listBeenList.get(i);
                    List<CartResult.CartBean> cartBeenList = listBean.getCart();
                    for (int j = 0; j < cartBeenList.size(); j++) {

                        if (cbAllCheck.isChecked()) {
                            CartResult.CartBean cartBean = cartBeenList.get(j);
                            cartBean.setChecked(true);
                            cartBeenList.set(j, cartBean);
                            MyCartList.ListBean listBean2 = listBeenList.get(i);
                            listBeenList.set(i, listBean2);
                            myCartList.setList(listBeenList);
                        } else {
                            CartResult.CartBean cartBean = cartBeenList.get(j);
                            cartBean.setChecked(false);
                            cartBeenList.set(j, cartBean);
                            MyCartList.ListBean listBean2 = listBeenList.get(i);
                            listBeenList.set(i, listBean2);
                            myCartList.setList(listBeenList);
                        }
                    }
                }

                ((MainActivity) getActivity()).buyCarToolBar.setToolbarTitle("购物车(" + getCheckedItemAmount() + ")");
                mAdapter.notifyDataSetChanged();
                updateBtnSettle();
                tvTotalPrice.setText("¥" + makeTotalResult());
            }
        });
        getPresenter().getBuyCarList(SpUtil.getStringSF(getActivity(), Constant.TOKEN), SpUtil.getStringSF(getActivity(), Constant.MERCHANTID));
        updateBtnSettle();
    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerBuyCarComponent.builder()
                .appComponent(appComponent)
                .buyCarModule(new BuyCarModule(this)) //请将BuyCarModule()第一个首字母改为小写
                .build()
                .inject(this);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_buycar;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    //购物车列表获取成功
    @Override
    public void onBuyCarListSuccess(Cart cart) {
        dataSource.clear();

        CartResult cartResult = gson.fromJson(gson.toJson(cart.getResult()), CartResult.class);
        List<CartResult.CartBean> list = cartResult.getCart();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setChecked(false);
        }
        myCartList = getMyCartList(list, getMerchant_idList(cartResult));
        dataSource.addAll(myCartList.getList());
        mAdapter.notifyDataSetChanged();
        ((MainActivity) getActivity()).buyCarToolBar.setToolbarTitle("购物车(" + getCheckedItemAmount() + ")");
        updateBtnSettle();
        tvTotalPrice.setText("¥" + makeTotalResult());
    }

    @Override
    public void onBuyCarListFailed(Cart cart) {
        if (!TextUtils.isEmpty(cart.getApp_msg())) {
            ToastUtils.showMessage(getActivity(), cart.getApp_msg());
        }
    }

    @Override
    public void onBuyCarListFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            //showToast(throwable.getMessage());
            ToastUtils.showMessage(getActivity(), throwable.getMessage());
            /*mBundle = new Bundle();
            mBundle.putInt(Constant.SELECT_YTPE, 1);
            IntentUtils.showIntent(getActivity(), MyOrderActivity.class, mBundle);*/
        }
    }

    //设置商品数量成功
    @Override
    public void onSetCartAmountSuccess(SetCartAmountResult setCartAmountResult) {
        if (!TextUtils.isEmpty(setCartAmountResult.getResult())) {
            showToast(setCartAmountResult.getResult());
            //ToastUtils.showMessage(getActivity(), setCartAmountResult.getResult());
        }

    }

    @Override
    public void onSetCartAmountFailed(SetCartAmountResult setCartAmountResult) {

        if (!TextUtils.isEmpty(setCartAmountResult.getResult())) {
            showToast(setCartAmountResult.getResult());
            //ToastUtils.showMessage(getActivity(), setCartAmountResult.getResult());
        }
    }

    @Override
    public void onSetCartAmountFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            showToast(throwable.getMessage());
            //ToastUtils.showMessage(getActivity(), throwable.getMessage());
        }
    }

    @Override
    public void onRemoveCartSuccess(CartRemoveResult cartRemoveResult) {
        if (!TextUtils.isEmpty(cartRemoveResult.getResult())) {
            ToastUtils.showMessage(getActivity(), cartRemoveResult.getResult());
            getPresenter().getBuyCarList(SpUtil.getStringSF(getActivity(), Constant.TOKEN), SpUtil.getStringSF(getActivity(), Constant.MERCHANTID));
        }
    }

    @Override
    public void onRemoveCartFailed(CartRemoveResult cartRemoveResult) {
        if (!TextUtils.isEmpty(cartRemoveResult.getResult())) {
            ToastUtils.showMessage(getActivity(), cartRemoveResult.getResult());
        }
    }

    @Override
    public void onRemoveCartFailed(Throwable throwable) {
        if (!TextUtils.isEmpty(throwable.getMessage())) {
            ToastUtils.showMessage(getActivity(), throwable.getMessage());
        }
    }

    @OnClick({R.id.btn_settle})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_settle:
                Intent intent = new Intent(getActivity(), ConfirmOrderActivity.class);
                intent.putExtra("cart_list", gson.toJson(myCartList));
                intent.putExtra("total_price", tvTotalPrice.getText().toString().substring(1));
                startActivityForResult(intent, 1);
                break;
        }
    }

    //获取总的选中数量
    public int getCheckedItemAmount() {
        int amount = 0;
        for (int i = 0; i < dataSource.size(); i++) {
            List<CartResult.CartBean> cartBeanList = dataSource.get(i).getCart();
            for (int j = 0; j < cartBeanList.size(); j++) {
                if (cartBeanList.get(j).isChecked()) {
                    amount += 1;
                }
            }

        }
        return amount;

    }

    public int getTotalAmount() {
        int amount = 0;
        for (int i = 0; i < myCartList.getList().size(); i++) {
            List<CartResult.CartBean> cartBeanList = myCartList.getList().get(i).getCart();
            for (int j = 0; j < cartBeanList.size(); j++) {
                amount += 1;
            }

        }
        return amount;

    }

    //更新提交按钮状态
    public void updateBtnSettle() {
        if (getCheckedItemAmount() > 0) {
            btnSettle.setBackgroundResource(R.drawable.btn_settle_selector);
            btnSettle.setEnabled(true);
            if (getCheckedItemAmount() == getTotalAmount()) {
                cbAllCheck.setChecked(true);
            } else {
                cbAllCheck.setChecked(false);
            }
        } else {
            btnSettle.setBackgroundColor(Color.rgb(204, 204, 204));
            btnSettle.setEnabled(false);
            cbAllCheck.setChecked(false);
        }
    }

    //计算购物车所有选中商品总价
    public String makeTotalResult() {
        String res = "0.00";
        double d = 0;
        for (int i = 0; i < dataSource.size(); i++) {
            List<CartResult.CartBean> cartBeanList = dataSource.get(i).getCart();
            for (int j = 0; j < cartBeanList.size(); j++) {
                if (cartBeanList.get(j).isChecked()) {
                    d += Integer.parseInt(cartBeanList.get(j).getNum()) * Double.parseDouble(cartBeanList.get(j).getProduct().getPrice());
                }
            }


        }
        res = new java.text.DecimalFormat("#.00").format(d);
        if (res.startsWith(".")) {
            res = "0" + res;
        }
        return res;
    }

    //一个店铺下被选中的数量
    public int getCheckedAmountInOneCart(MyCartList.ListBean listBean) {
        int amount = 0;
        List<CartResult.CartBean> cartBeanList = listBean.getCart();
        for (int j = 0; j < cartBeanList.size(); j++) {
            if (cartBeanList.get(j).isChecked()) {
                amount += 1;
            }
        }
        return amount;
    }

    //一个店铺下选中商品总价
    public String makeOneCartTotalResult(MyCartList.ListBean listBean) {
        String res = "0.00";
        double d = 0;
        List<CartResult.CartBean> cartBeanList = listBean.getCart();
        for (int j = 0; j < cartBeanList.size(); j++) {
            if (cartBeanList.get(j).isChecked()) {
                d += Integer.parseInt(cartBeanList.get(j).getNum()) * Double.parseDouble(cartBeanList.get(j).getProduct().getPrice());
            }
        }
        res = new java.text.DecimalFormat("#.00").format(d);
        if (res.startsWith(".")) {
            res = "0" + res;
        }
        return res;
    }

    public List<Integer> getMerchant_idList(CartResult cartResult) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < cartResult.getCart().size(); i++) {
            if (!isContainInList(cartResult.getCart().get(i).getMerchant_id(), res)) {
                res.add(cartResult.getCart().get(i).getMerchant_id());
            }
        }
        return res;
    }

    public boolean isContainInList(int index, List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (index == list.get(i)) {
                return true;
            }
        }
        return false;
    }

    public String getMerchant_title(int index, List<CartResult.CartBean> list_cart) {
        String res = "";
        for (int i = 0; i < list_cart.size(); i++) {
            if (list_cart.get(i).getMerchant_id() == index) {
                res = list_cart.get(i).getMerchant_title();
                break;
            }
        }
        return res;
    }


    //获得MyCartList对象
    public MyCartList getMyCartList(List<CartResult.CartBean> list_cart, List<Integer> int_list) {
        MyCartList myCartList = new MyCartList();
        List<MyCartList.ListBean> list = new ArrayList<>();
        for (int i = 0; i < int_list.size(); i++) {
            MyCartList.ListBean listBean = new MyCartList.ListBean();
            listBean.setMerchant_id(int_list.get(i));
            listBean.setMerchant_title(getMerchant_title(int_list.get(i), list_cart));
            List<CartResult.CartBean> cart = new ArrayList<>();
            for (int j = 0; j < list_cart.size(); j++) {
                if (int_list.get(i) == list_cart.get(j).getMerchant_id()) {
                    cart.add(list_cart.get(j));
                }
            }
            listBean.setCart(cart);
            list.add(listBean);
        }
        myCartList.setList(list);
        return myCartList;
    }

    //弹出toast
    public void showToast(String text) {

        if (mToast == null) {
            mToast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    //取消toast对象
    public void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelToast();
    }

    public void onMessageEvent(String str) {
        /* Do something */
        if ("支付成功".equals(str)) {
            getPresenter().getBuyCarList(SpUtil.getStringSF(getActivity(), Constant.TOKEN), SpUtil.getStringSF(getActivity(), Constant.MERCHANTID));
            updateBtnSettle();
            //tvTotalPrice.setText("¥" + makeTotalResult());
            Bundle mBundle = new Bundle();
            mBundle.putInt(Constant.SELECT_YTPE, 2);
            IntentUtils.showIntent(getActivity(), MyOrderActivity.class, mBundle);
        } else {
            getPresenter().getBuyCarList(SpUtil.getStringSF(getActivity(), Constant.TOKEN), SpUtil.getStringSF(getActivity(), Constant.MERCHANTID));
            updateBtnSettle();
            //tvTotalPrice.setText("¥" + makeTotalResult());
            Bundle mBundle = new Bundle();
            mBundle.putInt(Constant.SELECT_YTPE, 1);
            IntentUtils.showIntent(getActivity(), MyOrderActivity.class, mBundle);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        //EventBus.getDefault().unregister(this);
    }


}