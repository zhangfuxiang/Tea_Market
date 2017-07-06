package com.delta.smt.ui.HomePage.subjectActivity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.home_page.activity.ActivityList;
import com.delta.smt.entity.home_page.activity.ActivityListResult;
import com.delta.smt.ui.HomePage.subjectActivity.di.DaggerSubjectActivityComponent;
import com.delta.smt.ui.HomePage.subjectActivity.di.SubjectActivityModule;
import com.delta.smt.ui.HomePage.subjectActivity.mvp.SubjectActivityContract;
import com.delta.smt.ui.HomePage.subjectActivity.mvp.SubjectActivityPresenter;
import com.delta.smt.ui.HomePage.subjectActivityDetail.SubjectActivityDetailActivity;
import com.delta.smt.ui.find.FindToolBar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;
import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by wushufeng on 2017/3/19.
 */

public class SubjectActivityActivity extends BaseActivity<SubjectActivityPresenter> implements SubjectActivityContract.View, SuperBaseAdapter.OnItemClickListener<ActivityListResult.ListBean>, SuperRecyclerView.LoadingListener {


    @BindView(R.id.rvSubjectList)
    SuperRecyclerView rvSubjectList;
    @BindView(R.id.toolbar)
    FindToolBar toolbar;
    int indexPage = 2;
    Gson gson = new GsonBuilder().
            registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

