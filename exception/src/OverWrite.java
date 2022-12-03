

/*方法重写的规则:
        1.子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型 子对子 父对父
        也就是说，如果父类没有抛出异常，子类一定不能抛出异常
        并且所有的异常抛出应该在方法里面
*/


import java.io.FileNotFoundException;
import java.io.IOException;

public class OverWrite {
    public static void main(String[] args) {
        SubClass sp = new SubClass();
        display(sp);
    }

    public static void display(SuperClass s){
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class SuperClass{
    public void method()  throws IOException {
        System.out.println("111");
    }


}

class SubClass extends SuperClass{
    public void method() throws FileNotFoundException {
        System.out.println("222");
    }

}




