package www.itheima.demo;

import java.util.Objects;

public class TestRe {
    public static void main(String[] args) {
        int [] data1 = {1,2,3,4,5,6,7,8};
        int [] data2 = {0,2,3,4,5,6,7,8};
        User u1 = null;
        User u2 = new User("xixi","2021222",data2);


        //1.equals====================================================

        //System.out.println(u1.equals(u2));//空指针调用异常，java的Objects解决了这个问题，
        boolean equals = Objects.equals(u1, u2);
        System.out.println(equals);
        //调用的细节：
        //1.方法的底层就是会去判断u1是不是null,如果是null的话，会直接返回false;
        //2.如果不是null,就会利用u1再次去调用equals的方法。
        //3.如果方法没有重写，那就是比较两者的地址值
        //4.如果方法重新写了，那就是比较属性值。

        //2.null====================================================
        User u3 = null;
        User u4 = new User();

        System.out.println(Objects.isNull(u3));
        System.out.println(Objects.isNull(u4));

        System.out.println(Objects.nonNull(u3));
        System.out.println(Objects.nonNull(u4));









    }


}
