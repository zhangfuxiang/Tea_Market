package com.delta.smt.ui.Personal.my_order.all_content.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.commonlibs.di.scope.FragmentScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.Personal.my_order.all_content.mvp.AllContentContract;
import com.delta.smt.ui.Personal.my_order.all_content.mvp.AllContentModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Fuxiang.Zhang on 2017/4/25.
 */

@Module
public class AllContentModule {
    private AllContentContract.View mView;

    /**
     * 构建AllContentModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public AllContentModule(AllContentContract.View view) {
        this.mView = view;
    }

      @FragmentScope
//    @ActivityScope
    @Provides
    AllContentContract.View provideAllContentView() {
        return mView;
    }

      @FragmentScope
//    @ActivityScope
    @Provides
    AllContentContract.Model provideAllContentModel(ApiService apiService) {
        return new AllContentModel(apiService);
    }
}