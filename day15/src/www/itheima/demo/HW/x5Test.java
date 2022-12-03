package www.itheima.demo.HW;

public class x5Test {
    public static void main(String[] args) {
        A a = new A();
        a.methodA(new InterA() {
            @Override
            public void showA() {
                System.out.println("重写的方法");
            }
        });
    }
}


interface InterA {
    void showA();
}

class A {
    public void methodA(InterA a)
    { a.showA();}
}