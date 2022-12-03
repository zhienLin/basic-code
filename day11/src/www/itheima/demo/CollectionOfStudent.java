package www.itheima.demo;

import java.util.ArrayList;

public class CollectionOfStudent {
    public static void main(String[] args) {
        //创建集合
        ArrayList<Student> list = new ArrayList<>();
        //创建学生对象
        Student s1 = new Student();
        Student s2 = new Student();
        s1.setName("hahaha");
        s1.setAge(18);
        s1.setName("xixixi");
        s1.setAge(19);

        //添加元素
        list.add(s1);
        list.add(s2);
        System.out.println(list.get(0).getName()+","+list.get(0).getAge());

    }



}
