package www.itheima.demo;

import java.util.ArrayList;

public class CollectionInClass {
    public static void main(String[] args) {
        //1、创建集合对象
        //泛型：限定集合中存储数据的类型
        //ArrayList<String> list = new ArrayList<>(String);有点麻烦，jdk7以后是接下来的形式：
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);//输出的是“[]”;
        //2、此时我们创建的是ArrayList的对象，而ArrayList是java已经写好的一个类，这个类在底层做了一些处理
        //打印对象不是地址值，而是集合中存储数据内容，在展示的时候会拿[]把所有的数据进行包裹

        /*3、boolean add(E e) 增加元素

             boolean remove(E e) 删除元素
             E remove(int index)

             E set(int index,Ee)修改元素

             E get(int index)查询元素
             int size()*/

        //boolean result = list.add("aaa");//一般不管返回值，因为通过查看add的源码就知道不管添加什么都返回true。
        //System.out.println(result);
        //System.out.println(list);

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        boolean result = list.remove("aaa");
        System.out.println(result);
        System.out.println(list);

        String fff = list.set(0,"ff");
        System.out.println(list);
        System.out.println(fff);//这里返回的是被覆盖的元素

        String s = list.get(1);
        System.out.println(s);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }



    }
}
