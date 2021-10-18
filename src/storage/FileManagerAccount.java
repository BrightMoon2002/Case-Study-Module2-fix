package storage;

import login.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerAccount extends BaseFileManager<Account> {

        private static FileManagerAccount fileManagerAccount;
        private FileManagerAccount() {}
        public static FileManagerAccount getInstance() {
            if (fileManagerAccount == null) {
                fileManagerAccount = new FileManagerAccount();
            }
            return fileManagerAccount;
        }
        @Override
        public void writeList(List<Account> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            File file = new File("listAccount.txt");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
                oos.close();
                fos.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public List<Account> readList() {
            List<Account> accountList = new ArrayList<>();
            File file = new File("listAccount.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (file.length() == 0) {
                return new ArrayList<>();
            }
            try {
                FileInputStream is = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(is);
                accountList = (List<Account>) ois.readObject();
                ois.close();
                is.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return accountList;
        }
    }
