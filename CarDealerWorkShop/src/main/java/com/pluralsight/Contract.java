package com.pluralsight;

import java.time.LocalDate;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;


    public Contract(String customerName, String customerEmail, Vehicle sold) {
        this.date = LocalDate.now().toString(); // Automatically set to current date
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = sold;
    }

    public String getDate() {
        return date;
    }

    // Removed setDate method to ensure date is always the current date

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    static double emi_calculator(double Price, double interestRate, double time) {
        double emi;
        interestRate = interestRate / (12 * 100); // one month interest
        time = time * 12; // one month period
        emi = (Price * interestRate * (double) Math.pow(1 + interestRate, time)) / (double) (Math.pow(1 + interestRate, time) - 1);
        return (emi);
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}