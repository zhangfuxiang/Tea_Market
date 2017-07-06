package com.delta.smt.ui.drinktea.write_order_info.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.drinktea.write_order_info.mvp.WriteOrderInfoContract;
import com.delta.smt.ui.drinktea.write_order_info.mvp.WriteOrderInfoModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/4/21.
 */

@Module
public class WriteOrderInfoModule {
    private WriteOrderInfoContract.View mView;

    /**
     * 构建WriteOrderInfoModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public WriteOrderInfoModule(WriteOrderInfoContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    WriteOrderInfoContract.View provideWriteOrderInfoView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    WriteOrderInfoContract.Model provideWriteOrderInfoModel(ApiService apiService) {
        return new WriteOrderInfoModel(apiService);
    }
}