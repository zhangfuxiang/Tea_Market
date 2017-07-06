package com.delta.smt.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by wushufeng on 2017/3/21.
 */

public class StringTabEntity implements CustomTabEntity {
    public String title;

    public StringTabEntity(String title) {
        this.title = title;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return 0;
    }

    @Override
    public int getTabUnselectedIcon() {
        return 0;
    }
}
