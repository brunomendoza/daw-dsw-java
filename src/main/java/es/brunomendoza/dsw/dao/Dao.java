package es.brunomendoza.dsw.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    T getById(Long id) throws SQLException, ClassNotFoundException;
//    List<T> getAll() throws SQLException, ClassNotFoundException;
//    Boolean save(T t) throws SQLException, ClassNotFoundException;
//    Boolean remove(T t) throws SQLException, ClassNotFoundException;
//    Boolean update (T t) throws SQLException, ClassNotFoundException;
}
