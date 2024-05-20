package com.pluralsight;

import java.time.LocalDate;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee = 100;
    private double processingFee;
    private boolean finance;

    public SalesContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicle, boolean finance) {
        super(date, customerName, customerEmail, vehicle);
        this.finance = finance;
        this.processingFee = (vehicle.getPrice() < 10000) ? 295 : 495;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    @Override
    public double calculateTotalPrice()
    {
        double totalPrice = getVehicle().getPrice() + salesTaxAmount + recordingFee + processingFee;
        setTotalPrice(totalPrice);
        return totalPrice;
    }

    @Override
    public double calculateMonthlyPayment()
    {
        double vehiclePrice = getVehicle().getPrice();
        double monthlyInterest;
        int numberOfPayments;

        if (vehiclePrice >= 10000)
        {
            monthlyInterest = 0.0425 / 12;
            numberOfPayments = 48;
        } else {

            monthlyInterest = 0.0525 / 12;
            numberOfPayments = 24;
        }

        double monthlyPayment = (vehiclePrice * monthlyInterest) / (1 - Math.pow(1 + monthlyInterest, -numberOfPayments));

        setMonthlyPayment(monthlyPayment);
        return monthlyPayment;
    }
}