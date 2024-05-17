package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface
{
   public static Scanner userInput = new Scanner(System.in);

   private DealerShip dealerShip = null;

   public UserInterface()
   {
      dealerShip = DealershipFileManager.getDealership();
      Contract contract = new Contract("date", "Hassan Gulaid", "gulaid06@gmail.com", "vehicle sold",3433, 313){

      };
   }

   public void run()
   {
      Scanner scanner = new Scanner(System.in);
      int choice = 0;

      while (choice != 99)
      {
         System.out.println();
         System.out.println("[1] - Find vehicles within a price range");
         System.out.println("[2] - Find vehicles by make / model");
         System.out.println("[3] - Find vehicles by year range");
         System.out.println("[4] - Find vehicles by color");
         System.out.println("[5] - Find vehicles by mileage range");
         System.out.println("[6] - Find vehicles by type (car, truck, SUV, van)");
         System.out.println("[7] - List ALL vehicles");
         System.out.println("[8] - Add a vehicle");
         System.out.println("[9] - Remove a vehicle");
         System.out.println("[10] - Buy a Vehicle");
         System.out.println("[11] - Lease a Vehicle");
         System.out.println("[99] - Quit");

         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         switch (choice)
         {
            case 1:
               findVehiclesWithinPriceRange();
               break;
            case 2:
               findVehiclesByMakeModel();
               break;
            case 3:
               findVehiclesByYearRange();
               break;
            case 4:
               findVehiclesByColor();
               break;
            case 5:
               findVehiclesByMileageRange();
               break;
            case 6:
               findVehiclesByType();
               break;
            case 7:
               listAllVehicles();
               break;
            case 8:
               addVehicle();
               break;
            case 9:
               removeVehicle();
               break;
            case 10:
               buyVehicle();
               break;
            case 11:
               System.out.println("Lease");
                System.out.println();

               break;
            case 99:
               DealershipFileManager.saveDealership(dealerShip);
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Invalid choice. Please try again.");
         }
      }
      scanner.close();
   }

   private void findVehiclesWithinPriceRange() {
      System.out.print("Enter minimum price: ");
      double minPrice = userInput.nextDouble();

      System.out.print("Enter maximum price: ");
      double maxPrice = userInput.nextDouble();
      userInput.nextLine();

      ArrayList<Vehicle> vehiclesInRange = dealerShip.findVehiclesWithinPriceRange(minPrice, maxPrice);
      System.out.println("Vehicles within price range $" + minPrice + " - $" + maxPrice + ":");
      for (Vehicle vehicle : vehiclesInRange)
      {
         printVehicleInfo(vehicle);
      }
   }

   private void findVehiclesByMakeModel() {
      System.out.print("Enter make or model to search: ");
      String makeOrModel = userInput.next();

      ArrayList<Vehicle> matchingVehicles = dealerShip.findVehiclesByMakeModel(makeOrModel);
      System.out.println("Vehicles with make or model \"" + makeOrModel + "\":");
      for (Vehicle vehicle : matchingVehicles)
      {
         printVehicleInfo(vehicle);
      }
   }

   private void findVehiclesByYearRange()
   {
      System.out.print("Enter minimum year: ");
      int minYear = userInput.nextInt();
      System.out.print("Enter maximum year: ");
      int maxYear = userInput.nextInt();

      ArrayList<Vehicle> vehiclesYearRange = dealerShip.findVehiclesByYearRange(minYear, maxYear);
      System.out.println("Vehicles within year range " + minYear + " - " + maxYear + ":");
      for (Vehicle vehicle : vehiclesYearRange)
      {
         printVehicleInfo(vehicle);
      }
   }

   private void findVehiclesByColor()
   {
      System.out.print("Enter color to search: ");
      String color = userInput.next();

      ArrayList<Vehicle> vehiclesColor = dealerShip.findVehiclesByColor(color);
      System.out.println("Vehicles with color \"" + color + "\":");
      for (Vehicle vehicle : vehiclesColor)
      {
         printVehicleInfo(vehicle);
      }
   }

   private void findVehiclesByMileageRange()
   {
      System.out.print("Enter minimum mileage: ");
      int minMileage = userInput.nextInt();
      System.out.print("Enter maximum mileage: ");
      int maxMileage = userInput.nextInt();

      ArrayList<Vehicle> vehiclesMillage = dealerShip.findVehiclesByMileageRange(minMileage, maxMileage);
      System.out.println("Vehicles within mileage range " + minMileage + " - " + maxMileage + ":");
      for (Vehicle vehicle : vehiclesMillage)
      {
         printVehicleInfo(vehicle);
      }
   }

   private void findVehiclesByType()
   {
      System.out.print("Enter type to search (Car, Truck, SUV, Van): ");
      String type = userInput.next();

      ArrayList<Vehicle> vehiclesByType = dealerShip.findVehiclesByType(type);
      System.out.println("Vehicles with type \"" + type + "\":");
      for (Vehicle vehicle : vehiclesByType)
      {
         printVehicleInfo(vehicle);
      }
   }

   private void listAllVehicles()
   {
      System.out.println("All vehicles:");
      for (Vehicle vehicle : dealerShip.getAllVehicles())
      {
         printVehicleInfo(vehicle);
      }
   }

   private void addVehicle()
   {
      System.out.println("Add a new vehicle:");

      System.out.print("Enter VIN: ");
      int vin = userInput.nextInt();
      System.out.print("Enter Year: ");

      int year = userInput.nextInt();
      System.out.print("Enter Make: ");
      String make = userInput.next();
      System.out.print("Enter Model: ");
      String model = userInput.next();
      System.out.print("Enter Vehicle Type: ");
      String vehicleType = userInput.next();
      System.out.print("Enter Color: ");
      String color = userInput.next();
      System.out.print("Enter Odometer: ");
      int odometer = userInput.nextInt();
      System.out.print("Enter Price: ");
      double price = userInput.nextDouble();

      Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
      dealerShip.addVehicle(newVehicle);
      System.out.println("Vehicle added successfully.");
   }

   private void removeVehicle()
   {
      System.out.println("Remove a vehicle:");

      System.out.print("Enter VIN of the vehicle you want to remove: ");
      int vinToRemove = userInput.nextInt();

      boolean removed = false;
      for (Vehicle vehicle : dealerShip.getAllVehicles())
      {
         if (vehicle.getVin() == vinToRemove)
         {
            dealerShip.removeVehicle(vehicle);
            removed = true;
            System.out.println("Vehicle removed successfully.");
            break;
         }
      }
      if (!removed)
      {
         System.out.println("Vehicle with VIN " + vinToRemove + " not found.");
      }
   }
   private void printVehicleInfo(Vehicle vehicle)
   {
      String vehicleInfo = String.format("VIN:%-10d  Year:%-10d  Make:%-10s  Model:%-10s  Type:%-10s  Color:%-10s  Odometer:%-10d miles  Price:$%-10.2f", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

      System.out.println(vehicleInfo);
   }

   private void buyVehicle()
   {
      System.out.println("Select Vin of Vehicle");
   }

}
