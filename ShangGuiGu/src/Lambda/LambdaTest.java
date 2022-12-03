package Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Lambda表达式作为函数式接口的一个实例
 *
 * Java内置的4大函数式接口:
 * 消费型接口Consumer<T>    void    accept(T t)
 * 供给型接口Supplier<T>     T      get()
 * 函数型接口Function<T,R>   R      appLy(T t)
 * 断定型接口Predicate<T>  booLean  test(T t)
 * @author zzy
 * @date 2022-10-18 09:08
 */
public class LambdaTest {

    @Test
    public void test(){
        happyTime(400,  aDouble -> {System.out.println("消费"+aDouble+"元");});
    }
    public void happyTime(double money,Consumer<Double> con){
        con.accept(money);
    }


    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("a1");
        list.add("b1");
        list.add("a2");
        list.add("a3");
        list.add("b2");

        List<String> a = filterString(list, s -> {
                    if (s.startsWith("a"))
                        return true;
                    return false;
                }
        );

        for (String s : a) {
            System.out.println(s);
        }


    }
    public List<String> filterString (List<String> list, Predicate<String> pre){
        ArrayList<String> arrayList = new ArrayList<>();

        for (String s : list) {
            if(pre.test(s))
                arrayList.add(s);
        }
        return arrayList;
    }



}
