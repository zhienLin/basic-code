import java.util.HashMap;
import java.util.Map;

public class DoubleCollectionMethod {
    public static void main(String[] args) {
/*      v put(K key,v value) 添加元素
        v remove(objekt key) 根据键删除键值对元素
        void clear() 移除所有的键值对元素
        boolean containsKey(object key) 判断集合是否包含指定的键
        boolean containsValue(object value) 判断集合是否包含指定的值
        boolean isEmpty() 判断集合是否为空
        int size() 集合的长度，也就是集合中键值对的个数
*/
        //Map是一个接口，因此我们不能创建它的对象，只能创建它实现类的对象
        Map<String , String> m = new HashMap<>();
        //1.put():添加+覆盖
        //如果是首次添加，即键未出现过，那就是直接添加，返回null;
        //如果是重复添加，即键已经存在过，那么就会重新覆盖，并且返回之前的"值"。
        String put = m.put("ziyu", "wangtong");
        System.out.println(put);//null
        String put1 = m.put("ziyu", "zhien");
        System.out.println(put1);//wangtong
        m.put("zhien","muhua");
        m.put("jiangcheng","gufei");


        //2.remove(),根据键删除元素，并且返回被删除对象的值
        String result = m.remove("ziyu");
        System.out.println(result);//zhien

        //3.clear()
        //m.clear();

        //4.containsKey()
        boolean containsResult = m.containsKey("zhien");
        System.out.println(containsResult);

        //4.isEmpty()
        System.out.println(m.isEmpty());

        //5.size()
        System.out.println(m.size());


        System.out.println(m);





    }
}
/*
1、双列集合一次需要存一对数据，分别为键和值
2、键不能重复，值可以重复
3、键和值是一一对应的，每一个键只能找到自己对应的值
4、键＋值这个整体我们称之为“键值对”或者“键值对对象”，在Java中叫做“Entry对象”
*/
