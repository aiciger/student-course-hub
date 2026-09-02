package hbv.DAO;

import java.util.List;

public interface DAOInterface<T> {
    List<T> findAll();
    T findById(int id);
    T findByName(String name);
    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);
}