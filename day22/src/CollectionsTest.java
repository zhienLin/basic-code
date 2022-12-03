import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
//Collections是针对集合操作的一种工具类，里面全部都是静态的方法
    //因此可以通过类名直接调用相应的方法

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(7);
        Collections.sort(list);
        Collections.reverse(list);
        Collections.shuffle(list);
    }
}
