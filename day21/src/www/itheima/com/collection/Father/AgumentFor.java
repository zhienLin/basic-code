package www.itheima.com.collection.Father;

import java.util.ArrayList;
import java.util.Collection;

public class AgumentFor {
    //增强for遍历
    //主要的格式：for(数据类型 变量名 : 集合/数组名){}
    //这个里面的变量名只是一个形式的变量，用在循环里面起到一个
    //中间过渡的作用，改变s的值并不会对集合或者数组产生什么影响。
    //快捷方式：集合/数组名.for
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
