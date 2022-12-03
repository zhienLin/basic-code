package www.itguigu.com;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStop {

    //1.匹配与查找
    @Test
    public void test1(){

        List<Employee> employees = EmployeeData.getEmployees();

        //**1:allMatch()
        //练习：是否所有的员工都大于18岁
        boolean resultName = employees.stream().allMatch(e -> e.getAge() > 10);
        System.out.println(resultName);

        //**2:anyMatch(Predicate p)—检查是否至少匹配一个元素
        //练习：是否有员工的月薪大于10000
        boolean resultSalary = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(resultSalary);

        //**3:noneMatch(Predicate p)——检查是否没有匹配的元素
        boolean resultFirstname = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(resultFirstname);

        //**4:findFirst——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //**5:findAny—返回当前流中的任意元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);

        //***6:count—-返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        //***7:max(Comparator c)一返回流中最大值
        //练习:返回最高的工资
        Stream<Double> moneyStream = employees.stream().map(employee -> employee.getSalary());
        Optional<Double> max = moneyStream.max(Double::compare);
        System.out.println(max);

        //***8:min( comparator c)—返回流中最小值练习:返回最低工资的员工
        Optional<Employee> min = employees.stream().min((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()));
        System.out.println(min);

        //***9:forEach(Consumer c)—内部迭代
        employees.stream().forEach( System.out ::println);

        //内部迭代和外部迭代的区别：外部迭代可能需要外部创建一个指针，手动进行指针下移的操作
        //内部迭代自己就会进行自增的操作
    }

    //2.归约
    @Test
    public void test2(){
        //1，reduce(T identity,Binaryoperator)—可以将流中元素反复结合起来，得到一个值,返回T。
        //练习：计算1-100的自然数的和
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        //2，reduce(Binaryoperator)
        List<Employee> employees = EmployeeData.getEmployees();
        Optional<Double> sumSalary= employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
        System.out.println(sumSalary);

        //归约是在对流进行处理的基础上，就流中的数据进行各种各样的操作。
        //比如通过map()的方法，我们能够拿到某些流中的数据值，然后再对流中的数据值进行归约的操作。
        //上面两个函数不一样的地方就是，一个有初始值，一个没有初始值。
    }

    //3.收集
    public void test3(){
        //collect(collector c)--将流转换为其他形式。接收一个collector接口的实现，
        //练习1:查找工资大于6000日的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
        Set<Employee> employeeSet = employees.stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toSet());
    }


}
