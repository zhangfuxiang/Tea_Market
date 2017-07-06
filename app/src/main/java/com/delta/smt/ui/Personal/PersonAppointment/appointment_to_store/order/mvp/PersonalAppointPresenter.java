package com.delta.smt.ui.Personal.PersonAppointment.appointment_to_store.order.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.smt.Constant;
import com.delta.smt.entity.MyAppointResult;
import com.delta.smt.entity.UserInfo;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by xy on 2017/3/18.
 */

public class PersonalAppointPresenter extends BasePresenter<PersonalAppointContract.Model,PersonalAppointContract.View> {

    @Inject
    public PersonalAppointPresenter(PersonalAppointContract.Model model, PersonalAppointContract.View mView) {
        super(model, mView);
    }


    public void getUseInfo(String token,String merchant_id) {
        getModel().getUseInfo(token,merchant_id).subscribe(new Action1<UserInfo>() {
            @Override
            public void call(UserInfo userInfo) {

                if(userInfo.getApp_code()==22000){
                    getView().ShowUserInfoSuccess(userInfo);
                }else {
                    getView().showUserInfoError();
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

                try {
                    getView().showUserInfoError();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void getPersonalAppoint(String token, String merchanId, int type, int page, int size, final int status) {
        getModel().getPersonalAppoint(token, merchanId,type, page, size).subscribe(new Action1<MyAppointResult>() {
            @Override
            public void call(MyAppointResult blanceDetailResult) {
                if (blanceDetailResult.getApp_code() == 22000) {
                    switch (status) {
                        case Constant.NOMAL:
                            getView().getBlanceDetailSuccess(blanceDetailResult.getResult());
                            break;
                        case Constant.PUllTOREFRESH:
                            getView().RefershSucess(blanceDetailResult.getResult());
                            break;
                        case Constant.UPLOADMORE:
                            getView().loadSucess(blanceDetailResult.getResult());

                            break;
                        default:
                            break;
                    }

                } else {
                    getView().getBlanceDetailFaild(blanceDetailResult.getApp_msg());
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                try {
                    getView().getBlanceDetailFaild("获取信息失败");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
