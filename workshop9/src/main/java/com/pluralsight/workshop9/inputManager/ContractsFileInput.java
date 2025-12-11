package com.pluralsight.workshop9.inputManager;

import java.util.Scanner;

public class ContractsFileInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String addSalesContract(){
        String input = ("What is the vin of the car you wish to sell?");
        System.out.println(input);
        return scanner.nextLine();
    }
    public static String addLeaseContract(){
        String input = ("What is the vin of the car you wish to lease?");
        System.out.println(input);
        return scanner.nextLine();
    }
}
