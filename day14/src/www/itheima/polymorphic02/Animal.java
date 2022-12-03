package www.itheima.polymorphic02;

public class Animal {
    private String color;
    private int age;
    static {
        System.out.println("111");
    }

    public Animal() {
    }

    public Animal(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(String something){
        System.out.println(age+"岁的"+color+"的动物正在吃"+something);
    }


}
