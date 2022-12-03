package Array.StringBuffer;

/**
 * String,StringBuffer,StringBuilder三者之间的异同
 * String:不可变的字符序列;
 * StringBuffer:可变的字符序列，线程安全的，效率低;
 * StringBuiLder:可变的字符序列，线程不安全的，效率高;
 *
 * 三者都是用char[]型数组存储的
 *
 * String str = new String(); //new char[0];
 * String str1 = new String( "abc"); //new char[] {'a ' , 'b ' , 'c '};
 *
 *
 * @author zzy
 * @date 2022-10-12 16:23
 */
public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("123");
        sb.setCharAt(1,'P');
    }
}
