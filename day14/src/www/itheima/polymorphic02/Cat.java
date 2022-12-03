package www.itheima.polymorphic02;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(String color, int age) {
        super(color, age);
    }

    @Override
    public void eat(String something) {
        System.out.println(getAge()+"岁的"+getColor()+"的猫眯着眼睛侧着头吃"+something);
    }

    public void catchMouse(){
        System.out.println("猫捉老鼠");
    }
}
