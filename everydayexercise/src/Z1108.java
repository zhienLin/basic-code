/**
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 * <p>
 * 请你返回 words 数组中 一致字符串 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 *
 * @author zzy
 * @date 2022-11-08 17:31
 */
public class Z1108 {
    public static void main(String[] args) {
        String allowed = "cad";
        String[] words = {"cc","acd","b","ba","bac","bad","ac","d"};
        int result = countConsistentStringsOffice(allowed, words);
        System.out.println(result);
    }

    //自己最笨的方法
    public static int countConsistentStrings(String allowed, String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            int flag = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (allowed.indexOf(words[i].charAt(j)) == -1) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                result++;
        }

        return result;

    }

    //官方的解题方法(进行26位的或，相当于每一个小写的字母对应一个26位上的1，如果有重复的也不会受影响
    // 然后跟需要比较的字符串进行比较，如果刚好两个或完之后，还等于之前的mask，那么就一定是存在基字符串的字符
    // 完全涵盖了子字符串，然后大功告成！)
    //这样或的方法适合于判断有没有元素是否全部涵盖
    public static int countConsistentStringsOffice(String allowed, String[] words){
        int result = 0;
        int mask = 0;
        int [] store = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            int index = allowed.charAt(i) - 'a';
            store[index] = 1;
            mask |= 1<<index;
        }
        for (int i = 0; i < words.length; i++) {
            int mask1 = 0;
            for (int i1 = 0; i1 < words[i].length(); i1++) {
                int index1 = words[i].charAt(i1) - 'a';
                mask1 |= 1<<index1;
            }

            if((mask1 | mask)==mask)
                result ++;

        }

        return result;

    }


}
