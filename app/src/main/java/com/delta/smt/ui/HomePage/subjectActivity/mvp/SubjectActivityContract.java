package com.delta.smt.ui.HomePage.subjectActivity.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.home_page.activity.ActivityList;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/19.
 */

public interface SubjectActivityContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onSujectListSuccess(ActivityList item);

        void onSujectListfailed(ActivityList item);

        void onSujectListfailed(Throwable throwable);

        void onSujectListLoadMoreSuccess(ActivityList item);

        void onSujectListLoadMorefailed(ActivityList item);

        void onSujectListRefreshSuccess(ActivityList item);

        void onSujectListRefreshfailed(ActivityList item);

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ActivityList> getSubjectActivityList(
                String token,
                String is_on_time,
                String page,
                String size,
                String category_id,
                String status,
                String merchant_id);
    }
}