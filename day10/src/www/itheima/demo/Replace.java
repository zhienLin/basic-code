package www.itheima.demo;

public class Replace {
    public static void main(String[] args) {
        String talk = "你会不会TMD打野啊SB";

        //定义一个敏感词库
        String[] arr = {"TMD", "CMD", "SB", "MLGB"};

        /* String replacedtalk = "";
        //循环得到每一个敏感词
        for (int i = 0; i < arr.length; i++) {
            replacedtalk = talk.replace(arr[i], "***");
            System.out.println(replacedtalk);
        }
        System.out.println(replacedtalk);*/
        //这个for循环不彳亍的原因是因为，每一次进行循环，都会把对应的替换之后的值给replacetalk,每一次replacetalk的值都会被重新赋值。
        // 也就是说，替换完之后的值并没有参与到循环当中，如果你想让替换完之后的值参与到循环当中，就要按照下面的方法去重新循环。


        for (int i = 0; i < arr.length; i++) {
            talk = talk.replace(arr[i], "***");
        }
        System.out.println(talk);

    }
}
