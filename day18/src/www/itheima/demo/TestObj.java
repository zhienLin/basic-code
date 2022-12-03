package www.itheima.demo;

import org.w3c.dom.ls.LSOutput;

import java.util.Objects;

public class TestObj {
    public static void main(String[] args) {
        Object object = new Object();
        String s = object.toString();
        System.out.println(s);//java.lang.Object@5594a1b5   包名+类名+@+地址值

        Student s1 = new Student("lili","看书");
        Student s2 = new Student("lili","看书");
        //1、toString==============================================================================
        //System 是一个类名，out是一个静态变量
        //System.out获取一个打印的对象
        //然后调用PRINTLN的方法
        //println()的方法：
        //核心逻辑：当我们打印一个对象的时候，底层会判断当前是否是一个空值，如果是就调用toString的方法。
        //但是我们需要的是属性值，不是地址值，这个时候可以对Student中的toString()方法进行重写。
        System.out.println(s1);
        System.out.println(s1.toString());

        //2、equals==============================================================================
        System.out.println(s1.equals(s2));//false

    }


    static class Student{
        private  String name;
        private  String hobby;

        public Student(String name, String hobby) {
            this.name = name;
            this.hobby = hobby;
        }

        public Student() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", hobby='" + hobby + '\'' +
                    '}';
        }

        //重写之后的方法就是比较属性值
        //没有重写的就是地址值
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;//看看是不是一个对象
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(hobby, student.hobby);
        }

    }


}
//ltoString方法的结论:
//如果我们打印一个对象，想要看到属性值的话，那么就重写toString方法就可以了。
//在重写的方法中，把对象的属性值进行拼接。一般我们用那个快捷插件的时候就会自动生成toString()的方法。
