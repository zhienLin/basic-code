package www.itheima.demo.InnerClass1;

public class Test {
    public static void main(String[] args) {
        method(
                new Animal() {
                    @Override
                    public void eat() {

                    }
                }

        );
    }

    public static void method(Animal a){
        a.eat();
    }
}
