/**
 * 可变参数本质上是一个数组
 * 可变参数的小细节:
 * 1.在方法的形参中最多只能写一个可变参数。可变参数，理解为一个大胖子，有多少吃多少
 * 2.在方法的形参当中，如果出了可变参数以外，还有其他的形参，那么可变参数要写在最后
 * 格式:属性类型...名字  // int. . .args
 * @author zzy
 * @date 2022-10-12 22:24
 */
public class ChangeableParameter {
    public static void main(String[] args) {

        int sum = getSum(1,2,3,4,5,6,7,8,9);
        System.out.println(sum);
    }

    public static int getSum(int... args){
        int sum =0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }

}
