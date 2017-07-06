package com.delta.commonlibs.utils;

import android.util.Log;

/**
 * @author :  V.Wenju.Tian
 * @description : 防止多次点击
 * @date : 2016/12/19 14:04
 */
public class SingleClick {

    private static long lastTime;

    public static boolean isSingle(long defalutTime) {
        long currentTime = System.currentTimeMillis();
        boolean isSign = currentTime - lastTime <= defalutTime ? false : true;
        Log.e("taggg", isSign + "");
        lastTime = currentTime;

        return isSign;
    }

    public static long getLastTime() {
        return lastTime;
    }

    public static void setLastTime(long lastTime) {
        SingleClick.lastTime = lastTime;
    }

}
