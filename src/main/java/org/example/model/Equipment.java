package org.example.model;

public class Equipment {
    private Ski ski;
    private int quantity;

    public Equipment(int quantity, Ski ski){
        this.quantity = quantity;
        this.ski = ski;
    }

    public Ski getSki() {
        return ski;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
