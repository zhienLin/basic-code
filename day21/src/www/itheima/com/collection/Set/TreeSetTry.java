package www.itheima.com.collection.Set;
//TreeSet的特性：不重复。无索引、可排序。
//排序的方式1：
//1.对于数据类型的：Integer,Double..，默认按照从小到大的孙旭
//2.对于字符或者字符串的对象，是根据对应字符的ASCALL值升序进行排序的
//3.对于自定义类的对象,就需要在自定义的对象的类中扩展Comparable<>的接口，
//并且要直接在后面的泛型里面标明他的类型，即当前的对象类型。然后重写comparato的方法。
//comparato(E e)中的e是我们在利用TreeSet排序的红黑树的根结点。
//也就是Javabean类实现Comparable接口制定的比较规则


//排序的方式2：创建TreeSet对象时候，传递比较器Comparator指定规则，默认使用第一种，当第一种不能满足需求，就第二种。


import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class TreeSetTry {
    public static void main(String[] args) {
        //需求1：利用TreeSet进行整数的存储并进行排序。
        TreeSet<Integer> ts = new TreeSet<>();
        System.out.println(ts.add(4));
        System.out.println(ts.add(2));
        System.out.println(ts.add(5));
        System.out.println(ts.add(3));
        System.out.println(ts.add(1));
        System.out.println(ts);//[1, 2, 3, 4, 5]这个是以有序的方式存储的。

        //需求2：创建TreeSet集合，并添加3个学生对象学生
        //对象属性:姓名，年龄。
        //要求按照学生的年龄进行排序
        //同年龄按照姓名字母排列(暂不考虑中文)
        //同姓名，同年龄认为是同一个人。
        Student1 s1 = new Student1("ahua",25);
        Student1 s2 = new Student1("ahua",23);
        Student1 s3 = new Student1("bhsa",25);
        Student1 s4 = new Student1("ahua",25);
        Student1 s5 = new Student1("pda",24);

        TreeSet<Student1> tss = new TreeSet<>();
        tss.add(s1);
        tss.add(s2);
        tss.add(s3);
        tss.add(s4);
        tss.add(s5);
        System.out.println(tss);



        //o1表示的是当前要添加的元素，o2表示的是红黑树已经存在的元素。
        TreeSet<String> tsCom = new TreeSet<>((o1, o2) ->{
                int length = o1.length()-o2.length();
                length= length==0? o1.compareTo(o2):length;
                return length;
            });
        System.out.println(tsCom.add("qwer"));
        System.out.println(tsCom.add("ab"));
        System.out.println(tsCom.add("c"));
        System.out.println(tsCom.add("df"));

        System.out.println(tsCom);


    }
}

class Student1 implements Comparable<Student1>{
    private String name;
    private int age;


    public Student1() {
    }

    public Student1(String name, int age) {
        this.name = name;
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

    public String toString() {
        return "Student1{name = " + name + ", age = " + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student1 = (Student1) o;
        return age == student1.age &&
                Objects.equals(name, student1.name);
    }

    @Override
    public int compareTo(Student1 o) {
        int temp = (this.getAge() - o.getAge()==0)? 0 : this.getAge() - o.getAge();
        int temp1 = temp== 0 ? (this.getName().compareTo(o.getName())) : temp;
        return temp1;
    }
}
