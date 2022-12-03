package www.itheima.demo;

import java.util.Random;
import java.util.Scanner;

public class bichromaticSphere {
    public static void main(String[] args) {
        //1、生成中奖号码
        int[] newnum = createNumber();
        for (int i = 0; i < newnum.length; i++) {
            System.out.print(newnum[i]+" ");
        }
        System.out.println();

        //2、键盘录入彩民朋友自己的双色球号
        int[] guessnum1 = InputNumber();

        //3、输出中将号码
        System.out.print("红色球的中将号码分别是：");
        for (int i = 0; i < newnum.length - 1; i++) {
            System.out.print(newnum[i] + " ");
        }
        System.out.println();
        System.out.print("蓝色球的中将号码分别是：");
        System.out.println(newnum[6]);

        //4、创建判断中将的情况
        rankTest(newnum, guessnum1);

    }

    //1.生成随机号码
    public static int[] createNumber() {
        int[] number1 = new int[7];
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int random1 = r.nextInt(33) + 1;
            if (compare(number1, random1)) {
                number1[i] = random1;
                i++;
            }
        }
        number1[6] = r.nextInt(16) + 1;
        return number1;
    }

    //随机变量的对比
    public static boolean compare(int[] number1, int random1) {
        for (int i = 0; i < number1.length; i++) {
            if (number1[i] == random1)
                return false;
        }
        return true;
    }

    //2.键盘录入
    public static int[] InputNumber() {
        Scanner s = new Scanner(System.in);
        int[] guessnum = new int[7];
        for (int i = 1; i < 7; i++) {
            System.out.print("您的第" + i + "颗红色球号码是：");
            guessnum[i - 1] = s.nextInt();

        }
        System.out.print("您的颗蓝色球号码是：");
        guessnum[6] = s.nextInt();
        System.out.println();
        return guessnum;
    }

    //3.判断中奖情况
    public static int rankTest(int[] newnum, int[] number1) {
        int countred = 0;
        int countblue = 0;
        for (int i = 0; i < newnum.length - 1; i++) {
            for (int j = 0; j <= newnum.length - 1; j++) {
                if (newnum[i] == number1[j]) {
                    countred += 2;
                    break; //如果找到了相同的，就不需要在循环了，直接跳出内循环，判断下一个号码是否中奖。
                }
            }
        }
        if (newnum[6] == number1[6])
            countblue += 3;

        if ((countblue) == 3 && countred <= 2) {
            System.out.println("恭喜您中了六等奖，奖金为5元");
            return 6;
        } else if ((countred + countblue) <= 9 && (countred + countblue) > 7) {
            System.out.println("恭喜您中了五等奖，奖金为10元");
            return 5;
        } else if ((countred + countblue) <= 11 && (countred + countblue) > 9) {
            System.out.println("恭喜您中了四等奖，奖金为200元");
            return 4;
        } else if ((countred + countblue) == 13) {
            System.out.println("恭喜您中了三等奖，奖金为3000元");
            return 3;
        } else if ((countred + countblue) == 12) {
            System.out.println("恭喜您中了二等奖，奖金为500万元");
            return 2;
        } else if ((countred + countblue) == 15) {
            System.out.println("恭喜您中了一等奖，奖金为1000万元");
            return 1;
        } else {
            System.out.println("很遗憾，您没有中奖");
            return 0;
        }

    }

}

//错误的情况：就是在进行循环的时候，我们想要获得用户的自己的红球号码，并且把他放在数组当中。
//第1个求放在索引0中，这个里面出现了错误，数组的第一个值没有赋值，因为循环是从0开始的

//还有一个问题就是在判断的是否有号码是一致的时候，只要找到了就要用break跳出内循环。
//注意：break只能跳出一次循环