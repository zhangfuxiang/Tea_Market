
package com.delta.smt.entity.home_page.home_page_ads.news_detail;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Result {

    @SerializedName("news")
    private News mNews;

    public News getNews() {
        return mNews;
    }

    public void setNews(News news) {
        mNews = news;
    }

}
