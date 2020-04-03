package com.example.work_05_zadanie_03_currency.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCurrency that = (MyCurrency) o;
        return Double.compare(that.usd, usd) == 0 &&
                Double.compare(that.usdInput, usdInput) == 0 &&
                counter == that.counter &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usd, usdInput, status, counter);
    }
}
