/**
 * @author zzy
 * @date 2022-11-04 21:44
 */
public class Z1104 {
    public static void main(String[] args) {
        int target =reachNumber(12);
        System.out.println(target);

        int target2 =reachNumber1(12);
        System.out.println(target2);
    }
    public static int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public static int reachNumber1(int target) {
        int result = 0, num = 0, t = Math.abs(target); // 由于target有负数情况，为了统一计算逻辑，所以取绝对值
        // 直到num值大于等于t，并且num减t是偶数，才结束while循环
        while (num < t || (num - t) % 2 != 0)
            num += ++result; // num=1+2+3+4+……
        return result;
    }
}
