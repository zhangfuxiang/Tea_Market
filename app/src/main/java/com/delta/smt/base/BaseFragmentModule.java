package com.delta.smt.base;

import com.delta.commonlibs.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/14 10:57
 */

@Module
public abstract class BaseFragmentModule<E> {

    private E e;

    public BaseFragmentModule(E e) {
        this.e = e;
    }

    @FragmentScope
    @Provides
    public E providerView(E e) {
        return e;
    }
}
