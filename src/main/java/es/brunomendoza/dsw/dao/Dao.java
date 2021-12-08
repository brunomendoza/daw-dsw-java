package es.brunomendoza.dsw.dao;

import java.util.List;

public interface Dao<T> {
    T getById(Long id);
    List<T> getAll();
    Boolean save(T t);
    Boolean remove(T t);
    Boolean update (T t);
}
