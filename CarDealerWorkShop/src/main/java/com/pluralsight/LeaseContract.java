package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;
    private final double leaseInterestRate = 0.04;
    private final int leaseDuration = 36;

    public LeaseContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicle)
    {
        super(date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = vehicle.getPrice() * 0.5;
        this.leaseFee = vehicle.getPrice() * 0.07;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public double getLeaseInterestRate() {
        return leaseInterestRate;
    }

    public int getLeaseDuration() {
        return leaseDuration;
    }

    @Override
    public double calculateTotalPrice()
    {
        double totalPrice = getVehicle().getPrice() + leaseFee;
        setTotalPrice(totalPrice);
        return totalPrice;
    }

    @Override
    public double calculateMonthlyPayment()
    {
        Scanner stdin = new Scanner(System.in);

        double principal = getTotalPrice();

        float annualInterest = (float) leaseInterestRate * 100;

        int years = 3;

        stdin.close();

        double monthlyInterest = annualInterest / 12 / 100;
        int numberOfPayments = years * 12;

        double monthlyPayment = (principal * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -numberOfPayments));

        setMonthlyPayment(monthlyPayment);
        return monthlyPayment;
    }
}