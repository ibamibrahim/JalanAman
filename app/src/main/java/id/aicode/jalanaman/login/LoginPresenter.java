package id.aicode.jalanaman.login;

import id.aicode.jalanaman.BaseModel;
import id.aicode.jalanaman.BaseView;

/**
 * Created by Ibam on 7/16/2017.
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View mView;

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
    }
}
