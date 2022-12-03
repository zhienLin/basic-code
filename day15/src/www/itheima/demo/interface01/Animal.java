package www.itheima.demo.interface01;

public abstract class Animal {
    private String name;
    private int age;
    public abstract void eat();

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
