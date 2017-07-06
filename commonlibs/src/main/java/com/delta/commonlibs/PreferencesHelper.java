package com.delta.commonlibs;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private static final String SETTING = "setting";
    private static final String ID = "USER_ID";
    private static final String FIRST_TIME = "firstTime";
    private static final String ISLOGIN = "isLogin";
    private static final boolean FIRST_TIME_DEFAULT = true;
    private static final String PREF_KEY_SIGNED_IN_RIBOT = "PREF_KEY_SIGNED_IN_RIBOT";
    private final SharedPreferences mPref;

    public PreferencesHelper(Context context) {
        mPref = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE);
    }

    public void saveCurrentUserId(String id) {
        mPref.edit().putString(ID, id).apply();
    }

    public String getCurrentUserId() {
        return mPref.getString(ID, null);

    }

    public boolean isLogined() {
        return mPref.getBoolean(ISLOGIN, false);
    }

    public void setIslogin(boolean islogin) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putBoolean(ISLOGIN, islogin);
        editor.apply();

    }

    public boolean isFirstTime() {
        return mPref.getBoolean(FIRST_TIME, FIRST_TIME_DEFAULT);
    }

    public void saveFirstTime(boolean isFirst) {
        SharedPreferences.Editor editor = mPref.edit();
        editor.putBoolean(FIRST_TIME, isFirst);
        editor.apply();
    }

    public void Clear() {
        mPref.edit().clear().apply();
    }
}
