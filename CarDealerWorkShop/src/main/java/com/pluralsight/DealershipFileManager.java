package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class DealershipFileManager
{
    public static DealerShip getDealership()
    {
        String filePath = "Files/inventory.csv";
        DealerShip dealership = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath)))
        {
            String dealerShipInformation = bufferedReader.readLine();
            String[] dealershipInfo = dealerShipInformation.split("\\|");

            if (dealershipInfo.length >= 3) {
                String name = dealershipInfo[0];
                String address = dealershipInfo[1];
                String phone = dealershipInfo[2];
                dealership = new DealerShip(name, address, phone);
            }

            String vehicleLines;
            while ((vehicleLines = bufferedReader.readLine()) != null)
            {
                String[] vehicleInfo = vehicleLines.split("\\|");

                if (vehicleInfo.length >= 8)
                {
                    int vin = Integer.parseInt(vehicleInfo[0]);
                    int year = Integer.parseInt(vehicleInfo[1]);
                    String make = vehicleInfo[2];
                    String model = vehicleInfo[3];
                    String vehicleType = vehicleInfo[4];
                    String color = vehicleInfo[5];
                    int odometer = Integer.parseInt(vehicleInfo[6]);
                    double price = Double.parseDouble(vehicleInfo[7]);
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }
        }
        catch (IOException | NumberFormatException exception)
        {
            System.out.println("Sorry we had an error");
        }
        return dealership;
    }

    public static void saveDealership(DealerShip dealership)
    {
        String filePath = "Files/inventory.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");

            for (Vehicle vehicle : dealership.getAllVehicles())
            {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");
            }
        } catch (IOException exception)
        {
            System.out.println("There was an error");
        }
    }
}
