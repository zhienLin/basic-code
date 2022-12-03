package www.itheima.com.Lambda;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Integer arr2[] = {9,5,7,1,4,2,10,3,6,8};

        //Lambda的完整格式
        Arrays.sort(arr2, (Integer o1, Integer o2)-> {
                return o2 - o1;
            });
        //Lambda的省略格式（更加精简）
        Arrays.sort(arr2, (o1, o2)-> o2 - o1);//记住这个排序方法就好，感觉Lambda用处不太大。

        System.out.println(Arrays.toString(arr2));


        method(() -> {
            System.out.println("XIXIXIXI");
            //这里相当于对swimming()的方法进行重写
            });



    }

    public static void method(Swim s){
        s.swimming();
    }


    public static class StringSort {
    }
}

interface Swim{
    public abstract void swimming();
}



/*
函数式编程(Functional programming) 是一种思想特点。
函数式编程思想，忽略面向对象的复杂语法，强调做什么，而不是谁去做。
更加关注方法体的逻辑，而不是对象了

具体的形式为：
1、()对应着方法的形参
2、->固定格式
3、{}对应着方法的方法体


Lambda表达式可以用来简化匿名内部类的书写
Lambda表达式只能简化函数式接口的匿名内部类的写法
函数式接口:有且仅有一个抽象方法的接口叫做函数式接口，
          接口上方可以加@FunctionalInterface注解来检验是否是函数式接口

他的核心是：可推导、可省略；所以接口中有且仅有一个抽象方法

1.参数类型可以省略不写。
2.如果只有一个参数，参数可以省略，同时() 也可以省略。
3.如果Lambda表达式的方法体只有一行，大括号，分号，return可以省略不写，需要同时省略。


*/
