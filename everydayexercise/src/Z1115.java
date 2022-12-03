import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 1710
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * <p>
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * <p>
 * 返回卡车可以装载 单元 的 最大 总数。
 * <p>
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 *
 * @author zzy
 * @date 2022-11-15 21:33
 */
public class Z1115 {


    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}};
        int truckSize = 35;
        int maxWeight = maximumUnits(boxTypes, truckSize);
        System.out.println(maxWeight);

    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set  = new TreeSet<>(( o1 , o2) ->o2-o1);


        for (int i = 0; i < boxTypes.length; i++) {
            boolean add = set.add(boxTypes[i][1]);
            if (add == false) {
                Integer integer = map.get(boxTypes[i][1]);
                map.put(boxTypes[i][1], boxTypes[i][0] + integer);
            } else
                map.put(boxTypes[i][1], boxTypes[i][0]);
        }

        map.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println(integer +"  "+ integer2);
            }
        });

        set.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });


        for (Integer integer : set) {
            System.out.println(integer);
            Integer value = map.get(integer);
            count = count + value;
            if (count < truckSize)
                sum += value * integer;
            else {
                sum += integer * (truckSize - count + value);
                return sum;
            }
        }

        return sum;


    }
}
