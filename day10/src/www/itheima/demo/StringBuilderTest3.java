package www.itheima.demo;

public class StringBuilderTest3 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        System.out.println(sb1.capacity());// 16
        System.out.println(sb1.length());//0
        //刚开始的时候容量的默认值是，因为没有内容，所以长度为0

        //对于在0的长度的基础上直接添加的情况
        //case1:添加的长度小于当前的容量值的时候(16)，容量不会改变，只有长度会在0的基础上加上添加的字符串的内容
        sb1.append("abc");
        System.out.println(sb1.capacity());// 16
        System.out.println(sb1.length());//3

        //case2:添加的长度大于当前的容量值的时候(16)，但是小于默认扩容，容量发生改变，会在(原来的容量上* 2 + 2),
        // 长度会在原来的，基础上加上添加的字符串的内容
        sb2.append("abcdefghijklmnopqrstuvwxyz");
        System.out.println(sb2.capacity());// 16
        System.out.println(sb2.length());//3

        //case3:添加的长度不仅大于当前的容量值的时候(16)，而且大于默认的扩容容量(34),那么容量就是该数组的长度，
        sb3.append("012345678901234567890123456789012345");
        System.out.println(sb3.capacity());// 36
        System.out.println(sb3.length());//36

        //=================================================================================================
        //对于在已有容量的基础上添加的情况，如果添加之后的数组没有超过了已有的容量，那么添加之后的容量不变，长度直接加就可以了。
        sb2.append("0");
        System.out.println(sb2.capacity());// 16
        System.out.println(sb2.length());//3

        //对于在已有容量的基础上添加的情况，如果添加之后的数组超过了已有的容量，但是没有超过(已有的容量 * 2) + 2，那么添加之后的容量=(已有的容量 * 2) + 2
        sb3.append("01234567890");
        System.out.println(sb3.capacity());// 74 = 36 * 2 + 2
        System.out.println(sb3.length());//36

        //对于在已有容量的基础上添加的情况，如果添加之后的数组超过了已有的容量，并且超过了(已有的容量 * 2) + 2，那么容量就是该数组添加之后的长度。
        sb1.append("01234567890123456789012345678912");
        System.out.println(sb1.capacity());// 35
        System.out.println(sb1.length());//35


    }
}
