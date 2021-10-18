package login;

import java.io.Serializable;

public class Admin extends Account implements Serializable {


    public Admin() {
    }

    public Admin(String username, String password, String id, String fullName) {
        super(username, password, id, fullName);
        super.setRole("Admin");
    }




    @Override
    public String toString() {
        return "Admin{} " + super.toString();
    }
}
