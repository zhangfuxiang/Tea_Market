package com.delta.smt.ui.find.collectionInfo;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by wushufeng on 2017/4/9.
 */

public class XIVPagerView extends PagerAdapter {
    private int mChildCount = 0;

    @Override
    public void notifyDataSetChanged() {
        mChildCount = getCount();
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public int getItemPosition(Object object) {
        if (mChildCount > 0) {
            mChildCount--;
            return POSITION_NONE;
        }
        return super.getItemPosition(object);
    }
}
