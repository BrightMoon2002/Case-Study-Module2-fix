package view;

import control.*;
import login.Account;
import login.AccountFactory;
import login.AccountType;
import storage.FileManagerAccount;
import storage.FileManagerLogin;

import java.util.List;
import java.util.Scanner;

public class MenuLogin {
    private static MenuAdmin menuAdmin;
    private static MenuCustomer menuCustomer;


    public static void loginMenu() {

        AccountManager accountManager = new AccountManager();
        LoginManager loginManager = new LoginManager();


        FileManagerAccount fileManagerUser = FileManagerAccount.getInstance();
        accountManager.setFileManagerUser(fileManagerUser);
        List<Account> userList = fileManagerUser.readList();
        accountManager.setUserList(userList);
        Account account1 = AccountFactory.getAccount(AccountType.CUSTOMER, "Mark","123", "222", "Hoang");
        accountManager.saveList(account1);
        Account account2 = AccountFactory.getAccount(AccountType.ADMIN, "Admin1", "1", "1", "Tokuda");
accountManager.saveList(account2);
        FileManagerLogin fileManagerLogin = FileManagerLogin.getInstance();
        loginManager.setFileManagerLogin(fileManagerLogin);
        List<Account> loginList = fileManagerLogin.readList();
        loginManager.setAccountList(loginList);


        while (true) {
            System.out.println("-------Login to come to the Paradise Massage Club-------");
            System.out.println("         ");
            System.out.println("Enter the username:");
            Scanner inputUsername = new Scanner(System.in);
            String username = inputUsername.nextLine();
            Account account = accountManager.searchByName(username);
            if (account != null) {
                System.out.println("Enter the password:");
                Scanner inputPassword = new Scanner(System.in);
                String password = inputPassword.nextLine();
                if (account.getPassword().equals(password)) {
                    if (account.getRole().equalsIgnoreCase("Admin")) {
                        loginManager.saveUser(account);
                        menuAdmin.menuAdmin();

                    } else {
                        loginManager.saveUser(account);
                        menuCustomer.menuCustomer();
                    }
                } else {
                    System.err.println("wrong password");
                }
            } else {
                System.err.println("wrong user");
            }


        }
    }
}
