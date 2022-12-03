package www.itheima1;

/**
 * @author zzy
 * @date 2022-10-17 11:20
 */
public class Creature <T> implements MyInterface{
    @MyAnnotation
    private int age;
    public String kind;


    @MyAnnotation
    public Creature() {
    }

    public Creature(int age, String kind) {
        this.age = age;
        this.kind = kind;
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
     * @return kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * 设置
     * @param kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    public String toString() {
        return "Creature{age = " + age + ", kind = " + kind + "}";
    }

    @Override
    public void method() {
        System.out.println("重写接口方法");
    }
}
