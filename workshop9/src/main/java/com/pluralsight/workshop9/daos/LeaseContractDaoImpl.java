package com.pluralsight.workshop9.daos;

import com.pluralsight.workshop9.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeaseContractDaoImpl {
    private static DataSource dataSource;

    public LeaseContractDaoImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public LeaseContractDaoImpl(int leaseId, int vin, Date date) {
    }


    public int addLeaseContract(LeaseContract leaseContract) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO leaseContracts (VIN, Date) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, leaseContract.toString());
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
    public List<LeaseContract> displayLeaseContract() {
        List<LeaseContract> lContract = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT leaseID, VIN, date FROM leasecontracts;");

             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                int lease_id = resultSet.getInt("leaseID");
                int vin = resultSet.getInt("vin");
                Date date = resultSet.getDate("date");

                LeaseContract leaseContract = new LeaseContract(lease_id, vin, date);
                lContract.add(leaseContract);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lContract;
    }
}
