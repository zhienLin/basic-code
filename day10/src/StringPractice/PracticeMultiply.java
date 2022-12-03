package StringPractice;
/*给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，
它们的乘积也表示为字符串形式。注意:需要用已有的知识完成。*/

public class PracticeMultiply {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "123";
        //转换成数组的形式
        char [] newnum1 = num1.toCharArray();
        char [] newnum2 = num2.toCharArray();
        //调用转换成数字的方法，并且得到结果。

        int sum1 = getN2(newnum1);
        System.out.println(sum1);
        int sum2 = getN2(newnum2);
        int result = sum1 * sum2;

        String stringResult = result + "";
        System.out.println(stringResult);

    }

    //得到每一位，然后按照位数的10次幂
    public static int getN2(char[] newnum) {
        int sum = 0;
        for (int a = 0; a < newnum.length; a++) {
            int temp = newnum[a] - '0';
            for (int j = 0; j < newnum.length - a - 1; j++) {
                temp = temp * 10;
            }
            sum = sum + temp;

        }
        return sum;
    }

}
