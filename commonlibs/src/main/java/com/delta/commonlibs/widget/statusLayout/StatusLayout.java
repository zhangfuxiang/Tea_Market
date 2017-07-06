package com.delta.commonlibs.widget.statusLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.delta.commonlibs.R;

public class StatusLayout extends RelativeLayout {


    private final int StateContent = -1, StateLoading = 0, StateError = 1, StateEmpty = 2, StateNoNet = 3;
    /**
     * 四种状态布局
     **/
    private View noNetwrokView, loadingView, loadingWrongView, noDataView;
    /***
     * 存放所有的布局文件
     **/
    private View mContentView;
    /***
     * 当前显示的布局
     */
    private int mShowState = StateContent;

    public StatusLayout(Context context) {
        this(context, null);
    }

    public StatusLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.StatusLayout, defStyleAttr, 0);
        try {
            LayoutInflater inflater = LayoutInflater.from(context);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            if (array.hasValue(R.styleable.StatusLayout_noNetLayout)) {
                int noNetId = array.getResourceId(R.styleable.StatusLayout_noNetLayout, R.layout.viewstatus_no_netwrok);
                noNetwrokView = inflater.inflate(noNetId, null);
                addView(noNetwrokView, params);
                setViewVisibility(noNetwrokView, false);
            }
            if (array.hasValue(R.styleable.StatusLayout_emptyLayout)) {
                int emptyId = array.getResourceId(R.styleable.StatusLayout_emptyLayout, R.layout.viewstatus_no_data);
                noDataView = inflater.inflate(emptyId, null);
                addView(noDataView, params);
                setViewVisibility(noDataView, false);
            }
            if (array.hasValue(R.styleable.StatusLayout_errorLayout)) {
                int errorId = array.getResourceId(R.styleable.StatusLayout_errorLayout, R.layout.viewstatus_loading_faile);
                loadingWrongView = inflater.inflate(errorId, null);
                addView(loadingWrongView, params);
                setViewVisibility(loadingWrongView, false);
            }
            if (array.hasValue(R.styleable.StatusLayout_loadingLayout)) {
                int loadingId = array.getResourceId(R.styleable.StatusLayout_loadingLayout, R.layout.viewstatus_loading);
                loadingView = inflater.inflate(loadingId, null);
                addView(loadingView, params);
                setViewVisibility(loadingView, false);
            }
        } finally {
            array.recycle();
        }
    }

    /**
     * 检查某个控件是否为空，并初始化
     *
     * @param state
     */
    private void checkNullAndInflate(int state) {
        View pView = null;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        switch (state) {
            case StateEmpty:
                if (noDataView == null) {
                    noDataView = inflater.inflate(R.layout.viewstatus_no_data, null);
                    pView = noDataView;
                }
                break;
            case StateError:
                if (loadingWrongView == null) {
                    loadingWrongView = inflater.inflate(R.layout.viewstatus_loading_faile, null);
                    pView = loadingWrongView;
                }
                break;
            case StateLoading:
                if (loadingView == null) {
                    loadingView = inflater.inflate(R.layout.viewstatus_loading, null);
                    pView = loadingView;
                }
                break;
            case StateNoNet:
                if (noNetwrokView == null) {
                    noNetwrokView = inflater.inflate(R.layout.viewstatus_no_netwrok, null);
                    pView = noNetwrokView;
                }
                break;
        }
        if (pView != null) {
            addView(pView, params);
            setViewVisibility(pView, false);
        }
    }


    /**
     * 显示空视图
     */
    public void showEmptyView() {
        checkNullAndInflate(StateEmpty);
        selectView(nowShowView(mShowState), noDataView);
        mShowState = StateEmpty;
    }

    /**
     * 显示没有网络视图
     */
    public void showNoNetView() {
        checkNullAndInflate(StateNoNet);
        selectView(nowShowView(mShowState), noNetwrokView);
        mShowState = StateNoNet;
    }

    /**
     * 显示加载中布局
     */
    public void showLoadingView() {
        checkNullAndInflate(StateLoading);
        selectView(nowShowView(mShowState), loadingView);
        mShowState = StateLoading;
    }

    /**
     * 显示加载失败视图
     */
    public void showErrorView() {
        checkNullAndInflate(StateError);
        selectView(nowShowView(mShowState), loadingWrongView);
        mShowState = StateError;
    }

    /**
     * 显示内容视图
     */
    public void showContentView() {
        selectView(nowShowView(mShowState), mContentView);
        mShowState = StateContent;
    }

    /**
     * 设置没有网络时点击事件
     * <p>
     * 有默认点击事件
     *
     * @param pClick 点击回调
     */
    public void setNoNetClick(OnClickListener pClick) {
        if (noNetwrokView == null) {
            throw new NullPointerException("view not inflate");
        }
        if (pClick != null) {
            noNetwrokView.findViewById(R.id.vs_nn_root).setOnClickListener(pClick);
        } else {
            noNetwrokView.findViewById(R.id.vs_nn_root).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openWifiSetting(getContext());
                }
            });
        }
    }

    /**
     * 设置加载中的点击事件
     *
     * @param pClick 回调
     */
    public void setLoadingClick(OnClickListener pClick) {
        if (pClick != null) {
            if (loadingView == null) {
                throw new NullPointerException("view not inflate");
            }
            loadingView.findViewById(R.id.vs_le_root).setOnClickListener(pClick);
        }
    }

    /**
     * 设置加载失败点击事件
     *
     * @param pClick 点击回调
     */
    public void setErrorClick(OnClickListener pClick) {
        if (pClick != null) {
            if (loadingWrongView == null) {
                throw new NullPointerException("view not inflate");
            }
            loadingWrongView.findViewById(R.id.vs_lf_root).setOnClickListener(pClick);
        }
    }

    /**
     * 设置没有数据时，点击事件
     *
     * @param pClick 点击回调
     */
    public void setEmptyClick(OnClickListener pClick) {
        if (pClick != null) {
            if (noDataView == null) {
                throw new NullPointerException("view not inflate");
            }
            noDataView.findViewById(R.id.vs_nd_root).setOnClickListener(pClick);
        }
    }

    /**
     * 打开网络设置界面
     *
     * @param pContext 上下文
     */
    private void openWifiSetting(Context pContext) {
        Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (pContext != null) {
            pContext.startActivity(intent);
        }
    }

    /**
     * 根据状态返回布局
     *
     * @param state
     * @return
     */
    private View nowShowView(int state) {
        View retuView = null;
        switch (state) {
            case StateContent:
                retuView = mContentView;
                break;
            case StateEmpty:
                retuView = noDataView;
                break;
            case StateError:
                retuView = loadingWrongView;
                break;
            case StateLoading:
                retuView = loadingView;
                break;
            case StateNoNet:
                retuView = noNetwrokView;
                break;
        }
        return retuView;
    }

    /**
     * 从旧布局选择到新布局，可以考虑做动画
     *
     * @param pOldView
     * @param pNewView
     */
    private void selectView(final View pOldView, final View pNewView) {
        setViewVisibility(pOldView, true);
        setViewVisibility(pNewView, true);
        AlphaAnimation oldAlpha = new AlphaAnimation(1, 0);
        oldAlpha.setDuration(500);
        final AlphaAnimation newAlpha = new AlphaAnimation(0, 1);
        newAlpha.setDuration(500);
        pOldView.setAnimation(oldAlpha);
        pNewView.setAnimation(newAlpha);
        oldAlpha.startNow();
        newAlpha.startNow();
        oldAlpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setViewVisibility(pOldView, false);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        newAlpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setViewVisibility(pNewView, true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    /***
     * 设置一个控件的状态
     *
     * @param pView 控件
     * @param vis   true，显示，false不显示
     */
    private void setViewVisibility(View pView, boolean vis) {
        if (pView != null) {
            pView.setVisibility(vis ? VISIBLE : GONE);
        }
    }

    /***
     * 如果没有设置内容布局ID,除了四个状态布局，其它都算是内容布局
     *
     * @param view
     */
    private void checkIsContentView(View view) {
        if (view != null && view != noNetwrokView && view != loadingView && view != loadingWrongView && view != noDataView) {
            mContentView = view;
            int mixConut = 0;
            if (noNetwrokView != null) {
                mixConut++;
            }
            if (loadingView != null) {
                mixConut++;
            }
            if (loadingWrongView != null) {
                mixConut++;
            }
            if (noDataView != null) {
                mixConut++;
            }
            if (getChildCount() != mixConut) {
                throw new RuntimeException("StatusLayout must only one child");
            }

        }
    }

    @Override
    public void addView(View child) {
        checkIsContentView(child);
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        checkIsContentView(child);
        super.addView(child, index);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        checkIsContentView(child);
        super.addView(child, index, params);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        checkIsContentView(child);
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int width, int height) {
        checkIsContentView(child);
        super.addView(child, width, height);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        checkIsContentView(child);
        return super.addViewInLayout(child, index, params);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        checkIsContentView(child);
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }
}