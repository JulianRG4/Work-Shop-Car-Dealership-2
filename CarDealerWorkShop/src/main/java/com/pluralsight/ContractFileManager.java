package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager {
    private static final String Contracts_File_Path = "Files/Contracts.csv";

    private static final ArrayList<Contract> contract = new ArrayList<>();



    private static void appendContract(Contract contract)
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Contracts_File_Path, true)))
            if (contract instanceof SalesContract)
            {
                SalesContract salesContract = (SalesContract) contract;
                writer.write("Sale".toUpperCase() + "|");
                writer.write(contract.getDate() + "|");
                writer.write(contract.getCustomerName() + "|");
                writer.write(contract.getCustomerEmail() + "|");
                writer.write(contract.getVehicleSold() + "|");
                writer.write(String.valueOf(salesContract.getTotalPrice()) + "|");
                writer.write(String.valueOf(salesContract.getMonthlyPayment()) + "|");
                writer.write(salesContract.getSalesTax() + "|");
                writer.write(salesContract.getRecordingFee() + "|");
                writer.write(salesContract.getProcessingFee() + "|");
                writer.write(salesContract.isFinancing() ? "yes" : "no" + "|");
                writer.write("\n");

            }
            else if (contract instanceof LeaseContract){


            } catch (IOException | NumberFormatException exception)
            {
                System.out.println("There ");

            }




        }





    }





























}
