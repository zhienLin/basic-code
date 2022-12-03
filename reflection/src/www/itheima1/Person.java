package www.itheima1;

import java.io.Serializable;

/**
 * @author zzy
 * @date 2022-10-17 11:21
 */
public class Person extends Creature <String> implements Serializable {
    private String name;
    public int level;
    boolean buru;

    public Person() {
    }

    public Person(String name, int level, boolean buru) {
        this.name = name;
        this.level = level;
        this.buru = buru;
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
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * 设置
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * 获取
     * @return buru
     */
    public boolean isBuru() {
        return buru;
    }

    /**
     * 设置
     * @param buru
     */
    public void setBuru(boolean buru) {
        this.buru = buru;
    }

    public String toString() {
        return "Person{name = " + name + ", level = " + level + ", buru = " + buru + "}";
    }


    @MyAnnotation
    private String show(int i) throws Exception{
        System.out.println(i);
        if(i == 1)
            return "1";
        else
            return "0";
    }

    private static boolean verify(char c) {
        System.out.println(c);
        if(c == 'a')
            return true;
        else
            return false;
    }



}
