package com.delta.smt.ui.brands.mvp;

import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.Constant;
import com.delta.smt.entity.Brands;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/14 10:41
 */

@ActivityScope
public class BrandPresenter extends BasePresenter<BrandContract.Model, BrandContract.View> {
    @Inject
    public BrandPresenter(BrandContract.Model model, BrandContract.View mView) {
        super(model, mView);
    }

    public void getReports(int index, final int status) {

        getModel().getBrands(index).subscribe(new Action1<Brands>() {
            @Override
            public void call(Brands brands) {
                Log.d(TAG, "call() called with: report = [" + brands + "]");
                switch (status) {
                    case Constant.NOMAL:
                        getView().Sucess(brands);
                        break;
                    case Constant.PUllTOREFRESH:
                        getView().RefershSucess(brands);
                        break;
                    case Constant.UPLOADMORE:
                        getView().loadSucess(brands);

                        break;
                    default:
                        break;
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

                getView().failed();
                Log.d(TAG, "call() called with: throwable = [" + throwable + "]");
            }
        });
    }
}