                @Override
                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src == src.longValue())
                        return new JsonPrimitive(src.longValue());
                    return new JsonPrimitive(src);
                }
            }).create();
    private List<ActivityListResult.ListBean> dataSource = new ArrayList<>();
    private SuperBaseAdapter<ActivityListResult.ListBean> mAdapter;

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerSubjectActivityComponent.builder()
                .appComponent(appComponent)
                .subjectActivityModule(new SubjectActivityModule(this)) //请将SubjectActivityModule()第一个首字母改为小写
                .build()
                .inject(this);
    }

    @Override
    protected void initView() {
        toolbar.setToolbarTitle(getIntent().getStringExtra("title"));
        toolbar.setToolbarLeftButton(R.mipmap.ic_back);
        mAdapter = new SuperBaseAdapter<ActivityListResult.ListBean>(this, dataSource) {
            @Override
            protected void convert(BaseViewHolder holder, ActivityListResult.ListBean item, int position) {
                holder.setText(R.id.tv_show_activity_name, item.getTitle());
                holder.setText(R.id.tv_showEnrollAmount, item.getSign_num() + "/" + item.getNumber());
                long now_time = System.currentTimeMillis();
                long start_time = item.getStart_time() * 1000;
                long end_time = item.getEnd_time() * 1000;

                TextView activityState = holder.getView(R.id.tv_showSubjectActivityState);
                if (item.getIs_signed() == 1 + "") {
                    activityState.setTextColor(getResources().getColor(R.color.base_color));
                    activityState.setText("已报名");
                } else {
                    activityState.setTextColor(Color.rgb(255, 96, 0));
                    Log.i(TAG, "convert: " + now_time + "-" + start_time);
                    if (now_time < start_time) {

                        activityState.setText("报名中");
                        if (item.getSign_num() == item.getNumber()) {
                            activityState.setText("报名人数已满");
                        } else {
                            activityState.setText("报名中");
                        }
                    } else if (now_time >= end_time) {
                        activityState.setText("活动已结束");
                    } else {
                        activityState.setText("活动进行中");
                    }
                }


                ImageView iv = holder.getView(R.id.iv_subject_activity);

                //Glide.with(SubjectActivityActivity.this).load(dataSource.get(position).getImages()).placeholder(R.mipmap.picture).crossFade().into(iv);

                //假数据
                Glide.with(SubjectActivityActivity.this).load(item.getImages().get(0)).placeholder(R.mipmap.picture).thumbnail(0.1f).crossFade().into(iv);


            }

            @Override
            protected int getItemViewLayoutId(int position, ActivityListResult.ListBean item) {
                if (position % 2 == 0) {
                    return R.layout.item_subject_activity_list_left;
                } else {
                    return R.layout.item_subject_activity_list_right;
                }

            }
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            rvSubjectList.setLayoutManager(new GridLayoutManager(this, 2));
        }

        rvSubjectList.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        rvSubjectList.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        rvSubjectList.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
        rvSubjectList.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义上拉加载的样式
        // superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);//设置下拉箭头
        rvSubjectList.setAdapter(mAdapter);
        rvSubjectList.setLoadingListener(this);

        mAdapter.setOnItemClickListener(this);


    }

    @Override
    protected void initData() {
        //getPresenter().getSubjectActivityList(SpUtil.getStringSF(SubjectActivityActivity.this, Constant.TOKEN), "1", "10", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), Constant.NOMAL);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().getSubjectActivityList(SpUtil.getStringSF(SubjectActivityActivity.this, Constant.TOKEN), "1", "1", "10", getIntent().getStringExtra("category_id"), 0 + "", SpUtil.getStringSF(this, Constant.MERCHANTID), Constant.NOMAL);
    }

    @OnClick(R.id.toolbar_left_button_arl)
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_button_arl:
                this.finish();
                break;
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_subject_list_page;
    }


    @Override
    public void onSujectListSuccess(ActivityList item) {

        dataSource.clear();
        ActivityListResult activityListResult = gson.fromJson(gson.toJson(item.getResult()), ActivityListResult.class);
        List<ActivityListResult.ListBean> list = activityListResult.getList();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSujectListfailed(ActivityList item) {
        if (!TextUtils.isEmpty(item.getApp_msg())) {
            ToastUtils.showMessage(SubjectActivityActivity.this, item.getApp_msg());
        }
    }

    @Override
    public void onSujectListfailed(Throwable throwable) {
        ToastUtils.showMessage(this, throwable.getMessage());
        rvSubjectList.completeLoadMore();
        rvSubjectList.completeRefresh();
    }

    @Override
    public void onSujectListLoadMoreSuccess(ActivityList item) {
        indexPage++;
        ActivityListResult activityListResult = gson.fromJson(gson.toJson(item.getResult()), ActivityListResult.class);
        List<ActivityListResult.ListBean> list = activityListResult.getList();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
        rvSubjectList.completeLoadMore();
        if (list.size() == 0) {
            ToastUtils.showMessage(this, "已经到达最底部！");
            indexPage--;
        }
    }

    @Override
    public void onSujectListLoadMorefailed(ActivityList item) {
        ToastUtils.showMessage(this, "加载更多失败！");
        rvSubjectList.completeLoadMore();
    }

    @Override
    public void onSujectListRefreshSuccess(ActivityList item) {
        indexPage = 2;
        dataSource.clear();
        ActivityListResult activityListResult = gson.fromJson(gson.toJson(item.getResult()), ActivityListResult.class);
        List<ActivityListResult.ListBean> list = activityListResult.getList();
        dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
        rvSubjectList.completeRefresh();
    }

    @Override
    public void onSujectListRefreshfailed(ActivityList item) {
        ToastUtils.showMessage(this, "列表刷新失败！");
        rvSubjectList.completeRefresh();
    }

    @Override
    public void onItemClick(View view, ActivityListResult.ListBean item, int position) {
        IntentUtils.showIntent(SubjectActivityActivity.this,
                SubjectActivityDetailActivity.class,
                new String[]{"activity_id"},
                new String[]{item.getId() + ""});
    }

    @Override
    public void onRefresh() {
        getPresenter().getSubjectActivityList(SpUtil.getStringSF(SubjectActivityActivity.this, Constant.TOKEN), "1", "1", "10", getIntent().getStringExtra("category_id"), 0 + "", SpUtil.getStringSF(this, Constant.MERCHANTID), Constant.PUllTOREFRESH);

    }

    @Override
    public void onLoadMore() {
        getPresenter().getSubjectActivityList(SpUtil.getStringSF(SubjectActivityActivity.this, Constant.TOKEN), "1", indexPage + "", "10", getIntent().getStringExtra("category_id"), 0 + "", SpUtil.getStringSF(this, Constant.MERCHANTID), Constant.UPLOADMORE);
    }
}