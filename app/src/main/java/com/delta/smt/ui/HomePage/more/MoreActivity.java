package com.delta.smt.ui.HomePage.more;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.Constant;
import com.delta.smt.R;
import com.delta.smt.base.BaseActivity;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.di.component.AppComponent;
import com.delta.smt.entity.Order;
import com.delta.smt.entity.home_page.home_page_ads.message.SystemMessage;
import com.delta.smt.ui.HomePage.HomePageAPIService;
import com.delta.smt.ui.HomePage.more.sys_pub.MyMessage;
import com.delta.smt.ui.HomePage.more.sys_pub.SystemPublicActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shaoqiang.Zhang on 2017/4/7.
 */

public class MoreActivity extends BaseActivity implements CommonBaseAdapter.OnItemClickListener<Order>{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_left_button)
    ImageView leftButton;
    @BindView(R.id.toolbar_right_button)
    TextView rightButton;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.more_rv)
    RecyclerView more_rv;
    private List<Order> list = new ArrayList<>();
    private CommonBaseAdapter<Order> adapter;

    @OnClick(R.id.toolbar_left_button)
    void back() {
        finish();
    }

    int delver=0;
    int sysPub=0;
    int circly=0;

    List<MyMessage> sysPubList=new ArrayList<>();
    List<MyMessage> delverList=new ArrayList<>();
    List<MyMessage> circlyList=new ArrayList<>();

    @Override
    protected void initView() {

        list.clear();
        for(int i=0;i<3;i++){
            list.add(new Order());
        }

        toolbarTitle.setText("消息");
        rightButton.setVisibility(View.INVISIBLE);
        leftButton.setImageResource(R.mipmap.ic_back);
        adapter=new CommonBaseAdapter<Order>(this,list) {
            @Override
            protected void convert(CommonViewHolder holder, Order item, int position) {

                switch (position){

                    case 0:
                        if(delver==0){
                            holder.setVisible(R.id.message_count_tv,false);
                        }else {
                            holder.setVisible(R.id.message_count_tv,true);
                            holder.setText(R.id.message_count_tv,delver+"");
                        }
                        holder.setImageResource(R.id.order_iv,R.mipmap.more_car2);
                        holder.setText(R.id.title,"物流助手");
                        break;
                    case 1:
                        if(sysPub==0){
                            holder.setVisible(R.id.message_count_tv,false);
                        }else {
                            holder.setVisible(R.id.message_count_tv,true);
                            holder.setText(R.id.message_count_tv,sysPub+"");
                        }
                        holder.setImageResource(R.id.order_iv,R.mipmap.system_pub);
                        holder.setText(R.id.title,"系统通告");
                        break;
                    case 2:
                        if(circly==0){
                            holder.setVisible(R.id.message_count_tv,false);
                        }else {
                            holder.setVisible(R.id.message_count_tv,true);
                            holder.setText(R.id.message_count_tv,circly+"");
                        }
                        holder.setImageResource(R.id.order_iv,R.mipmap.tea_circle);
                        holder.setText(R.id.title,"茶圈子互动通知");
                        break;
                    default:
                        break;

                }

            }

            @Override
            protected int getItemViewLayoutId(int position, Order item) {
                return R.layout.item_more;
            }
        };

        adapter.setOnItemClickListener(this);
        more_rv.setLayoutManager(new LinearLayoutManager(this));
        more_rv.setAdapter(adapter);

    }

    @Override
    protected void initData() {

        new HomePageAPIService().getSystemMessageCall(SpUtil.getStringSF(this, Constant.TOKEN)).enqueue(new Callback<SystemMessage>() {
            @Override
            public void onResponse(Call<SystemMessage> call, Response<SystemMessage> response) {

                if(response.body()!=null) {
                    if(response.body().getAppCode()==22000) {
                        for (com.delta.smt.entity.home_page.home_page_ads.message.List list : response.body().getResult().getList()) {

                            if(list.getType()==1){
                                sysPub++;
                                sysPubList.add(new MyMessage(list.getCreateTime(), list.getMessage()));
                            }
                            if(list.getType()==2){
                                delver++;
                                delverList.add(new MyMessage(list.getCreateTime(), list.getMessage()));
                            }
                            if(list.getType()==3){
                                circly++;
                                circlyList.add(new MyMessage(list.getCreateTime(), list.getMessage()));
                            }

                        }
                    }
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<SystemMessage> call, Throwable t) {

            }
        });

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_more;
    }

    @Override
    protected void componentInject(AppComponent appComponent) {

    }

    @Override
    public void onItemClick(View view, Order item, int position) {
        view.findViewById(R.id.message_count_tv).setVisibility(View.INVISIBLE);
        switch (position){
            case 0:
                break;
            case 1:
                Intent i=new Intent();
                i.putParcelableArrayListExtra("message", (ArrayList<? extends Parcelable>) sysPubList);
                i.setClass(this,SystemPublicActivity.class);
                startActivity(i);
                break;
            case 2:
                break;
            default:
                break;
        }

    }

}
