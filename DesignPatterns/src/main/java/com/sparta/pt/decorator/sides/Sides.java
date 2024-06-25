package com.sparta.pt.decorator.sides;

import com.sparta.pt.decorator.Pizza;

public abstract class Sides extends Pizza {
    private Pizza pizza;

    public Sides(Pizza pizza) {
        this.pizza = pizza;
    }

    public abstract String getDescription();
}
