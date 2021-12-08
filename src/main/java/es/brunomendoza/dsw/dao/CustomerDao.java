package es.brunomendoza.dsw.dao;

import es.brunomendoza.dsw.model.Customer;

import java.sql.*;
import java.util.List;

public class CustomerDao implements Dao<Customer>{
    @Override
    public Customer getById(Long id) {
        Customer customer = null;
        ResultSet resultSet;
        String query = "SELECT * FROM customer WHERE id = ? LIMIT 1";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://db:3306/ecommerce", "dsw", "dsw");
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return customer;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Boolean save(Customer customer) {
        return null;
    }

    @Override
    public Boolean remove(Customer customer) {
        return null;
    }

    @Override
    public Boolean update(Customer customer) {
        return null;
    }
}
