package www.itheima.demo;

public class GirlFriendTest {
    public static void main(String[] args) {

        GirlFriend[] grilFriend = new GirlFriend[4];
        GirlFriend grilFriends1 = new GirlFriend("筱筱", 23, '女', "游泳");
        GirlFriend grilFriends2 = new GirlFriend("之意", 25, '女', "书法");
        GirlFriend grilFriends3 = new GirlFriend("顾瑀", 20, '女', "健身");
        GirlFriend grilFriends4 = new GirlFriend("吉萨", 19, '女', "吉他");
        grilFriend[0] = grilFriends1;
        grilFriend[1] = grilFriends2;
        grilFriend[2] = grilFriends3;
        grilFriend[3] = grilFriends4;


        int sum = 0;
        for (int i = 0; i < grilFriend.length; i++) {
            sum = sum + grilFriend[i].getAge();
        }


        int ave = sum / 4;
        System.out.println(ave);


        for (int i = 0; i < grilFriend.length; i++) {
            if (grilFriend[i].getAge() <= ave)
                System.out.println(grilFriend[i].getName() + ", " + grilFriend[i].getAge() +
                        ", " + grilFriend[i].getGender() + ", " + grilFriend[i].getHobby() + ".");
        }

    }
}
