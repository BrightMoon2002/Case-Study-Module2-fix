package login;

import java.io.Serializable;

public class Customer extends Account implements Serializable {
    private String mobile;

    public Customer() {
    }


    public Customer(String username, String password, String id, String fullName) {
        super(username, password, id, fullName);
        super.setRole("Customer");
    }

    @Override
    public void setFullName(String fullName) {
        super.setFullName(fullName);
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", mobile='" + mobile + '\'' +
                "} " + super.toString();
    }
}

