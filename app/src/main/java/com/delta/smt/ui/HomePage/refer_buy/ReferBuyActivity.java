package com.delta.smt.ui.HomePage.refer_buy;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.ReferBuy;
import com.delta.smt.ui.HomePage.HomePageAPIService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shaoqiang.Zhang on 2017/3/30.
 */

public class ReferBuyActivity extends BaseActivity implements CommonBaseAdapter.OnItemClickListener<ReferBuy.Result.MList>{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.refer_buy_rv)
    RecyclerView refer_buy_rv;
    private List<ReferBuy.Result.MList> list = new ArrayList<>();
    private CommonBaseAdapter<ReferBuy.Result.MList> adapter;

    @OnClick(R.id.toolbar_left_button)
    void back() {
        finish();
    }

    @Override
    protected void initView() {

        toolbarTitle.setText("新购买咨询");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);

        adapter=new CommonBaseAdapter<ReferBuy.Result.MList>(this,list) {
            @Override
            protected void convert(CommonViewHolder holder, ReferBuy.Result.MList item, int position) {

                holder.setText(R.id.refer_buy_question_tv,item.getQuestions());


                holder.getView(R.id.refer_buy_replay_tv).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

            @Override
            protected int getItemViewLayoutId(int position, ReferBuy.Result.MList item) {
                return R.layout.item_refer_buy;
            }

        };

        adapter.setOnItemClickListener(this);
        refer_buy_rv.setLayoutManager(new LinearLayoutManager(this));
        refer_buy_rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {

        new HomePageAPIService().getReferBuyCall(SpUtil.getStringSF(this, Constant.TOKEN)).enqueue(new Callback<ReferBuy>() {
            @Override
            public void onResponse(Call<ReferBuy> call, Response<ReferBuy> response) {
                list.clear();
                for (ReferBuy.Result.MList l:response.body().getResult().getList()){
                    list.add(l);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ReferBuy> call, Throwable t) {

            }
        });

    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_refer_buy;
    }

    @Override
    public void onItemClick(View view, ReferBuy.Result.MList item, int position) {



    }
}
