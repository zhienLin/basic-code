package StringPractice;
/*给定两个字符串，A和B。
A的旋转操作就是将A最左边的字符移动到最右边。
例如，若A= 'abcde'，在移动一次之后结果就是'bcdea'。
如果在若干次调整操作之后，A能变成B，那么返回True。如果不能匹配成功，则返回false*/
//定义一个方法来调整字符串，调整的原字符串和调整的位数由形参传递。
//在调整从1到字符串长度之间，如果有一次和B是一样的，那么就匹配成功

public class PracticeAdjust1 {
    public static void main(String[] args) {
        String s1 = "12345";
        String s2 = "12345";
        if(s1.length() != s2.length())
            System.out.println("这两个字符串长度不一样，根本无法匹配");
        else {
            if (adjust(s1, s2))
                System.out.println("匹配成功");
            else
                System.out.println("匹配失败");
        }
    }

    //调整函数:用substring进行截取，把左边的字符截取出来拼接到右侧去
    public static String adjust(String s1, int num) {
        for (int i = 1; i <= num; i++) {
            s1 = s1.substring(1) + s1.charAt(0);//这里一定要交到s1中去，如果不给s1，那么s1的值不会发生改变的，以后就会出现新的值，还是不发生改变。
        }
        return s1;
    }

    //匹配函数
    public static boolean adjust(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (adjust(s1, i).equals(s2)) {
                return true;
            }
        }
        return false;
    }

}

//套路:
//如果我们看到要修改字符串的内容可以有两个办法:
//1.用substring进行截取，把左边的字符截取出来拼接到右侧去
//2.可以把字符串先变成一个字符数组，然后调整字符数组里面数据，最后再把字符数组变成字符串。