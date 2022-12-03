package www.itheima.demo.HW;

public class x4OuterDemp {
    public static void main(String[] args) { Outer.method().show(); }
}
interface Inter {
    void show();
}
class Outer {
    public static Inter method(){
        Inter i = new Inter(){
            @Override
            public void show() {
                System.out.println("HelloWord");
            }
        };
        return i;
    }



}
