package com.delta.smt.api;


import com.delta.smt.entity.AddMyShopResult;
import com.delta.smt.entity.AddSubjectToMy;
import com.delta.smt.entity.AddToCartResult;
import com.delta.smt.entity.AuctionHouseListItem;
import com.delta.smt.entity.BlanceDetailResult;
import com.delta.smt.entity.Brands;
import com.delta.smt.entity.ChargeResult;
import com.delta.smt.entity.ItemBean1;
import com.delta.smt.entity.LoginResult;
import com.delta.smt.entity.MerchantInfo;
import com.delta.smt.entity.MyActivity;
import com.delta.smt.entity.MyAppointResult;
import com.delta.smt.entity.OrderOtherListItem;
import com.delta.smt.entity.ProductDetail;
import com.delta.smt.entity.RegisterResult;
import com.delta.smt.entity.ResetPwdResult;
import com.delta.smt.entity.SendCodeResult;
import com.delta.smt.entity.ShopCommodityListItem;
import com.delta.smt.entity.StartResult;
import com.delta.smt.entity.SubjectActivityDetailResult;
import com.delta.smt.entity.SubjectActivityListItem;
import com.delta.smt.entity.User;
import com.delta.smt.entity.UserCLoginResult;
import com.delta.smt.entity.UserInfo;
import com.delta.smt.entity.UserLoginResult;
import com.delta.smt.entity.cart.AddressAreaResult;
import com.delta.smt.entity.cart.Cart;
import com.delta.smt.entity.cart.CartRemoveResult;
import com.delta.smt.entity.cart.DefaultAddressResult;
import com.delta.smt.entity.cart.DeleteUserAddress;
import com.delta.smt.entity.cart.NewAddressResult;
import com.delta.smt.entity.cart.PayOrder;
import com.delta.smt.entity.cart.SetCartAmountResult;
import com.delta.smt.entity.cart.SubmitOrder;
import com.delta.smt.entity.cart.UpdateUserAddress;
import com.delta.smt.entity.cart.UserAddressList;
import com.delta.smt.entity.drinktea.OrderThis;
import com.delta.smt.entity.drinktea.ShopList;
import com.delta.smt.entity.drinktea.UserAddress;
import com.delta.smt.entity.home_page.activity.ActivityCancelResult;
import com.delta.smt.entity.home_page.activity.ActivityDetail;
import com.delta.smt.entity.home_page.activity.ActivityList;
import com.delta.smt.entity.home_page.activity.ActivitySignUpResult;
import com.delta.smt.entity.home_page.home_page_ads.classify_goods.ProductCategoryListResult;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
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

    @GET("http://tea.api.test.sygcsoft.com/api/customer/product/detail")
    Observable<ProductDetail> getProductDetail(@Query("token") String token,
                                               @Query("product_id") String product_id, @Query("merchant_id") String stringSF);

    @GET("http://tea.api.test.sygcsoft.com/api/merchant/systemshop/product/addMyShop")
    Observable<AddMyShopResult> getAddMyShopResult(@Query("token") String token,
                                                   @Query("product_id") String product_id/*,
                                                   @Query("price") String price*/);

    @GET("http://tea.api.test.sygcsoft.com/api/cart/add")
    Observable<AddToCartResult> addToCartResult(@Query("token") String token, @Query("product_id") String product_id, @Query("num") String num);


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
    Observable<SendCodeResult> sendCodeC(
            @Query("merchant_id") String merchant_id,
            @Query("phone") String phone,
            @Query("type") String type);

    @GET("http://tea.api.test.sygcsoft.com/api/customer/user/login")
    Observable<UserCLoginResult> loginC(@Query("phone") String phone, @Query("code") String code, @Query("merchant_id") String merchant_id);


    /**
     * @description :收货地址api
     * @author : Fuxiang.Zhang
     * @date : 2017/5/8 22:32
     */

    //上传文件
    @Multipart
    @POST("http://tea.api.test.sygcsoft.com/api/upload/image")
    Observable<ResponseBody> submitImage(@Query("token") String token, @Part MultipartBody.Part file);

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/add")
    Observable<ResponseBody> addReceiveAddress(
            @Query("token") String token,
            @Query("location_id") String location_id,
            @Query("phone") String phone,
            @Query("name") String name,
            @Query("address") String address,
            @Query("default") String defaultAdress
    );

    @GET("http://tea.api.test.sygcsoft.com/api/location/getAll?as_tree=1")
    Observable<ResponseBody> getLocation();

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/getList")
    Observable<ResponseBody> getReceiveAddress(@Query("token") String token);

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/del")
    Observable<ResponseBody> deleteAddress(
            @Query("token") String token,
            @Query("address_id") int location_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/detail")
    Observable<ResponseBody> getAddressDetail(
            @Query("token") String token,
            @Query("address_id") int location_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/update")
    Observable<ResponseBody> editReceiveAddress(
            @Query("token") String token,
            @Query("location_id") int location_id,
            @Query("name") String name,
            @Query("phone") String phone,
            @Query("address") String address,
            @Query("default") String defaultAdress,
            @Query("address_id") int address_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/update")
    Observable<ResponseBody> editDefaultAddress(
            @Query("token") String token,
            @Query("default") String defaultAdress,
            @Query("address_id") int address_id
    );

    /**
     * @description :我的订单api
     * @author : Fuxiang.Zhang
     * @date : 2017/5/13 20:14
     */

    @GET("http://tea.api.test.sygcsoft.com/api/order/getList")
    Observable<ResponseBody> getMyOrderList(
            @Query("token") String token,
            @Query("pay_status") String pay_status,
            @Query("deliver_status") String deliver_status,
            @Query("page") String page,
            @Query("size") String size

    );

    @GET("http://tea.api.test.sygcsoft.com/api/order/getList")
    Observable<ResponseBody> getUnpaymentList(
            @Query("token") String token,
            @Query("pay_status") String pay_status,
            @Query("deliver_status") String deliver_status,
            @Query("page") String page,
            @Query("size") String size

    );

    @GET("http://tea.api.test.sygcsoft.com/api/order/getList")
    Observable<ResponseBody> getNOReceiveList(
            @Query("token") String token,
            @Query("pay_status") String pay_status,
            @Query("deliver_status") String deliver_status,
            @Query("size") String size

    );

    @GET("http://tea.api.test.sygcsoft.com/api/order/takeDelivery")
    Observable<ResponseBody> confirmReceive(@QueryMap Map<String, String> queryMap);


    @GET("http://tea.api.test.sygcsoft.com/api/order/getList")
    Observable<ResponseBody> getNoSendList(
            @Query("token") String token,
            @Query("pay_status") String pay_status,
            @Query("deliver_status") String deliver_status,
            @Query("page") String page,
            @Query("size") String size

    );

    @GET("http://tea.api.test.sygcsoft.com/api/order/cancel")
    Observable<ResponseBody> cancelOrder(
            @Query("token") String token,
            @Query("order_id") String order_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/order/pay")
    Observable<ResponseBody> payOrder(
            @QueryMap Map<String, String> queryMap
    );

    @GET("http://tea.api.test.sygcsoft.com/api/order/detail")
    Observable<ResponseBody> getOrderDetail(
            @Query("token") String token,
            @Query("order_id") String order_id
    );


    /**
     * @description :设置模块api
     * @author : Fuxiang.Zhang
     * @date : 2017/5/20 14:35
     */

    @GET("http://tea.api.test.sygcsoft.com/api/app/suggest")
    Observable<ItemBean1> submitAdvice(@QueryMap Map<String, String> queryMap);


    @GET("http://tea.api.test.sygcsoft.com/api/user/info")
    Observable<ResponseBody> getPersonInformation(
            @Query("token") String token
    );

    @GET("http://tea.api.test.sygcsoft.com/api/user/update")
    Observable<ResponseBody> updatePersonInformation(
            @QueryMap Map<String, String> querymap);


    //不用
    @GET("http://tea.api.test.sygcsoft.com/api/cart/get")
    Observable<Cart> getCart(@Query("token") String token);

    @GET("http://tea.api.test.sygcsoft.com/api/cart/get")
    Observable<Cart> getCartList(@Query("token") String token, @Query("merchant_id") String merchant_id);

    @GET("http://tea.api.test.sygcsoft.com/api/cart/set")
    Observable<SetCartAmountResult> setCartAmount(@Query("token") String token, @Query("merchant_id") String merchant_id, @Query("product_id") String product_id, @Query("num") String num);

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/getDefault")
    Observable<DefaultAddressResult> getDefaultAddress(@Query("token") String token, @Query("merchant_id") String merchant_id);

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/add")
    Observable<NewAddressResult> addUserAddress(@Query("token") String token,
                                                @Query("merchant_id") String merchant_id,
                                                @Query("location_id") String location_id,
                                                @Query("phone") String phone,
                                                @Query("name") String name,
                                                @Query("address") String address,
                                                @Query("default") String def);

    @GET("http://tea.api.test.sygcsoft.com/api/location/getAll")
    Observable<AddressAreaResult> getAddressArea(@Query("as_tree") String as_tree);

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/del")
    Observable<DeleteUserAddress> deleteUserAddress(@Query("token") String token,
                                                    @Query("merchant_id") String merchant_id,
                                                    @Query("address_id") String address_id);

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/update")
    Observable<UpdateUserAddress> updateUserAddress(@Query("token") String token,
                                                    @Query("merchant_id") String merchant_id,
                                                    @Query("location_id") String location_id,
                                                    @Query("name") String name,
                                                    @Query("phone") String phone,
                                                    @Query("address") String address,
                                                    @Query("default") String def,
                                                    @Query("address_id") String address_id);

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/getList")
    Observable<UserAddressList> getMyAddressList(@Query("token") String token, @Query("merchant_id") String merchant_id);

    @GET("http://tea.api.test.sygcsoft.com/api/shop/getList")
    Observable<ShopList> getShopList(@Query("token") String token,
                                     @Query("merchant_id") String merchant_id,
                                     @Query("page") String page,
                                     @Query("size") String size,
                                     @Query("keyword") String keyword,
                                     @Query("is_current") String is_current);

    @GET("http://tea.api.test.sygcsoft.com/api/shop/bespeak")
    Observable<OrderThis> bespeakShop(@Query("token") String token,
                                      @Query("merchant_id") String merchant_id,
                                      @Query("room_num") String room_num,
                                      @Query("shop_id") String shop_id,
                                      @Query("start_time") String start_time,
                                      @Query("end_time") String end_time,
                                      @Query("comment") String comment);

    @GET("http://tea.api.test.sygcsoft.com/api/userAddress/getList")
    Observable<UserAddress> getUserAddressList(@Query("token") String token, @Query("merchant_id") String merchant_id);

    @GET
    Observable<SubmitOrder> submitOrder(@Url String url);

    @GET("http://tea.api.test.sygcsoft.com/api/order/pay")
    Observable<PayOrder> payOrder(@Query("token") String token, @Query("merchant_id") String merchant_id,
                                  @Query("order_ids") String order_ids,
                                  @Query("pay_type") String pay_type,
                                  @Query("pay_pwd") String pay_pwd);

    /**
     * Personal
     *
     * @param token
     * @param merchant_id
     * @return
     */
    @GET("http://tea.api.test.sygcsoft.com/api/user/info")
    Observable<UserInfo> getUserInfo(@Query("token") String token, @Query("merchant_id") String merchant_id);

    @GET("http://tea.api.test.sygcsoft.com/api/balance/getDetails")
    Observable<BlanceDetailResult> getBlanceDetail(@Query("token") String token, @Query("merchant_id") String merchanId, @Query("type") int type, @Query("page") int page, @Query("size") int size);

    @GET("http://tea.api.test.sygcsoft.com/api/customer/act/myList")
    Observable<MyActivity> getPersonalActivity(@Query("token") String token, @Query("merchant_id") String merchanId, @Query("status") int type, @Query("page") int page, @Query("size") int size);

    @GET("http://tea.api.test.sygcsoft.com/api/shop/myBespeak")
    Observable<MyAppointResult> getPersonalAppoint(@Query("token") String token, @Query("merchant_id") String merchanId, @Query("status") int type, @Query("page") int page, @Query("size") int size);

    @GET("http://tea.api.test.sygcsoft.com/api/shop/cancel")
    Observable<ResponseBody> cancelAppointMent(@QueryMap Map<String, String> queryMap);

    @GET("http://tea.api.test.sygcsoft.com/api/shop/arrive")
    Observable<ResponseBody> arrive(@QueryMap Map<String, String> queryMap1);

    @GET("http://tea.api.test.sygcsoft.com/api/balance/rechargeMap")
    Observable<ChargeResult> getChargeList(@QueryMap Map<String, String> queryMap);

    @GET("http://tea.api.test.sygcsoft.com/api/balance/recharge")
    Observable<ResponseBody> chargePay(@QueryMap Map<String, String> queryMap);

    @GET("http://tea.api.test.sygcsoft.com/api/user/changePhone")
    Observable<ResponseBody> changePhone(@QueryMap Map<String, String> stringStringMap);

    @GET("http://tea.api.test.sygcsoft.com/api/user/setPayPwd")
    Observable<ResponseBody> modifyChargePassword(@QueryMap Map<String, String> stringStringMap);

    @GET("http://tea.api.test.sygcsoft.com/api/user/checkPayPwd")
    Observable<ResponseBody> checkPayPwd(@QueryMap Map<String, String> stringStringMap);

    @GET("http://tea.api.test.sygcsoft.com/api/user/checkCode")
    Observable<ResponseBody> checkCode(@QueryMap Map<String, String> stringStringMap);

    @GET("http://tea.api.test.sygcsoft.com/api/merchantInfo/info")
    Observable<MerchantInfo> getMerchantInfo(@QueryMap Map<String, String> stringStringMap);

    @GET("http://tea.api.test.sygcsoft.com/api/user/pay")
    Observable<ResponseBody> pay(@QueryMap Map<String, String> stringStringMap);

    @GET("http://tea.api.test.sygcsoft.com/api/category/getList")
    Observable<ProductCategoryListResult> getProductCategoryList(@Query("type") String type, @Query("as_tree") String as_tree, @Query("merchant_id") long merchant_id);

    @GET("http://tea.api.test.sygcsoft.com/api/customer/product/getList")
    Observable<ShopCommodityListItem> getCommodityList(@Query("token") String token,
                                                       @Query("page") String page,
                                                       @Query("size") String size,
                                                       @Query("allow_other_sale") String allow_other_sale,
                                                       @Query("category_id") String category_id,
                                                       @Query("order") String order,
                                                       @Query("order_type") String order_type,
                                                       @Query("merchant_id") long merchant_id);

    @GET("http://tea.api.test.sygcsoft.com/api/withdraw/submit")
    Observable<ResponseBody> withdraw(@QueryMap Map<String, String> stringObjectMap);


    @GET("http://tea.api.test.sygcsoft.com/api/customer/product/getList")
    Observable<ShopCommodityListItem> searchGoods(@Query("token") String token,
                                                  @Query("page") String page,
                                                  @Query("size") String size,
                                                  @Query("merchant_id") long merchant_id,
                                                  @Query("keyword") String keyword);

    //活动列表
    @GET("http://tea.api.test.sygcsoft.com/api/customer/act/getList")
    Observable<ActivityList> getSubjectActivityList(
            @Query("token") String token,
            @Query("is_on_time") String is_on_time,
            @Query("page") String page,
            @Query("size") String size,
            @Query("category_id") String category_id,
            @Query("status") String status,
            @Query("merchant_id") String merchant_id);


    //活动详情
    @GET("http://tea.api.test.sygcsoft.com/api/customer/act/detail")
    Observable<ActivityDetail> getSubjectActivityDetail(
            @Query("token") String token,
            @Query("act_id") String act_id,
            @Query("merchant_id") String merchant_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/customer/act/signUp")
    Observable<ActivitySignUpResult> signUpActivity(
            @Query("token") String token,
            @Query("act_id") String act_id,
            @Query("pay_type") String pay_type,
            @Query("pay_pwd") String pay_pwd,
            @Query("merchant_id") String merchant_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/customer/act/cancel")
    Observable<ActivityCancelResult> cancelActivity(
            @Query("token") String token,
            @Query("id") String id,
            @Query("merchant_id") String merchant_id
    );

    @GET("http://tea.api.test.sygcsoft.com/api/cart/remove")
    Observable<CartRemoveResult> removeCart(@Query("token") String token,
                                            @Query("product_ids") String product_ids,
                                            @Query("merchant_id") String merchant_id);
}

