package com.delta.smt.ui.find.productDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delta.smt.R;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.entity.ProductDetail;
import com.delta.smt.ui.find.auctionHouseDetail.AdaptiveViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushufeng on 2017/3/21.
 */

public class ProductParaFragment extends Fragment {
    AdaptiveViewPager vp;
    RecyclerView mRecyclerView;

    private List<ProductDetail.ResultBean.ProductBean.ParamBean> dataSource = new ArrayList<>();
    private CommonBaseAdapter<ProductDetail.ResultBean.ProductBean.ParamBean> mAdapter;


    public ProductParaFragment() {
    }

    public void setAdaptiveViewPager(AdaptiveViewPager vp) {
        this.vp = vp;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_para, container, false);
        vp.setObjectForPosition(view, 1);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        mAdapter = new CommonBaseAdapter<ProductDetail.ResultBean.ProductBean.ParamBean>(getActivity(), dataSource) {
            @Override
            protected void convert(CommonViewHolder holder, ProductDetail.ResultBean.ProductBean.ParamBean item, int position) {
                holder.setText(R.id.tv_product_para_label, item.getName());
                holder.setText(R.id.tv_product_para, item.getValue());
            }

            @Override
            protected int getItemViewLayoutId(int position, ProductDetail.ResultBean.ProductBean.ParamBean item) {
                return R.layout.item_product_para_list;

            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


    public void setParamDataSource(List<ProductDetail.ResultBean.ProductBean.ParamBean> ds) {
        this.dataSource.clear();
        List<ProductDetail.ResultBean.ProductBean.ParamBean> list = ds;
        this.dataSource.addAll(list);
        mAdapter.notifyDataSetChanged();
    }
}
