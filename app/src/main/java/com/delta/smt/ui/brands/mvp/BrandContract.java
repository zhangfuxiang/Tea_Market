package com.delta.smt.ui.brands.mvp;


import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.Brands;

import rx.Observable;

/**
 * @description :
 * @autHor :  V.Wenju.Tian
 * @date : 2016/12/14 10:00
 */


public interface BrandContract {
    interface Model extends IModel {

        Observable<Brands> getBrands(int index);


    }

    interface View extends IView {
        void showloading();

        void Sucess(Brands brands);

        void RefershSucess(Brands brands);

        void loadSucess(Brands brands);

        void failed();


    }
}
