package www.itheima.HW;

public class PhoneTest {
    public static void main(String[] args) {
        Phone.size = 6;
        Phone p = new Phone("苹果",8999);
        System.out.println(p.getBrand()+", "+p.getPrice()+", "+p.size);
        p.call();
        p.sendMessage();
        p.playGame();
    }
}
