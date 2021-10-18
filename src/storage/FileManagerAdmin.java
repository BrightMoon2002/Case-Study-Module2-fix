package storage;

import login.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerAdmin extends BaseFileManager<Admin> {
    private static FileManagerAdmin fileManagerAdmin;

    private FileManagerAdmin() {
    }

    public static FileManagerAdmin getInstance() {
        if (fileManagerAdmin == null) {
            fileManagerAdmin = new FileManagerAdmin();
        }
        return fileManagerAdmin;
    }

    @Override
    public void writeList(List<Admin> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listAdmin.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Admin> readList() {
        List<Admin> adminList = new ArrayList<>();
        File file = new File("listAdmin.txt");
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
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            adminList = (List<Admin>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return adminList;

    }
}

