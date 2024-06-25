package com.sparta.pt.decorator.sides;

import com.sparta.pt.decorator.Pizza;

public class Salad extends Sides{

    public Salad(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " and salad";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 10;
    }
}
