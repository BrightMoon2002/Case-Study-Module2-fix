package control;

import login.Account;
import storage.FileManagerAccount;

import java.util.List;

public class AdminManager extends AccountManager{

    public AdminManager() {
    }

    @Override
    public List<Account> getUserList() {
        return super.getUserList();
    }

    @Override
    public void setUserList(List<Account> userList) {
        super.setUserList(userList);
    }

    @Override
    public FileManagerAccount getFileManagerUser() {
        return super.getFileManagerUser();
    }

    @Override
    public void setFileManagerUser(FileManagerAccount fileManagerUser) {
        super.setFileManagerUser(fileManagerUser);
    }

    @Override
    public List<Account> findAll() {
        return super.findAll();
    }

    @Override
    public void saveList(Account account) {
        super.saveList(account);
    }

    @Override
    public void removeByIndex(int index) {
        super.removeByIndex(index);
    }

    @Override
    public void changePassword(int index, String password) {
        super.changePassword(index, password);
    }

    @Override
    public void updateByIndex(int index, Account user) {
        super.updateByIndex(index, user);
    }

    @Override
    public Account searchById(String id) {
        return super.searchById(id);
    }

    @Override
    public int searchIndexById(String id) {
        return super.searchIndexById(id);
    }

    @Override
    public Account searchByName(String name) {
        return super.searchByName(name);
    }

    @Override
    public void showAllList() {
        super.showAllList();
    }
}
