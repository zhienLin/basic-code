package www.itguigu.com;

import org.junit.Test;

import java.util.Optional;

/*
到目前为止，臭名昭著的空指针异常是导致Java应用程序失败的最常见原因。以前，为了解决空指针异常，
Google公司著名的Guava项目引入了Optional类，Guava通过使用检查空值的方式来防止代码污染，
它鼓励程序员写更干净的代码。受到Google Guava的启发，Optional类已经成为Java 8类库的一部分。
Optional<T>类(java.util.Optional)是一个容器类，它可以保存类型T的值，代表这个值存在。
或者仅仅保存null，表示这个值不存在。原来用null表示值不存在，现在Optional可以更好的表达这个概念。
并且可以避免空指针异常。Optional类的Javadoc描述如下:这是一个可以为null的容器对象。
如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
*/


public class Optional1 {
/*
   Optional.of(T t) :创建一个OptionaL实例，t必须非空;
   Optional.empty() :创建一个空的optional实例
   Optional.ofNulLable(T t): t可以为nuLl
*/

    @Test
    public void test1(){
        Boy b = new Boy();
        Girl girlGet = b.getGirl();
        String name = girlGet.getName();//NullPointerException
        System.out.println(name);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        //Optional<Girl> girl1 = Optional.of(girl);NullPointerException
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);//Optional.empty
        Optional<Girl> empty = Optional.empty();
        System.out.println(empty);//Optional.empty
        String name = girl1.get().getName();//java.util.NoSuchElementException: No value present
        System.out.println(name);
        //空的没有办法调用get()的方法。
    }

    @Test
    public void test3(){
        Girl girl = new Girl();
        Boy boy1 = new Boy();
        boy1 = null;
        Boy boy2 = new Boy(girl);


        Optional<Boy> boy1Optional = Optional.ofNullable(boy1);
        Boy boy = boy1Optional.orElse(new Boy());
        Girl girl1 = boy.getGirl();
        Girl girl2 = Optional.ofNullable(girl1).orElse(new Girl("金高银"));
        String name = girl2.getName();
        System.out.println(name);


    }
    
}


class Girl{
    private String name;

    public Girl() {
    }

    public Girl(String name) {
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
        return "Girl{name = " + name + "}";
    }
}

class Boy{
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    /**
     * 获取
     * @return girl
     */
    public Girl getGirl() {
        return girl;
    }

    /**
     * 设置
     * @param girl
     */
    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public String toString() {
        return "Boy{girl = " + girl + "}";
    }
}