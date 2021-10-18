package control;


import login.Account;
import storage.FileManagerLogin;

import java.util.List;

public class LoginManager {
    private List<Account> accountList;
    private FileManagerLogin fileManagerLogin;

    public LoginManager() {
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> userList) {
        this.accountList = userList;
    }

    public FileManagerLogin getFileManagerLogin() {
        return fileManagerLogin;
    }

    public void setFileManagerLogin(FileManagerLogin fileManagerLogin) {
        this.fileManagerLogin = fileManagerLogin;
    }

    public void saveUser(Account account) {
        if (accountList.size() == 0) {
            accountList.add(account);
        }else {
            accountList.set(0, account);
        }
        fileManagerLogin.writeList(accountList);
    }
}