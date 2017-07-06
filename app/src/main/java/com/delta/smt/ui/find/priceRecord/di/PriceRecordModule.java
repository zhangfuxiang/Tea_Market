package com.delta.smt.ui.find.priceRecord.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.find.priceRecord.mvp.PriceRecordContract;
import com.delta.smt.ui.find.priceRecord.mvp.PriceRecordModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Shufeng.Wu on 2017/3/21.
 */

@Module
public class PriceRecordModule {
    private PriceRecordContract.View mView;

    /**
     * 构建PriceRecordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public PriceRecordModule(PriceRecordContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    PriceRecordContract.View providePriceRecordView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    PriceRecordContract.Model providePriceRecordModel(ApiService apiService) {
        return new PriceRecordModel(apiService);
    }
}