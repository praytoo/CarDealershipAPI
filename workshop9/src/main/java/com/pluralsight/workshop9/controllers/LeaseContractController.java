package com.pluralsight.workshop9.controllers;

import com.pluralsight.workshop9.models.LeaseContract;
import com.pluralsight.workshop9.models.SalesContract;
import com.pluralsight.workshop9.service.LeaseContractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lease")
public class LeaseContractController {
    private LeaseContractService leaseContractService;

    public LeaseContractController(LeaseContractService leaseContractService) {
        this.leaseContractService = leaseContractService;
    }
    //http://localhost:8080/lease
    @GetMapping
    public List<LeaseContract> getAllLeaseContracts(LeaseContract leaseContract) {
        return leaseContractService.getAllLeaseContracts(leaseContract);
    }
    @PostMapping
    public LeaseContract addLContract(@RequestBody LeaseContract leaseContract){
        return leaseContractService.addLContract(leaseContract);
    }
    //http://localhost:8080/lease/id/4
    @GetMapping("/id/{id}")
    public LeaseContract getLeaseById(@PathVariable Integer id){
        return leaseContractService.getLeaseById(id);
    }
}
