package com.delta.smt.ui.HomePage.productDetail;

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
import com.delta.smt.entity.Order;
import com.delta.smt.ui.find.auctionHouseDetail.AdaptiveViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shaoqiang.Zhang on 2017/4/18.
 */

public class BuyReferFragment  extends Fragment {

    AdaptiveViewPager vp;
    @BindView(R.id.product_detail_refer_rv)
    RecyclerView product_detail_refer_rv;

    private List<Order> list=new ArrayList<>();
    private CommonBaseAdapter<Order> adapter;

    public BuyReferFragment() {
    }

    public void setAdaptiveViewPager(AdaptiveViewPager vp) {
        this.vp = vp;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refer_buy, container, false);
        ButterKnife.bind(this, view);
        vp.setObjectForPosition(view, 2);
        initView();
        return view;
    }

    private void initView() {

        list.clear();
        for (int i = 0; i < 6; i++) {
            list.add(new Order());
        }

        adapter=new CommonBaseAdapter<Order>(getContext(),list) {
            @Override
            protected void convert(CommonViewHolder holder, Order item, int position) {

            }

            @Override
            protected int getItemViewLayoutId(int position, Order item) {
                return R.layout.item_product_refer_buy;
            }
        };

        product_detail_refer_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        product_detail_refer_rv.setAdapter(adapter);

    }

}
