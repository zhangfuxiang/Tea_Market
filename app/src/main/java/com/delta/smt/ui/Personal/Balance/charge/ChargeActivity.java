package com.delta.smt.ui.Personal.Balance.charge;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ChargeResult;
import com.delta.smt.ui.Personal.Balance.charge.di.ChargeModule;
import com.delta.smt.ui.Personal.Balance.charge.di.DaggerChargeComponent;
import com.delta.smt.ui.Personal.Balance.charge.mvp.ChargeContract;
import com.delta.smt.ui.Personal.Balance.charge.mvp.ChargePresenter;
import com.delta.smt.ui.buycar.confirmOrder.InputPasswordBottomDialog;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.utils.MapUtils;
import com.delta.smt.utils.ViewFindUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.shaohui.bottomdialog.BaseBottomDialog;
import me.shaohui.bottomdialog.BottomDialog;

import static com.delta.smt.R.id.rb_wechat;


/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

public class ChargeActivity extends BaseActivity<ChargePresenter> implements ChargeContract.View, CommonBaseAdapter.OnItemClickListener<ChargeResult.ResultBean.MapBean> {


    @BindView(R.id.toolbar_left_button)
    ImageView toolbarLeftButton;
    @BindView(R.id.tv_left_button_name)
    TextView tvLeftButtonName;
    @BindView(R.id.toolbar_left_button_arl)
    AutoRelativeLayout toolbarLeftButtonArl;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_right_button)
    TextView toolbarRightButton;
    @BindView(R.id.toolbar_right_button_iv)
    ImageView toolbarRightButtonIv;
    @BindView(R.id.toolbar_right_button_iv_arl)
    AutoRelativeLayout toolbarRightButtonIvArl;
    @BindView(R.id.toolbar)
    FindToolBar toolbar;
    @BindView(R.id.rv_merchant)
    RecyclerView rvMerchant;
    private List<ChargeResult.ResultBean.MapBean> datas_in = new ArrayList<>();
    private CommonBaseAdapter<ChargeResult.ResultBean.MapBean> mAdapter_in;
    private TextView tv_pay_way;
    private TextView tv_pay_way1;
    private BaseBottomDialog bottomDialog;


    @Override
    protected void componentInject(AppComponent appComponent) {

        DaggerChargeComponent.builder().appComponent(appComponent).chargeModule(new ChargeModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        datas_in.clear();

        Map<String, String> queryMap = MapUtils.CreateQueryMap(this);
        getPresenter().getChargeList(queryMap);
        mAdapter_in = new CommonBaseAdapter<ChargeResult.ResultBean.MapBean>(this, datas_in) {
            @Override
            protected void convert(CommonViewHolder holder, ChargeResult.ResultBean.MapBean item, int position) {

                holder.setText(R.id.tv_raw_money, item.getTotal());
                holder.setText(R.id.tv_sell_money, "售价：￥" + item.getMoney());
                if (item.getRecommand() == 1) {
                    holder.getView(R.id.iv_worth).setVisibility(View.VISIBLE);
                } else {
                    holder.getView(R.id.iv_worth).setVisibility(View.GONE);
                }

            }

            @Override
            protected int getItemViewLayoutId(int position, ChargeResult.ResultBean.MapBean item) {
                return R.layout.item_charge;
            }
        };
        rvMerchant.setAdapter(mAdapter_in);
        rvMerchant.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter_in.setOnItemClickListener(this);

    }


    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void initView() {
        toolbarTitle.setText("充值");
        toolbarRightButton.setVisibility(View.INVISIBLE);
        toolbarLeftButton.setImageResource(R.mipmap.ic_back);


    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_charge_layout;
    }


    @OnClick({R.id.toolbar_left_button_arl})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                finish();
                break;
        }
    }


    @Override
    public void onItemClick(final View view, final ChargeResult.ResultBean.MapBean item, int position) {
        // // You can do any of the necessary the operation with the view
// Dialog window dim amount(can change window background color）, range：0 to 1，default is : 0.2f
// click the external area whether is closed, default is : true
// setting the DialogFragment tag
        bottomDialog = BottomDialog.create(getSupportFragmentManager())
                .setViewListener(new BottomDialog.ViewListener() {
                    @Override
                    public void bindView(View v) {
                        // // You can do any of the necessary the operation with the view


                        final View ll_payvay = ViewFindUtils.find(v, R.id.ll_pay_way);
                        final View ll_pay = ViewFindUtils.find(v, R.id.ll_dialog_pay);
                        tv_pay_way1 = ViewFindUtils.find(v, R.id.tv_pay_way);
                        TextView tv_money = ViewFindUtils.find(v, R.id.tv_money);
                        tv_money.setText(item.getTotal());
                        TextView tv_sell = ViewFindUtils.find(v, R.id.tv_sell);
                        tv_sell.setText("￥" + item.getMoney());
                        RadioGroup radioGroup = ViewFindUtils.find(v, R.id.rg_pay_way);
                        ViewFindUtils.find(v, R.id.rb_ali).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tv_pay_way1.setText("支付宝支付");
                                ll_pay.setVisibility(View.VISIBLE);
                                ll_payvay.setVisibility(View.GONE);
                            }
                        });
                        ViewFindUtils.find(v, rb_wechat).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tv_pay_way1.setText("微信支付");
                                ll_pay.setVisibility(View.VISIBLE);
                                ll_payvay.setVisibility(View.GONE);
                            }
                        });

                        ViewFindUtils.find(v, R.id.ll_pay).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ll_pay.setVisibility(View.GONE);
                                ll_payvay.setVisibility(View.VISIBLE);
                            }
                        });
                        ViewFindUtils.find(v, R.id.iv_delete).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                bottomDialog.dismiss();
                            }
                        });
                        ViewFindUtils.find(v, R.id.bt_pay).setOnClickListener(new View.OnClickListener() {

                            private Map<String, String> queryMap;

                            @Override
                            public void onClick(View v) {

                                bottomDialog.dismiss();
                                queryMap = MapUtils.CreateQueryMap(ChargeActivity.this);
                                queryMap.put("total", item.getMoney());
                                String s = tv_pay_way1.getText().toString().equals("支付宝支付") ? "1" : "2";
                                queryMap.put("pay_type", s);


                                InputPasswordBottomDialog dialog = new InputPasswordBottomDialog();
                                dialog.setHeight(getWindowManager().getDefaultDisplay().getHeight() * 1250 / 1920);
                                dialog.setDimAmount(0.8f);
                                dialog.setCancelOutside(true);
                                dialog.show(getSupportFragmentManager());
                                dialog.setOnSignUpListener(new InputPasswordBottomDialog.OnSignUpListener() {
                                    @Override
                                    public void onSignUp(String pwd) {
                                        getPresenter().chargePay(queryMap);
                                    }
                                });
                                dialog.setOnDismissListener(new InputPasswordBottomDialog.OnDismissListener() {
                                    @Override
                                    public void onDismiss() {

                                    }
                                });
                            }
                        });


                    }
                })
                .setLayoutRes(R.layout.bottomdialog_charge)
                .setDimAmount(0.1f)            // Dialog window dim amount(can change window background color）, range：0 to 1，default is : 0.2f
                .setCancelOutside(true)     // click the external area whether is closed, default is : true
                .setTag("BottomDialog")     // setting the DialogFragment tag
                .show();

    }

    @Override
    public void getChargeListSucess(List<ChargeResult.ResultBean.MapBean> map) {

        datas_in.clear();
        datas_in.addAll(map);
        mAdapter_in.notifyDataSetChanged();
    }

    @Override
    public void getChargeListFailed(String app_msg) {

        ToastUtils.showMessage(this, app_msg);
    }

    @Override
    public void chargeSuccess() {
        ToastUtils.showMessage(this, "充值成功");
        finish();

    }

    @Override
    public void chargeFailed() {
        ToastUtils.showMessage(this, "充值失败");
    }
}