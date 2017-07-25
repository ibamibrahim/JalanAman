package id.aicode.jalanaman.services.models;

/**
 * Created by Ibam on 7/25/2017.
 */

public class RegisterData {

    String username;
    String email;
    String first_name;
    String last_name;
    String password;

    public RegisterData(String username, String email, String first_name, String last_name, String password) {
        this.username = username;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }
}
