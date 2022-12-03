import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class ArrayListHashMAP {
    public static void main(String[] args) {
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
        HashMap<String,String> hm1 = new HashMap<>();
        hm1.put("面包","大咩");
        hm1.put("酸奶","加餐");
        hm1.put("玉米","正餐");
        HashMap<String,String> hm2 = new HashMap<>();
        hm2.put("毛衣","秋天");
        hm2.put("棉衣","冬天");
        hm2.put("裙子","夏天");
        HashMap<String,String> hm3 = new HashMap<>();
        hm3.put("毛","秋");
        hm3.put("棉","冬");
        hm3.put("裙","夏");

        arrayList.add(hm1);
        arrayList.add(hm2);
        arrayList.add(hm3);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).forEach(( s,  s2) ->System.out.println(s + "  "+s2));
        }
    }
}
