package id.aicode.jalanaman.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.aicode.jalanaman.BuildConfig;
import id.aicode.jalanaman.R;
import id.aicode.jalanaman.helper.Helper;
import id.aicode.jalanaman.homepage.MainActivity;
import id.aicode.jalanaman.register.RegisterActivity;
import id.aicode.jalanaman.services.FirebaseInstanceIDService;
import id.aicode.jalanaman.services.LocalServices;
import id.aicode.jalanaman.services.models.login.LoginResponse;
import id.aicode.jalanaman.services.models.login.Place;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.login_button)
    Button mButton;

    @BindView(R.id.email_input)
    EditText inputEmail;

    @BindView(R.id.password_input)
    EditText inputPassword;

    @BindView(R.id.sign_up_now)
    TextView signUpNow;

    LoginPresenter loginPresenter;
    ProgressDialog dialog;

    String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter();
        loginPresenter.setView(this);

        /** for debugging purpose*/
        if (BuildConfig.BUILD_TYPE.equals("debug")) {
            inputEmail.setText("ibrahim52@ui.ac.id");
            inputPassword.setText("ibamibrahim");
        }

        if (LocalServices.isLoggedInBool(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        testToken();
    }

    public void testToken(){
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, token);
        Toast.makeText(getApplicationContext(), token, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.unsetView();
    }

    @OnClick(R.id.login_button)
    public void buttonLoginClicked() {
        Log.d(TAG, "Login with email");
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        Log.d(TAG, email + " " + password);
        loginWithEmail(email, password);
    }

    @OnClick(R.id.sign_up_now)
    public void signUpNowCliked(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginWithEmail(String password, String email) {
        // show progressDialog
        dialog = Helper.showProgressDialog(this, "Loading..");
        dialog.show();
        loginPresenter.login(email, password, getApplicationContext());
    }

    @Override
    public void loginSuccess(LoginResponse response) {
        // pindah activity
        List<Place> place = response.getUser().getProfile().getPlaces();
        String json = Helper.objectToJson(place);
        dialog.dismiss();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("placeJson", json);
        startActivity(intent);
    }

    @Override
    public void loginFailed() {
        dialog.hide();
        Helper.createToast(this, "Login gagal! Email/password anda salah");
    }
}
