package HW;
/*定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，并在控制台输出结果。
要求：
1、如果传递的参数为空，返回null  ***************************************这个不会啊，这个怎么判断啊？？？？？
2、如果传递的数组元素个数为0，返回[]
3、如果数组为int[] arr = {1,2,3}; ，执行方法后的输出结果为：[1, 2, 3]*/


import java.util.StringJoiner;

public class HW2 {
    public static void main(String[] args) {
        int [] arr = {12,3,4,5,6};
        System.out.println(exchange(arr));

    }
    public static String exchange(int [] arr){
        StringJoiner sj = new StringJoiner(",","[","]");
        if(arr.length == 0)
            return "[]";
        // 健壮性判断
        if (arr == null)
            return null;

        for (int i = 0; i < arr.length; i++) {
            sj.add(arr[i]+"");
        }
        return sj.toString();

    }
}
