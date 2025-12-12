package com.pluralsight.workshop9.daos;

import com.pluralsight.workshop9.models.LeaseContract;
import com.pluralsight.workshop9.models.SalesContract;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LeaseContractDao {
    List<LeaseContract> getAllLeaseContracts(LeaseContract leaseContract);
    LeaseContract addLContract(LeaseContract leaseContract);

}
