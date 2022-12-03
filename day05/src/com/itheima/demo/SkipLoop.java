package com.itheima.demo;

public class SkipLoop {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if(i != 3)
                System.out.println("小老虎在吃第" + i + "个包子");
            else
                continue;
        }
    }
}
