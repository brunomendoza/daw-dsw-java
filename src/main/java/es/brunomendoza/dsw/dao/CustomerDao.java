package es.brunomendoza.dsw.dao;

import es.brunomendoza.dsw.model.Customer;

import java.sql.*;
import java.util.List;

public class CustomerDao implements Dao<Customer>{
    public Customer authenticate (String username, String password) throws SQLException, ClassNotFoundException {
        Customer customer = null;
        ResultSet resultSet;
        Connection connection = null;
        String query = "SELECT * from customer WHERE username = ? AND password = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://db:3306/dsw", "dsw", "dsw");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            customer = new Customer(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("birthdate"),
                    resultSet.getLong("country_id"),
                    resultSet.getString("address"),
                    resultSet.getString("phone_number1"),
                    resultSet.getString("phone_number2"),
                    resultSet.getString("email"),
                    resultSet.getDate("created_at")
            );
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return customer;
    }

    @Override
    public Customer getById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Customer customer = null;
        ResultSet resultSet;
        String query = "SELECT * FROM customer WHERE id = ? LIMIT 1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://db:3306/dsw", "dsw", "dsw");
            PreparedStatement statement = connection.prepareStatement(query);
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
                    resultSet.getLong("country_id"),
                    resultSet.getString("address"),
                    resultSet.getString("phone_number1"),
                    resultSet.getString("phone_number2"),
                    resultSet.getString("email"),
                    resultSet.getDate(("created_at"))
            );
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return customer;
    }
}
