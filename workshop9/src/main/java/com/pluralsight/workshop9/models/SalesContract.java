package com.pluralsight.workshop9.models;

import java.sql.Date;

public class SalesContract {
    private int salesID;
    private int VIN;
    private Date date;

    public SalesContract(int salesID, int VIN, Date date) {
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
