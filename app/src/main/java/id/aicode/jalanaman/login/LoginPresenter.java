package id.aicode.jalanaman.login;

import java.util.Timer;
import java.util.TimerTask;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.services.RemoteServices;
import id.aicode.jalanaman.services.models.user.UserResponse;
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
    public void login(String password, String email) {
        // connect to services
        // kalo sukses, post event bus dan mView.loginsukses
        remoteServices.login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<UserResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loginFailed();
                    }

                    @Override
                    public void onNext(UserResponse userResponse) {
                        if(userResponse.getUser() != null){
                            mView.loginSuccess();
                        } else {
                            mView.loginFailed();
                        }
                    }
                });
    };
}
