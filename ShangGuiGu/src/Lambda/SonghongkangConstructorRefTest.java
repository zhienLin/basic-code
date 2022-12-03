package Lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * 和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 * 抽象方法的返回值类型即为构造器所属的类的类型
 * 二、数组引用
 * 大家可以把数组看做是一个特殊的类，则写法与构造器一致
 * Created by shkstart
 */
public class SonghongkangConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    //new SongkongkangEmployee() 这两个方法都是空参的，返回值都是SongkongkangEmployee类型的
    @Test
    public void test1() {
        Supplier<SongkongkangEmployee> supplier1 = new Supplier() {
            @Override
            public Object get() {
                return new SongkongkangEmployee();
            }
        };
        System.out.println(supplier1.get().getName() + 1);

        Supplier<SongkongkangEmployee> supplier2 = () -> new SongkongkangEmployee();
        System.out.println(supplier2.get().getName() + 2);


        Supplier<SongkongkangEmployee> supplier3 = SongkongkangEmployee::new;
        System.out.println(supplier3.get().getName() + 3);


    }

    //Function中的R apply(T t)
    @Test
    public void test2() {
        Function<Integer, SongkongkangEmployee> function1 = new Function<Integer, SongkongkangEmployee>() {
            @Override
            public SongkongkangEmployee apply(Integer integer) {
                return new SongkongkangEmployee(integer);
            }
        };
        System.out.println(function1.apply(12).getName());

        Function<Integer, SongkongkangEmployee> function2 = integer -> new SongkongkangEmployee(integer);
        System.out.println(function2.apply(12).getName());

        //因为前面已经指明当前输入的是Integer类型，因此可以不加
        Function<Integer, SongkongkangEmployee> function3 = SongkongkangEmployee::new;
        System.out.println(function3.apply(13).getName());
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3() {
        BiFunction<Integer, String, SongkongkangEmployee> bf1 =
                (Integer integer, String s) -> new SongkongkangEmployee(integer, s);

        System.out.println(bf1.apply(23, "xixi").getName());

        BiFunction<Integer, String, SongkongkangEmployee> bf2 = SongkongkangEmployee::new;
        System.out.println(bf2.apply(23, "hahha").getName());


    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        Function<Integer, String[]> func2 =String[] :: new;
        String[] arr2 = func1.apply(2);
        System.out.println(Arrays.toString(arr2));


    }
}
