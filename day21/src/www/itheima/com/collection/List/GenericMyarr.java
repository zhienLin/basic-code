package www.itheima.com.collection.List;

public class GenericMyarr {
    public static void main(String[] args) {
        MyArrayList<String> list =  new MyArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        System.out.println(list.toString());

        String s = list.get(2);
        System.out.println(s);

    }
}
