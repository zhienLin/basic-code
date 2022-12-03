import java.util.HashSet;
import java.util.Set;

public class Z0916 {
    //给定一个字符串，请你找出其中不含有重复字符的最长子串的长度.
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    public static void main(String[] args) {
        String s = "cssdwsd";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public static int lengthOfLongestSubstring(String s) {

        //自己的方法
/*        int max = 0;
        //从0到最后，逐个比较剩余元素，求取最大值。
        for (int i = 0; i < s.length(); i++) {
            max = max > findStr((s.substring(i))) ? max : findStr((s.substring(i)));
        }
        return max;*/

        //这一题用滑动2窗口的方法比较好求解
        if (s.length() <= 1)
            return s.length();
        int left = 0;
        int right = 0;
        int maxLength = 1;
        Set<Character> window = new HashSet<>();

        while (right < s.length()) {
            while(window.contains(s.charAt(right)))
            {
                window.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            window.add(s.charAt(right));
            right++;
        }

        return maxLength;

    }


    //比较一个字符串的中的不重复元素的值
    public static int findStr(String s) {
        if (s.length() == 0)//如果剩余元素根本就没有了，直接返回0
            return 0;
        if (s.length() == 1)//如果只有一个剩余元素，那就直接返回1
            return 1;
        int result = 1;//这里是返回值的情况，可以等于最大值，也可以等于1.
        String substring1 = s.substring(1);//截取除了第一个元素之外的剩余的字符串
        int index = substring1.indexOf(s.charAt(0)) + 1;//拿着剩余的字符串跟第一个元素进行比较
        if (index != 0)//如果存在重复的元素，我们得到重复元素的之前的字符串的内容
            return result = 1 + findStr(s.substring(1, index));//在1+（除了第一个元素 + 最后一个元素， 他们这个字符串再去做重复元素的判断）
        return 1 + findStr(s.substring(1));//如果不存在重复元素，那就是除了第一个元素之外的剩余字符串的比较

    }

}
