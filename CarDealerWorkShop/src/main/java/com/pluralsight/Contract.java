package com.pluralsight;

import java.time.LocalDate;

public abstract class Contract
{
    private LocalDate date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(LocalDate date, String customerName, String customerEmail, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public String getCustomerEmail()
    {
        return customerEmail;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public double getMonthlyPayment()
    {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment)
    {
        this.monthlyPayment = monthlyPayment;
    }

    public abstract double calculateTotalPrice();
    public abstract double calculateMonthlyPayment();
}

