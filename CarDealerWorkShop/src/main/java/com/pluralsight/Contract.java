package com.pluralsight;

public abstract class Contract
{
    private String  date;
    private String customerName;
    private String customerEmail;
    private String vehicleSold;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, String sold, double totalPrice, double monthlyPayment)
    {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = sold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerEmail()
    {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail)
    {
        this.customerEmail = customerEmail;
    }



    public String getVehicleSold()
    {
        return vehicleSold;
    }

    public void setVehicleSold(String vehicleSold)
    {
        this.vehicleSold = vehicleSold;
    }







    static double emi_calculator(double Price, double interestRate, double time)
    {
        double emi;

        interestRate = interestRate / (12 * 100); // one month interest
        time = time * 12; // one month period
        emi = (Price * interestRate * (double) Math.pow(1 + interestRate, time)) / (double) (Math.pow(1 + interestRate, time) - 1);

        return (emi);
    }

    public abstract double getTotalPrice();
    public  abstract double getMonthlyPayment();


}
