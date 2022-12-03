package www.itheima.demo.HW;

public class x2New extends x2Phone implements x2Play{
    @Override
    public void call() {
        System.out.println("newcall");
    }

    @Override
    public void play() {
        System.out.println("newplay");
    }
}
