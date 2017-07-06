package com.delta.smt.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.smt.MainActivity;
import com.delta.smt.app.App;
import com.delta.smt.di.component.AppComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/12 15:30
 */

public abstract class BaseFragment<p extends BasePresenter> extends Fragment {
    @Inject
    protected p mPresenter;
    private App application;
    private View rootView;
    private MainActivity mainActivity;
    private Unbinder bind;

    @Override
    public void onAttach(Context context) {
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) getActivity();
        }

        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        application = (App) (getActivity().getApplication());
        componentInject(application.getAppComponent());//依赖注入
        rootView = inflater.inflate(getContentViewId(), container, false);
        bind = ButterKnife.bind(this, rootView);
        initData();
        initView();
        return rootView;
    }

    protected abstract void initView();

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    protected abstract void componentInject(AppComponent appComponent);


    public p getPresenter() {
        return mPresenter;
    }

    protected abstract void initData();

    protected abstract int getContentViewId();

    @Override
    public void onDestroy() {
        if (bind != Unbinder.EMPTY) {
            bind.unbind();

        }
        super.onDestroy();
    }
}
