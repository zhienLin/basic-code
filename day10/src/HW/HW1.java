package HW;

import jdk.swing.interop.SwingInterOpUtils;

/*我国的居民身份证号码，由由十七位数字本体码和一位数字校验码组成。请定义方法判断用户输入的身份证号码是否合法，并在主方法中调用方法测试结果。
规则为：号码为18位，不能以数字0开头，前17位只可以是数字，最后一位可以是数字或者大写字母X。*/
public class HW1 {
    public static void main(String[] args) {
        String idnumber = "131225202012141229";
        System.out.println(testify(idnumber));

    }
    public static boolean testify(String s){
        if(s.length() != 18)
            return false;
        if(!(testifynumber(s.charAt(0), '1', '9')))
            return false;
        for (int i = 0; i < s.length() - 1; i++) {
            if(!(testifynumber(s.charAt(i), '0', '9')))
                return false;
        }
        if( !((testifynumber(s.charAt(s.length() - 1), '0', '9')) || ((s.charAt(s.length() - 1) - 'X') == 0)))
            return false;
        return true;
    }

    public static boolean testifynumber(char chs, char a, char b){
        if((chs - a) >= 0 && (chs - b) <= 0)
            return true;
        else
            return false;
    }




}
