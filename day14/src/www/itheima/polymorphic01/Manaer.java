package www.itheima.polymorphic01;

public class Manaer extends Person{

    @Override
    public void show(){
        System.out.println("管理员的信息为"+getName()+getAge());
    }
}
