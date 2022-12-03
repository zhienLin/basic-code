package www.itheima.demo.a01staticdemo1;
//这个叫做javabean类
public class Student implements Cloneable{
    private String name;
    private int age;
    private String gender;
    public static String teacherName;
    public Student() {
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void study(){
        System.out.println(name+"正在学习");
    }//这里没有static
    public void showInFo(){
        System.out.println("姓名为："+ name+". 年龄为："+age+". 性别为："+gender+". 老师名字为："+teacherName);
    }

}
