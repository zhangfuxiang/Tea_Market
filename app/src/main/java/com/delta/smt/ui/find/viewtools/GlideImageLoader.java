package com.delta.smt.ui.find.viewtools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.delta.smt.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Shufeng.Wu on 2017/3/16.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context.getApplicationContext())
                .load(path)
                .placeholder(R.mipmap.picture)
                .crossFade()
                .into(imageView);

    }
}
