package www.itheima.demo;

import java.util.Random;

public class ChouJiang {
    /*一个大V直播抽奖，奖品是现金红包，分别有{2,588,888,1000,10000}五个奖金。
            请使用代码模拟抽奖，打印出每个奖项，奖项的出现顺序要随机且不重复。
            打印效果如下：（随机顺序，不一定是下面的顺序）
            ```
            888元的奖金被抽出
            588元的奖金被抽出
            10000元的奖金被抽出
            1000元的奖金被抽出
            2元的奖金被抽出
            ```*/
    public static void main(String[] args) {
        // 1.把奖池里面的所有奖项打乱
        int[] arr = {2, 588, 888, 1000, 10000};
        Random r = new Random();
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int a = r.nextInt(arr.length);
            temp = arr[i];
            arr[i] = arr[a];
            arr[a] = temp;
        }

        //2、遍历奖池
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+"元的奖品被抽出");
        }

    }


}











