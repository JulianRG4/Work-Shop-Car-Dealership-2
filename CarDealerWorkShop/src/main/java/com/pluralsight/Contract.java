package com.pluralsight;

import java.time.LocalDate;

public abstract class Contract
{
    private LocalDate date = LocalDate.now();
    private String customerName;
    private String customerEmail;
    private String sold;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String LocalDate, String customerName, String customerEmail, String sold, double totalPrice, double monthlyPayment)
    {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.sold = sold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public LocalDate getDate() {


        return LocalDate.now();


    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

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

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public double getMonthlyPayment()
    {
        return monthlyPayment;
    }

//public void toString()

}
