package login;

import java.io.Serializable;

public class Account extends BaseUser implements Serializable {

    private String password;
    private String username;
    private String id;
    private String role;
    private String fullName;

    public Account(String username, String password, String id) {
        this.password = password;
        this.username = username;
        this.id = id;
    }

    public Account(String username, String password, String id, String fullName) {
        this.password = password;
        this.username = username;
        this.id = id;
        this.fullName = fullName;
    }

    public Account() {
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setFullName(String fullName) {

    }

    @Override
    public String getFullName() {
        return getFullName();
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", id='" + id + '\'' +
                "} " + super.toString();
    }
}