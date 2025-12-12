package com.pluralsight.workshop9.controllers;

import com.pluralsight.workshop9.models.LeaseContract;
import com.pluralsight.workshop9.models.SalesContract;
import com.pluralsight.workshop9.service.LeaseContractService;
import org.springframework.http.ResponseEntity;
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
    //http://localhost:8080/lease
    @PostMapping
    public LeaseContract addLContract(@RequestBody LeaseContract leaseContract){
        return leaseContractService.addLContract(leaseContract);
    }
    //http://localhost:8080/lease/id/4
    @GetMapping("/id/{id}")
    public ResponseEntity<LeaseContract> getLeaseById(@PathVariable int id){
        LeaseContract leaseContract = leaseContractService.getLeaseById(id);
        if (leaseContract == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(leaseContract);
    }
}
