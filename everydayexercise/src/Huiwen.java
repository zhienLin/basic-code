public class Huiwen {

    public static void main(String[] args) {
        int num = 12345;
        System.out.println(isPalindromeOfficial(num));


    }

    public static boolean isPalindrome(int x) {
        String s1 = Integer.toString(x);
        StringBuilder reverse = new StringBuilder(s1).reverse();
        String s2 = reverse.toString();

        if (s1.equals(s2))
            return true;

        return false;
    }


    public static boolean isPalindromeOfficial(int x) {
        //把这个数前面的后面的几位反转，然后和前面的几位进行比较，如果相同，就回文数
        //而且f负数、0-9以及个位是0的数都不是回文数
        if (x >= 0 && x <= 9)
            return true;
        else if (x < 0 || x % 10 == 0)
            return false;
        else {
            int result = 0;
            int ge = 0;
            while (x > result) {
                ge = x % 10;
                result = result * 10 + ge;
                x = x / 10;
            }

            if (x == result || x == result / 10)
                return true;
            else
                return false;

        }
    }


}
