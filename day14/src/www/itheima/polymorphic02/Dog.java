package www.itheima.polymorphic02;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String color, int age) {
        super(color, age);
    }

    @Override
    public void eat(String something) {
        System.out.println(getAge()+"岁的"+getColor()+"的狗两只前腿死死的抱住"+something+"猛吃");
    }

    public void lookHome(){
        System.out.println("狗看家");
    }
}
