package storage;

import model.Bill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerBill extends BaseFileManager<Bill>  {
    private static FileManagerBill fileManagerBill;
    private FileManagerBill() {}
    public static FileManagerBill getInstance() {
        if (fileManagerBill == null) {
            fileManagerBill = new FileManagerBill();
        }
        return fileManagerBill;
    }
    @Override
    public void writeList(List<Bill> list) {

        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listBill.txt");
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
    public List<Bill> readList()  {
        List<Bill> billList = new ArrayList<>();
        File file = new File("listBill.txt");
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
            billList = (List<Bill>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return billList;
    }
}
