package www.itheima.com.collection.List;

public class GenericInterface {
    public static void main(String[] args) {
        //1.实现类给出了具体的类型，那么创建对象的时候就不需要额外给出了
        InterfaceDemo1 id = new InterfaceDemo1();
        id.add("aaa");

        //2.实现类延续泛型，创建实现类的时候在确定类型
        //如果想要创建的实现类有多种数据类型的话，就用这种方法。
        InterfaceDemo2<String> st = new InterfaceDemo2<>();
        st.add("1");
        InterfaceDemo2<Integer> inte = new InterfaceDemo2<>();
        inte.add(2);

    }
}
/*
泛型接口的两种使用方式：
1.实现类给出具体的类型。
2.实现类延续泛型，创建实现类的时候在确定类型。
 */