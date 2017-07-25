package id.aicode.jalanaman.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.homepage.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.login_button)
    Button mButton;

    @BindView(R.id.email_input)
    EditText inputEmail;

    @BindView(R.id.password_input)
    EditText inputPassword;

    LoginPresenter loginPresenter;
    ProgressDialog dialog;

    String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter();
        loginPresenter.setView(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        loginPresenter.unsetView();
    }

    @OnClick(R.id.login_button)
    public void buttonLoginClicked(){
        Log.d(TAG, "ogin with email");
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        Log.d(TAG, email + " " + password);
        loginWithEmail(email, password);
    }

    @Override
    public void loginWithEmail(String password, String email) {
        // show progressDialog
        dialog = Helper.showProgressDialog(this, "Loading..");
        dialog.show();
        loginPresenter.login(email, password);
    }

    @Override
    public void loginSuccess() {
        // pindah activity
        dialog.dismiss();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFailed() {
        dialog.hide();
        Helper.createToast(this, "Login gagal! Email/password anda salah");
    }
}
