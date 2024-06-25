package com.sparta.pt.singleton;

public class App {
    public static void main(String[] args) {
        SingletonExample example1 = SingletonExample.getSingletonExample();
        SingletonExample example2 = SingletonExample.getSingletonExample();

        System.out.println(example1.hashCode());
        System.out.println(example2.hashCode());
    }
}
