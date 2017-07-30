package id.aicode.jalanaman.services.models;

/**
 * Created by Ibam on 7/25/2017.
 */

public class LoginData {
    String email;
    String password;
    String device_token;

    public LoginData(String username, String password, String deviceToken) {
        this.email = username;
        this.password = password;
        this.device_token = deviceToken;
    }
}
