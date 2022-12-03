package www.itheima.polymorphic01;

public class Student extends Person{
    private String name = "张三的儿子";
    public void show(){
        System.out.println("学生的信息为"+getName()+getAge());
    }

}
