package storage;

import java.util.List;

public abstract class BaseFileManager<T>  {
    abstract void writeList(List<T> list) ;
    abstract List<T> readList() ;
}
