package com.pluralsight;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
class DealerShipTest
{
    @Test
    public void addVehicle_Should_AddAVehicle_ToArrayList()
    {
        // arrange
        DealerShip dealerShip = new DealerShip("Test 1", "Test 2", "Test 3");
        Vehicle vehicle = new Vehicle(12345, 2002, "Toyota", "Camry", "Car", "Blue", 10000, 25000.0);

        // act
        dealerShip.addVehicle(vehicle);

        // assert
        int expectedInventorySize = 1;
        int inventorySize = dealerShip.getAllVehicles().size();
        assertEquals(expectedInventorySize, inventorySize, "Because we added 2 vehicles to the inventory");
        assertTrue(dealerShip.getAllVehicles().contains(vehicle), "Because the first vehicle should be in the inventory");
    }

    @Test
    public void testRemoveVehicle()
    {
        // Arrange
        DealerShip dealerShip = new DealerShip("Test1 ", "Test 2", "Test 3");
        Vehicle vehicle = new Vehicle(12345, 2002, "Toyota", "Camry", "Car", "Blue", 10000, 25000.0);

        // Act
        dealerShip.removeVehicle(vehicle);

        // Assert
        int expectedInventorySize = 0;
        int inventorySize = dealerShip.getAllVehicles().size();
        assertEquals(expectedInventorySize, inventorySize, "Because we removed the 1 vehicle from the inventory");

    }
    @Test
    public void testFindVehiclesByColor() {
        // Arrange
        DealerShip dealerShip = new DealerShip("Test DealerShip", "Test Address", "Test Phone");
        Vehicle vehicle1 = new Vehicle(12345, 2022, "Toyota", "Camry", "Car", "Blue", 10000, 25000.0);
        Vehicle vehicle2 = new Vehicle(54321, 2002, "Honda", "Accord", "Car", "Red", 15000, 20000.0);
        Vehicle vehicle3 = new Vehicle(98765, 2002, "Ford", "Fiesta", "Car", "Blue", 20000, 18000.0);

        dealerShip.addVehicle(vehicle1);
        dealerShip.addVehicle(vehicle2);
        dealerShip.addVehicle(vehicle3);

        // Act
        ArrayList<Vehicle> blueVehicles = dealerShip.findVehiclesByColor("Blue");

        // Assert
        int expectedBlueVehicleCount = 2;
        assertEquals(expectedBlueVehicleCount, blueVehicles.size(), "There should be 2 blue vehicles");

        // Check if each blue vehicle is actually in the list
        assertTrue(blueVehicles.contains(vehicle1), "The first blue vehicle should be in the list");
        assertTrue(blueVehicles.contains(vehicle3), "The second blue vehicle should be in the list");
    }
}
