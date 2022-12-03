package www.itheima.demo;
//定义数组存储商品对象，商品的属性：
//创建三个商品对象，并把商品对象放在数组当中。
//主要思路：先定义一个类描述商品。
public class CommodityTest {
    public static void main(String[] args) {
        Commodity [] arr = new Commodity[3];
        Commodity commodity1 = new Commodity(001,"钟薛高",12.9,34);
        Commodity commodity2 = new Commodity(002,"雪莲",0.5,65);
        Commodity commodity3 = new Commodity(003,"巧乐兹",3.5,11);
        arr[0] = commodity1;
        arr[1] = commodity2;
        arr[2] = commodity3;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getName());
        }

    }
}
