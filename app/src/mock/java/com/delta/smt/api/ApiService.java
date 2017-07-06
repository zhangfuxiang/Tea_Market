package com.delta.smt.api;


import com.delta.smt.entity.AddAddress;
import com.delta.smt.entity.AddSubjectToMy;
import com.delta.smt.entity.AuctionHouseListItem;
import com.delta.smt.entity.Brands;
import com.delta.smt.entity.ItemAddressDetail;
import com.delta.smt.entity.ItemBean;
import com.delta.smt.entity.ItemLocation;
import com.delta.smt.entity.ItemReceiveAddress;
import com.delta.smt.entity.LoginResult;
import com.delta.smt.entity.OrderOtherListItem;
import com.delta.smt.entity.RegisterResult;
import com.delta.smt.entity.ResetPwdResult;
import com.delta.smt.entity.SendCodeResult;
import com.delta.smt.entity.StartResult;
import com.delta.smt.entity.SubjectActivityDetailResult;
import com.delta.smt.entity.SubjectActivityListItem;
import com.delta.smt.entity.User;
import com.delta.smt.entity.UserCLoginResult;
import com.delta.smt.entity.UserLoginResult;
import com.delta.smt.entity.cart.Cart;
import com.delta.smt.entity.cart.SetCartAmountResult;

import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;


/**
 * Created by Administrator on 2016/3/23.
 */
public interface ApiService {
    //@POST("ams/library/user/login2")
    Observable<LoginResult> login(@Body User user);

    @GET("http://tea.api.test.sygcsoft.com/api/merchant/app/start")
    Observable<StartResult> start(@Query("client") String client,
                                  @Query("client_version") String client_version,
                                  @Query("os") String os,
                                  @Query("os_token") String os_token,
                                  @Query("api_version") String api_version);

    @GET("v2/items")
    Observable<Brands> getBrands(@QueryMap Map<String, String> map);

    Observable<RegisterResult> login(@Body String str);

    @GET("http://tea.api.test.sygcsoft.com/api/merchant/user/resgietrTest")
    Observable<RegisterResult> register(@Query("client") String client,
                                        @Query("client_version") String client_version,
                                        @Query("os") String os,
                                        @Query("os_token") String os_token,
                                        @Query("api_version") String api_version,
                                        @Query("shop_title") String shop_title,
                                        @Query("phone") String phone,
                                        @Query("password") String password,
                                        @Query("name") String name);

    @GET("http://tea.api.test.sygcsoft.com/api/merchant/user/sendCode")
    Observable<SendCodeResult> sendCode(@Query("client") String client,
                                        @Query("client_version") String client_version,
                                        @Query("os") String os,
                                        @Query("os_token") String os_token,
                                        @Query("api_version") String api_version,
                                        @Query("phone") String phone,
                                        @Query("type") String type);

    @GET("http://tea.api.test.sygcsoft.com/api/merchant/user/resetPwd")
    Observable<ResetPwdResult> resetPwd(@Query("client") String client,
                                        @Query("client_version") String client_version,
                                        @Query("os") String os,
                                        @Query("os_token") String os_token,
                                        @Query("api_version") String api_version,
                                        @Query("phone") String phone,
                                        @Query("password") String password,
                                        @Query("code") String code);

    @GET("http://tea.api.test.sygcsoft.com/api/merchant/user/login")
    Observable<UserLoginResult> login(@Query("client") String client,
                                      @Query("client_version") String client_version,
                                      @Query("os") String os,
                                      @Query("os_token") String os_token,
                                      @Query("api_version") String api_version, @Query("phone") String phone, @Query("password") String password);

    @GET("http://tea.api.test.sygcsoft.com/api/merchant/activity/getList")
    Observable<SubjectActivityListItem> getSubjectActivityList(
            @Query("client") String client,
            @Query("client_version") String client_version,
            @Query("os") String os,
            @Query("os_token") String os_token,
            @Query("api_version") String api_version,
            @Query("token") String token,
            @Query("page") String page,
            @Query("size") String size,
            @Query("start_date") String start_date);


    @GET("http://tea.api.test.sygcsoft.com/api/merchant/activity/detail")
    Observable<SubjectActivityDetailResult> getSubjectActivityDetail(
            @Query("client") String client,
            @Query("client_version") String client_version,
            @Query("os") String os,
            @Query("os_token") String os_token,
            @Query("api_version") String api_version,
            @Query("token") String token,
            @Query("activity_id") String activity_id);

    @GET("http://tea.api.test.sygcsoft.com/api/merchant/activity/addMy")
    Observable<AddSubjectToMy> addSubjectToMy(
            @Query("client") String client,
            @Query("client_version") String client_version,
            @Query("os") String os,
            @Query("os_token") String os_token,
            @Query("api_version") String api_version,
            @Query("token") String token,
            @Query("activity_id") String activity_id
    );

    Observable<AuctionHouseListItem> getAuctionList();

    Observable<SubjectActivityListItem> getSubjectList();

    Observable<OrderOtherListItem> getOrderOtherList();

    @GET("http://tea.api.test.sygcsoft.com/api/customer/user/sendCode")
    Observable<SendCodeResult> sendCodeC(@Query("phone") String phone,
                                         @Query("type") String type);

    @GET("http://tea.api.test.sygcsoft.com/api/customer/user/login")
    Observable<UserCLoginResult> loginC(@Query("phone") String phone, @Query("code") String code, @Query("merchant_id") String merchant_id);

    /**
     * @description :收货地址管理
     * @author : Fuxiang.Zhang
     * @date : 2017/5/8 22:32
     */

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/add")
    Observable<AddAddress> addReceiveAddress(
            @Query("token") String token,
            @Query("location_id") String location_id,
            @Query("phone") String phone,
            @Query("name") String name,
            @Query("address") String address,
            @Query("default") String defaultAdress
    );

    @GET("http://tea.api.test.sygcsoft.com/api/location/getAll?as_tree=1")
    Observable<ItemLocation> getLocation();

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/getList")
    Observable<ItemReceiveAddress> getReceiveAddress(@Query("token") String token);

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/del")
    Observable<ItemBean> deleteAddress(
            @Query("token") String token,
            @Query("address_id") int location_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/detail")
    Observable<ItemAddressDetail> getAddressDetail(
            @Query("token") String token,
            @Query("address_id") int location_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/update")
    Observable<AddAddress> editReceiveAddress(
            @Query("token") String token,
            @Query("location_id") int location_id,
            @Query("name") String name,
            @Query("phone") String phone,
            @Query("address") String address,
            @Query("default") int defaultAdress,
            @Query("address_id") int address_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/cart/get")
    Observable<Cart> getCart(@Query("token") String token);

    @GET("http://tea.api.test.sygcsoft.com/api/cart/set")
    Observable<SetCartAmountResult> setCartAmount(@Query("token") String token, @Query("product_id") String product_id, @Query("num") String num);

}
