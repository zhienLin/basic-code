package www.itheima.polymorphic01;

public class TestPerson {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("zhangsan");
        s.setAge(23);

        Manaer m = new Manaer();
        m.setName("lisi");
        m.setAge(24);

        Teacher t = new Teacher();
        t.setName("wangwu");
        t.setAge(25);

        register(s);
        register(m);
        register(t);
        //既能调用老师，也能调用学生，并且每一个方法都是继承之后的

        //调用成员变量:编译看左边，运行也看左边
        //编译看左边: javac编译代码的时候，会看左边的父类中有没有这个变量，如果有，编译成功，如果没有编译失败。
        //运行也看左边: java运行代码的时候，实际获取的就是左边父类中成员变量的值
        Person s1 = new Student();
        System.out.println(s1.getName());//”张三“ 而不是”张三的儿子“。

        //调用成员方法:编译看左边，运行看右边
        //编译看左边: javac编译代码的时候，会看左边的父类中有没有这个方法，如果有，编译成功，如果没有编译失败。
        //运行也看右边: java运行代码的时候，实际获取的就是右边子类中成员的方法
        s1.show();//学生的信息为张三0

        //理解:
        //Animal a = new Dog( );
        //现在用a去调用变量和方法的呀?是的
        //而a是Animal类型的，所以默认都会从Animal这个类中去找
        //成员变量:在子类的对象中，会把父类的成员变量也继承下的。父: name 子: name
        //成员方法:如果子类对方法进行了重写，那么在虚方法表中是会把父类的方法进行覆盖的。



    }
    public static void register(Person p){
        p.show();
    }
}
