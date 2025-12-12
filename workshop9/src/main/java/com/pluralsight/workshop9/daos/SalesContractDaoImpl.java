package com.pluralsight.workshop9.daos;

import com.pluralsight.workshop9.models.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class SalesContractDaoImpl implements SalesContractDao{
    private DataSource dataSource;

    public SalesContractDaoImpl() {
    }

    @Autowired
    public SalesContractDaoImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public SalesContract addSContract(SalesContract salesContract) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO salesContracts (VIN, Date) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setInt(1, salesContract.getVIN());
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
        return salesContract;
    }

    @Override
    public List<SalesContract> getAllSalesContracts(SalesContract salesContract) {
        List<SalesContract> sContract = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT salesID, VIN, date FROM salescontracts;");

             ResultSet resultSet = preparedStatement.executeQuery();) {

            while (resultSet.next()) {
                int sales_id = resultSet.getInt("salesID");
                int vin = resultSet.getInt("vin");
                Date date = resultSet.getDate("date");

                SalesContract salesContract2 = new SalesContract(sales_id, vin, date);
                sContract.add(salesContract2);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sContract;
    }
}
