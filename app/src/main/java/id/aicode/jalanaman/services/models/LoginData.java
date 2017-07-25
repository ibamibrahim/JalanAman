package id.aicode.jalanaman.services.models;

/**
 * Created by Ibam on 7/25/2017.
 */

public class LoginData {
    String email;
    String password;

    public LoginData(String username, String password) {
        this.email = username;
        this.password = password;
    }
}
