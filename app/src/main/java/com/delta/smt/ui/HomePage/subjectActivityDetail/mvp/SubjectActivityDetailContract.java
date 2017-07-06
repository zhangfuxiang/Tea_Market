package com.delta.smt.ui.HomePage.subjectActivityDetail.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.home_page.activity.ActivityCancelResult;
import com.delta.smt.entity.home_page.activity.ActivityDetail;
import com.delta.smt.entity.home_page.activity.ActivitySignUpResult;

import rx.Observable;


/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

public interface SubjectActivityDetailContract {
    //对于经常使用的关于UI的方法可以定义到BaseView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        void onDetailSuccess(ActivityDetail activityDetail);

        void onDetailFailed(ActivityDetail activityDetail);

        void onDetailFailed(Throwable throwable);

        void onSignUpSuccess(ActivitySignUpResult activitySignUpResult);

        void onSignUpFailed(ActivitySignUpResult activitySignUpResult);

        void onSignUpFailed(Throwable throwable);

        void onCancelSuccess(ActivityCancelResult activityCancelResult);

        void onCancelFailed(ActivityCancelResult activityCancelResult);

        void onCancelFailed(Throwable throwable);

    }

    //Model层定义接口,外部只需关心model返回的数据,无需关心内部细节,及是否使用缓存
    interface Model extends IModel {
        Observable<ActivityDetail> getSubjectActivityDetail(
                String token,
                String act_id,
                String merchant_id
        );

        Observable<ActivitySignUpResult> signUpActivity(
                String token,
                String act_id,
                String pay_type,
                String pay_pwd,
                String merchant_id
        );

        Observable<ActivityCancelResult> cancelActivity(
                String token,
                String id,
                String merchant_id
        );

    }
}