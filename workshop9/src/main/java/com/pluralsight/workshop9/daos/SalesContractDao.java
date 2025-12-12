package com.pluralsight.workshop9.daos;

import com.pluralsight.workshop9.models.SalesContract;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SalesContractDao {
    List<SalesContract> getAllSalesContracts(SalesContract salesContract);
    SalesContract addSContract(SalesContract salesContract);
}
