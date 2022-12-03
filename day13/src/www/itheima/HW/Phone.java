package www.itheima.HW;
/*完成代码(按照标准格式写)，然后在测试类中测试。
        1.手机类Phone
        属性:品牌brand,价格price
        无参构造,有参构造
        行为:打电话call,发短信sendMessage,玩游戏playGame
        ⒉测试类
        创建Phone类对象,调用Phone类中的方法
        思考:
        假设所有的手机都有属性屏幕的尺寸(int size),而且假设所有手机的屏幕尺寸为6,应该如何实现?
        提示:
        可以把size定义为静态*/


public class Phone {
    private String brand;
    private int price;
    public static int size;

    public Phone() {
    }

    public Phone(String brand, int price) {
        this.brand = brand;
        this.price = price;
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
    public void call(){
        System.out.println("用手机打电话");
    }

    public void sendMessage(){
        System.out.println("用手机发短信");
    }

    public void playGame(){
        System.out.println("用手机玩游戏");
    }
}
