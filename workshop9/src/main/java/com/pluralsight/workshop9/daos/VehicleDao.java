package com.pluralsight.workshop9.daos;

import com.pluralsight.workshop9.models.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VehicleDao {
    Vehicle vehicleAdd(Vehicle vehicle);
    void updateVehicle(Integer vin, Vehicle vehicle);
    //int vehicleDelete();
    //List<Vehicle> searchByPriceRange();
    //List<Vehicle> searchByMakeModel();
    //List<Vehicle> searchByYearRange();
    //List<Vehicle> searchByColor();
    //List<Vehicle> searchByMileageRange();
    //List<Vehicle> searchByType();
    List<Vehicle> getAllVehicles(Integer minPrice, Integer maxPrice, String make2, String model2, Integer minYear, Integer maxYear, String color2, Integer minMiles, Integer maxMiles, String type2);
}
