package com.delta.smt.ui.login.start.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.entity.StartResult;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by wushufeng on 2017/4/4.
 */

//@FragmentScope
@ActivityScope
public class StartPresenter extends BasePresenter<StartContract.Model, StartContract.View> {


    @Inject
    public StartPresenter(StartContract.Model model, StartContract.View mView) {
        super(model, mView);
    }

    public void start(String client, String client_version, String os, String os_token, String api_version) {


        getModel().start(client, client_version, os, os_token, api_version).subscribe(new Action1<StartResult>() {
            @Override
            public void call(StartResult startResult) {

                if ("22000".equals(startResult.getApp_code())) {
                    getView().onStartSuccess(startResult);
                } else {
                    getView().onStartFailed(startResult);
                }


            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().onStartFailed(throwable);
            }
        });
    }


}