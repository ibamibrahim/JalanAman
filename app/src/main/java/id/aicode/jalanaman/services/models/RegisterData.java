package id.aicode.jalanaman.services.models;

/**
 * Created by Ibam on 7/25/2017.
 */

public class RegisterData {

    String username;
    String email;
    String first_name;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegisterData(){}
    public RegisterData(String username, String email, String first_name, String last_name, String password) {
        this.username = username;
        this.email = email;
        this.first_name = first_name;
        this.password = password;
    }
}
