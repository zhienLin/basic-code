package www.itheima.demo;

import com.google.gson.Gson;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1.先创建一个对象
        int [] data = {1,2,3,4,5,6,7,8};
        User u1 = new User("xixi","2021222",data);

        //2.克隆对象,这里的clone()不能被使用，因为它是Protected，只能在本包里面使用
        //考虑到只能被本包内，或者子类所使用，所以可以考虑方法重写。
        User u2 = (User)u1.clone();


        //Object里面的克隆是浅克隆。
        //如果想要深克隆，我们需要在方法中自己重写。

/*
        System.out.println(u1);
        System.out.println(u2);
*/


        //第三方的工具 放在了lib
        //1.第三方写的代码导入到项目中
        //2.编写代码
        Gson gson = new Gson();
        //把对象变成一个字符串
        String s = gson.toJson(u1);
        //再把字符串变回对象就可以了
        User user = gson.fromJson(s, User.class);

        int[] data1 = u1.getData();
        data1[0] = 100;


        //打印对象
        System.out.println(user);


    }
}
