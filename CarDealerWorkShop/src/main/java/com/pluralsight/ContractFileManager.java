package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContractFileManager
{

    private static final String CONTRACTS_FILE_PATH = "Files/Contracts.csv";

    public static void saveSaleContract(List<String> contractData, String financeOption, double monthlyPayment) {
        double price = Double.parseDouble(contractData.get(11));
        double salesTax = calculateSalesTax(price);
        double processingFee = calculateProcessingFee(price);
        double totalPrice = price + salesTax + 100.00 + processingFee;

        List<String> fullContractData = new ArrayList<>(contractData);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE_PATH, true))) {
            StringBuilder builder = new StringBuilder();
            for (String data : fullContractData)
            {
                builder.append(data).append("|");
            }
            builder.setLength(builder.length() - 1);
            writer.write(builder.toString());
            writer.newLine();
        } catch (IOException exception) {
            System.out.println("Sorry there was an error");
        }
    }