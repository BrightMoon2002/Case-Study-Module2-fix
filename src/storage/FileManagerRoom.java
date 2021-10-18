package storage;


import model.room.Room;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManagerRoom extends BaseFileManager<Room> {

    private static FileManagerRoom fileManagerRoom;
    private FileManagerRoom() {}
    public static FileManagerRoom getInstance() {
        if (fileManagerRoom== null) {
            fileManagerRoom = new FileManagerRoom();
        }
        return fileManagerRoom;
    }


    @Override
    public void writeList(List<Room> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listRoom.txt");
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
    public List<Room> readList() {
        List<Room> roomList = new ArrayList<>();
        File file = new File("listRoom.txt");
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
            roomList = (List<Room>) ois.readObject();
            ois.close();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return roomList;
    }
}
