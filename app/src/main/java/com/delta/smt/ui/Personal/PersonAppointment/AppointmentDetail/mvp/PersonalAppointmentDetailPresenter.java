package com.delta.smt.ui.Personal.PersonAppointment.AppointmentDetail.mvp;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import rx.functions.Action1;

/**
 * Created by Fuxiang.Zhang on 2017/4/27.
 */

//@FragmentScope
@ActivityScope
public class PersonalAppointmentDetailPresenter extends BasePresenter<PersonalAppointmentDetailContract.Model, PersonalAppointmentDetailContract.View> {


    @Inject
    public PersonalAppointmentDetailPresenter(PersonalAppointmentDetailContract.Model model, PersonalAppointmentDetailContract.View mView) {
        super(model, mView);
    }


    public void cancelAppointMent(Map<String, String> queryMap) {

        getModel().cancelAppointMent(queryMap).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody s) {
                try {
                    JSONObject jsonObject = new JSONObject(s.string().trim());

                    int appcode = jsonObject.getInt("app_code");
                    String app_msg = jsonObject.getString("app_msg");
                    if (appcode == 22000) {
                        getView().showCancelSuccess();

                    } else {
                        getView().showCancelFailed(app_msg);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void arrive(Map<String, String> queryMap1) {

        getModel().arrive(queryMap1).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody s) {
                try {
                    JSONObject jsonObject = new JSONObject(s.string().trim());
                    String app_msg = jsonObject.getString("app_msg");
                    int appcode = jsonObject.getInt("app_code");
                    if (appcode == 22000) {
                        getView().arriveSuccess();
                    } else {
                        getView().arriveFailed(app_msg);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

            }
        });
    }
}