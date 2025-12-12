package com.pluralsight.workshop9.models;

import java.sql.Date;

public class LeaseContract {
    private Integer leaseID;
    private Integer VIN;
    private Date date;

    public Integer getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(Integer leaseID) {
        this.leaseID = leaseID;
    }

    public Integer getVIN() {
        return VIN;
    }

    public void setVIN(Integer VIN) {
        this.VIN = VIN;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LeaseContract(Integer leaseID, Integer VIN, Date date) {
        this.leaseID = leaseID;
        this.VIN = VIN;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Lease Contract: " + "\n" +
                "leaseID=" + leaseID + "\n" +
                ", VIN=" + VIN + "\n" +
                ", date=" + date + "\n" + "-------\n";
    }
}
