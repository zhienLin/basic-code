package www.itheima.demo;

public class SystemTest {
    public static void main(String[] args) {
        System.exit(0);
        System.out.println(System.currentTimeMillis());//1659315912651
        System.currentTimeMillis();//
        //public static void arraycopy(数据源数组，起始索引，目的地数组，起始索引，拷贝个数)
        //1、如果数据类型是基本的数据类型，不同类型之间不能顾实现类型的转换。
        //2、如果是引用数据类型，那么子类可以给父类对象进行复制的操作。
        int [] arr1 = {1,2,3,4,5,6,7,8,9,0};
        int [] arr2 = new int[10];// 0 0 0 0 0 1 2 3 0 0
        System.arraycopy(arr1,0,arr2,5,3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }

        Student s1 = new Student("lili");
        Student s2 = new Student("haha");
        Student [] s = {s1, s2};

        Person [] p = new Person[2];
        System.arraycopy(s,0,p,0,2);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].getName());
        }


    }
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student extends Person{

    public Student(String name) {
        super(name);
    }

    public Student() {
    }
}

