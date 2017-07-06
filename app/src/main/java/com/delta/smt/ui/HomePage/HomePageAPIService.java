package com.delta.smt.ui.HomePage;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.app.App;
import com.delta.smt.entity.AddSubjectToMy;
import com.delta.smt.entity.AppointmentStoreDetail;
import com.delta.smt.entity.ArriveResoult;
import com.delta.smt.entity.PushableActivity;
import com.delta.smt.entity.ReferBuy;
import com.delta.smt.entity.ShopCommodityListItem;
import com.delta.smt.entity.TodoThings;
import com.delta.smt.entity.home_page.activity.ActivityCategory;
import com.delta.smt.entity.home_page.home_page_ads.AdImages;
import com.delta.smt.entity.home_page.home_page_ads.gust_like.GustYouLike;
import com.delta.smt.entity.home_page.home_page_ads.little_tip.LittleTip;
import com.delta.smt.entity.home_page.home_page_ads.message.SystemMessage;
import com.delta.smt.entity.home_page.home_page_ads.near_activity.NearActivity;
import com.delta.smt.entity.home_page.home_page_ads.news.TeaArtMeeting;
import com.delta.smt.entity.home_page.home_page_ads.news_detail.NewsDetail;
import com.delta.smt.entity.home_page.home_page_ads.systemgoods.SystemGoods;
import com.delta.smt.entity.home_page.home_page_ads.tea_circly.TeaCircly;

import retrofit2.Call;
import rx.Observable;

/**
 * Created by Shaoqiang.Zhang on 2017/4/10.
 */

public class HomePageAPIService {

    public static int merchant_id = 1;
    HomePageAPI service = App.getRetrofit().create(HomePageAPI.class);

    public Call<TodoThings> getSearchBooksCall(String token) {

        return service.getTodoThingsCount(token);

    }

    public Call<AppointmentStoreDetail> getAppointmentDetailCall(String token) {

        return service.getAppointmentDetail(token, 50);

    }

    public Call<ArriveResoult> arriveResoultCall(String token, int bespeak_id) {

        return service.arriveStore(token, bespeak_id);

    }

    public Call<ReferBuy> getReferBuyCall(String token) {

        return service.getReferBuyList(token, 50);

    }

    public Call<PushableActivity> getPushableActivityCall(String token) {

        return service.getPushableActivityList(token, 50);

    }

    public Call<AddSubjectToMy> addPushableActCall(String token, long id) {

        return service.addPushableActivityList(token, id);

    }

    public Call<AdImages> getAdListCall(String token) {

        return service.getAdList(token, 30, merchant_id);

    }

    public Call<TeaCircly> getTeaCirclyListCall(String token) {

        return service.getTeaCirclyList(token, 30, merchant_id);

    }

    public Call<NearActivity> getActivityCall(String token) {

        return service.getActivity(token, 30, merchant_id);

    }

    public Call<GustYouLike> getYouLikeCall(String token) {

        return service.getYouLike(token, merchant_id);

    }

    public Call<SystemGoods> getSystemGoodsCall(String token, long category_id, String order, String order_type) {

        return service.getSystemGoods(token, merchant_id, category_id, order, order_type);

    }

    public Call<SystemMessage> getSystemMessageCall(String token) {
        return service.getSystemMessage(token, merchant_id, 30);
    }

    public Call<ShopCommodityListItem> getSystemShopListCall(String token, String order, String order_type) {
        return service.getSystemShopList(token, merchant_id, order, order_type);
    }

    public Call<LittleTip> getLittleTipCall() {
        return service.getLittleTip(6,merchant_id);
    }

    public Call<TeaArtMeeting> getHeadLineNewsCall(String token) {
        return service.getHeadLineNews(token,merchant_id, 10);
    }

    public Call<NewsDetail> getNewsDetailCall(long id) {
        return service.getNewsDetail(id);
    }

    public Observable<ActivityCategory> getActivityCategory(String type, String as_tree) {
        return service.getActivityCategory(type, as_tree).compose(RxsRxSchedulers.<ActivityCategory>io_main());
    }
}
