package com.delta.smt.base;


/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */

public class BaseModel<T> {


    private T t;

    public BaseModel(T t) {
        this.t = t;
    }

    public T getService() {
        return t;
    }
}
