package com.pluralsight.workshop9.daos;

import com.pluralsight.inputManager.ContractsFileInput;
import com.pluralsight.models.SalesContract;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SalesContractDao {
    private static DataSource dataSource;

    public SalesContractDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public static int addSalesContract() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO salesContracts (VIN, Date) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, ContractsFileInput.addSalesContract());
            preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows updated: " + rows);

            try (ResultSet keys = preparedStatement.getGeneratedKeys();) {

                boolean results = false;
                while (keys.next()) {
                    results = true;
                    System.out.println("Keys added: " + keys.getInt(1));
                    return keys.getInt(1);
                }if (!results){
                    System.out.println("No results were found");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    public List<SalesContract> displaySalesContract() {
        List<SalesContract> sContract = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT salesID, VIN, date FROM salescontracts;");

             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                int sales_id = resultSet.getInt("salesID");
                int vin = resultSet.getInt("vin");
                Date date = resultSet.getDate("date");

                SalesContract salesContract = new SalesContract(sales_id, vin, date);
                sContract.add(salesContract);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sContract;
    }
}
