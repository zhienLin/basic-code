package www.itheima.com.collection.List;

import java.util.Arrays;

public class MyArrayList <E>{
    Object obj []= new Object[10];

    int index = 0;

    public boolean add(E e){
        obj [index++] =  e;
        return true;
    }
    public E get(int a){
        E result = (E) obj[a];
        return result;
    }


    @Override
    public String toString() {
        return "MyArrayList{" +
                "obj=" + Arrays.toString(obj) +
                ", index=" + index +
                '}';
    }
}
/*
我们需要注意的：
1.当我们自己在设计泛型类的时候，要从两个角度去看待，开发者以及使用者。
2.从开发者：我们应该从定义不确定的泛型类型，里面进行操作应该是在Object的基础上的
所以我们定义的是Object类型的数组，在进行加造作的时候，也需要转换成对应的Object类型。
3.但是一旦实现类要使用到返回类型的值，我们就要进行对应类型的强制转换。
以上的思路也是符合java编程的思想。
 */