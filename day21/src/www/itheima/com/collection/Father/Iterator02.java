package www.itheima.com.collection.Father;

import java.util.*;

public class Iterator02 {
    public static void main(String[] args) {
        /*
        迭代器的细节注意点:
        1.报错NoSuchElementException,
        其实就是最后指向了一个不存在的数，但是因为collection没有索引，所以不会报指针越界异常

        2.迭代器遍历完毕，指针不会复位，如果还想重新遍历，就必须在重新创建Interator的对象

        3.循环中只能用一次next方法，也就是说一个hasNext()的循环里面只能有一个next()方法，
        不然会有NoSuchElementException的异常错误。

        4.迭代器遍历时，不能用集合的方法进行增加或者删除
        暂时当做一个结论先行记忆，在今天我们会讲解源码详细的再来分析。
        如果我实在要删除:那么可以用迭代器提供的remove方法进行删除。
        如果要添加，暂时没有办法。
        */


        //1.创建集合并添加元素
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");
        coll.add("eee");

        Iterator<String> it = coll.iterator();

        while(it.hasNext()){
            String str = it.next();
        }



        //错误1： it.next(); NoSuchElementException

        //错误2：迭代器遍历完毕，指针不会复位，如果还想重新遍历，就必须在重新创建Interator的对象。
        //错误3:循环中只能用一次next方法，也就是说一个hasNext()的循环里面只能有一个next()方法，
        //不然会有NoSuchElementException的异常错误。

        /*Iterator<String> it2 = coll.iterator();
        while(it2.hasNext()){
            String str = it2.next();
            String str2 = it2.next();
            System.out.println(str);
            System.out.println(str2);  NoSuchElementException
        }*/


        //错误4:迭代器遍历时，不能用集合的方法进行增加或者删除

        Iterator<String> it2 = coll.iterator();
        while(it2.hasNext()){
            String str = it2.next();
            if(str.equals("bbb"))
                //coll.remov e("bbb");ConcurrentModificationException
            {
                it2.remove();
            }
            System.out.println(str);
        }
        System.out.println(coll);

    }


}
