package HW;
/*现有如下文本：
"Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的"。
请编写程序，统计该文本中"Java"一词出现的次数。*/
// 查找参数字符串str在调用方法的字符串中第一次出现的索引，如果不存在，返回-1
//public int indexOf(String str)

// 截取字符串，从索引beginIndex（包含）开始到字符串的结尾
//public String substring(int beginIndex)


import java.util.StringJoiner;

public class HW3 {
    public static void main(String[] args) {
        String s = "Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java是高性能的，Java语言是跨平台的";
        int count = times(s,"Java");
        System.out.println(count);

    }

    public static int times(String s, String s1) {
        int time = 0;
        int index = 0;
        while(s.indexOf(s1) != -1){
            index = s.indexOf(s1);
            time++;
            s = s.substring(index+s1.length());
        }
        return time;
    }

}
//这里需要注意的就是，因为s.indexOf("平台")索引得到的值是从平台开始的。如果我们从它返回的值开始截取，那么就会一直选循环。
//所以我们要在索引的基础上在加上字符串的长度，这个才是截取函数的开始值。
//或者用替换的方法，不用上面的函数，用之前的数组长度-替换后的数组长度在除以被替换值的长度就是个数。