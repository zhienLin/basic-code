import com.sun.jdi.IncompatibleThreadStateException;

import java.util.*;
import java.util.function.BiConsumer;

public class FightingLandlordsUpgrade2 {
    /*
    通过程序实现斗地主过程当中的洗牌、发牌和看牌
    //建立一个HashMap存储相应的牌和索引
    //定义ArrayList集合去获得索引
    //给每一个玩家分发索引，利用TreeSet
    //每个玩家根据索引，在HashMap中寻找对应的牌。
    //遍历每个玩家的牌
     */
    public static void main(String[] args) {
        //1
        Map<Integer, String> m = new HashMap();
        //2
        ArrayList<Integer> index = new ArrayList<>();

        String[] color = {"♥", "♠", "♦", "♣"};
        String[] num = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};
        int temp = 0;
        for (String n : num) {
            for (String c : color) {
                m.put(temp, c + n);
                index.add(temp++);
            }
        }
        m.put(temp, "小王");
        index.add(temp++);
        m.put(temp, "大王");
        index.add(temp);


        Collections.shuffle(index);
        //3
        TreeSet<Integer> ts1 = new TreeSet<>();
        TreeSet<Integer> ts2 = new TreeSet<>();
        TreeSet<Integer> ts3 = new TreeSet<>();
        TreeSet<Integer> tsdp = new TreeSet<>();

        for (int i = 0; i < index.size(); i++) {
            Integer flag = index.get(i);
            if (i > index.size() - 4)
                tsdp.add(flag);
            else if (i % 3 == 0)
                ts1.add(flag);
            else if (i % 3 == 1)
                ts2.add(flag);
            else
                ts3.add(flag);
        }

        //6
        sort(ts1, "player1",m);
        sort(ts2, "player2",m);
        sort(ts3, "player3",m);
        sort(tsdp, "剩余",m);

    }

    public static void sort(TreeSet<Integer> ts1, String name, Map<Integer, String> m) {

        System.out.printf(name+"的牌是：");
        for (Integer player : ts1) {
            String card = m.get(player);
            System.out.print(card + " ");
        }
        System.out.println();
    }


}
