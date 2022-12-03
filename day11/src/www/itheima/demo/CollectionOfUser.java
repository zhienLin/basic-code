package www.itheima.demo;

import java.util.ArrayList;

public class CollectionOfUser {
    public static void main(String[] args) {
        ArrayList<UserInFo> list = new ArrayList<>();
        UserInFo u1 = new UserInFo("001","筱筱","123");
        UserInFo u2 = new UserInFo("002","笑笑","456");
        UserInFo u3 = new UserInFo("003","晓晓","789");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        int result = seek(list, "008");
        System.out.println(result);
    }
    public static int seek (ArrayList<UserInFo> list, String id){//这里必须要限定给定的类型，也就是UserInFo才可以实现调用

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i). getId().equals(id))
                return i;
        }

        return -1;
    }
}
