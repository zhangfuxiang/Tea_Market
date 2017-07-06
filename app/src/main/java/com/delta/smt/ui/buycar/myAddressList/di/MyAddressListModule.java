package com.delta.smt.ui.buycar.myAddressList.di;

import com.delta.commonlibs.di.scope.ActivityScope;
import com.delta.smt.api.ApiService;
import com.delta.smt.ui.buycar.myAddressList.mvp.MyAddressListContract;
import com.delta.smt.ui.buycar.myAddressList.mvp.MyAddressListModel;

import dagger.Module;
import dagger.Provides;


/**
 * Created by wushufeng on 2017/5/5.
 */

@Module
public class MyAddressListModule {
    private MyAddressListContract.View mView;

    /**
     * 构建MyAddressListModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyAddressListModule(MyAddressListContract.View view) {
        this.mView = view;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    MyAddressListContract.View provideMyAddressListView() {
        return mView;
    }

    //  @FragmentScope
    @ActivityScope
    @Provides
    MyAddressListContract.Model provideMyAddressListModel(ApiService apiService) {
        return new MyAddressListModel(apiService);
    }
}