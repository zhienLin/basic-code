package www.itheima.com.collection.List;

import java.util.ArrayList;

public class ListUtil {

    private ListUtil() {
    }

    public static <E> void addAll(ArrayList<E> list, E e1, E e2){
        list.add(e1);
        list.add(e2);
    }

    public static <E> void addAllMore(ArrayList<E> list, E... e){
        for (E element : e){
            list.add(element);
        }
    }


}
/*
泛型方法：之前我们先是在类定义的时候规定泛型，但是如果只有类当中的一个方法
会去规定泛型，我们就没有必要在类中去规定了，直接在方法中规定就可以了。
 */