package www.itheima.com.collection.List;
/*
    List系列集合独有的方法:
    void add(int index,E element) 在此集合中的指定位置插入指定的元素
    E remove(int index) 删除指定索引处的元素，返回被删除的元素
    E set(int index,E element) 修改指定索引处的元素，返回被修改的元素
    E get(int index) 返回指定索引处的元素
*/

import java.util.ArrayList;
import java.util.List;

public class FourMeans {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> listInteger = new ArrayList<>();

        list.add("111");
        list.add("222");
        list.add("333");
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);

        //1.add()在对应的索引处添加元素，从该索引开始往后的元素都挪一个，也就是长度会加1。
        {
            list.add(1, "***");
            System.out.println(list);
        }

        //2.remove()
        {
            list.remove(2);
            System.out.println(list);
            //如果集合是Integer类型的，那么想要去删除
            //请问:此时删除的是2这个元素，还是2索引上的元素?为什么?
            //因为在调用方法的时候，如果方法出现了重载现象
            //优先调用，实参跟形参类型一致的那个方法。
            listInteger.remove(2);//此时优先调用的是index
            //如果想要删除'2'这个元素，那么应该手动装箱，转化成对应的包装类。
            Integer i = 2;
            listInteger.remove(i);
            System.out.println(listInteger);
        }

        //3.set() 把对应元素的值进行修改就可以
        {
            String result = list.set(0, "xixi");
            System.out.println(result);
            System.out.println(list);
        }

        //4.get() 获取对应元素的值
        {
            String result = list.get(0);
            System.out.println(result);
            System.out.println(list);
        }


    }


}
