package com.delta.commonlibs.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
* @description :提供Application以及Gson对象
* @author :  V.Wenju.Tian
* @date : 2016/12/5 14:34
*/
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApplication;
    }
    @Singleton
    @Provides
    public Context provideContext() {
        return mApplication;
    }
    @Singleton
    @Provides
    public Gson provideGson(){return new Gson();}
}
