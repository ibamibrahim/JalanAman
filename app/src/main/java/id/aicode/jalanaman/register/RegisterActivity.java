package id.aicode.jalanaman.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.aicode.jalanaman.BuildConfig;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.homepage.MainActivity;
import id.aicode.jalanaman.services.LocalServices;

import static java.security.AccessController.getContext;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {

    @BindView(R.id.email_input_reg)
    TextView email;

    @BindView(R.id.name_input_reg)
    TextView name;

    @BindView(R.id.password_input_reg)
    TextView password;

    @BindView(R.id.password_input_reg_conf)
    TextView passwordConf;

    ProgressDialog dialog;
    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initPresenter();
        ButterKnife.bind(this);

        /** for debugging purpose*/
        if (BuildConfig.BUILD_TYPE.equals("debug")) {
            String random = UUID.randomUUID().toString().substring(0, 7);
            email.setText(random+"@gmail.com");
            name.setText(random+"@gmail.com");
            password.setText("shauguyg3 y21 gua");
            passwordConf.setText("shauguyg3 y21 gua");
        }

        if (LocalServices.isLoggedInBool(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void initPresenter() {
        this.presenter = new RegisterPresenter();
        presenter.setView(this);
    }

    @OnClick(R.id.register_button)
    public void registerButton() {
        String strEmail = email.getText().toString();
        String strPassword = password.getText().toString();
        String strPasswordConf = passwordConf.getText().toString();
        String strName = name.getText().toString();

        if (strEmail.equals("") || strPassword.equals("") || strPasswordConf.equals("") || strName
                .equals("")) {
            Helper.createToast(getApplicationContext(), "Semua field harus diisi!");
        } else {
            if (strPassword.equals(strPasswordConf)) {
                register(strPassword, strEmail, strName);
            } else {
                Helper.createToast(getApplicationContext(), "Password harus sama");
            }
        }
    }

    @Override
    public void register(String password, String email, String name) {
        dialog = Helper.showProgressDialog(this, "Loading..");
        dialog.show();
        presenter.register(password, email, name, getApplicationContext());
    }

    @Override
    public void registerSuccess() {
        dialog.dismiss();
        Helper.createToast(getApplicationContext(), "Register success! Now logging in to " +
                "the apps..");

        final Intent intent = new Intent(this, MainActivity.class);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 1300);
    }

    @Override
    public void registerFailed(String m) {
        dialog.dismiss();
        Helper.createToast(getApplicationContext(), "Register failed! "+m);
    }
}
