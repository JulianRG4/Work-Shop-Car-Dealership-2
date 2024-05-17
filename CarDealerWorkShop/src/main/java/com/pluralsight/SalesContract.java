package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTax;
    private int recordingFee;
    private int processingFee;
    private boolean financing;


    public SalesContract(String date, String customerName, String customerEmail, String sold, double totalPrice, double monthlyPayment, double salesTax, int recordingFee, int processingFee)
    {
        super(date, customerName, customerEmail, sold, totalPrice, monthlyPayment);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
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

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinancing() {
        return financing;
    }

    public void setFinancing(boolean financing) {
        this.financing = financing;
    }

    @Override
    public double getTotalPrice()
    {
        double totalPrice = getVehicleSold().get

    }

    @Override
    public double getMonthlyPayment()
    {
        return 0;
    }
}
