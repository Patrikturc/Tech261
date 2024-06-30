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

        GenericRectangle<? extends Number> integerGenericRectangle3 = new GenericRectangle<>(2.2, 5.5);

        System.out.printf("Object Integer Rectangle Area %f\n", integerGenericRectangle3.getWidth()*integerGenericRectangle3.getHeight());
        //I can use ? as a wild card type but once we pass something in it will become final
        //We can write ? and follow it with extends or super <? extends Number> that will allow all types of number and it's children(Double, Integer etc)
        //We can write ? and follow it with super <? super Number> super will mean this class and any of it's parents)
        //
    }
}
