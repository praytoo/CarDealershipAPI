package com.pluralsight.workshop9.controllers;

import com.pluralsight.workshop9.models.Vehicle;
import com.pluralsight.workshop9.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicle")
public class VehicleController {
        private VehicleService vehicleService;

        public VehicleController(VehicleService vehicleService) {
            this.vehicleService = vehicleService;
        }
        //http://localhost:8080/vehicle
        @GetMapping
        public List<Vehicle> getAllVehicle(@RequestParam(required = false) Integer minPrice, @RequestParam (required = false) Integer maxPrice, @RequestParam (required = false) String make2, @RequestParam (required = false) String model2, @RequestParam (required = false) Integer minYear, @RequestParam (required = false) Integer maxYear, @RequestParam (required = false) String color2, @RequestParam (required = false) Integer minMiles, @RequestParam (required = false) Integer maxMiles, @RequestParam (required = false) String type2) {
            return vehicleService.getAllVehicles(minPrice, maxPrice, make2, model2, minYear, maxYear, color2, minMiles, maxMiles, type2);
        }
    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.vehicleAdd(vehicle);
    }
    @PutMapping("{vin}")
    public void updateVehicle(@PathVariable Integer vin, @RequestBody Vehicle vehicle){
        vehicleService.updateVehicle(vin, vehicle);
    }
}
