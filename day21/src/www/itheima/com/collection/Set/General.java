package www.itheima.com.collection.Set;
/*
无序:存取顺序不一致
不重复:可以去除重复
无索引:没有带索引的方法，所以不能使用普通for循环遍历，也不能通过索引来获取元素
*/

/*
遍历的方式：
1.迭代器遍历
2.增强for
3.Lambda表达式
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class General {
    public static void main(String[] args) {
        //不重复
        Set<String> set = new HashSet<>();
        boolean result1 = set.add("111");
        boolean result2 = set.add("111");
        System.out.println(result2);
        System.out.println(set);

        //无序
        set.add("222");
        set.add("333");
        set.add("444");
        set.add("555");
        System.out.println(set);

        //迭代器遍历
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println("=============================");
        //增强for
        for (String str : set) {
            System.out.println(str);
        }

        System.out.println("=============================");

        set.forEach( s -> System.out.println(s));

    }
}
