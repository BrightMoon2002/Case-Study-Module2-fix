package storage;


import model.idol.Idol;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerIdol extends BaseFileManager<Idol>{
    private static FileManagerIdol fileManagerIdol;
    private FileManagerIdol() {}
    public static FileManagerIdol getInstance() {
        if (fileManagerIdol == null) {
            fileManagerIdol = new FileManagerIdol();
        }
        return fileManagerIdol;
    }

    @Override
    public void writeList(List<Idol> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listIdol.txt");
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
    public List<Idol> readList() {
        List<Idol> idolList = new ArrayList<>();
        File file = new File("listIdol.txt");
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
            idolList = (List<Idol>) ois.readObject();
            ois.close();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return idolList;
    }
}

