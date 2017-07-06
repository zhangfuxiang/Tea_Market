package com.delta.smt.ui.HomePage.subjectActivityDetail.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.home_page.activity.ActivityCancelResult;
import com.delta.smt.entity.home_page.activity.ActivityDetail;
import com.delta.smt.entity.home_page.activity.ActivitySignUpResult;

import rx.Observable;


/**
 * Created by Shufeng.Wu on 2017/3/22.
 */


public class SubjectActivityDetailModel extends BaseModel<ApiService> implements SubjectActivityDetailContract.Model {

    public SubjectActivityDetailModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<ActivityDetail> getSubjectActivityDetail(String token, String act_id, String merchant_id) {
        return getService().getSubjectActivityDetail(token, act_id, merchant_id).compose(RxsRxSchedulers.<ActivityDetail>io_main());
    }

    @Override
    public Observable<ActivitySignUpResult> signUpActivity(String token, String act_id, String pay_type, String pay_pwd, String merchant_id) {
        return getService().signUpActivity(token, act_id, pay_type, pay_pwd, merchant_id).compose(RxsRxSchedulers.<ActivitySignUpResult>io_main());
    }

    @Override
    public Observable<ActivityCancelResult> cancelActivity(String token, String id, String merchant_id) {
        return getService().cancelActivity(token, id, merchant_id).compose(RxsRxSchedulers.<ActivityCancelResult>io_main());
    }




    /*@Override
    public Observable<SignUpSubjectActivityResult> signUpSubjectActivity(String token, String activity_id, String pay_type, String paypwd) {
        return getService().signUpSubjectActivity(token, activity_id, pay_type, paypwd).compose(RxsRxSchedulers.<SignUpSubjectActivityResult>io_main());
    }*/

}