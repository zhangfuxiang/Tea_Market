package com.delta.smt.ui.HomePage;

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
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Shaoqiang.Zhang on 2017/4/10.
 */

public interface HomePageAPI {

    @GET("api/merchant/manage/getUndo")
    Call<TodoThings> getTodoThingsCount(@Query("token") String token);

    @GET("api/merchant/bespeak/getList")
    Call<AppointmentStoreDetail> getAppointmentDetail(@Query("token") String token, @Query("size") int size);

    @GET("api/merchant/bespeak/arrive")
    Call<ArriveResoult> arriveStore(@Query("token") String token, @Query("bespeak_id") int bespeak_id);

    @GET("api/merchant/consult/getList")
    Call<ReferBuy> getReferBuyList(@Query("token") String token, @Query("size") int size);

    @GET("api/merchant/activity/getList")
    Call<PushableActivity> getPushableActivityList(@Query("token") String token, @Query("size") int size);

    @GET("/api/merchant/activity/addMy")
    Call<AddSubjectToMy> addPushableActivityList(@Query("token") String token, @Query("activity_id") long id);

    @GET("/api/ad/getList")
    Call<AdImages> getAdList(@Query("token") String token, @Query("size") long size, @Query("merchant_id") long merchant_id);

    @GET("/api/circle/getTopList")
    Call<TeaCircly> getTeaCirclyList(@Query("token") String token, @Query("size") long size, @Query("merchant_id") long merchant_id);

    @GET("/api/customer/act/recommand")
    Call<NearActivity> getActivity(@Query("token") String token, @Query("size") long size, @Query("merchant_id") long merchant_id);

    @GET("/api/customer/product/recommand")
    Call<GustYouLike> getYouLike(@Query("token") String token, @Query("merchant_id") long merchant_id);

    @GET("/api/customer/product/getList")
    Call<SystemGoods> getSystemGoods(@Query("token") String token, @Query("merchant_id") long merchant_id, @Query("category_id") long category_id, @Query("order") String order, @Query("order_type") String order_type);

    @GET("/api/message/getList")
    Call<SystemMessage> getSystemMessage(@Query("token") String token, @Query("merchant_id") long merchant_id, @Query("size") long size);

    @GET("/api/customer/product/getList")
    Call<ShopCommodityListItem> getSystemShopList(@Query("token") String token, @Query("merchant_id") long merchant_id, @Query("order") String order, @Query("order_type") String order_type);

    @GET("/api/tips/recommand")
    Call<LittleTip> getLittleTip(@Query("num") long num, @Query("merchant_id") long merchant_id);

    @GET("/api/app/meetList")
    Call<TeaArtMeeting> getHeadLineNews(@Query("token") String token, @Query("merchant_id") long merchant_id, @Query("size") int size);

    @GET("/api/merchant/news/detail")
    Call<NewsDetail> getNewsDetail(@Query("news_id") long id);

    @GET("/api/category/getList")
    Observable<ActivityCategory> getActivityCategory(@Query("type") String type, @Query("as_tree") String as_tree);
}
