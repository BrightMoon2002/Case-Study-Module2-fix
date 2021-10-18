package login;

public class AccountFactory {
    private AccountFactory() {}

    public static final Account getAccount(AccountType userType, String userName, String password, String id, String fullName) {
        switch (userType) {
            case ADMIN:
                return  new Admin(userName, password, id, fullName);
            case CUSTOMER:
                return new Customer(userName, password, id, fullName);
            default:
                throw new IllegalArgumentException("This idol type is unsupported");
        }
    }
}
