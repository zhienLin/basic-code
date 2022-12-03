package StringPractice;
/* 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
单词是指仅由字母组成、不包含任何空格字符的最大子字符串。
示例1:输入: s = "Hello wor1d“输出:5
解释:最后一个单词是wor1d”，长度为5。
示例2:输入: s = "fly metothe moon "输出:4解释:最后一个单词是"moon”，长度为4。
示例3:输入: s = "luffy is still joyboy"
输出:6
解释:最后一个单词是长度为6的“joyboy”。*/


public class WordLength {
    public static void main(String[] args) {
        String  s1 = "Hello world";
        String  s2 = "fly metothe moon";
        String  s3 = "luffy is still joyboy";
        System.out.println(spaceDetection(s1));
        System.out.println(spaceDetection(s2));
        System.out.println(spaceDetection(s3));

        //老师的方法：倒着遍历，直到遇到空格，遍历的次数就是字符串的长度啦。


    }

    public static int spaceDetection(String s){
        int spot = 0;
        for (int i = 0; i < s.length(); i++) {
            if(! (((s.charAt(i) - 'a') >= 0 && (s.charAt(i) - 'a') <= 25)||
                    ((s.charAt(i) - 'A') >= 0 && (s.charAt(i) - 'A') <= 25))){
                spot = i;;
            }
        }

        return s.substring(spot+1).length();

    }
}
