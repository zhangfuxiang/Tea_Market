package com.delta.smt.utils;

import android.content.Context;

import com.delta.commonlibs.utils.SpUtil;
import com.delta.smt.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2017/5/18 15:32
 */


public class MapUtils {

    public static Map<String, String>   CreateQueryMap(Context context) {
        Map<String, String> maps = new HashMap<>();
        maps.put("token", SpUtil.getStringSF(context, Constant.TOKEN));
        maps.put("merchant_id", SpUtil.getStringSF(context, Constant.MERCHANTID));
        return maps;
    }

}
