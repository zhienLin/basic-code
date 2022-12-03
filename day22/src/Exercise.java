import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

public class Exercise {
    public static void main(String[] args) {
        HashMap<Student,String >  map = new HashMap<>();
        Student s1 = new Student(23,"xixi");
        Student s2 = new Student(24,"haha");
        Student s3 = new Student(25,"heihei");
        Student s4 = new Student(25,"heihei");
        map.put(s1,"heibei");
        map.put(s3,"heibei");
        map.put(s2,"heibei");
        map.forEach((Student student, String s) ->  System.out.println(student+","+s));
    }
}


class Student{
    private int age;
    private String name;


    public Student() {
    }

    public Student(int age, String name) {
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
        return "Student{age = " + age + ", name = " + name + "}";
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
        return Objects.hash(age, name);
    }
}
