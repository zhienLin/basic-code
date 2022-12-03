package Annotation;

import java.lang.annotation.Annotation;

/**
 * @author zzy
 * @date 2022-10-13 10:47
 */
public class Test {
    public static void main(String[] args) {
        Class<Mid> modClass = Mid.class;
        Annotation[] annotations = modClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}
@Test1("xiixixi")
@Test1("xiix")
class Mid {
    private String name;

    public Mid() {
    }

    public Mid(String name) {
        this.name = name;
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
        return "Mid{name = " + name + "}";
    }
}

class Mod extends Mid{
    private String name;

    public Mod() {
    }

    public Mod(String name) {
        this.name = name;
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
        return "Mod{name = " + name + "}";
    }
}