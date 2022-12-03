package www.itheima.demo;

import java.util.ArrayList;

public class CollectingInClassTest2 {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        //在jdk5以后，int 和 Integer之间可以相互转化

        ArrayList<Character> list1 = new ArrayList<>();
        list1.add('a');
        list1.add('b');
        list1.add('c');
        list1.add('d');
        System.out.println(list1);
    }
}
