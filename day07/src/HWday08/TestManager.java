package HWday08;

public class TestManager {
    public static void main(String[] args) {
        Manager m = new Manager("之恩",202410401,19800,8000);
        m.work("之恩",202410401,19800,8000);
    }
}
// 这个很容易和前面的创建方法的情况弄混。
// 一般创建方法的机制是：在同一个类下，创建一个public static void(int, boolean...) 方法名(形参){java语句}
// 但是在创建对象的时候，一般是要创建一个类，类中并没有main程序，里面的方法就是public void 方法名(形参){java语句}，一定是返回值是void,并且没有static关键字修饰