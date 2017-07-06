package com.delta.smt.ui.find.priceRecord.mvp;

import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.AuctionDetailRecordItem;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;


/**
 * Created by Shufeng.Wu on 2017/3/21.
 */


public class PriceRecordModel extends BaseModel<ApiService> implements PriceRecordContract.Model {

    public PriceRecordModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<AuctionDetailRecordItem> getPriceRecordList() {
        List<AuctionDetailRecordItem.ResultBean> result = new ArrayList<>();
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥438.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥418.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥398.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥378.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥358.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥338.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥300.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥280.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥260.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥240.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥220.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥200.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥180.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥160.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥140.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥120.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥100.00", "2016-12-12 12:22:22"));
        result.add(new AuctionDetailRecordItem.ResultBean("http://www.itouxiang.net/uploads/allimg/20160610/jn5i5v2wfly554324.jpg"
                , "王先生(13812345678)", "¥80.00", "2016-12-12 12:22:22"));
        AuctionDetailRecordItem auctionDetailRecordItem = new AuctionDetailRecordItem("success", "0", result);
        return Observable.just(auctionDetailRecordItem);
    }
}