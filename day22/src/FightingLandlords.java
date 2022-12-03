import java.util.*;

public class FightingLandlords {
    /*
    通过程序实现斗地主过程当中的洗牌、发牌和看牌
    1.定义一个集合对象存储54张牌
    2.生成54张牌并且把其添加到集合当中
    3.打乱牌的顺序
    4.定义三个玩家的集合对象以及一个底牌对象
    5.遍历集合给每一个人发牌
    6.指定顺序并遍历(共有的)
     */
    public static void main(String[] args) {
        //1
        ArrayList<String> poker = new ArrayList<>();

        //2
        String[] color = {"♥", "♠", "♦", "♣"};
        String[] num = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};
        for (String c : color) {
            for (String n : num) {
                poker.add(c + n);
            }
        }
        poker.add("大王");
        poker.add("小王");

        //3
        Collections.shuffle(poker);

        //4
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> lastCards = new ArrayList<>();

        //5
        for (int i = 0; i < poker.size(); i++) {
            String card = poker.get(i);
            if (i > poker.size() - 4)
                lastCards.add(card);
            else if (i % 3 == 0)
                player1.add(card);
            else if (i % 3 == 1)
                player2.add(card);
            else
                player3.add(card);
        }

        //6
        sort(player1, "player1");
        sort(player2, "player2");
        sort(player3, "player3");
        sortLast(lastCards);

    }

    public static ArrayList<String> sort(ArrayList<String> list, String name){
        System.out.print(name + "的牌是：");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i)+ " ");
        }
        System.out.println();
        return list;
    }

    public static ArrayList<String> sortLast(ArrayList<String> list){
        System.out.print("底牌是：");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i)+ " ");
        }
        System.out.println();
        return list;
    }





}
