package id.aicode.jalanaman.register;

import android.content.Context;

import id.aicode.jalanaman.BasePresenter;
import id.aicode.jalanaman.BaseView;

/**
 * Created by Ibam on 7/27/2017.
 */

public class RegisterContract {

    interface Presenter extends BasePresenter {
        void register(String password, String email, String name, Context context);
    }

    interface View extends BaseView {
        void register(String password, String email, String name);

        void registerSuccess();

        void registerFailed(String m);
    }
}
