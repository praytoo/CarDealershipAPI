package com.pluralsight.workshop9.controllers;

import com.pluralsight.workshop9.models.SalesContract;
import com.pluralsight.workshop9.models.Vehicle;
import com.pluralsight.workshop9.service.SalesContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SalesContractController {
    private SalesContractService salesContractService;

    public SalesContractController(SalesContractService salesContractService) {
        this.salesContractService = salesContractService;
    }
    //http://localhost:8080/sales
    @GetMapping
    public List<SalesContract> getAllSalesContracts(SalesContract salesContract) {
        return salesContractService.getAllSalesContracts(salesContract);
    }
    @PostMapping
    public SalesContract addSContract(@RequestBody SalesContract salesContract){
        return salesContractService.addSContract(salesContract);
    }
}
