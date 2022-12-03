package www.itheima.demo.InnerClass;

public class Car {//外部类
    private String brand;
    private String color;
    public void method(){
        Engine e = new Engine();
        System.out.println(e.name);//外部类没有办法访问内部类，因为没有创建对象，那么我们就没有办法知道到底是谁的name.
    }
    class Engine{
        private String name;
        private int age;
        public void show(){
            System.out.println(brand);//可以访问外部类的成员变量的，哪怕是私有的
        }
    }
}
