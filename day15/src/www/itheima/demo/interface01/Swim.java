package www.itheima.demo.interface01;
//成员方法：使用public static final修饰。是final是因为没有成员变量，里面都是常量，因此不需要赋值
//构造方法：没有。没有成员变量，自然没有成员方法
//成员方法：默认是public abstract修饰
public interface Swim {
    static final int a = 10;
    public abstract void swim();
}
