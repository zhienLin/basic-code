package www.itheima.demo;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;
//Cloneable里面没有任何的抽象方法
//如果没有抽象方法，那就是一个标记性接口
//Cloneable一旦实现了，那么当前类的对象就可以被克隆
//如果没有实现，当前类的对象就不能被克隆。
public class User implements Cloneable{
    private String name;
    private String id;
    private int [] data;

    public User() {
    }

    public User(String name, String id, int[] data) {
        this.name = name;
        this.id = id;
        this.data = data;
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
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return data
     */
    public int[] getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(int[] data) {
        this.data = data;
    }

    public String toString() {
        return "User{name = " + name + ", id = " + id + ", data = " + arrToString() + "}";
    }

    public String arrToString(){
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i = 0; i < data.length; i++) {
            sj.add(data[i]+"");
        }
        return sj.toString();
    }

    //这里方法重写的目的就是因为clone的方法是protected的
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //自己设计深克隆的方法
        int [] newarr = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            newarr [i] = data[i];
        }

        User clone1 = (User)super.clone();
        clone1.setData(newarr);
        return clone1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(id, user.id) &&
                Arrays.equals(data, user.data);
    }

}
