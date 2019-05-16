package com.my.flowers.entity;

/**
 * Created by Space on 11.03.2019.
 */
public abstract class Flower {
    private int price;

    public Flower(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
