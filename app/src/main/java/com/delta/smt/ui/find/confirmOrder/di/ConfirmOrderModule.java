package com.delta.smt.ui.find.confirmOrder.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.find.confirmOrder.mvp.ConfirmOrderContract;
import com.delta.smt.ui.find.confirmOrder.mvp.ConfirmOrderModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/3/29.
 */

@Module
public class ConfirmOrderModule {
    private ConfirmOrderContract.View mView;

    /**
     * 构建ComfirmOrderModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ConfirmOrderModule(ConfirmOrderContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ConfirmOrderContract.View provideComfirmOrderView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    ConfirmOrderContract.Model provideComfirmOrderModel(ApiService apiService) {
        return new ConfirmOrderModel(apiService);
    }
}