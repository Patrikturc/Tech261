package com.sparta.pt.decorator.sides;

import com.sparta.pt.decorator.Pizza;

public class Chips extends Sides{

    public Chips(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " and Chips";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 20;
    }
}
