package com.delta.smt.ui.find.myGivePrice.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.find.myGivePrice.mvp.MyGivePriceContract;
import com.delta.smt.ui.find.myGivePrice.mvp.MyGivePriceModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/3/21.
 */

@Module
public class MyGivePriceModule {
    private MyGivePriceContract.View mView;

    /**
     * 构建MyGivePriceModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyGivePriceModule(MyGivePriceContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    MyGivePriceContract.View provideMyGivePriceView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    MyGivePriceContract.Model provideMyGivePriceModel(ApiService apiService) {
        return new MyGivePriceModel(apiService);
    }
}