public class PublicPre {

    //编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 "";


    public static void main(String[] args) {
        String strs [] = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {
        return  find(strs, 0) ;
    }


    public static String find(String[] strs, int index) {
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].charAt(index) != strs[i + 1].charAt(index))
                return "";
        }
            return strs[0].charAt(index) + find(strs, ++index);
    }



}
