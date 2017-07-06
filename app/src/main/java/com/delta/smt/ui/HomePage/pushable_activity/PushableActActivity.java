package com.delta.smt.ui.HomePage.pushable_activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
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
import com.delta.smt.entity.AddSubjectToMy;
import com.delta.smt.entity.PushableActivity;
import com.delta.smt.entity.PushableActivityList;
import com.delta.smt.ui.HomePage.HomePageAPIService;
import com.delta.smt.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shaoqiang.Zhang on 2017/4/5.
 */

public class PushableActActivity extends BaseActivity implements CommonBaseAdapter.OnItemClickListener<PushableActivityList> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.push_able_goods_rv)
    RecyclerView push_able_goods_rv;
    private List<PushableActivityList> list = new ArrayList<>();
    private CommonBaseAdapter<PushableActivityList> adapter;

    @OnClick(R.id.toolbar_left_button)
    void back() {
        finish();
    }

    @Override
    protected void initView() {

        toolbarTitle.setText("可推广活动(" + getIntent().getExtras().getString("count") + ")");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        adapter = new CommonBaseAdapter<PushableActivityList>(this, list) {
            @Override
            protected void convert(CommonViewHolder holder, final PushableActivityList item, int position) {

                holder.setText(R.id.push_able_act_sub_tv, item.getTitle());
                holder.setText(R.id.push_able_act_content, "已报名/限定人数：" + item.getSignNum() + "/" + item.getNumber()
                        + " | 时间：" + DataUtils.timeStamp2Date(String.valueOf(item.getStartTime()), "HH:mm")
                        + "-" + DataUtils.timeStamp2Date(String.valueOf(item.getEndTime()), "HH:mm"));

                Glide.with(PushableActActivity.this)
                        .load(item.getImageUrl())
                        .crossFade()
                        .into((ImageView) holder.getView(R.id.push_able_act_image));

                holder.getView(R.id.push_able_act_add_tv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new HomePageAPIService().addPushableActCall(SpUtil.getStringSF(PushableActActivity.this, Constant.TOKEN), item.getId()).enqueue(
                                new Callback<AddSubjectToMy>() {
                                    @Override
                                    public void onResponse(Call<AddSubjectToMy> call, Response<AddSubjectToMy> response) {
                                        ToastUtils.showMessage(PushableActActivity.this, response.body().getApp_msg());
                                    }

                                    @Override
                                    public void onFailure(Call<AddSubjectToMy> call, Throwable t) {
                                        ToastUtils.showMessage(PushableActActivity.this,"你无法加入该活动！");
                                    }
                                }
                        );
                    }
                });

            }

            @Override
            protected int getItemViewLayoutId(int position, PushableActivityList item) {
                return R.layout.item_pushable_act;
            }
        };

        adapter.setOnItemClickListener(this);
        push_able_goods_rv.setLayoutManager(new LinearLayoutManager(this));
        push_able_goods_rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {

        new HomePageAPIService().getPushableActivityCall(SpUtil.getStringSF(this, Constant.TOKEN)).enqueue(new Callback<PushableActivity>() {
            @Override
            public void onResponse(Call<PushableActivity> call, Response<PushableActivity> response) {

                list.clear();
                for (PushableActivityList l : response.body().getResult().getList()) {

                    list.add(l);

                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PushableActivity> call, Throwable t) {

            }
        });

    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_pushable_act;
    }

    @Override
    public void onItemClick(View view, PushableActivityList item, int position) {

    }
}
