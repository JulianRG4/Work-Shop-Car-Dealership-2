package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DealerShip {
    public static Scanner userInput = new Scanner(System.in);

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public DealerShip(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> findVehiclesWithinPriceRange(double minPrice, double maxPrice) {
        ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                vehiclesInRange.add(vehicle);
            }
        }
        return vehiclesInRange;
    }

    public ArrayList<Vehicle> findVehiclesByMakeModel(String makeOrModel) {
        ArrayList<Vehicle> vehiclesMakeOrModel = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(makeOrModel) || vehicle.getModel().equalsIgnoreCase(makeOrModel)) {
                vehiclesMakeOrModel.add(vehicle);
            }
        }
        return vehiclesMakeOrModel;
    }

    public ArrayList<Vehicle> findVehiclesByYearRange(int minYear, int maxYear) {
        ArrayList<Vehicle> vehiclesYearRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                vehiclesYearRange.add(vehicle);
            }
        }
        return vehiclesYearRange;
    }

    public ArrayList<Vehicle> findVehiclesByColor(String color) {
        ArrayList<Vehicle> vehiclesColor = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehiclesColor.add(vehicle);
            }
        }
        return vehiclesColor;
    }

    public ArrayList<Vehicle> findVehiclesByMileageRange(int minMileage, int maxMileage) {
        ArrayList<Vehicle> vehiclesMillage = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage) {
                vehiclesMillage.add(vehicle);
            }
        }
        return vehiclesMillage;
    }

    public ArrayList<Vehicle> findVehiclesByType(String type) {
        ArrayList<Vehicle> vehiclesByType = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                vehiclesByType.add(vehicle);
            }
        }
        return vehiclesByType;
    }

    public Vehicle findVehicleByVIN(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null;
    }

    public void printVehicleInfo(Vehicle vehicle) {
        String vehicleInfo = String.format(
                "VIN:%-10d  Year:%-10d  Make:%-10s  Model:%-10s  Type:%-10s  Color:%-10s  Odometer:%-10d miles  Price:$%-10.2f",
                vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(),
                vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        System.out.println(vehicleInfo);
    }

    public void buyOrLeaseVehicle() {
        System.out.println("Buy or Lease a Vehicle:");
        System.out.println("[1] - Buy");
        System.out.println("[2] - Lease");
        System.out.println("[3] - Cancel");

        System.out.print("Enter your choice: ");
        int buyOrLeaseChoice = userInput.nextInt();

        switch (buyOrLeaseChoice) {
            case 1:
                System.out.print("Enter VIN of the vehicle you want to buy: ");
                int vinToBuy = userInput.nextInt();
                buyVehicle(vinToBuy);
                break;
            case 2:
                System.out.print("Enter VIN of the vehicle you want to lease: ");
                int vinToLease = userInput.nextInt();
                leaseVehicle(vinToLease);
                break;
            case 3:
                System.out.println("Transaction canceled.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void buyVehicle(int vinToBuy) {
        Vehicle vehicleToBuy = findVehicleByVIN(vinToBuy);

        if (vehicleToBuy != null) {
            System.out.println("You have selected the following vehicle:");
            printVehicleInfo(vehicleToBuy);
            System.out.print("Confirm purchase (Yes / No): ");
            String confirmation = userInput.next();
            if (confirmation.equalsIgnoreCase("Yes")) {
                System.out.print("Enter your First and Last name: ");
                String customerFirstName = userInput.next();
                String customerLastName = userInput.next();
                String customerName = customerFirstName + " " + customerLastName;
                System.out.print("Enter your email: ");
                String customerEmail = userInput.next();
                System.out.print("Would you like to finance the purchase? (Yes / No): ");
                String financeConfirmation = userInput.next();
                boolean isFinanced = financeConfirmation.equalsIgnoreCase("Yes");

                LocalDate currentDate = LocalDate.now();
                SalesContract salesContract = new SalesContract(currentDate, customerName, customerEmail, vehicleToBuy, isFinanced);
                double totalCost = salesContract.calculateTotalPrice();
                double monthlyPayment = isFinanced ? salesContract.calculateMonthlyPayment() : 0.0;

                List<String> contractData = ContractFileManager.generateSaleContractData(currentDate, customerName, customerEmail, vehicleToBuy, salesContract, totalCost);
                ContractFileManager.saveSaleContract(contractData, isFinanced, monthlyPayment);

                System.out.println("Total Price: $" + String.format("%.2f", totalCost));
                System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);

                removeVehicle(vehicleToBuy);
            } else {
                String customerName = "";
                String customerEmail = "";
                LocalDate currentDate = LocalDate.now();
                SalesContract salesContract = new SalesContract(currentDate, customerName, customerEmail, vehicleToBuy, false);
                double totalCost = salesContract.calculateTotalPrice();
                double monthlyPayment = 0.0;

                List<String> contractData = ContractFileManager.generateSaleContractData(currentDate, customerName, customerEmail, vehicleToBuy, salesContract, totalCost);
                ContractFileManager.saveSaleContract(contractData, false, monthlyPayment);
            }
        } else {
            System.out.println("Vehicle with VIN " + vinToBuy + " not found.");
        }
    }

    public void leaseVehicle(int vinToLease) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(dateFormatter);

        Vehicle vehicleToLease = findVehicleByVIN(vinToLease);
        if (vehicleToLease != null) {
            System.out.println("You have chosen to lease the following vehicle:");
            printVehicleInfo(vehicleToLease);
            System.out.print("Confirm lease (Yes / No): ");
            String confirmation = userInput.next();
            if (confirmation.equalsIgnoreCase("Yes")) {
                double price = vehicleToLease.getPrice();
                double endingValue = price * 0.5;
                double leaseFee = price * 0.07;
                double totalCost = (price - endingValue) + leaseFee;
                double monthlyPayment = (totalCost * (1 + 0.04 * 3)) / 36;

                List<String> leaseContractData = ContractFileManager.generateLeaseContractData(currentDate, vehicleToLease, price, endingValue, leaseFee, totalCost, monthlyPayment);
                ContractFileManager.saveLeaseContract(leaseContractData, monthlyPayment);

                System.out.printf("Monthly Lease Payment: $%.2f\n", monthlyPayment);
                System.out.println("Thank you for leasing with us!");

                removeVehicle(vehicleToLease);
            } else {
                System.out.println("Lease canceled.");
            }
        } else {
            System.out.println("Vehicle with VIN " + vinToLease + " not found.");
        }
    }
}


