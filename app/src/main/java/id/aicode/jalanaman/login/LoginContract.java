package id.aicode.jalanaman.login;

import android.content.Context;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;

/**
 * Created by Ibam on 7/16/2017.
 */

public class LoginContract {
    interface Presenter extends BasePresenter {
        void login(String password, String email, Context context);
    }

    interface View extends BaseView {
        void loginWithEmail(String password, String email);
        void loginSuccess();
        void loginFailed();
    }
}
