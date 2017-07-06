package com.delta.smt.ui.find.auctionHouse.mvp;

import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.AuctionHouseListItem;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/18.
 */


public class AuctionHouseModel extends BaseModel<ApiService> implements AuctionHouseContract.Model {

    public AuctionHouseModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<AuctionHouseListItem> getAuctionList() {
        AuctionHouseListItem item = new AuctionHouseListItem();
        item.setCode("0");
        item.setMsg("success");
        List<AuctionHouseListItem.ResultBean> list = new ArrayList<>();
        list.add(new AuctionHouseListItem.ResultBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg",
                "武夷岩茶 ZHP0860-125 2016春茶", "438.00", "18", "2017-05-01 15:00:00"));
        list.add(new AuctionHouseListItem.ResultBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg",
                "武夷岩茶 ZHP0860-125 2016春茶", "438.00", "18", "2017-04-25 15:00:00"));
        list.add(new AuctionHouseListItem.ResultBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg",
                "武夷岩茶 ZHP0860-125 2016春茶", "438.00", "18", "2017-04-20 15:00:00"));
        list.add(new AuctionHouseListItem.ResultBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg",
                "武夷岩茶 ZHP0860-125 2016春茶", "438.00", "18", "2017-04-10 15:00:00"));
        list.add(new AuctionHouseListItem.ResultBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg",
                "武夷岩茶 ZHP0860-125 2016春茶", "438.00", "18", "2017-04-05 15:00:00"));
        list.add(new AuctionHouseListItem.ResultBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg",
                "武夷岩茶 ZHP0860-125 2016春茶", "438.00", "18", "2017-03-25 15:00:00"));
        list.add(new AuctionHouseListItem.ResultBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg",
                "武夷岩茶 ZHP0860-125 2016春茶", "438.00", "18", "2017-03-21 15:00:00"));
        item.setResult(list);
        return Observable.just(item);
    }
}