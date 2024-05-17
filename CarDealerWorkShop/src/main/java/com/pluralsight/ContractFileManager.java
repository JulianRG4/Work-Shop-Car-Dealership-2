package com.pluralsight;

import java.io.*;
import java.util.List;

public class ContractFileManager {
    private static final String File_Path = "Files/Contracts.csv";

    public Vehicle getVehicleByVin(int vin, List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles)
        {
            if (vehicle.getVin() == vin)
            {
                return vehicle;
            }
        }
        return null;
    }
}

//    public void saveContract(Contract contract, Vehicle vehicle)
//    {
//        try(PrintWriter printWriter = new PrintWriter(new File("Files/Contracts.csv")))
//        {
//            for ()
//        }
//        catch (IOException _)
//        {
//            System.out.println("sorry there was an error");
//        }
//    }
//
//}
