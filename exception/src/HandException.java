//之前讲过异常主要有两个过程，"抛"和"抓"
//关于抛，之前处理的都是自动抛出的异常，
//除此之外我们也可以自己手动添加异常 用到的是throw的关键字 这属于第一部分呢

//需要特别注意的是：如果手动抛出的是运行异常，其实并不会报错，因为运行异常本来就可以不用try-catch
//如果是编译异常，解决办法还是之前的两种。

//throw 是抛出异常的一种方式，而throws则是处理异常的一种方式

import java.util.Scanner;

public class HandException {
    public static void main(String[] args) {
        try {
            Student st = new Student();
            st.method(-12);
            System.out.println(st);
        } catch (CreatException e) {
            String message = e.getMessage();
            System.out.println(message);
        }

    }
}
class Student{
    private int id;

    public void method(int id) {
        if(id >= 0) {
            this.id = id;
        }
        else
            throw new CreatException("111");
    }


    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }


    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "Student{id = " + id + "}";
    }
}
