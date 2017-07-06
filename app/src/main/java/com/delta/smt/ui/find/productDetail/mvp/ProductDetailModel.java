package com.delta.smt.ui.find.productDetail.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.AddMyShopResult;
import com.delta.smt.entity.AddToCartResult;
import com.delta.smt.entity.ProductDetail;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/25.
 */


public class ProductDetailModel extends BaseModel<ApiService> implements ProductDetailContract.Model {

    public ProductDetailModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ProductDetail> getProductDetail(String token, String product_id, String stringSF) {
        /*UserAddressItem<String> picture_urls = new ArrayList<>();
        picture_urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489950197679&di=6d9dba83a0c39fa8fdde1264c7797bbe&imgtype=0&src=http%3A%2F%2Fimage.tech-food.com%2Fimages%2Fnews%2Fbpic%2F2009-7%2F200973165541987.jpg");
        picture_urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489950269666&di=a1e25a5fb69546029bf64b6a510bf747&imgtype=0&src=http%3A%2F%2Ferp.huipin.com.cn%2FPublic%2Fkindeditor%2Fattached%2Fimage%2F20140306%2F20140306033220_99420.jpg");
        picture_urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489950315549&di=5528e7851f2df65f0b449c04926eedc8&imgtype=0&src=http%3A%2F%2Ffile1.youboy.com%2Fd%2F175%2F13%2F65%2F3%2F236143.jpg");
        picture_urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489950365089&di=a59a63dd1353b63b9ad6fc636120bbbf&imgtype=0&src=http%3A%2F%2Fimages4.c-ctrip.com%2Ftarget%2Ft1%2Ftuangou%2F393%2F978%2F563%2Ffede7991fc9e4ad9b0082ea2a29c2dd5_720_480_s.jpg");
        ProductDetailItem.ResultBean result = new ProductDetailItem.ResultBean("武夷岩茶 ZHP0860-125 2016春茶", "438.00", "老开心茶楼", "18", picture_urls);
        ProductDetailItem auctionDetailItem = new ProductDetailItem("success", "0", result);
        return Observable.just(auctionDetailItem);*/
        return getService().getProductDetail(token, product_id,stringSF).compose(RxsRxSchedulers.<ProductDetail>io_main());
    }

    @Override
    public Observable<AddMyShopResult> getAddMyShopResult(String token, String product_id/*, String price*/) {
        return getService().getAddMyShopResult(token, product_id/*, price*/).compose(RxsRxSchedulers.<AddMyShopResult>io_main());
    }

    @Override
    public Observable<AddToCartResult> addToCart(String token, String product_id, String num) {
        return getService().addToCartResult(token, product_id, num).compose(RxsRxSchedulers.<AddToCartResult>io_main());
    }
}