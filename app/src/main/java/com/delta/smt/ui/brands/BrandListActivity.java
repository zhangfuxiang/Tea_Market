package com.delta.smt.ui.brands;

import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.widget.statusLayout.StatusLayout;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.Brands;
import com.delta.smt.ui.brands.di.BrandModule;
import com.delta.smt.ui.brands.di.DaggerBrandComponent;
import com.delta.smt.ui.brands.mvp.BrandContract;
import com.delta.smt.ui.brands.mvp.BrandPresenter;
import com.superrecycleview.superlibrary.recycleview.ProgressStyle;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.delta.smt.base.BaseApplication.getContext;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/20 13:27
 */


public class BrandListActivity extends BaseActivity<BrandPresenter> implements BrandContract.View, SuperRecyclerView.LoadingListener {
    @BindView(R.id.lv_list)
    SuperRecyclerView superRecyclerView;
    @BindView(R.id.status)
    StatusLayout status;
    private List<Brands.DataBean.ItemsBean> datas;
    private CommonBaseAdapter commonBaseAdapter;
    private int index = 1;

    @Override
    protected void initView() {
        commonBaseAdapter = new CommonBaseAdapter<Brands.DataBean.ItemsBean>(getContext(), datas) {

            @Override
            protected void convert(CommonViewHolder holder, Brands.DataBean.ItemsBean item, int position) {

                holder.setText(R.id.tv_name, item.getData().getName());
                Glide.with(getContext()).load(item.getData().getCover_image_url()).placeholder(R.mipmap.ic_loading_rotate).error(R.mipmap.ic_user).into(((ImageView) holder.getView(R.id.iv)));
            }

            @Override
            protected int getItemViewLayoutId(int position, Brands.DataBean.ItemsBean item) {
                return R.layout.item_brands;
            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        superRecyclerView.setLayoutManager(layoutManager);
        superRecyclerView.setRefreshEnabled(true);//可以定制是否开启下拉刷新
        superRecyclerView.setLoadMoreEnabled(true);//可以定制是否开启加载更多
        superRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
        superRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//可以自定义上拉加载的样式
        // superRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);//设置下拉箭头
        superRecyclerView.setAdapter(commonBaseAdapter);
        superRecyclerView.setLoadingListener(this);
    }

    @Override
    protected void componentInject(AppComponent appComponent) {


        DaggerBrandComponent.builder().appComponent(appComponent).brandModule(new BrandModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        datas = new ArrayList<>();
        status.showLoadingView();
        getPresenter().getReports(1, Constant.NOMAL);

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_diseasereport;
    }

    @Override
    public void showloading() {

    }


    @Override
    public void Sucess(Brands brands) {
        status.showContentView();
        datas.clear();
        datas.addAll(brands.getData().getItems());
        commonBaseAdapter.notifyDataSetChanged();

    }

    @Override
    public void RefershSucess(Brands brands) {
        status.showContentView();
        datas.clear();
        datas.addAll(brands.getData().getItems());
        commonBaseAdapter.notifyDataSetChanged();
        superRecyclerView.completeRefresh();
    }

    @Override
    public void loadSucess(Brands brands) {
        status.showContentView();
        datas.addAll(brands.getData().getItems());
        commonBaseAdapter.notifyDataSetChanged();
        superRecyclerView.completeLoadMore();
    }


    @Override
    public void failed() {
        status.showErrorView();
    }


    @Override
    public void onRefresh() {

        index = 1;

        getPresenter().getReports(index, Constant.PUllTOREFRESH);

    }

    @Override
    public void onLoadMore() {

        getPresenter().getReports(++index, Constant.UPLOADMORE);
    }

}
