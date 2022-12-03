package www.itheima.com.Lambda;
import java.util.Arrays;

public class GirlFriendSort {
    public static void main(String[] args) {
        //定义女朋友数组
        GrilFriend g1 = new GrilFriend("xiaoa", 21, 164);
        GrilFriend g2 = new GrilFriend("wenwe", 30, 172);
        GrilFriend g3 = new GrilFriend("clala", 26, 166);
        GrilFriend g4 = new GrilFriend("alala", 26, 163);
        GrilFriend g5 = new GrilFriend("blala", 26, 163);
        GrilFriend g6 = new GrilFriend("hiaoa", 21, 165);
        GrilFriend[] arr = {g1, g2, g3, g4, g5, g6};
        //开始排列
        Arrays.sort(arr, ( o1,  o2) -> {
                int temp = o1.getAge() - o2.getAge();
                temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                temp = temp == 0 ? o1.getName().compareTo(o2.getName()): temp;
                //compareTo()就是用来比较字符串里面字符的大小，依次比较，相同的话就往下比较。
                return temp;
            }
        );


        //打印验证
        System.out.println(Arrays.toString(arr));
    }
}

//定义女朋友类
class GrilFriend {
    private String name;
    private int age;
    private int height;

    public GrilFriend() {
    }

    public GrilFriend(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return "GrilFriend{name = " + name + ", age = " + age + ", height = " + height + "}";
    }
}

//你自己写的方法
/*
//1.先对年龄进行排序
        Arrays.sort(arr, (GrilFriend o1, GrilFriend o2) -> o1.getAge() - o2.getAge());

                //2.在相同的年龄中比较身高
                for (int i = 0; i < arr.length - 1; ) {
        int start = i;
        int end = i + 1;
        while (arr[start].getAge() == arr[end].getAge()) {
        end++;
        }
        i = end;
        //对身高排序
        Arrays.sort(arr, start, end, (GrilFriend o1, GrilFriend o2) -> o1.getHeight() - o2.getHeight());

        //3.前两个如果都相同就比较姓名的首字母
        for (int j = start; j < end; ) {
        int start1 = j;
        int end1 = j + 1;
        while (arr[start1].getName().charAt(0) == arr[end1].getName().charAt(0)) {
        end1++;
        }
        j = end1;
        //对姓名手写字母排序
        Arrays.sort(arr, start1, end1, (GrilFriend o1, GrilFriend o2) -> o1.getName().charAt(0) - o2.getName().charAt(0));
        }

        }*/
