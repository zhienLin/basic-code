package Lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用!
 * 方法引用可以看做是Lambda表达式深层次的表达。换句话说，方法引用就是Lambda表达式，
 * 也就是函数式接口的一个实例，通过方法的名字来指向一个方法,可以认为是Lambda表达式的一个语法糖。
 * 如下三种主要使用情况:
 * >对象::实例方法名
 * >类::静态方法名
 * >类::实例方法名(实现的方法的参数1作为方法体中的调用者时候可以用)
 * 要求:实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致!(针对情况1和形况2 )
 * 格式:使用操作符::将类(或对象)与方法名分隔开来。
 * <p>
 * 方法引用的使用
 * <p>
 * Created by shkstart.
 */
public class SonghongkangMethodRefTest {

    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1() {
        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("123456789");

        PrintStream out = System.out;
        Consumer<String> con2 = out::println;
        con2.accept("987654321");

    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        SongkongkangEmployee e = new SongkongkangEmployee(2050160, "张滋榆", 23, 25678.12);

        Supplier<String> sup1 = () -> e.getName();
        System.out.println(sup1.get());

        Supplier<String> sup2 = e::getName;
        System.out.println(sup2.get());
    }

    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(1, 2));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(2, 1));


    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        Function<Double, Long> function = Math::round;
        Long apply = function.apply(14.1);
        System.out.println(apply);
    }

    // 情况三：类 :: 实例方法
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test5() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));
        Comparator<String> com2 = String::compareTo;
        System.out.println(com1.compare("abh", "abd"));
    }

    //BiPredicate中的boolean test(T t1, T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6() {
        BiPredicate<Integer, Integer> bp1 = (t1, t2) -> t1.equals(t2);
        System.out.println(bp1.test(1, 2));

        BiPredicate<Integer, Integer> bp2 = Integer::equals;
        System.out.println(bp2.test(1, 1));
    }

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test7() {
        SongkongkangEmployee e = new SongkongkangEmployee(2050160, "张滋", 23, 25678.12);
        Function<SongkongkangEmployee, String> function1 = SongkongkangEmployee ::getName;
        System.out.println(function1.apply(e));

        Function<SongkongkangEmployee, String> function2 = new Function<SongkongkangEmployee, String>() {
            @Override
            public String apply(SongkongkangEmployee songkongkangEmployee) {
                return songkongkangEmployee.getName();
            }
        };
        System.out.println(function2.apply(e));


    }
}

