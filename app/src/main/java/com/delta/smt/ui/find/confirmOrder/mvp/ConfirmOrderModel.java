package com.delta.smt.ui.find.confirmOrder.mvp;

import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ComfirmOrderListItem;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/29.
 */


public class ConfirmOrderModel extends BaseModel<ApiService> implements ConfirmOrderContract.Model {

    public ConfirmOrderModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ComfirmOrderListItem> getComfirmOrderList() {
        List<ComfirmOrderListItem.Result> list = new ArrayList<>();
        list.add(new ComfirmOrderListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new ComfirmOrderListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new ComfirmOrderListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new ComfirmOrderListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new ComfirmOrderListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new ComfirmOrderListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new ComfirmOrderListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        ComfirmOrderListItem item = new ComfirmOrderListItem("success","0",list);
        return Observable.just(item);
    }
}