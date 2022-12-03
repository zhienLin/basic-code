package www.itheima.com;

import www.itheima.com01.Student;
import www.itheima.com02.Teacher;
import www.itheima.com03.MyService;

import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        Student.study();
        Teacher.teach();

        ServiceLoader<MyService> myServices = ServiceLoader.load(MyService.class);
        //这里如果有多个接口的实现类，就会进行一一的遍历
        for (MyService myService : myServices) {
            myService.service();//学IT,来黑马。因为实现类的对象是ITheima,多态的形式，调用的是其实现类的service()方法。
        }

    }
}
