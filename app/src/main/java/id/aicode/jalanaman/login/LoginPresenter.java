package id.aicode.jalanaman.login;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.RemoteServices;
import id.aicode.jalanaman.services.models.login.LoginResponse;
import id.aicode.jalanaman.services.models.login.Place;
import retrofit2.Response;
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
        // connect to service
        String device_token = getDeviceToken();
        remoteServices.login(email, password, device_token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<LoginResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loginFailed();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Response<LoginResponse> response) {
                        LoginResponse loginResponse = response.body();
                        try {
                            Log.d("LoginPresenter", response.isSuccessful() + " " + response
                                    .errorBody().string());
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        if(loginResponse.getUser() != null){
                            mView.loginSuccess(loginResponse);
                            saveTokenAndUsername(loginResponse.getToken(), loginResponse.getUser
                                    ().getUsername(), context);
                        } else {
                            mView.loginFailed();
                        }
                    }
                });
    };

    private String getDeviceToken(){
        return FirebaseInstanceId.getInstance().getToken();
    }

    private void saveTokenAndUsername(String token, String username, Context context){
        token = "JWT " + token;
        LocalServices.saveToken(context, token);
        LocalServices.saveUsername(context, username);
        Log.d("LoginPresenter", token);
    }


}
