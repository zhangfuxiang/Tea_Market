package com.delta.smt.ui.Personal.Balance.BalanceDetail.order.mvp;

import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.delta.smt.entity.BlanceDetailResult;
import com.delta.smt.entity.UserInfo;

import rx.Observable;


public class BlanceDetailContract {

    public interface View extends IView {
        void ShowUserInfoSuccess(UserInfo userInfo);

        void showUserInfoError();

        void getBlanceDetailSuccess(BlanceDetailResult.ResultEntity result);

        void getBlanceDetailFaild(String app_msg);

        void RefershSucess(BlanceDetailResult.ResultEntity result);

        void loadSucess(BlanceDetailResult.ResultEntity result);
    }

    public interface Model extends IModel {
        Observable<UserInfo> getUseInfo(String token, String merchant_id);

        Observable<BlanceDetailResult> getBlanceDetail(String token, String merchanId, int type, int page, int size);
    }
}
