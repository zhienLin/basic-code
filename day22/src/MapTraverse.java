import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapTraverse {
    /*
    一共有三种遍历方式：
    1：键找值
    2：键值对
    3：Lambda表达式
     */
    public static void main(String[] args) {
        //1键找值
        {
            Map<String , String> m = new HashMap<>();
            m.put("滋榆", "汪彤");
            m.put("至恩","木华");
            m.put("蒋丞","顾飞");
            m.put("大刚","锅锅");

        //1.先把键值放在一个单列的集合中
            Set<String> mSet = m.keySet();
        //2.1遍历集合，得到每一个键（增强for）
            for (String key : mSet) {
        //3.利用m集合中的键获取对应的值，使用get()方法
                String value = m.get(key);
                System.out.println(key + "很爱"+value);
            }
            System.out.println("===========================================");
        //2.2遍历集合，得到每一个键（迭代器）
            Iterator<String> iterator = mSet.iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                String value = m.get(key);
                System.out.println(key + "很爱"+value);
            }
            System.out.println("===========================================");
        //2.3遍历集合，得到每一个键（Lambda）
            mSet.forEach( key ->{
                    String value = m.get(key);
                    System.out.println(key + "很爱"+value); }
            );



        }

        //2键值对
        {
            Map<String , String> m = new HashMap<>();
            m.put("滋榆", "玉儿");
            m.put("汪彤","仙女");
            m.put("顾飞","大飞");

            //获得一个包含键值对对象的集合
            Set<Map.Entry<String, String>> entries = m.entrySet();
            //在集合中遍历每一个键值对对象
            for (Map.Entry<String, String> sweetName : entries) {
                String key = sweetName.getKey();
                String value = sweetName.getValue();
                System.out.println(key+"的小名是"+value);
            }

            Iterator<Map.Entry<String, String>> iterator = entries.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> sweetName = iterator.next();
                String key = sweetName.getKey();
                String value = sweetName.getValue();
                System.out.println(key+"的小名是"+value);
            }


            entries.forEach(sweetName -> {
                    String key = sweetName.getKey();
                    String value = sweetName.getValue();
                    System.out.println(key+"的小名是"+value);
                }
            );

        }

        //3Lambda表达式
        //ForEach其实就是利用第二种方式进行遍历，依次得到每一个键和值
        //在调用accept()的方法就可以了。
        {
            Map<String , String> m = new HashMap<>();
            m.put("滋榆", "玉儿");
            m.put("汪彤","仙女");
            m.put("顾飞","大飞");
            m.forEach((key, value) -> System.out.println(key+"的小名是"+value));
        }
    }
}
