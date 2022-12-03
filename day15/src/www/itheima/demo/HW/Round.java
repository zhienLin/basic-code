package www.itheima.demo.HW;


import java.text.DecimalFormat;

public class Round extends Shape{
    private double radius;
    public final double PI = 3.14;


    public Round() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Round(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        double area = radius*PI*PI;
        System.out.println("半径为"+radius+"的圆的面积是"+area);
        return area;

    }

    @Override
    public double perimeter() {
        double perimeter = 2*radius*PI;
        System.out.println("半径为"+radius+"的圆的周长是"+perimeter);
        return perimeter;
    }
}
