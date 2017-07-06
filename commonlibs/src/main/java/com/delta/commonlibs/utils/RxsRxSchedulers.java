package com.delta.commonlibs.utils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author :  V.Wenju.Tian
 * @description :统一流转换操作，当创建Observable流的时候，compose()会立即执行，犹如已经提前写好了一个操作符一样
 * @date : 2016/12/5 15:34
 */

public class RxsRxSchedulers {
    public static <T> Observable.Transformer<T, T> io_main() {

        Observable.Transformer<T, T> transformer = new Observable.Transformer<T, T>() {

            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
        return transformer;
    }
}
