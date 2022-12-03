package com.itheima.demo.Arraydemo;
//静态初始化
public class ArrayDemo1 {
    public static void main(String[] args) {
        //定义数组，存储5个学生的年龄
        int [] age1 = new int[]{16,17,16,15,16,90,80,78};
        for (int i = 0; i < age1.length; i++) {
            System.out.println(age1 [i]);
        }

        for (int i = 0; i < age1.length; i++) {
            
        }
        
        int [] age2 = {11,12,11,13,12};
        System.out.println(age1);//[I@1b6d3586
        /*其实输出的是地址值，地址是就是数组在内存中的位置
        "["表示当前是一个数组
        I表示数组类型为整数
        @是一个间隔符号
        1b6d3586这才是真正的地址值  进制为16位  */

        //定义数组，存储5个学生的年龄
        String [] name1 = new String[]{"自愈","紫玉","子玉"};
        String [] name2 = {"之恩","智恩","知恩"};
    }
}
