package com.pluralsight.workshop9.service;

import com.pluralsight.workshop9.daos.LeaseContractDao;
import com.pluralsight.workshop9.models.LeaseContract;
import com.pluralsight.workshop9.models.SalesContract;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaseContractService {
    private LeaseContractDao leaseContractDao;

    public LeaseContractService(LeaseContractDao leaseContractDao) {
        this.leaseContractDao = leaseContractDao;
    }

    public List<LeaseContract> getAllLeaseContracts(LeaseContract leaseContract){
        return leaseContractDao.getAllLeaseContracts(leaseContract);
    }
    public LeaseContract addLContract(LeaseContract leaseContract){
        return leaseContractDao.addLContract(leaseContract);
    }
    public LeaseContract getLeaseById(int id){
        return leaseContractDao.getLeaseById(id);
    }
}
