import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/**
 * @author zzy
 * @date 2022-10-13 08:06
 */
public class GetName {
    public static void main(String[] args) throws IOException {

        //1.把所有学生导入到一个map的集合当中
        TreeMap<String, Double> map = new TreeMap();
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(new File("day23//NameLIst.txt"));
        BufferedReader br = new BufferedReader(fr);
        String s;
        while ((s = br.readLine()) != null) {
            map.put(s, 1.0);
            list.add(s);
        }
        list.remove("");
        map.remove("");
        List<Double> list1 = new ArrayList<>();
        for (int i1 = 0; i1 < 5; i1++) {
            //1.特殊情况
            if (i1 == 2) {
                System.out.println("小一");
                Double length = map.get("小一");
                double half = length / 2;
                double v2 = half / (map.size() - 1);
                Set<String> strings = map.keySet();
                for (String string : strings) {
                    Double objectLength = map.get(string);
                    map.put(string, objectLength + half / (map.size() - 1));
                }
                map.put("小一", half);


                map.forEach(new BiConsumer<String, Double>() {
                    @Override
                    public void accept(String s, Double aDouble) {
                        double v = aDouble / map.size();
                        list1.add(v);
                    }
                });

            }
            else{
                double random1 = Math.random();
                double v3 = random1 * map.size();//生成一个0-80的随机数
                double find1 = 0;
                for (int i = 0; i < list.size(); i++) {
                    String s1 = list.get(i);
                    Double aDouble = map.get(s1);
                    find1 = find1 + aDouble;
                    if (v3 < find1) {
                        System.out.println(s1);
                        Double d2 = map.get(s1);
                        double v2 = (d2 / 2) / (map.size() -1);
                        map.forEach(new BiConsumer<String, Double>() {
                            @Override
                            public void accept(String s, Double aDouble) {
                                    map.put(s, aDouble + v2);
                            }
                        });
                        map.put(s1, (d2 / 2));


                        break;
                    }
                }
            }
        }

    }
}
