package com.pluralsight;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String customerName, String customerEmail, Vehicle sold, double totalPrice, double monthlyPayment, double expectedEndingValue, double leaseFee) {
        super(customerName, customerEmail, sold, totalPrice, monthlyPayment);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return 0; // Implement as per your logic
    }

    @Override
    public double getMonthlyPayment() {
        return 0; // Implement as per your logic
    }
}