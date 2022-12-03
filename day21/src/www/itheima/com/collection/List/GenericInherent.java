package www.itheima.com.collection.List;

import java.util.ArrayList;

public class GenericInherent {

    public static void main(String[] args) {
        //需求1：泛型不具备继承性，但是数据具备继承性。

            Ye y1 = new Ye();
            Fu f1 = new Fu();

            ArrayList<Ye> ye = new ArrayList<>();
            ArrayList<Fu> fu = new ArrayList<>();
            ArrayList<Zi> zi = new ArrayList<>();

            verify(ye);
            verify(fu);
            verify(zi);

            //1.有问题，也就是不能实现泛型的继承
            verify(fu);

            //2.数据可以继承，因为往里面添加的是数据，所以可以添加其子类的对象
            ye.add(y1);
            ye.add(f1);





        //需求2:定义一个方法，形参是一个集合，但是集合中的数据类型不确定。
        method(ye);
        method(fu);
        method(zi);



    }


    public static <E> void method(ArrayList<E> list){
        System.out.println("执行");
    }

    public static void verify(ArrayList<? extends Ye> ye){
        System.out.println("yeyezaici");
    }
}

class Ye{

}

class Fu extends Ye{

}

class Zi extends Fu{

}



/*
泛型不具备继承性，但是数据具备继承性。也就是泛型里面是什么类型，就必须传递什么类型的数据。
*此时，泛型里面写的是什么类型，那么只能传递什么类型的数据。
*弊端:利用泛型方法有一个小弊端，此时他可以接受任意的数据类型
*希望:本方法虽然不确定类型，但是以后我希望只能传递Ye Fu zi
*此时我们就可以使用泛型的通配符:?也表示不确定的类型，他可以进行类型的限定
*?extends E:表示可以传递E或者E所有的子类类型
*?super E:表示可以传递E或者E所有的父类类型
*?和E的作用是一样的，但是如果写?就不用在方法前面再写一遍了
*应用场景:
1.如果我们在定义类、方法、接口的时候，如果类型不确定，就可以定义泛型类、泛型方法、泛型接口。
2.如果类型不确定，但是能知道以后只能传递某个继承体系中的，就可以泛型的通配符
3.泛型的通配符关键点:可以限定类型的范围。
 */