package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager
{
    private static final String CONTRACTS_FILE_PATH = "Files/Contracts.csv";
    private static final ArrayList<Contract> contracts = new ArrayList<>();

    public static void appendContract(Contract contract)
    {
        contracts.add(contract);
        saveContractsToFile();
    }

    private static void saveContractsToFile()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE_PATH)))
        {
            for (Contract contract : contracts)
            {
                if (contract instanceof SalesContract)
                {
                    SalesContract salesContract = (SalesContract) contract;
                    writer.write("SALE|");
                    writer.write(salesContract.getDate() + "|");
                    writer.write(salesContract.getCustomerName() + "|");
                    writer.write(salesContract.getCustomerEmail() + "|");
                    writer.write(salesContract.getVehicleSold() + "|");
                    writer.write(String.valueOf(salesContract.getTotalPrice()) + "|");
                    writer.write(String.valueOf(salesContract.getMonthlyPayment()) + "|");
                    writer.write(salesContract.getSalesTax() + "|");
                    writer.write(salesContract.getRecordingFee() + "|");
                    writer.write(salesContract.getProcessingFee() + "|");
                    writer.write((salesContract.isFinancing() ? "Yes" : "No") + "|");
                    writer.write("\n");
                }
                else if (contract instanceof LeaseContract)
                {
                    LeaseContract leaseContract = (LeaseContract) contract;
                    writer.write("LEASE|");
                    writer.write(leaseContract.getDate() + "|");
                    writer.write(leaseContract.getCustomerName() + "|");
                    writer.write(leaseContract.getCustomerEmail() + "|");
                    writer.write(leaseContract.getVehicleSold() + "|");
                    writer.write(String.valueOf(leaseContract.getTotalPrice()) + "|");
                    writer.write(String.valueOf(leaseContract.getMonthlyPayment()) + "|");
                    writer.write(leaseContract.getExpectedEndingValue() + "|");
                    writer.write(leaseContract.getLeaseFee() + "|");
                    writer.write("\n");
                }
            }
        }
        catch (Exception exception)
        {
            System.out.println("Sorry there was a bug");
        }
    }
}






























