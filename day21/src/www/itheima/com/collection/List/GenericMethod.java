package www.itheima.com.collection.List;

import java.util.ArrayList;

public class GenericMethod {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ListUtil.addAll(list1, "hhh","xxx");
        ListUtil.addAllMore(list2, 1,2,3,4,5,6);
        System.out.println(list1);
        System.out.println(list2);
    }


}
