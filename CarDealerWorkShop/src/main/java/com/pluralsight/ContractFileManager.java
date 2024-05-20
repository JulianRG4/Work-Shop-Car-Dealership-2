package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContractFileManager {

    private static final String CONTRACTS_FILE_PATH = "Files/Contracts.csv";


    public static void saveLeaseContract(List<String> contractData, double monthlyPayment) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE_PATH, true))) {
            StringBuilder builder = new StringBuilder();
            for (String data : contractData) {
                builder.append(data).append("|");
            }

            writer.write(builder.toString());
            writer.newLine();
        } catch (IOException exception) {
            System.out.println("Sorry there was an error saving the contract.");
        }
    }

    public static void saveSaleContract(List<String> contractData, boolean isFinanced, double monthlyPayment)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE_PATH, true)))
        {
            StringBuilder builder = new StringBuilder();
            for (String data : contractData)
            {
                builder.append(data).append("|");
            }
            builder.append(isFinanced ? "YES" : "NO").append("|");
            builder.append(String.format("%.2f", monthlyPayment));

            writer.write(builder.toString());
            writer.newLine();
        } catch (IOException exception)
        {
            System.out.println("Sorry there was an error saving the contract.");
        }
    }

    public static ArrayList<String> generateSaleContractData(LocalDate currentDate, String customerName, String customerEmail, Vehicle vehicleToBuy, SalesContract salesContract, double totalCost) {
        ArrayList<String> saleContractData = new ArrayList<>();
        saleContractData.add("SALE");
        saleContractData.add(currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        saleContractData.add(customerName);
        saleContractData.add(customerEmail);
        saleContractData.add(String.valueOf(vehicleToBuy.getVin()));
        saleContractData.add(String.valueOf(vehicleToBuy.getYear()));
        saleContractData.add(vehicleToBuy.getMake());
        saleContractData.add(vehicleToBuy.getModel());
        saleContractData.add(vehicleToBuy.getVehicleType());
        saleContractData.add(vehicleToBuy.getColor());
        saleContractData.add(String.valueOf(vehicleToBuy.getOdometer()));
        saleContractData.add(String.valueOf(vehicleToBuy.getPrice()));
        saleContractData.add(String.format("%.2f", salesContract.getSalesTaxAmount()));
        saleContractData.add(String.format("%.2f", salesContract.getRecordingFee()));
        saleContractData.add(String.format("%.2f", salesContract.getProcessingFee()));
        saleContractData.add(String.format("%.2f", totalCost));
        return saleContractData;
    }
    public static ArrayList<String> generateLeaseContractData(LocalDate currentDate, Vehicle vehicleToLease, double price, double endingValue, double leaseFee, double totalCost, double monthlyPayment) {
        Scanner userInput = new Scanner(System.in);

        ArrayList<String> leaseContractData = new ArrayList<>();
        leaseContractData.add("LEASE");
        leaseContractData.add(currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        System.out.print("Enter First and Last name: ");
        leaseContractData.add(userInput.next() + " " + userInput.next());
        System.out.print("Enter email: ");
        leaseContractData.add(userInput.next());
        leaseContractData.add(String.valueOf(vehicleToLease.getVin()));
        leaseContractData.add(String.valueOf(vehicleToLease.getYear()));
        leaseContractData.add(vehicleToLease.getMake());
        leaseContractData.add(vehicleToLease.getModel());
        leaseContractData.add(vehicleToLease.getVehicleType());
        leaseContractData.add(vehicleToLease.getColor());
        leaseContractData.add(String.valueOf(vehicleToLease.getOdometer()));
        leaseContractData.add(String.valueOf(price));
        leaseContractData.add(String.valueOf(endingValue));
        leaseContractData.add(String.format("%.2f", leaseFee));
        leaseContractData.add(String.format("%.2f", totalCost));
        leaseContractData.add(String.format("%.2f", monthlyPayment));
        return leaseContractData;
    }
}