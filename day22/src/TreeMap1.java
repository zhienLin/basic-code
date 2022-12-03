import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMap1 {
/*
    TreeMap跟TreeSet底层原理一样，都是红黑树结构的。
    由键决定特性:不重复、无索引、可排序。
    可排序:对键进行排序。
    注意:默认按照键的从小到大进行排序，也可以自己规定键的排序规则
代码书写两种排序规则：
    实现Comparable接口，指定比较规则。（主要用于自定义的JavaBean类当中的）
    创建集合时传递Comparator比较器对象，指定比较规则。（优先级高）*/

    public static void main(String[] args) {
/*      需求一：
        键:整数表示id
        值:字符串表示商品名称
        要求:按照id的升序排列、按照id的降序排列*/

        {
            TreeMap<Integer, String> tm = new TreeMap();
            tm.put(1, "bread");
            tm.put(2, "rice");
            tm.put(3, "apple");
            System.out.println(tm);

            TreeMap<Integer, String> tm1 = new TreeMap<>((o1, o2) -> o2 - o1);
            tm1.put(1, "bread");
            tm1.put(2, "rice");
            tm1.put(3, "apple");
            System.out.println(tm1);
        }




/*      需求2:
        键:学生对象
        值:籍贯
        要求:按照学生年龄的升序排列，年龄一样按照姓名的字母排列，同姓名年龄视为同一个人。*/
        {
            Student1 st1 = new Student1(25, "dafei");
            Student1 st2 = new Student1(24, "dafei");
            Student1 st3 = new Student1(24, "fafei");
            Student1 st4 = new Student1(25, "dafei");

            TreeMap<Student1, String> tm2 = new TreeMap<>();
            tm2.put(st1, "河北");
            tm2.put(st2, "北京");
            tm2.put(st3, "天津");
            tm2.put(st4, "内蒙古");
            System.out.println(tm2);
        }


/*      需求3:
        字符串"aababcabcdabcde"
        请统计字符串中每一个字符出现的次数，并按照以下格式输出输出结果:
        a(5) b(4) c(3) d(2) e(1)*/
        {
            String str = "aababfgsdfcvxsevdcabcdabcde";
            TreeMap<Character, Integer> tm = new TreeMap<>();
            for (int i = 0; i < str.length(); i++) {
                boolean flag = tm.containsKey(str.charAt(i));
                if(flag == true){
                    Integer num = tm.get(str.charAt(i));
                    num++;
                    tm.put(str.charAt(i),num);
                }
                else
                    tm.put(str.charAt(i),1);
            }
            tm.forEach((character, integer) ->System.out.print(character + "("+integer +")" ));

        }






    }
}

class Student1 implements Comparable<Student1>{
    private int age;
    private String name;


    public Student1() {
    }

    public Student1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Student1{age = " + age + ", name = " + name + "}";
    }

    @Override
    public int compareTo(Student1 o) {
        int result = this.getAge() - o.getAge();
        result = result == 0 ? this.getName().compareTo(o.getName()) : result;
        return result;
    }
}
