package com.delta.smt.ui.HomePage.subjectActivity.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.Constant;
import com.delta.smt.entity.home_page.activity.ActivityList;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/3/19.
 */

//@FragmentScope
@ActivityScope
public class SubjectActivityPresenter extends BasePresenter<SubjectActivityContract.Model, SubjectActivityContract.View> {


    @Inject
    public SubjectActivityPresenter(SubjectActivityContract.Model model, SubjectActivityContract.View mView) {
        super(model, mView);
    }

    public void getSubjectActivityList(String token, String is_on_time, String page, String size, String category_id, String status, String merchant_id, final int type) {
        getModel().getSubjectActivityList(token, is_on_time, page, size, category_id, status, merchant_id).subscribe(new Action1<ActivityList>() {
            @Override
            public void call(ActivityList activityList) {
                if (activityList.getApp_code() == 22000) {
                    if (type == Constant.NOMAL) {
                        getView().onSujectListSuccess(activityList);
                    } else if (type == Constant.PUllTOREFRESH) {

                        getView().onSujectListRefreshSuccess(activityList);
                    } else if (type == Constant.UPLOADMORE) {
                        getView().onSujectListLoadMoreSuccess(activityList);
                    }
                } else {
                    if (type == Constant.NOMAL) {
                        getView().onSujectListfailed(activityList);
                    } else if (type == Constant.PUllTOREFRESH) {

                        getView().onSujectListRefreshfailed(activityList);
                    } else if (type == Constant.UPLOADMORE) {
                        getView().onSujectListLoadMorefailed(activityList);
                    }
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onSujectListfailed(throwable);
            }
        });
    }


}