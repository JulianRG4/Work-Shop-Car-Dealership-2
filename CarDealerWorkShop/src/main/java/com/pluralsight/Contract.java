package com.pluralsight;

public abstract class Contract
{
    private String date;
    private String customerName;
    private String customerEmail;
    private String sold;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, String sold, double totalPrice, double monthlyPayment)
    {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.sold = sold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
}
