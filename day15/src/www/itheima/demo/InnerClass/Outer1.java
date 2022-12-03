package www.itheima.demo.InnerClass;

public class Outer1 {
    private int a = 10;
    class Inner{
        private int a = 10;
        public void show(){
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(Outer1.this.a);
        }
    }
}
