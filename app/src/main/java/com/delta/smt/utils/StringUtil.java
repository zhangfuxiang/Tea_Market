package com.delta.smt.utils;

import android.text.TextUtils;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {
    /**手机号验证
    * @param  str
   * @return 验证通过返回true
   */
    public static boolean isMobile(String str) {
        boolean b = false;
        Pattern p = Pattern.compile("^((13[0-9])|(15[0-9])|(18[0-9])|(17[0-9])|(14[0-9]))\\d{8}$"); // 验证手机号
        Matcher m = p.matcher(str);
        b = m.matches();
        return b;
    }

    /**
     * 是否为年份
     */
    public static boolean isYear(String code){
        String reg = "^\\d{4}$";
        return Pattern.compile(reg).matcher(code).find();
    }

    /**
     * 邮箱验证
     */
    public static boolean isEmail( String str ) {
        String regex = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$" ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher( str );
        return matcher.matches();
    }
    /**
     * 进行URL编码
     * @param src src
     * @param charset 字符集
     * @return 编码的字符串
     */
    public static String urlEncode(String src, String charset){
        if(TextUtils.isEmpty(charset)){
            charset = "utf-8";
        }
        String str = "";
        try{
            str = URLEncoder.encode(src,charset);
        } catch(Exception e){
            e.printStackTrace();
        }
        return str;
    }
    // 判断字符串不为空
    public static boolean isNotBlank(String str) {
        if (str != null && !"".equals(str) && !"null".equals(str))
            return true;
        return false;
    }
    public static boolean isData(String data){
        String regex = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$" ;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
}
