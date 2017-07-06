package com.delta.smt.ui.HomePage.purchase.get_cargo;

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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shaoqiang.Zhang on 2017/3/31.
 */

public class GetCargoFragment extends Fragment  implements CommonBaseAdapter.OnItemClickListener<Order>{

    @BindView(R.id.purchase_rv)
    RecyclerView purchase_rv;

    private List<Order> list=new ArrayList<>();
    private CommonBaseAdapter<Order> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_purchase, container, false);
        ButterKnife.bind(this, view);

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
                createInRv(holder);
            }


            @Override
            protected int getItemViewLayoutId(int position, Order item) {
                return R.layout.item_purchase;
            }
        };


        adapter.setOnItemClickListener(this);
        purchase_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        purchase_rv.setAdapter(adapter);

    }

    private void createInRv(CommonViewHolder holder) {
        RecyclerView purchase_in_rv= holder.getView(R.id.purchase_in_rv);

        List<Order> list_in=new ArrayList<>();
        CommonBaseAdapter<Order> adapter_in;

        list_in.clear();
        for (int i = 0; i < 4; i++) {
            list_in.add(new Order());
        }

        adapter_in=new CommonBaseAdapter<Order>(getContext(),list_in) {
            @Override
            protected void convert(CommonViewHolder holder, Order item, int position) {

            }

            @Override
            protected int getItemViewLayoutId(int position, Order item) {
                return R.layout.item_order_detail;
            }
        };

        purchase_in_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        purchase_in_rv.setAdapter(adapter_in);
    }


    @Override
    public void onItemClick(View view, Order item, int position) {

    }

}
