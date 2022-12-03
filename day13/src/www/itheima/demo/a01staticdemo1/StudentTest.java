package www.itheima.demo.a01staticdemo1;

public class StudentTest {
    public static void main(String[] args) {
        Student s1 = new Student("张三",23,"男");
        Student s2 = new Student("潇潇",24,"女");
        //第一种方法是对其中一个成员变量进行赋值调用
        //s1.teacherName = "阿伟老师";
        //第二种方法是对可以通过类名第调用
        Student.teacherName = "阿玮老师";
        s1.showInFo();
        s2.showInFo();

    }


}
