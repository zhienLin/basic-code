package www.itheima.demo;

import java.util.ArrayList;

public class CollectionInClassTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        System.out.println(list);//可以直接用输出啊，这道题的作用是什么
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() -1) {
                System.out.print(list.get(i));
                System.out.print(", ");
            }
            else{
                System.out.print(list.get(i));
                System.out.println("]");
            }
        }
    }
}
