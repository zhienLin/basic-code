package www.itheima.demo;

import java.util.Scanner;
/*对于键盘录入：
第一套体系：nextInt()(接收整数),nextDouble()(接收小数), s.next(接收字符串)，在遇到空格、Tab、回车键之后就停止接收。
第一套体系：nextLine();接收字符串，可以接收空格、Tab，只有在遇到回车的时候才停止。
这两套体系最好不要混用，加入先用第一套体系，最后结束的时候会按回车、空格或者Tab键表示结束。那么这个回车、空格或者Tab键会自动给下面的nextline();
如果按回车，那么回车会自动给nextline()，这个时候，nextline()就结束了。
如果是空格或者制表符，后面加别的东西。以及后面加的东西就会全部给nextline()。

 */
public class CarTest {
    public static void main(String[] args) {
        Car [] arr = new Car[3];
        Scanner s = new Scanner(System.in);
        System.out.println("请分别录入第一个汽车的品牌、价格以及颜色信息:");
        Car car1 = new Car(s.next(),s.nextInt(),s.next());
        System.out.println("请分别录入第二个汽车的品牌、价格以及颜色信息:");
        Car car2 = new Car(s.next(),s.nextInt(),s.next());
        System.out.println("请分别录入第三个汽车的品牌、价格以及颜色信息:");
        Car car3 = new Car(s.next(),s.nextInt(),s.next());
        arr[0]= car1;
        arr[1]= car2;
        arr[2]= car3;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第"+(i+1)+"个汽车的品牌是"+arr[i].getBrand()+"，价格是"
                    +arr[i].getPrice()+"，颜色是"+arr[i].getColor());
        }

    }
}
