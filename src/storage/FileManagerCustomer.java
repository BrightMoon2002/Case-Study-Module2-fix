package storage;


import login.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerCustomer extends BaseFileManager<Customer> {
    private static FileManagerCustomer fileManagerCustomer;
    private FileManagerCustomer() {}
    public static FileManagerCustomer getInstance() {
        if (fileManagerCustomer == null) {
            fileManagerCustomer = new FileManagerCustomer();
        }
        return fileManagerCustomer;
    }

    @Override
    public void writeList(List<Customer> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listCustomer.txt");
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
    public List<Customer> readList() {
        List<Customer> customerList = new ArrayList<>();
        File file = new File("listCustomer.txt");
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
            customerList = (List<Customer>) ois.readObject();
            ois.close();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
