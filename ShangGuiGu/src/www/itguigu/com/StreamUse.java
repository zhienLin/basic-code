package www.itguigu.com;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamUse {

    //1.筛选与切片
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        //1.filter(Predicate p)─-接收Lambda,从流中排除某些元素。
        employees.stream().filter(employee -> employee.getSalary() < 6000).forEach(System.out::println);

        //2.limit(n)—截断流，使其元素不超过给定数量。
        System.out.println("*************************************");
        employees.stream().limit(5).forEach(System.out::println);

        //3.skip(n)一跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。
        System.out.println("*************************************");
        employees.stream().skip(2).forEach(System.out::println);

        //4.distinct()—筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        Employee e1 = new Employee(1020, "扎克伯格", 35, 2500.32);
        Employee e2 = new Employee(1020, "扎克伯格", 35, 2500.32);
        Employee e3 = new Employee(1020, "扎克伯格", 35, 2500.32);
        Employee e4 = new Employee(1020, "扎克伯格", 35, 2500.32);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        System.out.println("*************************************");
        employees.stream().distinct().forEach(System.out::println);

    }


    //2.映射
    @Test
    public void test2() {
    //map(Function f):接收一个函数作为参数，将元素转换成其他形式或提取信息
    //该函数会被应用到每个无素上，并将其映射成一个新的元素。map()本身就有映射到意思

        //练习1：将集合中的小写字母全部转换为大写
        //map()这个函数可以对这个集合里面的每一个元素进行操作，相当于隐含遍历了集合
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings.stream().map(str -> str.toUpperCase()).forEach(System.out ::println);

        //练习2：获取长度大于3的员工的姓名
        List<String> list = new ArrayList<>();
        System.out.println();
        Stream<String> nameStream = EmployeeData.getEmployees().stream().map(Employee::getName);
        nameStream.filter(s -> s.length()>3).forEach(System.out ::println);
System.out.println("=================================================================================================");


    //flagMap(Function f)-接收一个函数作为参数，将流中的每个值转换为另外一个流，然后把这些流链接起来呢成为一个流
    //可以形象地点理解就是，add()和addAll()的方法，
        /* List list0 = new ArrayList(); list0.add(1);list0.add(2);list0.add(3);
        List list1 = new ArrayList(); list1.add(1);list1.add(2);list1.add(3);
        List list2= new ArrayList();list2.add(4);list2.add(5);list2.add(6);
        List list3= new ArrayList();list2.add(4);list2.add(5);list2.add(6);
        list1.add(list2);//[1, 2, 3, [4, 5, 6]],这个是把list2作为整个参数放进去了
        list0.addAll(list3);//[1, 2, 3, 4, 5, 6]，这个方法是逐个添加的*/

        //Firstly:单纯使用map()的方法
            //这个就是Stream里面有一个Stream,跟二位数组的嵌套关系特别像。也就是对流进行map之后得到的流，是两层的流
            Stream<Stream<Character>> streamStream = strings.stream().map(StreamUse::stringToStream);
            //streamStream.forEach(s -> s.forEach(System.out::println));//a a b b c c d d
            streamStream.forEach(System.out::println);//四个流的地址值

      //Secondly:使用进阶版的flagMap()的方法,对流进行操作之后得到的就是流还是一层的流
            Stream<Character> characterStream = strings.stream().flatMap(StreamUse::stringToStream);
            characterStream.forEach(System.out::println);

    }//优先使用flagMap()

    //3.排序
    @Test
    public void test3(){
        //1.自然排序
        List<Integer> integers = Arrays.asList(1, 34, 6, 7, 23, 7, 556, 2);
        integers.stream().sorted().forEach(System.out::println);

        //2.指定规则排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((o1,o2)-> o1.getAge() - o2.getAge()).forEach(System.out::println);

    }





    //相当于把一个字符串转换成了一个流
    public static  Stream<Character> stringToStream(String str){
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        return list.stream();

    }


}
