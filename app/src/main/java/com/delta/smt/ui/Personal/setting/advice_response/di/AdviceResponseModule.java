package com.delta.smt.ui.Personal.setting.advice_response.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.setting.advice_response.mvp.AdviceResponseContract;
import com.delta.smt.ui.Personal.setting.advice_response.mvp.AdviceResponseModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/5/20.
 */

@Module
public class AdviceResponseModule {
    private AdviceResponseContract.View mView;

    /**
     * 构建AdviceResponseModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AdviceResponseModule(AdviceResponseContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AdviceResponseContract.View provideAdviceResponseView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    AdviceResponseContract.Model provideAdviceResponseModel(ApiService apiService) {
        return new AdviceResponseModel(apiService);
    }
}