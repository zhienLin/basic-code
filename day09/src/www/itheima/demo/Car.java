package www.itheima.demo;

public class Car {
    private String brand;
    private int price;
    private String color;

    public Car() {
    }

    //快捷键：Alt + Insert 快速生成有参、无参以及get和set的方法
    public Car(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
