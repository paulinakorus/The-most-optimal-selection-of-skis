package org.example.service;

public class TotalResult {
    private double result;
    private int notServed;
    public TotalResult(double result, int notServed){
        this.result = result;
        this.notServed = notServed;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getNotServed() {
        return notServed;
    }

    public void setNotServed(int notServed) {
        this.notServed = notServed;
    }
}
