package id.aicode.jalanaman.login;

import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.RemoteServices;
import id.aicode.jalanaman.services.models.login.LoginResponse;
import id.aicode.jalanaman.services.models.login.Place;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ibam on 7/16/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View mView;
    RemoteServices remoteServices;

    public LoginPresenter(){
        this.remoteServices = new RemoteServices();
    }

    @Override
    public void setView(BaseView view) {
        this.mView = (LoginContract.View) view;
    }

    @Override
    public void unsetView() {
        this.mView = null;
    }

    @Override
    public void setModel(BaseModel model) {

    }

    @Override
    public void unsetModel() {

    }

    @Override
    public void login(String password, String email, final Context context) {
        // connect to services
        // kalo sukses, post event bus dan mView.loginsukses
        remoteServices.login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<LoginResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loginFailed();
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        if(loginResponse.getUser() != null){
                            mView.loginSuccess(loginResponse);
                            saveToken(loginResponse.getToken(), context);
                        } else {
                            mView.loginFailed();
                        }
                    }
                });
    };

    private void saveToken(String token, Context context){
        token = "JWT " + token;
        LocalServices.saveToken(context, token);
        Log.d("LoginPresenter", token);
    }
}
