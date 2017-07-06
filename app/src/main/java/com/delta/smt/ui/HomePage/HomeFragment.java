package com.delta.smt.ui.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.SpUtil;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.Constant;
import com.delta.smt.MainActivity;
import com.delta.smt.R;
import com.delta.smt.app.App;
import com.delta.smt.common.CommonBaseAdapter;
import com.delta.smt.common.CommonViewHolder;
import com.delta.smt.common.DividerGridItemDecoration;
import com.delta.smt.entity.TodoThings;
import com.delta.smt.entity.TodoThingsRv;
import com.delta.smt.entity.home_page.activity.ActivityCategory;
import com.delta.smt.entity.home_page.activity.ActivityCategoryResult;
import com.delta.smt.entity.home_page.home_page_ads.AdImages;
import com.delta.smt.entity.home_page.home_page_ads.AdList;
import com.delta.smt.entity.home_page.home_page_ads.gust_like.GustList;
import com.delta.smt.entity.home_page.home_page_ads.gust_like.GustYouLike;
import com.delta.smt.entity.home_page.home_page_ads.little_tip.LittleTip;
import com.delta.smt.entity.home_page.home_page_ads.near_activity.NearActList;
import com.delta.smt.entity.home_page.home_page_ads.near_activity.NearActivity;
import com.delta.smt.entity.home_page.home_page_ads.news.TeaArtMeeting;
import com.delta.smt.entity.home_page.home_page_ads.news_detail.NewsDetail;
import com.delta.smt.entity.home_page.home_page_ads.tea_circly.TeaCircly;
import com.delta.smt.ui.HomePage.group_purchase.GroupPurchaseActivity;
import com.delta.smt.ui.HomePage.productDetail.ProductDetailActivity;
import com.delta.smt.ui.HomePage.rush_to_purchase.RushToBuyActivity;
import com.delta.smt.ui.HomePage.subjectActivity.SubjectActivityActivity;
import com.delta.smt.ui.HomePage.subjectActivityDetail.SubjectActivityDetailActivity;
import com.delta.smt.ui.HomePage.tea_music.MusicActivity;
import com.delta.smt.ui.HomePage.viewtools.GlideImageLoader;
import com.delta.smt.ui.find.auctionHouse.AuctionHouseActivity;
import com.delta.smt.ui.find.systemShop.SystemShopActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.hwang.library.widgit.SmartRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.functions.Action1;

public class HomeFragment extends Fragment implements CommonBaseAdapter.OnItemClickListener<TodoThingsRv> {

