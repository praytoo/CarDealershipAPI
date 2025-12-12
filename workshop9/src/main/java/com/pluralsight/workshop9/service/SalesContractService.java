package com.pluralsight.workshop9.service;

import com.pluralsight.workshop9.daos.SalesContractDao;
import com.pluralsight.workshop9.models.LeaseContract;
import com.pluralsight.workshop9.models.SalesContract;
import com.pluralsight.workshop9.models.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesContractService {
    private SalesContractDao salesContractDao;

    public SalesContractService(SalesContractDao salesContractDao) {
        this.salesContractDao = salesContractDao;
    }


    public List<SalesContract> getAllSalesContracts(SalesContract salesContract){
        return salesContractDao.getAllSalesContracts(salesContract);
    }

    public SalesContract addSContract(SalesContract salesContract){
        return salesContractDao.addSContract(salesContract);
    }

    public SalesContract getSalesById(int id){

        return salesContractDao.getSalesById(id);
    }
}
