package www.itheima.demo;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args) {
        int [] arr1 = getGrade();
        System.out.println("选手的成绩为" + countGrade(arr1) + "分");

    }
    //定义一个方法体，来获取6位评委的打分情况。
    public static int[] getGrade() {
        int[] arrScore = new int[6];
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < arrScore.length; i++) {
            System.out.print("请输入第"+ (i+1) +"位评委的打分:");
            arrScore [i] = s.nextInt();
        }
        return arrScore;
    }

    //定义一个方法体，根据打分情况最后获得选手的最终成绩。
    public static double countGrade(int[] arr){
        double max = arr[0];
        double min = arr[0];
        double temp = 0.0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
            temp = temp + arr[i];
        }
        double average = (temp - min - max) / 4;
        return average;
    }


}
