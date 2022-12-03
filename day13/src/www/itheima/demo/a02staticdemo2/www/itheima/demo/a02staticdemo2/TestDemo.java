package www.itheima.demo.a02staticdemo2;
//测试工具类，不需要创建对象；
public class TestDemo {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5};
        String s = ArrayUtil.printArr(arr1);//类名.方法名() 就可以实现了，主要是针对静态的方法，并且方法私有，也就是不能被其他的测试类创建对象。
        System.out.println(s);
        double [] arr2 = {1,2,3,4,5};
        double average = ArrayUtil.getAverage(arr2);
        System.out.println(average);
    }
}
//以后我们想要遍历数组啊或者什么的，可以直接调用工具类的方法。