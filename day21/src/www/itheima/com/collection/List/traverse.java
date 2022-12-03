package www.itheima.com.collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
        迭代器遍历:在遍历的过程中需要删除元素,请使用迭代器。
        列表迭代器:在遍历的过程中需要添加元素,仅使用列表迭代器。
        增强for遍历、Lambda表达式:仅仅想遍历，那么使用增强for或Lambda表达式。
        普通for:如果遍历的时候想操作索引,可以用普通for。
*/

public class traverse {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");

        //1.迭代器遍历
        {
            Iterator<String> it = list.iterator();//list调用这个方法
            while(it.hasNext()){
                String next = it.next();
                System.out.println(next);
            }
        }

        //2.列表迭代器遍历（只是用于LIST）
        {
            ListIterator<String> stringListIterator = list.listIterator();
            while(stringListIterator.hasNext()){
                String next = stringListIterator.next();
                if("111".equals(next))
                    stringListIterator.add("444");
            }
        }

        //3.增强for遍历
        {
            for (String s : list) {
                System.out.println(s);
            }
        }

        //4.Lambda表达式
        {
            list.forEach( s -> System.out.println(s) );
        }

        //5.普通for 借用size()
        {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }

        System.out.println(list);


    }
}
