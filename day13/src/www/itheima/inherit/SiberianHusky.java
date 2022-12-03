package www.itheima.inherit;

public class SiberianHusky extends Dog {
    public SiberianHusky() {}

    @Override
    public void eat() {
        super.eat();
        System.out.println("狗在啃骨头");;
    }

    public void damage(){
        System.out.println("拆家");
    }
}
