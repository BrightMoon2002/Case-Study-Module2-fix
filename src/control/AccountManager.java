package control;

import login.Account;
import storage.FileManagerAccount;

import java.util.List;

public class AccountManager implements IGeneralManager<Account>{

        private List<Account> accountList;
        private FileManagerAccount fileManagerAccount;

        public List<Account> getUserList() {
            return accountList;
        }

        public void setUserList(List<Account> userList) {
            this.accountList = userList;
        }

        public FileManagerAccount getFileManagerUser() {
            return fileManagerAccount;
        }

        public void setFileManagerUser(FileManagerAccount fileManagerUser) {
            this.fileManagerAccount = fileManagerUser;
        }

        @Override
        public List<Account> findAll() {
            return accountList;
        }

        @Override
        public void saveList(Account account) {
            accountList.add(account);
            fileManagerAccount.writeList(accountList);

        }

        @Override
        public void removeByIndex(int index) {
            accountList.remove(index);
            fileManagerAccount.writeList(accountList);
        }

        public void changePassword(int index, String password) {
            accountList.get(index).setPassword(password);
            fileManagerAccount.writeList(accountList);
        }

        @Override
        public void updateByIndex(int index, Account user) {
            accountList.set(index, user);
            fileManagerAccount.writeList(accountList);
        }

        @Override
        public Account searchById(String id) {
            Account user = null;
            for (int i = 0; i < accountList.size(); i++) {
                if (accountList.get(i).getId().equals(id)) {
                    user = accountList.get(i);
                    break;
                }
            }
            return user;
        }

        @Override
        public Account searchByName(String name) {
            Account user = null;
            for (int i = 0; i < accountList.size(); i++) {
                if (accountList.get(i).getUsername().equals(name)) {
                    user = accountList.get(i);
                    break;
                }
            }
            return user;
        }

        @Override
        public void showAllList() {
            for (Account account : accountList
            ) {
                System.out.println(account);
            }
        }
    }

