package com.delta.smt.ui.find.auctionHouseDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.delta.smt.R;

/**
 * Created by wushufeng on 2017/3/21.
 */

public class ProductParaFragment extends Fragment {
    AdaptiveViewPager vp;


    public ProductParaFragment() {
    }

    public void setAdaptiveViewPager(AdaptiveViewPager vp) {
        this.vp = vp;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_para, container, false);
        vp.setObjectForPosition(view, 1);
        return view;
    }
}
