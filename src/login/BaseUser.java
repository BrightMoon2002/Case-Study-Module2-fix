package login;

public abstract class BaseUser {
    abstract String getUsername();

    abstract void setUsername(String username);

    abstract String getId();

    abstract void setId(String id);

    abstract String getPassword();

    abstract void setPassword(String password);

    abstract void setRole(String role);

    abstract String getRole();

    abstract void setFullName(String fullName);

    abstract String getFullName();




}
