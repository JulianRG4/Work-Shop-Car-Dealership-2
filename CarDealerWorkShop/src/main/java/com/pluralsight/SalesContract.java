package com.pluralsight;

import java.time.LocalDate;

public class SalesContract extends Contract
{
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_UNDER_10000 = 295.00;
    private static final double PROCESSING_FEE_OVER_10000 = 495.00;
    private static final double FINANCING_RATE_UNDER_1000 = 0.0525;
    private static final double FINANCING_RATE_OVER_10000 = 0.0425;
    private static final int LOAN_TERM_UNDER_10000 = 24;
    private static final int LOAN_TERM_OVER_10000 = 48;

    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private double financingFee;
    private double monthlyPayment;

    public SalesContract(LocalDate date, String customerName, String customerEmail, Vehicle vehicleSold, boolean financing)
    {
        super(date, customerName, customerEmail, vehicleSold);
        this.financing = financing;
        calulateFeesAndTaxes();
        calculateMonthlyPayment();
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public double getFinancingFee() {
        return financingFee;
    }

    public void setFinancingFee(double financingFee) {
        this.financingFee = financingFee;
    }

    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    @Override
    public double getTotalPrice()
    {

    }



    public static void calulateFeesAndTaxes


}