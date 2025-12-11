package com.pluralsight.workshop9.user;

import com.pluralsight.daos.CartDao;
import com.pluralsight.daos.LeaseContractDao;
import com.pluralsight.daos.SalesContractDao;
import com.pluralsight.daos.VehicleDao;
import com.pluralsight.models.Cart;
import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.SalesContract;
import com.pluralsight.models.Vehicle;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.inputManager.VehicleInput.getNumberChoice;
import static java.lang.System.out;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public UserInterface() {
    }

    public static boolean homeScreen(VehicleDao dataManager, SalesContractDao dataManager2, LeaseContractDao dataManager3, CartDao dataManager4) {
        String options = ("""
                What do you want to do?
                 1) Add a vehicle
                 2) Delete a vehicle
                 3) Search by price range
                 4) Search by make & model
                 5) Search by year range
                 6) Search by color
                 7) Search by mileage range
                 8) Search by type
                 9) Sell a vehicle
                 10) Lease a vehicle
                 11) View sale information
                 12) View lease information
                 13) Add to cart
                 14) Delete from cart
                 15) View cart
                 0) Exit
                Select an option:
                """);
        switch (getNumberChoice(options)) {
            case 1:
                int vehiclesAdd = dataManager.vehicleAdd();
                System.out.println(vehiclesAdd);
                break;
            case 2:
                int vehiclesDelete = dataManager.vehicleDelete();
                System.out.println(vehiclesDelete);
                break;
            case 3:
                List<Vehicle> vehiclePrice = dataManager.searchByPriceRange();
                System.out.println(vehiclePrice);
                break;
            case 4:
                List<Vehicle> vehicleMakeModel = dataManager.searchByMakeModel();
                System.out.println(vehicleMakeModel);
                break;
            case 5:
                List<Vehicle> vehicleYear = dataManager.searchByYearRange();
                System.out.println(vehicleYear);
                break;
            case 6:
                List<Vehicle> vehicleColor = dataManager.searchByColor();
                System.out.println(vehicleColor);
                break;
            case 7:
                List<Vehicle> vehicleMileage = dataManager.searchByMileageRange();
                System.out.println(vehicleMileage);
                break;
            case 8:
                List<Vehicle> vehicleType = dataManager.searchByType();
                System.out.println(vehicleType);
                break;
            case 9:
                int salesContract = SalesContractDao.addSalesContract();
                out.println(salesContract);
                break;
            case 10:
                int leaseContract = LeaseContractDao.addLeaseContract();
                out.println(leaseContract);
                break;
            case 11:
                List<SalesContract> salesContract2 = dataManager2.displaySalesContract();
                System.out.println(salesContract2);
                break;
            case 12:
                List<LeaseContract> leaseContract2 = dataManager3.displayLeaseContract();
                System.out.println(leaseContract2);
                break;
            case 13:
                int addCart = dataManager4.addCart();
                System.out.println(addCart);
                break;
            case 14:
                int deleteCart = dataManager4.deleteCart();
                System.out.println(deleteCart);
                break;
            case 15:
                List<Cart> viewCart = dataManager4.viewCart();
                System.out.println(viewCart);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                out.println("that's not an option");
                break;
        }
        return false;
    }
}
