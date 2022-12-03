package www.itheima.demo;
/*定义Javabean类:PhonePhone属性:品牌，价格。
        main方法中定义一个集合，存入三个手机对象。
        分别为:小米，1000。苹果，8000。锤子2999。
        定义一个方法，将价格低于3000的手机信息返回。*/


import java.util.ArrayList;

public class CollectionPhone {
    public static void main(String[] args) {
        ArrayList<Phone> list = new ArrayList<>();
        Phone p1 = new Phone("小米",1000);
        Phone p2 = new Phone("苹果",8000);
        Phone p3 = new Phone("锤子",2999);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        ArrayList<Phone> info = cheap(list, 3000);
        System.out.println(info);


    }

    //如果我们要返回多个数据，可以把这些数据先放到一个容器当中，再把容器返回(集合数组)
    public static ArrayList<Phone> cheap (ArrayList<Phone> list , int price){
        ArrayList<Phone> newlist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getPrice() < price) {
                newlist.add(list.get(i));
            }
        }
        return newlist;

    }

}
