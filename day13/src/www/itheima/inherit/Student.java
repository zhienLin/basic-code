package www.itheima.inherit;

public class Student {
    String name;
    String gender;
    String school;

    //需求：默认是传智大学
    public Student() {
        //表示调用本类其他构造方法
        //细节:虚拟机就不会再添加super();
        //因为这里的this相当于调用了下面的带参构造.
        //而带参构造已经隐含了super();
        //同样的也需要写在第一行，一般就是在有默认值的时候使用。
        this( null,null,"传智大学");

    }

    public Student(String name, String gender, String school) {
        this.name = name;
        this.gender = gender;
        this.school = school;
    }
}
