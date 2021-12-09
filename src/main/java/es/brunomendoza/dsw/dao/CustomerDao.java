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
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://db:3306/dsw", "dsw", "dsw");
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            resultSet.next();

            customer = new Customer(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("birthdate"),
                    resultSet.getInt("country_id"),
                    resultSet.getString("address"),
                    resultSet.getString("phone_number1"),
                    resultSet.getString("phone_number2"),
                    resultSet.getDate(("created_at"))
            );
            
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
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
