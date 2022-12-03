package com.itheima.demo;

public class MethodReload {
    public static void main(String[] args) {
            /*int two =  getSum2 (1,2);
            int three = getSum2 (3,getSum2(1,2));
            int four = getSum2 (getSum2 (1,2),getSum2 (3,4));
            System.out.println(two+" "+ three+" "+ four);

            int sum = 0;
            for (int i = 1; i <= 89; i++) {
                sum = getSum2 (i,sum);
            }
            System.out.println(sum);*/
        //==========================================================

        System.out.println(getComare(10,20));


    }

    //两个数字之和的方法
    /*public static int getSum2 (int num1,int num2){
        int result = num1 + num2;
        return result;
        }*/
    //===============================================


    //比较两个整数是否相同(byte, short,int,long)
        public static boolean getComare(byte num1,byte num2){
            boolean result;
            if (num1 != num2)
                result = false;
            else
                result = true;
            return result;
        }


        public static boolean getComare(short num1,short num2){
            boolean result;
            if (num1 != num2)
                result = false;
            else
                result = true;
            return result;
        }


        public static boolean getComare(int num1,int num2){
            boolean result;
            if (num1 != num2)
                result = false;
            else
                result = true;
            return result;
        }

        public static boolean getComare(long num1,long num2){
            boolean result;
            if (num1 != num2)
                result = false;
            else
                result = true;
            return result;
        }

}