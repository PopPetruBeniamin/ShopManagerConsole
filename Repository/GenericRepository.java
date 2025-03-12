package Repository;

import java.util.List;

public interface GenericRepository<T> {
    void add(T t);
    boolean updateByID(int ID,T t);
    void deleteByID(int ID);
    T getByID(int ID);
    List<T> getAll();
}
