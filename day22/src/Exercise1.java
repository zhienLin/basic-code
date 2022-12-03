
/*某个班级8O名学生，现在需要组成秋游活动，班长提供了四个景点依次是(A、B、C、D),每个学生只
        能选择一个景点，请统计出最终哪个景点想去的人数最多。*/

import java.util.*;

public class Exercise1 {
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        char [] arr = {'A','B','C','D'};
        Random r = new Random();
        //1.一共有80名学生
        for (int i = 0; i < 80; i++) {
            //2.每名学生进行投票
            int index = r.nextInt(4);
            //3.查看投的票数是否在map的集合中（如果在，次数加1，进行覆盖；如果不在，就新添加，次数为1）
            boolean flag = map.containsKey(arr[index]);
            if(flag == true){
                Integer integer = map.get(arr[index]);
                integer++;
                map.put(arr[index],integer);
            }else
                map.put(arr[index],1);
        }
        //4.寻找最大值
        int max = 0;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if(entry.getValue()>max)
                max = entry.getValue();
        }

        //5.找出符合最大值的选项。
        for (Map.Entry<Character, Integer> entry : entries) {
            if(entry.getValue() == max)
                System.out.println(entry.getKey());
        }



    }


}


