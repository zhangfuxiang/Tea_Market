package com.delta.smt.ui.HomePage.subjectActivityDetail.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.home_page.activity.ActivityCancelResult;
import com.delta.smt.entity.home_page.activity.ActivityDetail;
import com.delta.smt.entity.home_page.activity.ActivitySignUpResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by Shufeng.Wu on 2017/3/22.
 */

//@FragmentScope
@ActivityScope
public class SubjectActivityDetailPresenter extends BasePresenter<SubjectActivityDetailContract.Model, SubjectActivityDetailContract.View> {


    @Inject
    public SubjectActivityDetailPresenter(SubjectActivityDetailContract.Model model, SubjectActivityDetailContract.View mView) {
        super(model, mView);
    }

    public void getSubjectActivityDetail(String token, String act_id, String merchant_id) {
        getModel().getSubjectActivityDetail(token, act_id, merchant_id).subscribe(new Action1<ActivityDetail>() {
            @Override
            public void call(ActivityDetail activityDetail) {
                if (activityDetail.getApp_code() == 22000) {
                    getView().onDetailSuccess(activityDetail);
                } else {
                    getView().onDetailFailed(activityDetail);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onDetailFailed(throwable);
            }
        });
    }

    public void signUpActivity(String token, String act_id, String pay_type, String pay_pwd, String merchant_id) {
        getModel().signUpActivity(token, act_id, pay_type, pay_pwd, merchant_id).subscribe(new Action1<ActivitySignUpResult>() {
            @Override
            public void call(ActivitySignUpResult activitySignUpResult) {
                if (activitySignUpResult.getApp_code() == 22000) {
                    getView().onSignUpSuccess(activitySignUpResult);
                } else {
                    getView().onSignUpFailed(activitySignUpResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onSignUpFailed(throwable);
            }
        });
    }

    public void cancelActivity(String token, String id, String merchant_id) {
        getModel().cancelActivity(token, id, merchant_id).subscribe(new Action1<ActivityCancelResult>() {
            @Override
            public void call(ActivityCancelResult activityCancelResult) {
                if (activityCancelResult.getApp_code() == 22000) {
                    getView().onCancelSuccess(activityCancelResult);
                } else {
                    getView().onCancelFailed(activityCancelResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onCancelFailed(throwable);
            }
        });
    }

    /*public void signUpSubjectActivity(String token, String activity_id, String pay_type, String paypwd) {
        getModel().signUpSubjectActivity(token, activity_id, pay_type, paypwd).subscribe(new Action1<SignUpSubjectActivityResult>() {
            @Override
            public void call(SignUpSubjectActivityResult signUpSubjectActivityResult) {
                if (signUpSubjectActivityResult.getApp_code().equals("22000")) {
                    Log.i(TAG, "call: ");
                    try {
                        getView().onSignUpSuccess(signUpSubjectActivityResult);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    getView().onSignUpFailed(signUpSubjectActivityResult);
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onSignUpFailed(throwable);
            }
        });
    }*/


}