package com.delta.smt.ui.find.collectionInfo;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.delta.smt.R;
import com.delta.smt.ui.find.FindToolBar;
import com.delta.smt.ui.find.collectionInfo.ximageview.XImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wushufeng on 2017/4/9.
 */

public class ShowImagePage extends AppCompatActivity {

    private static final int REQUEST_SHOW_IMAGE_RESULT = 11;
    @BindView(R.id.toolbar)
    FindToolBar toolbar;

    TextView toolbarTitle;
    ViewPager pager;
    ArrayList<String> list;
    int position = 0;
    PagerAdapter mPagerAdapter;
    ViewPager.OnPageChangeListener onPageChangeListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_image_page);
        ButterKnife.bind(this);
        toolbar.setToolbarLeftButton(R.mipmap.ic_back);
        toolbar.setToolbarRightButton("删除");
        onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ShowImagePage.this.position = position;
                toolbar.setToolbarTitle("(" + (position + 1) + "/" + list.size() + ")");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };


        list = getIntent().getStringArrayListExtra("image_paths");
        position = getIntent().getIntExtra("image_position", 0);

        pager = (ViewPager) findViewById(R.id.viewPager);
        pager.addOnPageChangeListener(onPageChangeListener);
        mPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = View.inflate(ShowImagePage.this, R.layout.layout_page, null);
                setupXImageView((XImageView) view.findViewById(R.id.xImageView), (ProgressBar) view.findViewById(R.id.progress), position);
                container.addView(view);

                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        };
        pager.setAdapter(mPagerAdapter);

        pager.setCurrentItem(position);
        toolbar.setToolbarTitle("(" + (position + 1) + "/" + list.size() + ")");


    }

    private void setupXImageView(XImageView imageView, final ProgressBar progressBar, final int pos) {
        try {
            imageView.setImage(list.get(pos));

        } catch (Exception e) {
            e.printStackTrace();
        }

        imageView.setActionListener(new XImageView.OnActionListener() {
            @Override
            public void onSingleTapped(XImageView view, MotionEvent event, boolean onImage) {
            }

            @Override
            public boolean onDoubleTapped(XImageView view, MotionEvent event) {
                return false;
            }

            @Override
            public void onLongPressed(XImageView view, MotionEvent event) {
                //startActivity(new Intent(getApplicationContext(), ImageActivity.class));
            }

            @Override
            public void onSetImageFinished(XImageView view, boolean success, Rect image) {
                progressBar.setVisibility(View.GONE);

            }
        });
    }

    @OnClick({R.id.toolbar_left_button_arl, R.id.toolbar_right_button})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_button_arl:
                Intent intent = new Intent();
                intent.putExtra("image_paths_result", list);
                setResult(REQUEST_SHOW_IMAGE_RESULT, intent);
                finish();
                break;
            case R.id.toolbar_right_button:
                if (list.size() > 0) {
                    new AlertDialog.Builder(ShowImagePage.this)
                            .setTitle("提示")
                            .setMessage("要删除这张照片吗？")
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    list.remove(position);
                                    mPagerAdapter.notifyDataSetChanged();
                                    if (list.size() > 0) {
                                        if (position < list.size()) {
                                            pager.setAdapter(mPagerAdapter);
                                            pager.setCurrentItem(position);
                                            onPageChangeListener.onPageSelected(position);

                                        } else {
                                            pager.setCurrentItem(list.size() - 1);
                                            onPageChangeListener.onPageSelected(list.size() - 1);
                                        }
                                    } else {
                                        Intent intent = new Intent();
                                        intent.putExtra("image_paths_result", list);
                                        setResult(REQUEST_SHOW_IMAGE_RESULT, intent);
                                        ShowImagePage.this.finish();
                                        dialog.dismiss();

                                    }

                                    mPagerAdapter.notifyDataSetChanged();

                                }
                            }).show();
                }

                break;
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