    @BindView(R.id.vp_news)
    Banner banner;
    @BindView(R.id.waiting_to_do_rv)
    RecyclerView mSerialNoRv;
    @BindView(R.id.time_rv)
    RecyclerView time_rv;
    @BindView(R.id.tea_circle_rv)
    RecyclerView tea_circle_rv;
    @BindView(R.id.tea_near_rv)
    RecyclerView tea_near_rv;
    @BindView(R.id.tea_gust_like_rv)
    RecyclerView tea_gust_like_rv;
    @BindView(R.id.tea_one_tv)
    TextView tea_one_tv;
    @BindView(R.id.tea_two_tv)
    TextView tea_two_tv;
    @BindView(R.id.daily_one_tv)
    TextView daily_one_tv;
    @BindView(R.id.daily_two_tv)
    TextView daily_two_tv;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    MainActivity mainActivity;
    TodoThings things;
    Gson gson = new GsonBuilder().
            registerTypeAdapter(Double.class, new JsonSerializer<Double>() {

                @Override
                public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
                    if (src == src.longValue())
                        return new JsonPrimitive(src.longValue());
                    return new JsonPrimitive(src);
                }
            }).create();
    ActivityCategoryResult activityCategoryResult;
    private List<GustList> gustList = new ArrayList<>();
    private CommonBaseAdapter<GustList> gustAdapter;
    private List<com.delta.smt.entity.home_page.home_page_ads.tea_circly.List> teaCirclyList = new ArrayList<>();
    private CommonBaseAdapter<com.delta.smt.entity.home_page.home_page_ads.tea_circly.List> teaCircleadapter;
    private List<TodoThingsRv> todoThingsData = new ArrayList<>();
    private CommonBaseAdapter<TodoThingsRv> todoThingsAdapter;
    private List<TodoThingsRv> timeActData = new ArrayList<>();
    private CommonBaseAdapter<TodoThingsRv> timeActAdapter;
    private List<NearActList> nearActList = new ArrayList<>();
    private CommonBaseAdapter<NearActList> nearActAdapter;
    private String[] titles = {"茶叶汇", "茶器具", "茶点美食", "茶相关", "茶旅"
            , "培训", "品茶", "雅集", "预约喝茶", "品茶雅乐", "敬请期待", ""};
    private int[] images = {R.mipmap.tea_leave2, R.mipmap.tea_tools2, R.mipmap.tea_food2, R.mipmap.tea_about2, R.mipmap.teateravel
            , R.mipmap.train, R.mipmap.tea_tools2, R.mipmap.yaji, R.mipmap.appdreaktea, R.mipmap.tea_music2, 0, 0};

    public HomeFragment() {
    }

    @OnClick(R.id.circly_more)
    public void more() {
        mainActivity.setViewPagerPosition(1, 0, false);
    }

    /*public HomeFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }*/

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView();
        init12Modoule();
        initScrollNews();
        initScrollDaily();
        initTimeAct();
        initTeaCircle();
        initNearAct();
        initGustLike();
        Log.e("token", SpUtil.getStringSF(getActivity(), Constant.TOKEN));
        new HomePageAPIService().getActivityCategory("act", "1").subscribe(new Action1<ActivityCategory>() {
            @Override
            public void call(ActivityCategory activityCategory) {
                if (activityCategory.getApp_code() == 22000) {
                    activityCategoryResult = gson.fromJson(gson.toJson(activityCategory.getResult()), ActivityCategoryResult.class);
                    System.out.println(activityCategoryResult.toString());
                } else {
                    if (!TextUtils.isEmpty(activityCategory.getApp_msg())) {
                        ToastUtils.showMessage(getActivity(), activityCategory.getApp_msg());
                    }
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                if (!TextUtils.isEmpty(throwable.getMessage())) {
                    ToastUtils.showMessage(getActivity(), throwable.getMessage());
                }
            }
        });
        smartRefreshLayout.setOnRefreshListener(new SmartRefreshLayout.onRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                init12Modoule();
                initScrollNews();
                initScrollDaily();
                initTimeAct();
                initTeaCircle();
                initNearAct();
                initGustLike();
                smartRefreshLayout.stopRefresh();
                ToastUtils.showMessage(getActivity(),"刷新成功");
            }

            @Override
            public void onLoadMore() {

            }
        });
        return view;
    }

    private void initGustLike() {

        gustList.clear();

        new HomePageAPIService().getYouLikeCall(SpUtil.getStringSF(getActivity(), Constant.TOKEN)).enqueue(new Callback<GustYouLike>() {
            @Override
            public void onResponse(Call<GustYouLike> call, Response<GustYouLike> response) {
                if (response.body() != null) {
                    if (response.body().getAppCode() == 22000) {
                        gustList.addAll(response.body().getResult().getList());
                        gustAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<GustYouLike> call, Throwable t) {

            }
        });

        gustAdapter = new CommonBaseAdapter<GustList>(getActivity(), gustList) {
            @Override
            protected void convert(CommonViewHolder holder, GustList item, int position) {

                Glide.with(getActivity())
                        .load(item.getImages().get(0).getUrl())
                        .crossFade()
                        .into((ImageView) holder.getView(R.id.iv_commdity_picture));

                holder.setText(R.id.tv_show_commdity_name, item.getTitle());
                holder.setText(R.id.tv_showNowPrice, "当前价：¥" + item.getPrice());
                //TODO 销量字段不存在
                holder.setText(R.id.tv_sale_amount, "销量" + item.getSales());
            }

            @Override
            protected int getItemViewLayoutId(int position, GustList item) {
                if (position % 2 == 0) {
                    return R.layout.item_gust_like_left;
                } else {
                    return R.layout.item_gust_like_right;
                }

            }
        };
        tea_gust_like_rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        tea_gust_like_rv.setAdapter(gustAdapter);

        gustAdapter.setOnItemClickListener(new CommonBaseAdapter.OnItemClickListener<GustList>() {
            @Override
            public void onItemClick(View view, GustList item, int position) {
                IntentUtils.showIntent(getActivity(), com.delta.smt.ui.find.productDetail.ProductDetailActivity.class, new String[]{"product_id", "shop_address"}, new String[]{String.valueOf(item.getId()),item.getMerchant().getShopTitle()});
            }
        });
    }

    private void initNearAct() {

        nearActList.clear();
        new HomePageAPIService().getActivityCall(SpUtil.getStringSF(getActivity(), Constant.TOKEN)).enqueue(new Callback<NearActivity>() {
            @Override
            public void onResponse(Call<NearActivity> call, Response<NearActivity> response) {
                if (response.body() != null) {
                    if (response.body().getAppCode() == 22000) {
                        nearActList.clear();
                        nearActList.addAll(response.body().getResult().getList());
                        nearActAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<NearActivity> call, Throwable t) {

            }
        });

        nearActAdapter = new CommonBaseAdapter<NearActList>(getActivity(), nearActList) {
            @Override
            protected void convert(CommonViewHolder holder, NearActList item, int position) {
                holder.setText(R.id.tv_show_activity_name, item.getTitle());
                holder.setText(R.id.tv_showEnrollAmount, item.getSignNum() + "/" + item.getNumber());

                Glide.with(getActivity())
                        .load(item.getImageUrl())
                        .crossFade()
                        .into((ImageView) holder.getView(R.id.iv_subject_activity));
            }

            @Override
            protected int getItemViewLayoutId(int position, NearActList item) {
                if (position % 2 == 0) {
                    return R.layout.item_near_act_left;
                } else {
                    return R.layout.item_near_act_right;
                }
            }
        };

        tea_near_rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        tea_near_rv.setAdapter(nearActAdapter);

        nearActAdapter.setOnItemClickListener(new CommonBaseAdapter.OnItemClickListener<NearActList>() {
            @Override
            public void onItemClick(View view, NearActList item, int position) {
                IntentUtils.showIntent(getActivity(),
                        SubjectActivityDetailActivity.class,
                        new String[]{"activity_id"},
                        new String[]{String.valueOf(item.getId())});
            }
        });
    }

    private void initTeaCircle() {

        teaCirclyList.clear();

        new HomePageAPIService().getTeaCirclyListCall(SpUtil.getStringSF(getActivity(), Constant.TOKEN)).enqueue(new Callback<TeaCircly>() {
            @Override
            public void onResponse(Call<TeaCircly> call, Response<TeaCircly> response) {
                if (response.body() != null) {
                    teaCirclyList.addAll(response.body().getResult().getList());
                    teaCircleadapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TeaCircly> call, Throwable t) {

            }
        });

        teaCircleadapter = new CommonBaseAdapter<com.delta.smt.entity.home_page.home_page_ads.tea_circly.List>(getContext(), teaCirclyList) {
            @Override
            protected void convert(CommonViewHolder holder, com.delta.smt.entity.home_page.home_page_ads.tea_circly.List item, int position) {

                holder.setText(R.id.name_tv, item.getUser().getName());
                holder.setText(R.id.title_tv, item.getTitle());
                holder.setText(R.id.content_tv, item.getSummary());
                Glide.with(getActivity())
                        .load(item.getUser().getImageUrl())
                        .crossFade()
                        .into((ImageView) holder.getView(R.id.push_able_act_image));

            }

            @Override
            protected int getItemViewLayoutId(int position, com.delta.smt.entity.home_page.home_page_ads.tea_circly.List item) {
                return R.layout.item_tea_circle;
            }
        };

        tea_circle_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        tea_circle_rv.setAdapter(teaCircleadapter);
        teaCircleadapter.setOnItemClickListener(new CommonBaseAdapter.OnItemClickListener<com.delta.smt.entity.home_page.home_page_ads.tea_circly.List>() {
            @Override
            public void onItemClick(View view, com.delta.smt.entity.home_page.home_page_ads.tea_circly.List item, int position) {
                if (item.getScheme().contains("tea99")) {
                    mainActivity.setViewPagerPosition(1, item.getId(), true);
                } else {
                    Intent i = new Intent();
                    i.putExtra("url", item.getScheme() + "?token=" +
                            SpUtil.getStringSF(getActivity(), Constant.TOKEN) + "&id=" + item.getId());
                    i.setClass(getActivity(), WebViewActivity.class);
                    startActivity(i);
                }
            }
        });

    }

    private void initTimeAct() {

        timeActData.clear();
        for (int i = 0; i < 3; i++) {
            TodoThingsRv rv = new TodoThingsRv(titles[i], images[i]);
            timeActData.add(rv);
        }

        timeActAdapter = new CommonBaseAdapter<TodoThingsRv>(getContext(), timeActData) {
            @Override
            protected void convert(CommonViewHolder holder, TodoThingsRv item, int position) {

                switch (position) {

                    case 0:
                        break;
                    case 1:
                        holder.setImageResource(R.id.time_act_im, R.mipmap.pingtuan);
                        holder.setText(R.id.time_act_title, "品质拼团");
                        holder.setText(R.id.time_act_content, "优惠多多 血拼到底");
                        break;
                    case 2:
                        holder.setImageResource(R.id.time_act_im, R.mipmap.purchar);
                        holder.setText(R.id.time_act_title, "拍卖行");
                        holder.setText(R.id.time_act_content, "珍品 孤品值得你拥有");
                        break;
                    default:
                        break;
                }
            }

            @Override
            protected int getItemViewLayoutId(int position, TodoThingsRv item) {
                return R.layout.item_time_act;
            }
        };

        time_rv.addItemDecoration(new DividerGridItemDecoration(getContext()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        time_rv.setLayoutManager(linearLayoutManager);
        time_rv.setAdapter(timeActAdapter);
        timeActAdapter.setOnItemClickListener(new CommonBaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object item, int position) {
                switch (position) {
                    case 0:
                        IntentUtils.showIntent(getActivity(), RushToBuyActivity.class);
                        break;
                    case 1:
                        IntentUtils.showIntent(getActivity(), GroupPurchaseActivity.class);
                        break;
                    case 2:
                        IntentUtils.showIntent(getActivity(), AuctionHouseActivity.class);
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private void initScrollDaily() {

        new HomePageAPIService().getHeadLineNewsCall(SpUtil.getStringSF(getActivity(), Constant.TOKEN)).enqueue(new Callback<TeaArtMeeting>() {
            @Override
            public void onResponse(Call<TeaArtMeeting> call, Response<TeaArtMeeting> response) {
                if (response.body() != null) {
                    if (response.body().getAppCode() == 22000) {
                        for (int i = 0; i < 3; i++) {
                            switch (i) {
                                case 0:
                                    if (response.body().getResult().getList().size() > 0) {
                                        daily_one_tv.setText(response.body().getResult().getList().get(0).getTitle());
                                    }
                                    break;
                                case 1:
                                    if (response.body().getResult().getList().size() > 1) {
                                        daily_two_tv.setText(response.body().getResult().getList().get(1).getTitle());
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<TeaArtMeeting> call, Throwable t) {

            }
        });

    }

    private void initView() {

        new HomePageAPIService().getAdListCall(SpUtil.getStringSF(getActivity(), Constant.TOKEN)).enqueue(new Callback<AdImages>() {
            @Override
            public void onResponse(Call<AdImages> call, Response<AdImages> response) {
                if (response.body() != null) {

                    final List<String> images = new ArrayList<>();
                    final List<String> urls = new ArrayList<>();

                    if (response.body() != null) {
                        for (AdList list : response.body().getResult().getList()) {
                            images.add(list.getImageUrl());
                            urls.add(list.getLink());
                        }
                    }
                    if (images.size() == 0) {
                        images.addAll(App.images);
                    }

                    //设置banner样式
                    banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                    //设置图片加载器
                    banner.setImageLoader(new GlideImageLoader());
                    //设置图片集合
                    banner.setImages(images);
                    //设置banner动画效果
                    banner.setBannerAnimation(Transformer.Default);
                    //设置自动轮播，默认为true
                    banner.isAutoPlay(true);
                    //设置轮播时间
                    banner.setDelayTime(3000);
                    //设置指示器位置（当banner模式中有指示器时）
                    banner.setIndicatorGravity(BannerConfig.CENTER);
                    //banner设置方法全部调用完毕时最后调用
                    banner.start();

                    banner.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            if (urls.size() != 0) {
                                Intent i = new Intent();
                                i.putExtra("url", urls.get(position));
                                i.setClass(getActivity(), WebViewActivity.class);
                                startActivity(i);
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<AdImages> call, Throwable t) {

            }
        });

    }

    private void init12Modoule() {

        todoThingsData.clear();
        for (int i = 0; i < 12; i++) {
            TodoThingsRv rv = new TodoThingsRv(titles[i], images[i]);
            todoThingsData.add(rv);
        }

        todoThingsAdapter = new CommonBaseAdapter<TodoThingsRv>(getContext(), todoThingsData) {
            @Override
            protected void convert(CommonViewHolder holder, TodoThingsRv item, int position) {

                if(position!=10&&position!=11) {
                    holder.setText(R.id.todo_things_tv, item.getTitle());
                    holder.setImageResource(R.id.todo_things_iv, item.getImageUrl());
                }

            }

            @Override
            protected int getItemViewLayoutId(int position, TodoThingsRv item) {
                if(position==10){
                    return R.layout.item_todo_11;
                }if(position==11){
                    return R.layout.item_todo_12;
                }
                return R.layout.item_todo_things;
            }
        };
        todoThingsAdapter.setOnItemClickListener(this);
        mSerialNoRv.setLayoutManager(new GridLayoutManager(getContext(), 4));
        mSerialNoRv.setAdapter(todoThingsAdapter);

        //首页商户代办事项数
        new HomePageAPIService().getSearchBooksCall(SpUtil.getStringSF(getContext(), Constant.TOKEN)).enqueue(new Callback<TodoThings>() {
            @Override
            public void onResponse(Call<TodoThings> call, Response<TodoThings> response) {

                things = response.body();

            }

            @Override
            public void onFailure(Call<TodoThings> call, Throwable t) {

            }
        });
    }

    private void initScrollNews() {

        new HomePageAPIService().getLittleTipCall().enqueue(new Callback<LittleTip>() {
            @Override
            public void onResponse(Call<LittleTip> call, Response<LittleTip> response) {
                if (response.body() != null) {
                    if (response.body().getAppCode() == 22000) {
                        for (int i = 0; i < 3; i++) {
                            switch (i) {
                                case 0:
                                    if (response.body().getResult().getList().size() > 0) {
                                        trentToWebView(tea_one_tv, response, 0);
                                    }
                                    break;
                                case 1:
                                    if (response.body().getResult().getList().size() > 1) {
                                        trentToWebView(tea_two_tv, response, 1);
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<LittleTip> call, Throwable t) {

            }
        });
    }

    private void trentToWebView(TextView textView, final Response<LittleTip> response, final int num) {
        textView.setText(response.body().getResult().getList().get(num).getContent());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("~~~","点击了按钮");
                Log.e("~~~",response.body().getResult().getList().get(num).getId()+"");
                new HomePageAPIService().getNewsDetailCall(response.body().getResult().getList().get(num).getId()).enqueue(new Callback<NewsDetail>() {
                    @Override
                    public void onResponse(Call<NewsDetail> call, Response<NewsDetail> response) {
                        Log.e("~~~","收到了内容");
                        if (response.body() != null) {
                            try {
                                Intent i = new Intent();
                                i.putExtra("url", response.body().getResult().getNews().getContent());
                                i.putExtra("title", response.body().getResult().getNews().getTitle());
                                i.setClass(getActivity(), NewsDetailActivity.class);
                                startActivity(i);
                                Log.e("~~~","成功跳转了");
                            }catch (Exception e){
                                ToastUtils.showMessage(getActivity(),"获取新闻详情失败，请联系管理员");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsDetail> call, Throwable t) {

                    }
                });
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onItemClick(View view, TodoThingsRv item, int position) {

        Intent i = new Intent();
        Bundle b = new Bundle();
        switch (position) {
            case 0:
                IntentUtils.showIntent(getActivity(), SystemShopActivity.class, new String[]{"tea_classify"}, new String[]{"茶叶汇"});
                break;
            case 1:
                IntentUtils.showIntent(getActivity(), SystemShopActivity.class, new String[]{"tea_classify"}, new String[]{"茶器具"});
                break;
            case 2:
                IntentUtils.showIntent(getActivity(), SystemShopActivity.class, new String[]{"tea_classify"}, new String[]{"茶点茶食"});
                break;
            case 3:
                IntentUtils.showIntent(getActivity(), SystemShopActivity.class, new String[]{"tea_classify"}, new String[]{"茶相关"});
                break;
            case 4:
                IntentUtils.showIntent(getActivity(), SubjectActivityActivity.class, new String[]{"category_id", "title"}, new String[]{getActivityCategoryId("茶旅") + "", "茶旅"});
                break;
            case 5:
                IntentUtils.showIntent(getActivity(), SubjectActivityActivity.class, new String[]{"category_id", "title"}, new String[]{getActivityCategoryId("培训") + "", "培训"});
                break;
            case 6:
                IntentUtils.showIntent(getActivity(), SubjectActivityActivity.class, new String[]{"category_id", "title"}, new String[]{getActivityCategoryId("品茶") + "", "品茶"});
                break;
            case 7:
                IntentUtils.showIntent(getActivity(), SubjectActivityActivity.class, new String[]{"category_id", "title"}, new String[]{getActivityCategoryId("雅集") + "", "雅集"});
                break;
            case 8:
                mainActivity.dreakTea();
                break;
            case 9:
                i.setClass(getContext(), MusicActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
    }

    public int getActivityCategoryId(String category_name) {
        for (int i = 0; i < activityCategoryResult.getList().size(); i++) {
            if (category_name.equals(activityCategoryResult.getList().get(i).getName())) {
                return activityCategoryResult.getList().get(i).getId();
            }
        }
        return -1;
    }
}
