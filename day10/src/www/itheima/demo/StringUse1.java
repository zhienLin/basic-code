package www.itheima.demo;

public class StringUse1 {
    public static void main(String[] args) {
        //直接赋值的方法来定义字符串
        String s1 ="abc";
        //空参构造，里面什么都没有
        String s2 = new String();
        System.out.println("@"+ s2+"1");//打印出来的效果是：@1

        //传递一个字符串，根据传递的字符串来创建一个新的字符对象
        String  s3 = new String("111");//'new String' is redundant ，是灰色的，提示信息代表这块是多余的

        //传递一个字符数组，根据字符数组创建一个字符串
        char [] chs = {'a','b','c'};
        String  s4 = new String(chs);//这个定义的好处就是，我们可以通过改变字符数组的内容去改变字符串的内容。
                                    // 因为直接改变字符串的内容不是很好操作。

        //传递一个字节数组，根据字节数组创建一个字符串。byte
        byte [] BYTE={98,98,96};
        String s5 = new String(BYTE);//以后在网络当中传递的都是字节信息，但是字节信息我们不能直接观察到，
                                    // 所以可以利用定义一个字节数组，转化为字符串的时候会自动根据ASCALL表转换成对应的表示。


        //’==‘对于基本数据类型比较的是数据值，
        String s6 = new String("abc");
        String s7 = "abc";
        System.out.println(s6.equals(s7));
        String s8 = new String("ABc");
        System.out.println(s8.equalsIgnoreCase(s7));
    }
}
