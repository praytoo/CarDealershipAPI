package com.pluralsight.workshop9.daos;

import com.pluralsight.workshop9.models.LeaseContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class LeaseContractDaoImpl implements LeaseContractDao{
    private DataSource dataSource;

    public LeaseContractDaoImpl() {
    }

    @Autowired
    public LeaseContractDaoImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public LeaseContractDaoImpl(int leaseId, int vin, Date date) {
    }


    public LeaseContract addLContract(LeaseContract leaseContract) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO leaseContracts (VIN, Date) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setInt(1, leaseContract.getVIN());
            preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));

            int rows = preparedStatement.executeUpdate();

            System.out.println("Rows updated: " + rows);

            try (ResultSet keys = preparedStatement.getGeneratedKeys();) {

                boolean results = false;
                while (keys.next()) {
                    results = true;
                    System.out.println("Keys added: " + keys.getInt(1));
                }if (!results){
                    System.out.println("No results were found");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return leaseContract;
    }
    public List<LeaseContract> getAllLeaseContracts(LeaseContract leaseContract) {
        List<LeaseContract> lContract = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT leaseID, VIN, date FROM leasecontracts;");

             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                int lease_id = resultSet.getInt("leaseID");
                int vin = resultSet.getInt("vin");
                Date date = resultSet.getDate("date");

                LeaseContract leaseContract2 = new LeaseContract(lease_id, vin, date);
                lContract.add(leaseContract2);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lContract;
    }
}
