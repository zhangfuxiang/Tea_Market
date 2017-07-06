package com.delta.smt.ui.buycar.buycar.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.cart.Cart;
import com.delta.smt.entity.cart.CartRemoveResult;
import com.delta.smt.entity.cart.SetCartAmountResult;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/27.
 */


public class BuyCarModel extends BaseModel<ApiService> implements BuyCarContract.Model {

    public BuyCarModel(ApiService apiService) {
        super(apiService);
    }


    /*@Override
    public Observable<CartListResult> getBuyCarList() {
        ReferList<BuyCarListItem.Result>list = new ArrayList<>();
        list.add(new BuyCarListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new BuyCarListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new BuyCarListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new BuyCarListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new BuyCarListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new BuyCarListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        list.add(new BuyCarListItem.Result("武夷岩茶 ZHP0860-125 2016春茶","438.00","1","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3637033282,269490668&fm=23&gp=0.jpg"));
        BuyCarListItem item = new BuyCarListItem("success","0",list);
        return Observable.just(item);
    }*/

    @Override
    public Observable<Cart> getBuyCarList(String token, String merchant_id) {
        return getService().getCartList(token, merchant_id).compose(RxsRxSchedulers.<Cart>io_main());
    }

    @Override
    public Observable<SetCartAmountResult> setCartAmount(String token, String merchant_id, String product_id, String num) {
        return getService().setCartAmount(token, merchant_id, product_id, num).compose(RxsRxSchedulers.<SetCartAmountResult>io_main());
    }

    @Override
    public Observable<CartRemoveResult> removeCart(String token, String product_ids,String merchant_id) {
        return getService().removeCart(token, product_ids,merchant_id).compose(RxsRxSchedulers.<CartRemoveResult>io_main());
    }
}