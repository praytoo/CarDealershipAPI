package com.pluralsight.workshop9.daos;

import com.pluralsight.workshop9.models.Vehicle;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDaoImpl implements VehicleDao{
    private static DataSource dataSource;

    public VehicleDaoImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public Vehicle vehicleAdd(Vehicle vehicle) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vehicles (VIN, Sold, color, make, model, price, year, mileage, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);) {
            preparedStatement.setInt(1, vehicle.getVin());
            preparedStatement.setBoolean(2, vehicle.isSold());
            preparedStatement.setString(3, vehicle.getColor());
            preparedStatement.setString(4, vehicle.getMake());
            preparedStatement.setString(5, vehicle.getModel());
            preparedStatement.setInt(6, vehicle.getPrice());
            preparedStatement.setInt(7, vehicle.getYear());
            preparedStatement.setInt(8, vehicle.getOdometer());
            preparedStatement.setString(9, vehicle.getType());

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows updated: " + rows);

            try (ResultSet keys = preparedStatement.getGeneratedKeys();) {

                while (keys.next()) {
                    System.out.println("Keys added: " + keys.getInt(1));
                    }
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void updateVehicle(Integer vin, Vehicle vehicle) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE vehicles SET Sold = ?, color = ?, make = ?, model = ?, price = ?, year = ?, mileage = ?, type = ?" + "WHERE VIN = ?;")) {

            preparedStatement.setBoolean(1, vehicle.isSold());
            preparedStatement.setString(2, vehicle.getColor());
            preparedStatement.setString(3, vehicle.getMake());
            preparedStatement.setString(4, vehicle.getModel());
            preparedStatement.setInt(5, vehicle.getPrice());
            preparedStatement.setInt(6, vehicle.getYear());
            preparedStatement.setInt(7, vehicle.getOdometer());
            preparedStatement.setString(8, vehicle.getType());
            preparedStatement.setInt(9, vehicle.getVin());


            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows updated: " + rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    @Override
    public int vehicleDelete() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM vehicles WHERE VIN = ?;")) {

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows updated: " + rows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
    */

    @Override
    public List<Vehicle> getAllVehicles(Integer minPrice, Integer maxPrice, String make2, String model2, Integer minYear, Integer maxYear, String color2, Integer minMiles, Integer maxMiles, String type2) {
        StringBuilder query = new StringBuilder("SELECT * FROM vehicles WHERE 1=1");
        List<Object> params = new ArrayList<>();
        if(minPrice != null){
            query.append(" AND price > ?");
            params.add(minPrice);
        }
        if(maxPrice != null){
            query.append(" AND price < ?");
            params.add(maxPrice);
        }
        if(make2 != null){
            query.append(" AND make = ?");
            params.add(make2);
        }
        if(model2 != null){
            query.append(" AND model = ?");
            params.add(model2);
        }
        if(minYear != null){
            query.append(" AND year > ?");
            params.add(minYear);
        }
        if(maxYear != null){
            query.append(" AND year < ?");
            params.add(maxYear);
        }
        if(color2 != null){
            query.append(" AND color = ?");
            params.add(color2);
        }
        if(minMiles != null){
            query.append(" AND mileage > ?");
            params.add(minMiles);
        }
        if(maxMiles != null){
            query.append(" AND mileage < ?");
            params.add(maxMiles);
        }
        if(type2 != null){
            query.append(" AND type = ?");
            params.add(type2);
        }
        List<Vehicle> vehicles = new ArrayList<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
        ) {
            for (int i = 0; i < params.size(); i++){
                preparedStatement.setObject(i + 1, params.get(i));
            }

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Integer vin = resultSet.getInt("vin");
                    Integer year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String vehicleType = resultSet.getString("type");
                    String color = resultSet.getString("color");
                    Integer odometer = resultSet.getInt("mileage");
                    Integer price = resultSet.getInt("price");
                    boolean sold = resultSet.getBoolean("sold");


                    vehicles.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price, sold));
                }
            }

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
}
