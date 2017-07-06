package com.delta.smt.ui.find.systemShop.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.API;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.ShopCommodityListItem;
import com.delta.smt.entity.home_page.home_page_ads.classify_goods.ProductCategoryListResult;

import rx.Observable;


/**
 * Created by Shufeng.Wu on 2017/3/23.
 */


public class SystemShopModel extends BaseModel<ApiService> implements SystemShopContract.Model {

    public SystemShopModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<ShopCommodityListItem> getCommodityList(String token,
                                                              String page,
                                                              String size,
                                                              String allow_other_sale,
                                                              String category_id,
                                                              String order,
                                                              String order_type) {
        return getService().getCommodityList(token, page, size, allow_other_sale, category_id, order, order_type, API.category_id).compose(RxsRxSchedulers.<ShopCommodityListItem>io_main());
    }

    @Override
    public Observable<ShopCommodityListItem> searchGoods(String token, String page, String size, String keyword) {
        return getService().searchGoods(token,page,size,API.category_id,keyword);
    }

    @Override
    public Observable<ProductCategoryListResult> getCommodityClassify(String type, String as_type) {
        /*UserAddressItem<String> list1 = new ArrayList<>();
        list1.add("全部");
        list1.add("绿茶");
        list1.add("红茶");
        list1.add("乌龙茶");
        list1.add("白茶");
        list1.add("黄茶");
        list1.add("黑茶");
        list1.add("再加工茶");
        list1.add("代用茶");
        CommdityClassifyItem.Result result1 = new CommdityClassifyItem.Result("茶叶汇", list1);
        UserAddressItem<String> list2 = new ArrayList<>();
        list2.add("茶壶");
        list2.add("茶碗");
        CommdityClassifyItem.Result result2 = new CommdityClassifyItem.Result("茶工具", list2);
        UserAddressItem<String> list3 = new ArrayList<>();
        list3.add("茶点1");
        list3.add("茶点2");
        list3.add("茶点3");
        list3.add("茶点4");
        CommdityClassifyItem.Result result3 = new CommdityClassifyItem.Result("茶点茶食", list3);
        UserAddressItem<String> list4 = new ArrayList<>();
        list4.add("茶相关1");
        list4.add("茶相关2");
        list4.add("茶相关3");
        list4.add("茶相关4");
        CommdityClassifyItem.Result result4 = new CommdityClassifyItem.Result("茶相关", list4);
        UserAddressItem<String> list5 = new ArrayList<>();
        list5.add("高档茶具1");
        list5.add("高档茶具2");
        list5.add("高档茶具3");
        list5.add("高档茶具4");
        CommdityClassifyItem.Result result5 = new CommdityClassifyItem.Result("高档茶具", list5);
        UserAddressItem<CommdityClassifyItem.Result> resultList = new ArrayList<>();
        resultList.add(result1);
        resultList.add(result2);
        resultList.add(result3);
        resultList.add(result4);
        resultList.add(result5);
        CommdityClassifyItem commdityClassifyItem = new CommdityClassifyItem("success", "0", resultList);*/

        //return Observable.just(commdityClassifyItem);
        return getService().getProductCategoryList(type, as_type,2).compose(RxsRxSchedulers.<ProductCategoryListResult>io_main());
    }
}