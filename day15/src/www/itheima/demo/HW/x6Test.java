package www.itheima.demo.HW;

public class x6Test {
    public static void main(String[] args) {
        B b = new B(new InterB() {
            @Override
            public void showB() {
                System.out.println(1);
            }
        }

        );
        b.methodB();

    }
}

interface InterB {
    void showB();
}

//目标：调用成员方法methodB
class B {
    InterB b;

    public B(InterB b) {
        this.b = b;
    }

    public void methodB() {
        b.showB();
    }
}