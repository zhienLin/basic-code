package www.itheima.demo.a02staticdemo2;

public class ArrayUtil {
    //私有化构造方法 目的是不让外界创建他的对象
    private ArrayUtil(){}
   //public Student() {}和这个构造方法不同啊
    public static String printArr(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i < arr.length -1)
                sb.append(arr[i]+", ");
            else
                sb.append(arr[i]+"]");
        }
        return sb.toString();
    }
    public static double getAverage(double[] arr){
        double num = 0;
        for (int i = 0; i < arr.length; i++) {
           num += arr[i];
        }
        return num / arr.length;
    }
}
