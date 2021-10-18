package storage;

import login.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerLogin extends BaseFileManager<Account>{
    private static FileManagerLogin fileManagerLogin;
    private FileManagerLogin() {}
    public static FileManagerLogin getInstance() {
        if (fileManagerLogin== null) {
            fileManagerLogin = new FileManagerLogin();
        }
        return fileManagerLogin;
    }


    @Override
    public void writeList(List<Account> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listLogin.txt");
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
        List<Account> loginList = new ArrayList<>();
        File file = new File("listLogin.txt");
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
            loginList = (List<Account>) ois.readObject();
            ois.close();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loginList;
    }
}
