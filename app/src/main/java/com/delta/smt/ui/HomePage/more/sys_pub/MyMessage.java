package com.delta.smt.ui.HomePage.more.sys_pub;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shaoqiang.Zhang on 2017/5/22.
 */

public class MyMessage implements Parcelable{

    private String time;
    private String title;

    protected MyMessage(Parcel in) {
        time = in.readString();
        title = in.readString();
    }

    public static final Parcelable.Creator<MyMessage> CREATOR = new Parcelable.Creator<MyMessage>() {
        @Override
        public MyMessage createFromParcel(Parcel in) {
            return new MyMessage(in);
        }

        @Override
        public MyMessage[] newArray(int size) {
            return new MyMessage[size];
        }
    };

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeString(title);
    }

    public MyMessage(String time, String title) {
        this.time = time;
        this.title = title;
    }
}
