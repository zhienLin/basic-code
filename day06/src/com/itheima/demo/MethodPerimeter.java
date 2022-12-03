package com.itheima.demo;

public class MethodPerimeter {
    public static void main(String[] args) {
        squrtPerimeter(25, 20 );
    }

    public static void squrtPerimeter(double Length, double width ) {
        double Perimeter = (Length + width) * 2;
        System.out.println(Perimeter);
    }
}
