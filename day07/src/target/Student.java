package target;

public class Student {
    private String name;
    private int age;

    //如果我们自己没有写任何的构造方法，那么虚拟机会自动给我们一个空参的构造方法，里面什么都没有
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //这种构造的方法可以省去使用set的方法

    public void setName(String name) { this.name = name; }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
