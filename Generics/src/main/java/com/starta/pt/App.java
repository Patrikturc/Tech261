package com.starta.pt;

public class App {
    public static void main(String[] args) {
        IntegerRectangle integerRectangle = new IntegerRectangle(2,4);
        System.out.printf("Integer Rectangle Area: %d\n", integerRectangle.getWidth()*integerRectangle.getHeight());

        ObjectRectangle objrect1 = new ObjectRectangle(2, 4);

        System.out.printf("Object Integer Rectangle Area %d\n", (Integer)objrect1.getWidth()*(Integer)objrect1.getLength());

        GenericRectangle<Integer> integerGenericRectangle1 = new GenericRectangle<>(2, 5);
        GenericRectangle<Double> integerGenericRectangle2 = new GenericRectangle<>(2.2, 5.5);
        System.out.printf("Object Integer Rectangle Area %d\n", integerGenericRectangle1.getWidth()*integerGenericRectangle1.getHeight());
        System.out.printf("Object Integer Rectangle Area %f\n", integerGenericRectangle2.getWidth()*integerGenericRectangle2.getHeight());

    }
}
