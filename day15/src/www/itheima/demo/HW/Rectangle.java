package www.itheima.demo.HW;

public class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        double area = length*width;
        System.out.println("长度为"+length+"宽度为"+width+"的长方形的面积是"+area);
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = 2*(length*width);
        System.out.println("长度为"+length+"宽度为"+width+"的长方形的周长是"+perimeter);
        return perimeter;
    }
}
