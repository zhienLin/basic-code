package HWday08;

public class Phone {
    private String brand;
    private int price;
    private String color;

    public Phone() {
    }

    public Phone(String brand, int price, String color) {
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

    public void call(String brand,int price, String color){
        System.out.println("利用"+price+"的"+brand+"的"+color+"手机打电话");
    }

    public void sendMessage(String brand,int price, String color){
        System.out.println("利用"+price+"的"+brand+"的"+color+"手机发短信");
    }
}
