package com.delta.smt.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

public class CustomViewPager extends ViewPager {
   
    public CustomViewPager(Context context) {
        super(context);  
    }  
   
    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);  
    }  
   
    @Override  
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
   
        int height = 0;  
        for (int i = 0; i < getChildCount(); i++) {  
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));  
            int h = child.getMeasuredHeight();  
            if (h > height)  
                height = h;  
        }  
   
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);  
   
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
    }  
}  