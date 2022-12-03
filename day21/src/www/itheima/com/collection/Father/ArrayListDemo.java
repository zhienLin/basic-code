package www.itheima.com.collection.Father;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class ArrayListDemo {
    /*
        public boolean add(E e) 添加
        public void clear() 清空
        public boolean remove(E e) 删除
        public boolean contains(0bject obj) 判断是否包含(自定义javabean类的时候要重写equals方法)
        public boolean isEmpty() 判断是否为空
        public int size() 集合长度
        注意点:
        Collection是一个接口,我们不能直接创建他的对象。
        所以，现在我们学习他的方法时，只能创建他实现类的对象。
        实现类: ArrayList
        目的:为了学习Collection接口里面的方法
        自己在做一些练习的时候，还是按照之前的方腺去创建对象。
     */
    public static void main(String[] args) {
        Studet s1 = new Studet("xixi", 19);
        Studet s2 = new Studet("haha", 23);

        Collection<String> coll = new ArrayList<>();
        Collection<Studet> studetArrayList = new ArrayList<>();

//细节1:如果我们要往List系列集合中添加数据，那么方法永远返回true.因为List系列的是允许元素重复的。
//细节2:如果我们要往Set系列集合中添加数据，如果当前要添加元素不存在，方法返回true. 表示添加成功。
//如果当前要添加的元素已经存在，方法返回false,表示添加失败。因为Set系列的集合不允许重复。
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        System.out.println(coll);

//因为contains方法在底层依赖equals方法判断对象是否一致的。
//如果存的是自定义对象，没有重写equals方法，那么默认使用0bject类中的equals方法进行判断，而object类中equals方法，依赖地址值进行判断。
//需求:如果同姓名和同年龄，就认为是同一个学生。
//所以，需要在自定义的Javabean类中，重写equals方法就可以了 。
        studetArrayList.add(s1);
        studetArrayList.add(s2);
        Studet s3 = new Studet("haha", 23);
        System.out.println(studetArrayList.contains(s3));

        //    coll.clear();
        //    System.out.println(coll);

 //细节1:因为Collection里面定义的是共性的方法，所以此时不能通过索引进行删除。只能通过元素的对象进行删除。
 //细节2:方法会有一个布尔类型的返回值，删除成功返回true.删除失败返回false
 //如果要删除的元素不存在，就会删除失败。
        coll.remove("aaa");
        System.out.println(coll);


//在底层调用的是equals的方法，因为在java中字符串的equals方法已经重写了，就是比较的属性值。
//但是其他对象的equals比较的还是地址值，所以在创建对象的时候要重写其方法。
        System.out.println(coll.contains("bbb"));//Ctrl+Alt+B,不在是Ctrl+B了，因为要在具体的地方去找

        System.out.println(coll.isEmpty());
        System.out.println(coll.size());


    }

}

class Studet {
    private String name;
    private int age;

    public Studet() {
    }

    public Studet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studet studet = (Studet) o;
        return age == studet.age &&
                Objects.equals(name, studet.name);
    }


    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Studet{name = " + name + ", age = " + age + "}";
    }
}
