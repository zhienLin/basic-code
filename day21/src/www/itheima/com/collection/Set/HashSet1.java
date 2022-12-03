package www.itheima.com.collection.Set;
//the HashCode

/*
哈希值:对象的整数表现形式
      1．如果没有重写hashcode方法，不同对象计算出的哈希值是不同的(因为哈希值是根据地址值计算的，对象不同，地址不同，那么哈希值就不同)
      2．如果已经重写hashcode方法，不同的对象只要属性值相同，计算出的哈希值就是一样的
      3．但是在小部分情况下，不同的属性值或者不同的地址值计算出来的哈希值也有可能一样。(哈希碰撞)

1. Hashset集合的底层数据结构是什么样的?
先是创建一个默认长度为16，默认加载因子为0.75的一个数组，名为table
在JDK8之前是数组+链表的形式，并且如果是相同的哈希值，但是属性值不一样的话，新元素会替换老元素，老元素挂在新元素的下面
在JDK8之后是数组+链表+红黑树的形式，相同哈希值的对象，新元素直接挂在老元素的下面。
2. HashSet添加元素的过程?
这个里面有一个默认的加载因子的，当数组里面的元素超过素组长度*加载因子的时候，扩容为原来的2倍。
链表长度大于8，并且数组长度大于64的时候，就会把链表转化成为红黑树的形式。
3. HashSet为什么存和取的顺序不一样?
首先它本身每个对象添加的时候就是无序的，而且链表过长也会转化成对应的红黑树的形式，因此取数据的时候没有办法保证有序。
4.Hashset为什么没有索引?
因为它本身是数组+链表组成的，或者红黑树，下面的链表不好进行表示。
5. Hashset是利用什么机制保证去重的?
利用hashCode()以及equals()的方法。



*/
import java.util.Objects;

public class HashSet1 {
    public static void main(String[] args) {
        Student s1 = new Student("xixi",23);
        Student s2 = new Student("xixi",23);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        //但是在小部分情况下，不同的属性值或者不同的地址值计算出来的哈希值也有可能一样。(哈希碰撞)
        System.out.println("abc".hashCode());
        System.out.println("acD".hashCode());

    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
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
        return "Student{name = " + name + ", age = " + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}