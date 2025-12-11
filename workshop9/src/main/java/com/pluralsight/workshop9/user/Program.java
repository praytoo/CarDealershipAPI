package com.pluralsight.workshop9.user;

import com.pluralsight.daos.CartDao;
import com.pluralsight.daos.LeaseContractDao;
import com.pluralsight.daos.SalesContractDao;
import com.pluralsight.daos.VehicleDao;
import org.apache.commons.dbcp2.BasicDataSource;

import static com.pluralsight.user.UserInterface.homeScreen;

public class Program {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/cardealershipdatabase");
        dataSource.setUsername("root");
        dataSource.setPassword("yearup");

        VehicleDao dataManager = new VehicleDao(dataSource);
        SalesContractDao dataManager1 = new SalesContractDao(dataSource);
        LeaseContractDao dataManager2 = new LeaseContractDao(dataSource);
        CartDao dataManager4 = new CartDao(dataSource);


        boolean endProgram = false;
        while (!endProgram) {
            endProgram = homeScreen(dataManager, dataManager1, dataManager2, dataManager4);
        }
    }
}
