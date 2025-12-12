package com.pluralsight.workshop9.daos;

import com.pluralsight.workshop9.models.Cart;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl {
    private static DataSource dataSource;

    public CartDaoImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public int addCart(Cart cart){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cart (VIN) VALUES (?);", Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, cart.toString());

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows updated: " + rows);

            try (ResultSet keys = preparedStatement.getGeneratedKeys();) {

                while (keys.next()) {
                    System.out.println("Keys added: " + keys.getInt(1));
                    return keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
    public int deleteCart(Cart cart){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cart WHERE VIN = ?;")) {

            preparedStatement.setString(1, cart.toString());

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows updated: " + rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
    public List<Cart> viewCart(){
        List<Cart> cart = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT c.VIN, v.make, v.model, v.price, v.mileage, v.color, v.type, v.year, v.sold FROM cart AS c JOIN vehicles AS v ON c.VIN = v.VIN;");

             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                int vin = resultSet.getInt("vin");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                int mileage = resultSet.getInt("mileage");
                String color = resultSet.getString("color");
                double price = resultSet.getDouble("price");
                String type = resultSet.getString("type");
                int year = resultSet.getInt("year");
                boolean sold = resultSet.getBoolean("sold");

                Cart viewCart = new Cart(vin,make, model, price, color, type, mileage, year, sold);
                cart.add(viewCart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cart;
    }
}
