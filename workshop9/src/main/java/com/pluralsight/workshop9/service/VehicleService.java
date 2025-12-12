package com.pluralsight.workshop9.service;

import com.pluralsight.workshop9.daos.VehicleDao;
import com.pluralsight.workshop9.models.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleService {
    private VehicleDao vehicleDao;

    public VehicleService(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

/*    public int vehicleAdd(){
        return vehicleDao.vehicleAdd();
    }
    public int vehicleDelete(){
        return vehicleDao.vehicleDelete();
    }
    public List<Vehicle> searchByPriceRange(){
        return vehicleDao.searchByPriceRange();
    }
    public List<Vehicle> searchByMakeModel(){
        return vehicleDao.searchByMakeModel();
    }
    public List<Vehicle> searchByYearRange(){
        return vehicleDao.searchByYearRange();
    }
    public List<Vehicle> searchByColor(){
        return vehicleDao.searchByColor();
    }
    public List<Vehicle> searchByMileageRange(){
        return vehicleDao.searchByMileageRange();
    }
    public List<Vehicle> searchByType(){
        return vehicleDao.searchByType();
    }
 */

    @Bean
    public boolean vehicles(){
        return false;
    }
    @Bean
    public Integer vehicles3(){
        return 0;
    }
    @Bean
    public String vehicles2(){
        return "Range Rover";
    }
    public Vehicle vehicleAdd(Vehicle vehicle){
        return vehicleDao.vehicleAdd(vehicle);
    }
    public void updateVehicle(Integer vin, Vehicle vehicle){
        vehicleDao.updateVehicle(vin, vehicle);
    }
    @Bean
    public List<Vehicle> getAllVehicles(Integer minPrice, Integer maxPrice, String make2, String model2, Integer minYear, Integer maxYear, String color2, Integer minMiles, Integer maxMiles, String type2){
        return vehicleDao.getAllVehicles (minPrice, maxPrice, make2, model2, minYear, maxYear, color2, minMiles, maxMiles, type2);
    }
}