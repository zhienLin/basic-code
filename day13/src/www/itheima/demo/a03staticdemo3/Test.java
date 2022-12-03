package www.itheima.demo.a03staticdemo3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        //1.定义集合
        ArrayList<Student> list = new ArrayList<>();

        //2.创建对象
        Student s1 = new Student("zahngsan",23,"男");
        Student s2 = new Student("xiaoxiao",19,"女");
        Student s3 = new Student("lisi",29,"男");

        //3.添加对象到集合
        list.add(s1);
        list.add(s2);
        list.add(s3);
        int maxAge = ToolMax.getMaxAge(list);
        System.out.println(maxAge);

    }

}
//思路整理：首先得定义一个学生类型的javabean类。然后在测试类中定义一个集合，用来存储这个学生对象。
// 然后定义一个工具类去获得年龄最大的方法，在测试类中去进行调用。