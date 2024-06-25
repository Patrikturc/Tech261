package com.sparta.pt.decorator.sides;

import com.sparta.pt.decorator.Pizza;

public abstract class Sides extends Pizza {
    protected Pizza pizza;

    public Sides(Pizza pizza) { //we have an abstract class that takes another abstract class as a parameter
        this.pizza = pizza;
    }

    public abstract String getDescription();

    @Override
    public double getCost() { //Salad class is decorating the Pizza class
        return super.getCost() + 10;
    }
}
