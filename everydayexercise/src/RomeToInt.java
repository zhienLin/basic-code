import java.util.Scanner;

public class RomeToInt {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个罗马数字：");
        String s = sc.nextLine();
        System.out.println(romanToInt(s));
    }


    public static int romanToInt(String s) {
        int result = 0;
        String arr1[] = {"IV", "IX", "XL", "XC", "CD", "CM"};
        int arrNum1[] = {4, 9, 40, 90, 400, 900};
        String arr2[] = {"I", "V", "X", "L", "C", "D", "M"};
        int arrNum2[] = {1, 5, 10, 50, 100, 500, 1000};
        String replace1 = s;
        String replace2 = s;

        for (int i = arr1.length - 1; i >= 0; i--) {
            while (replace1.contains(arr1[i])) {
                int index = replace1.indexOf(arr1[i]);
                replace1 = replace1.substring(index + 2);
                result = result + arrNum1[i];
                replace2 = replace2.replace(arr1[i],"");
            }
        }

        for (int i = arr2.length - 1; i >= 0; i--) {
            while (replace2.contains(arr2[i])) {
                int index = replace2.indexOf(arr2[i]);
                replace2 = replace2.substring(index + 1);
                result = result + arrNum2[i];
            }
        }

        return result;


    }


/*  按照题目的描述，可以总结如下规则：
    罗马数字由 I,V,X,L,C,D,M 构成；
    当小值在大值的左边，则减小值，如 IV=5-1=4；
    当小值在大值的右边，则加小值，如 VI=5+1=6；
    由上可知，右值永远为正，因此最后一位必然为正。*/

    public int romanToIntOffice(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }













}
