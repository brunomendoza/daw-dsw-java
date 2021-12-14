package es.brunomendoza.dsw.dao;

import es.brunomendoza.dsw.model.Country;
import es.brunomendoza.dsw.model.Customer;

import java.sql.*;
import java.util.List;

public class CountryDao implements Dao<Country>{
    @Override
    public Country getById(Long id) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Country country = null;
        ResultSet resultSet;
        String query = "SELECT * FROM country WHERE id = ? LIMIT 1";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://db:3306/dsw", "dsw", "dsw");
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            resultSet.next();

            country = new Country(
                    resultSet.getLong("id"),
                    resultSet.getString("name")
            );
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return country;
    }
}
