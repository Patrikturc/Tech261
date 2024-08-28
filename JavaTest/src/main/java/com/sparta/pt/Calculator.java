package com.sparta.pt;

import java.util.List;

public class Calculator {

    private Integer num1;
    private Integer num2;
    private List<Integer> numbers;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public Integer add() {
        return num1 + num2;
    }

    public Integer subtract() {
        return num1 - num2;
    }

    public Integer multiply() {
        return num1 * num2;
    }

    public Integer divide() {
        try {
            return num1 / num2;
        } catch (ArithmeticException e) {
            throw new DivideByZeroException("Cannot Divide By Zero");
        }
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer sumOfEvenNumbers() {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
