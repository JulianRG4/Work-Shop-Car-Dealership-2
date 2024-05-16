package com.pluralsight;

import java.util.ArrayList;

public class DealerShip
{
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public DealerShip(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getAllVehicles()
    {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle)
    {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle)
    {
        inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> findVehiclesWithinPriceRange(double minPrice, double maxPrice)
    {
        ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();
        for (Vehicle vehicle : inventory)
        {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice)
            {
                vehiclesInRange.add(vehicle);
            }
        }
        return vehiclesInRange;
    }

    public ArrayList<Vehicle> findVehiclesByMakeModel(String makeOrModel) {
        ArrayList<Vehicle> vehiclesMakeOrModel = new ArrayList<>();
        for (Vehicle vehicle : inventory)
        {
            if (vehicle.getMake().equalsIgnoreCase(makeOrModel) || vehicle.getModel().equalsIgnoreCase(makeOrModel)) {
                vehiclesMakeOrModel.add(vehicle);
            }
        }
        return vehiclesMakeOrModel;
    }

    public ArrayList<Vehicle> findVehiclesByYearRange(int minYear, int maxYear)
    {
        ArrayList<Vehicle> vehiclesYearRange = new ArrayList<>();
        for (Vehicle vehicle : inventory)
        {
            if (vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear)
            {
                vehiclesYearRange.add(vehicle);
            }
        }
        return vehiclesYearRange;
    }

    public ArrayList<Vehicle> findVehiclesByColor(String color)
    {
        ArrayList<Vehicle> vehiclesColor = new ArrayList<>();
        for (Vehicle vehicle : inventory)
        {
            if (vehicle.getColor().equalsIgnoreCase(color))
            {
                vehiclesColor.add(vehicle);
            }
        }
        return vehiclesColor;
    }

    public ArrayList<Vehicle> findVehiclesByMileageRange(int minMileage, int maxMileage) {
        ArrayList<Vehicle> vehiclesMillage = new ArrayList<>();
        for (Vehicle vehicle : inventory)
        {
            if (vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage)
            {
                vehiclesMillage.add(vehicle);
            }
        }
        return vehiclesMillage;
    }

    public ArrayList<Vehicle> findVehiclesByType(String type)
    {
       ArrayList<Vehicle> vehiclesByType = new ArrayList<>();
        for (Vehicle vehicle : inventory)
        {
            if (vehicle.getVehicleType().equalsIgnoreCase(type))
            {
                vehiclesByType.add(vehicle);
            }
        }
        return vehiclesByType;
    }

}


