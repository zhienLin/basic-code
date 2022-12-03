package www.itheima.demo.interface01;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog("旺旺",1);
        d.eat();
        d.swim();

        Rrabit r = new Rrabit("白白",1);
        r.eat();

        Frog f = new Frog("呱呱",2);
        f.eat();
        f.swim();

        Interimpl i = new Interimpl();
        i.swim();
        Scanner sc = new Scanner(System.in);
        sc.next();

    }
}
