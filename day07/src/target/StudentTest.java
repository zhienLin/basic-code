package target;

public class StudentTest {
    public static void main(String[] args) {
        Student st1 = new Student("张三", 19);
        System.out.println(st1.getName());
        System.out.println(st1.getAge());
    }
}
//我所认为的构造方法就是省事了
//这里反复强调的一点就是：构造方法是创建对象的时候，由虚拟机调用的，
// 给成员变量进行初始化，而不是人为调用的。
// 我觉得可以这么理解：就是我们在创建对象的时候（代码第5行），
// 后面直接跟的是new,其实我们就只是创建了一个对象，但是虚拟机会再去调用public Student()的这个方法。