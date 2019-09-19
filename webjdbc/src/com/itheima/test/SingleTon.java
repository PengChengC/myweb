package com.itheima.test;

public class SingleTon {
    private SingleTon() {
    }

    private static SingleTon singleTon = new SingleTon();

    public static SingleTon getSingleTon() {
        return singleTon;
    }

    public static void main(String[] args) {
        SingleTon s1 = SingleTon.getSingleTon();
        SingleTon s2 = SingleTon.getSingleTon();
        System.out.println(s1 == s2);
    }
}
