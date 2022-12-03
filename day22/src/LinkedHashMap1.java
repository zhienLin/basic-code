import java.util.LinkedHashMap;

public class LinkedHashMap1 {
    /*LinkedHashMap是由键决定的:有序、不重复、无索引
    * 底层的数据结构仍然是哈希表，
    * 只不过每一个键值对元素又多了一个双链表机制记录存储的顺序。
    * */
    public static void main(String[] args) {
        LinkedHashMap<Integer,Character> lhm = new LinkedHashMap<>();
        lhm.put(1,'a');
        lhm.put(1,'b');
        lhm.put(2,'c');
        lhm.put(3,'d');

    }
}
