package id.aicode.jalanaman.register;

import android.content.Context;
import android.util.Log;

import com.squareup.picasso.Downloader;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.RemoteServices;
import id.aicode.jalanaman.services.models.RegisterData;
import id.aicode.jalanaman.services.models.register.RegisterResponse;
import okhttp3.Response;
import retrofit2.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ibam on 7/27/2017.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    RegisterContract.View mView;
    RemoteServices remoteServices;

    public RegisterPresenter() {
        this.remoteServices = new RemoteServices();
    }

    @Override
    public void setView(BaseView view) {
        this.mView = (RegisterContract.View) view;
    }

    @Override
    public void unsetView() {

    }

    @Override
    public void setModel(BaseModel model) {

    }

    @Override
    public void unsetModel() {

    }

    @Override
    public void register(String password, String email, String name, final Context context) {

        Log.d("Registerpresenter", password + email + name);
        RegisterData data = new RegisterData();
        data.setEmail(email);
        data.setUsername(email);
        data.setFirst_name(name);
        data.setPassword(password);

        remoteServices.register(data)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<RegisterResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.registerFailed(e.getMessage());
                    }

                    @Override
                    public void onNext(RegisterResponse registerResponse) {
                        if (registerResponse != null) {
                            saveToken(registerResponse.getToken(), context);
                            mView.registerSuccess();
                        } else {
                            mView.registerFailed("");
                        }
                    }
                });
    }

    private void saveToken(String token, Context context) {
        token = "JWT " + token;
        LocalServices.saveToken(context, token);
        Log.d("LoginPresenter", token);
    }
}

