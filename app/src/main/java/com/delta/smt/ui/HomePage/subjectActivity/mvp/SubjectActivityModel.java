package com.delta.smt.ui.HomePage.subjectActivity.mvp;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.delta.smt.api.ApiService;
import com.delta.smt.base.BaseModel;
import com.delta.smt.entity.home_page.activity.ActivityList;

import rx.Observable;


/**
 * Created by wushufeng on 2017/3/19.
 */


public class SubjectActivityModel extends BaseModel<ApiService> implements SubjectActivityContract.Model {

    public SubjectActivityModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<ActivityList> getSubjectActivityList(String token, String is_on_time, String page, String size, String category_id, String status, String merchant_id) {
        return getService().getSubjectActivityList(token, is_on_time, page, size, category_id, status, merchant_id).compose(RxsRxSchedulers.<ActivityList>io_main());
    }
}