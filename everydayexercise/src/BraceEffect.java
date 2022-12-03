public class BraceEffect {

    /*  给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。

        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。*/
    public static void main(String[] args) {
        String str = "[()[()]{}(())]";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        char[] chars =  new char[s.length()];
        int index = s.length() -1;
        String sL = "([{";
        String sR = ")]}";
        char arrLeft[] = {'(', '[', '{'};
        char arrRight[] = {')', ']', '}'};
        for (int length = s.length() -1; length >= 0; length--) {
            if (sR.indexOf(s.charAt(length)) != -1){
                chars[index] = s.charAt(length);
                index -- ;
            }

            else if(sL.indexOf(s.charAt(length)) != -1){
                index ++;
                if(index > s.length() -1)
                    return false;
                if(chars[index] == sR.charAt(sL.indexOf(s.charAt(length))))
                    chars[index] = 0;
                else
                    return false;
            }
            else
                return false;
        }
        if(index != s.length() -1)
            return false;
        else
            return true;

    }


}
