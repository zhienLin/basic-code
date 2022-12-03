import java.util.*;

public class FightingLandlordsUpgrade1 {
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
        ArrayList<Integer> poker = new ArrayList<>();

        //2
        for (int i = 1; i <= 54; i++) {
            poker.add(i);
        }

        //3
        Collections.shuffle(poker);

        //4
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> lastCards = new ArrayList<>();

        //5
        for (int i = 0; i < poker.size(); i++) {
            Integer card = poker.get(i);
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

    public static ArrayList<String> sort(ArrayList<Integer> list, String name) {
        String[] color = {"♥", "♠", "♦", "♣"};
        String[] num = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};
        String[] boss = {"小王", "大王"};
        ArrayList<String> listNew = new ArrayList<>();
        Collections.sort(list);
        if (list.contains(54) == true) {
            Integer i = 54;
            list.remove(i);
            listNew.add("大王");
        }
        if (list.contains(53) == true) {
            Integer i = 53;
            list.remove(i);
            listNew.add("小王");
        }

        Collections.sort(list, ( o1,  o2) -> {
                int flag = o2.intValue() % 13 - o1.intValue() % 13;
                flag = flag == 0 ? o1.intValue() % 4 - o2.intValue() % 4 : flag;
                return flag;});

        for (int i = 0; i < list.size(); i++) {
            listNew.add(color[list.get(i)%4]+ num[list.get(i)%13]);
        }


        System.out.print(name + "的牌是：");
        for (int i = 0; i < listNew.size(); i++) {
            System.out.printf(listNew.get(i) + " ");
        }
        System.out.println();
        return listNew;
    }

    public static ArrayList<String> sortLast(ArrayList<Integer> list) {
        String[] color = {"♥", "♠", "♦", "♣"};
        String[] num = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};
        ArrayList<String> listNew = new ArrayList<>();

        if (list.contains(54) == true) {
            Integer i = 54;
            list.remove(i);
            listNew.add("大王");
        }
        if (list.contains(53) == true) {
            Integer i = 53;
            list.remove(i);
            listNew.add("小王");
        }

        Collections.sort(list, ( o1,  o2) -> {
            int flag = o2.intValue() % 13 - o1.intValue() % 13;
            flag = flag == 0 ? o1.intValue() % 4 - o2.intValue() % 4 : flag;
            return flag;});

        for (int i = 0; i < list.size(); i++) {
            listNew.add(color[list.get(i)%4]+ num[list.get(i)%13]);
        }
        System.out.print("底牌是：");
        for (int i = 0; i < listNew.size(); i++) {
            System.out.printf(listNew.get(i) + " ");
        }
        System.out.println();
        return listNew;
    }


}
