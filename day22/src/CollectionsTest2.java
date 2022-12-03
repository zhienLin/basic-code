import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsTest2 {
 /* 需求: ArrayList存储学生对象，使用Collections对ArrayList进行排序
    要求:按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序
*/
    public static void main(String[] args) {
        ArrayList<Student2> al = new ArrayList<>();
        Student2 s1 = new Student2(23,"xixi");
        Student2 s4 = new Student2(25,"keihei");
        Student2 s2 = new Student2(24,"haha");
        Student2 s3 = new Student2(25,"heihei");
        al.add(s1);
        al.add(s2);
        al.add(s3);
        al.add(s4);
        Collections.sort(al, new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                int i = o1.getAge() - o2.getAge();
                i = i == 0 ? o1.getName().compareTo(o2.getName()): i;
                return i;
            }
        });

        for (Student2 student2 : al) {
            System.out.println(student2);
        }

    }
}

class Student2{
    private int age;
    private String name;


    public Student2() {
    }

    public Student2(int age, String name) {
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
        return "Student2{age = " + age + ", name = " + name + "}";
    }
}
