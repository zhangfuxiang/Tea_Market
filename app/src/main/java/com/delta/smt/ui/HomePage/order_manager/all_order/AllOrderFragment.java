package com.delta.smt.ui.HomePage.order_manager.all_order;

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
 * Created by Shaoqiang.Zhang on 2017/3/26.
 */

public class AllOrderFragment extends Fragment  implements CommonBaseAdapter.OnItemClickListener<Order>{

    @BindView(R.id.order_wait_todo_rv)
    RecyclerView order_wait_todo_rv;

    private List<Order> list=new ArrayList<>();
    private CommonBaseAdapter<Order> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order_manager_waitingtodo, container, false);
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

            }

            @Override
            protected int getItemViewLayoutId(int position, Order item) {
                return R.layout.item_order;
            }
        };

        adapter.setOnItemClickListener(this);
        order_wait_todo_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        order_wait_todo_rv.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, Order item, int position) {

    }
}
