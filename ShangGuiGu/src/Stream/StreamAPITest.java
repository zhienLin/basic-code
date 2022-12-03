package Stream;

import Lambda.SonghongkangEmployeeData;
import Lambda.SongkongkangEmployee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 实际开发中，项目中多数数据源都来自于Mysql，Oracle等。
 * 但现在数据源可以更多了，有MongDB，Radis等，而这些NoSQL的数据就需要Java层面去处理。
 * <p>
 * Stream和 Collection集合的区别:Collection是一种静态的内存数据结构，而Stream是有关计算的。
 * 前者是主要面向内存，存储在内存中后者主要是面向CPU，通过CPU实现计算。
 * 可以理解为Stream是对Collection的操作
 * <p>
 * Stream自己不会存储元素。
 * Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream。就像迭代器一样
 * Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 * <p>
 * 1-创建Stream
 * 一个数据源（如:集合、数组〉，获取一个流
 * 2-中间操作
 * 一个中间操作链，对数据源的数据进行处理
 * 3-终止操作(终端操作)
 * 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用。
 * 这也体现了延迟的效果，就是只有中间操作调用的时候并没有立马执行，而是等终止操作出现才开始执行。
 *
 * @author zzy
 * @date 2022-10-18 11:47
 */
public class StreamAPITest {

    //创建的方式一：通过集合
    @Test
    public void test1() {
        List<SongkongkangEmployee> employees = SonghongkangEmployeeData.getEmployees();
        //顺序流的创建，是根据集合的顺序依次操作数据的
        Stream<SongkongkangEmployee> stream = employees.stream();
        //并行流的创建，有很多线程去操作集合的元素，不按顺序
        Stream<SongkongkangEmployee> paralleStream = employees.parallelStream();
    }

    //创建的方式二：通过数组的静态方法：Arrays
    @Test
    public void test2() {
        SongkongkangEmployee e1 = new SongkongkangEmployee(001,"zhangsan");
        SongkongkangEmployee e2 = new SongkongkangEmployee(002,"lisi");
        SongkongkangEmployee e3 = new SongkongkangEmployee(003,"wangwu");
        SongkongkangEmployee [] arr = {e1,e2,e3};
        Stream<SongkongkangEmployee> stream = Arrays.stream(arr);
    }

    //创建的方式三：通过Stream的of()方法
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);
    }

    //创建的方式四：创建无限流
    @Test
    public void test4() {
        //迭代
        Stream.iterate(0,t ->t+2).limit(10).forEach(System.out ::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out ::println);
    }


}
