package control;

import java.util.List;

public interface IGeneralManager<T> {
    List<T> findAll();
    void saveList(T t);
    void removeByIndex(int index);
    void updateByIndex(int index, T t);
    T searchById(String id);
    T searchByName(String name);
    void showAllList();
}
