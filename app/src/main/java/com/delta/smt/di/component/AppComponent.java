package com.delta.smt.di.component;

import android.app.Application;
import android.content.Context;

import com.delta.commonlibs.di.module.AppModule;
import com.delta.commonlibs.di.module.ClientModule;
import com.delta.smt.api.ApiService;
import com.delta.smt.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by V.Wenju.Tian on 2016/11/22.
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class, ServiceModule.class})
public interface AppComponent {

    Application Application();

    ApiService apiService();

    Context context();

}
