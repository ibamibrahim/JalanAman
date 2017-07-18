package id.aicode.jalanaman.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.homepage.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener{

    @BindView(R.id.login_button)
    Button mButton;

    @BindView(R.id.email_input)
    EditText inputEmail;

    @BindView(R.id.password_input)
    EditText inputPassword;

    LoginPresenter loginPresenter;

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                loginWithEmail(email, password);
                break;
        }
    }


    @Override
    public void loginWithEmail(String password, String email) {
        // show progressDialog
        Helper.showProgressDialog(this, "Loading..");
        loginPresenter.login(email, password);
    }

    @Override
    public void loginSuccess() {
        // pindah activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFailed() {
        Helper.createToast(this, "Login gagal! Email/password anda salah");
    }
}
