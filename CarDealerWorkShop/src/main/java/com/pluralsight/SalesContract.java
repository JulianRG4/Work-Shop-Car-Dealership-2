package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTax;
    private int recordingFee;
    private boolean financing;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle sold, double totalPrice, double monthlyPayment, double salesTax, int recordingFee, int processingFee) {
        super(date, customerName, customerEmail, sold, totalPrice, monthlyPayment);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public int getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(int recordingFee) {
        this.recordingFee = recordingFee;
    }

    public boolean isFinancing() {
        return financing;
    }

    public void setFinancing(boolean financing)
    {
        this.financing = financing;
    }

    @Override
    public double getTotalPrice()
    {

        double totalPrice = getVehicleSold().getPrice() + (getVehicleSold().getPrice() * .05) + 100 + 295;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment()
    {
        if (financing)
        {
            double totalPrice = getTotalPrice();
            if (totalPrice >= 10000)
            {
                return calculateMonthlyPayment(totalPrice, 4.25, 48);
            }
            else
            {
                return calculateMonthlyPayment(totalPrice, 5.25, 24);
            }
        } else {
            return 0;
        }
    }

    private double calculateSalesTax(double totalPrice) {
        return totalPrice * (salesTax / 100.0);
    }

    private double calculateMonthlyPayment(double totalPrice, double annualInterestRate, int numberOfMonths) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        return (totalPrice * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfMonths));
    }

    public int getProcessingFee()
    {
        return 295;
    }
}