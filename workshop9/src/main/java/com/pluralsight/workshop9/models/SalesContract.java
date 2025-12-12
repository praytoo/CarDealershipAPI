package com.pluralsight.workshop9.models;

import java.sql.Date;

public class SalesContract {
    private Integer salesID;
    private Integer VIN;
    private Date date;

    public Integer getSalesID() {
        return salesID;
    }

    public void setSalesID(Integer salesID) {
        this.salesID = salesID;
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

    public SalesContract(Integer salesID, Integer VIN, Date date) {
        this.salesID = salesID;
        this.VIN = VIN;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sales Contract: " + "\n" +
                "salesID=" + salesID + "\n" +
                ", VIN=" + VIN + "\n" +
                ", date=" + date + "\n" + "-------\n";
    }
}
