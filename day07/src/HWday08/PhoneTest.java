package HWday08;

public class PhoneTest {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        p1.setBrand("小米");
        p1.setPrice(3998);
        p1.setColor("黑色");

        p1.call(p1.getBrand(),p1.getPrice(),p1.getColor());
        p1.sendMessage(p1.getBrand(),p1.getPrice(),p1.getColor());
    }
}
