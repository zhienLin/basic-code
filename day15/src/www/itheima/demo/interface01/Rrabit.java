package www.itheima.demo.interface01;

public class Rrabit extends Animal{
    public Rrabit() {
    }

    public Rrabit(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("吃胡罗卜");
    }

}
