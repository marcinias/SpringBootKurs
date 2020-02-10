package com.example.work_05_zadanie_03_currency.model;

public class MyCurrency {

    private double usd;
    private double usdInput;
    private String status = "";
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getUsdInput() {
        return usdInput;
    }

    public void setUsdInput(double usdInput) {
        this.usdInput = usdInput;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }
}
