package www.itheima.demo;

//把一个十进制的整数转换成2进制的字符串进行表示:其实就是toBinaryString()的方法


public class Exercise03 {
    public static void main(String[] args) {
        int a = 8;
        System.out.println(BinaryString(a));
    }

    public static String BinaryString(int a){
        StringBuilder sb = new StringBuilder();
        while (a != 0) {
            sb.append(a % 2);
            a = a / 2;
        }
        //字符串不方便进行的操作都可以在StringBuilder里面找一下
        StringBuilder reverse = sb.reverse();
        String binaryString = reverse.toString();
        return binaryString;
    }
}
