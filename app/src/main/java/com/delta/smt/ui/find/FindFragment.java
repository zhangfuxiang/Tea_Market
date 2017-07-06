package com.delta.smt.ui.find;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delta.commonlibs.utils.IntentUtils;
import com.delta.commonlibs.utils.ToastUtils;
import com.delta.smt.R;
import com.delta.smt.ui.find.auctionHouse.AuctionHouseActivity;
import com.delta.smt.ui.find.systemShop.SystemShopActivity;
import com.delta.smt.ui.find.viewtools.GlideImageLoader;
import com.makeramen.roundedimageview.RoundedImageView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wushufeng on 2017/3/16.
 */

public class FindFragment extends Fragment implements OnBannerListener {
    Banner banner;

    String[] urls;
    String[] line2Urls;
    String[] line2Texts;

    String[] line3Urls;
    String[] line3Texts;

    @BindView(R.id.enter_auction_house)
    AutoLinearLayout enterAuctionHouse;

    @BindView(R.id.line2_recommend1)
    RoundedImageView line2Recommend1;
    @BindView(R.id.line2_recommend2)
    RoundedImageView line2Recommend2;
    @BindView(R.id.tv_line2_recommend1)
    TextView tvLine2Recommend1;
    @BindView(R.id.tv_line2_recommend2)
    TextView tvLine2Recommend2;

    @BindView(R.id.enter_subject_activity)
    AutoLinearLayout enterSubjectActivity;

    @BindView(R.id.line3_recommend1)
    RoundedImageView line3Recommend1;
    @BindView(R.id.line3_recommend2)
    RoundedImageView line3Recommend2;
    @BindView(R.id.tv_line3_recommend1)
    TextView tvLine3Recommend1;
    @BindView(R.id.tv_line3_recommend2)
    TextView tvLine3Recommend2;

    @BindView(R.id.btn_tea_leaf)
    AutoRelativeLayout btnTeaLeaf;
    @BindView(R.id.btn_tea_tools)
    AutoRelativeLayout btnTeaTools;
    @BindView(R.id.btn_tea_food)
    AutoRelativeLayout btnTeaFood;
    @BindView(R.id.btn_tea_about)
    AutoRelativeLayout btnTeaAbout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        ButterKnife.bind(this, view);

        line2Recommend1.setCornerRadius((float) 10);
        line2Recommend1.setBorderWidth((float) 0);
        line2Recommend2.setCornerRadius((float) 10);
        line2Recommend2.setBorderWidth((float) 0);
        line3Recommend1.setCornerRadius((float) 10);
        line3Recommend1.setBorderWidth((float) 0);
        line3Recommend2.setCornerRadius((float) 10);
        line3Recommend2.setBorderWidth((float) 0);

        // Inflate the layout for this fragment
        urls = new String[]{
                "http://bizhi.zhuoku.com/wall/20060710/tea013.jpg",
                "http://bizhi.zhuoku.com/wall/20060710/tea009.jpg",
                "http://bizhi.zhuoku.com/wall/20060710/tea014.jpg",
                "http://bizhi.zhuoku.com/wall/20060710/tea024.jpg"
        };
        line2Urls = new String[]{
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489785069728&di=a32ea66b793616479c12dc84e5e94af7&imgtype=0&src=http%3A%2F%2Fattach.mapshow.cn%2F2014%2F0109%2F20140109092835359.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489785069728&di=a32ea66b793616479c12dc84e5e94af7&imgtype=0&src=http%3A%2F%2Fattach.mapshow.cn%2F2014%2F0109%2F20140109092835359.jpg"
        };

        line3Urls = new String[]{
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489785069728&di=a32ea66b793616479c12dc84e5e94af7&imgtype=0&src=http%3A%2F%2Fattach.mapshow.cn%2F2014%2F0109%2F20140109092835359.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1489785069728&di=a32ea66b793616479c12dc84e5e94af7&imgtype=0&src=http%3A%2F%2Fattach.mapshow.cn%2F2014%2F0109%2F20140109092835359.jpg"
        };

        line2Texts = new String[]{
                "武夷岩茶 ZHP0860-1 25 2016春茶",
                "武夷岩茶 ZHP0860-1 25 2016春茶"
        };
        line3Texts = new String[]{
                "武夷岩茶 春季采茶节活动",
                "武夷岩茶 春季采茶节活动"
        };


        banner = (Banner) view.findViewById(R.id.banner);
        banner.setOnBannerListener(this);
        showRecommendPager(banner, urls);
        loadLine2Content(line2Urls, line2Texts);
        loadLine3Content(line3Urls, line3Texts);

        return view;
    }

    public void showRecommendPager(Banner banner, String[] strs) {
        List<?> images = new ArrayList<>();
        List list = Arrays.asList(strs);
        images = new ArrayList(list);
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
    }

    public void loadLine2Content(String[] ivUrls, String[] text) {
        Glide.with(this).load(ivUrls[0]).crossFade().into(line2Recommend1);
        Glide.with(this).load(ivUrls[1]).crossFade().into(line2Recommend2);
        tvLine2Recommend1.setText(text[0]);
        tvLine2Recommend2.setText(text[1]);
    }

    public void loadLine3Content(String[] ivUrls, String[] text) {
        Glide.with(this).load(ivUrls[0]).crossFade().into(line3Recommend1);
        Glide.with(this).load(ivUrls[1]).crossFade().into(line3Recommend2);
        tvLine3Recommend1.setText(text[0]);
        tvLine3Recommend2.setText(text[1]);
    }

    @OnClick({R.id.enter_auction_house, R.id.enter_subject_activity, R.id.btn_tea_leaf, R.id.btn_tea_tools, R.id.btn_tea_food, R.id.btn_tea_about})
    void onClick(View v) {
        if (v.getId() == R.id.enter_auction_house) {
            IntentUtils.showIntent(getActivity(), AuctionHouseActivity.class);
        } else if (v.getId() == R.id.enter_subject_activity) {

        } else {
            IntentUtils.showIntent(getActivity(), SystemShopActivity.class);
        }
    }

    @Override
    public void OnBannerClick(int position) {
        ToastUtils.showMessage(getActivity(), position + "");
    }
}
