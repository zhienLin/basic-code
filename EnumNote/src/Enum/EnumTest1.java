package Enum;

/**
 * 一、枚举类的定义
 * 1.枚举类的理解:类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 *
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 *
 * 三、Enum类中的常用方法:
 * values()方法:返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 * valueOf(String str):可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对应的表达
 * tostring():返回当前枚举类对象常量的名称
 *
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 情况一:实现接口，在enum类中实现抽象方法
 * 情况二:让枚举类的对象分别实现接口中的抽象方法
 * @author zzy
 * @date 2022-10-12 19:52
 */
public class EnumTest1 {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }
}
//方式一：
class Season{
    //所有的属性都必须是私有并且不能改变的常量，因此用private final修饰
    //因为final修饰的值不能为null,也就是必须有初始值，那么赋值的操作可以在下面的私有化构造器当中给定。（这个不太懂）
    private final String SEASON;
    private final String DESC;

    //私有化构造器，并给出对象的属性值
    private Season(String SEASON,String DESC){
        this.SEASON=SEASON;
        this.DESC =DESC;
    }

    //提供当前枚举类的多个对象，因为是允许外部类访问的，因此用的是public,并且可以通过类名调用
    //也就是说是当前类所有对象所共有的，因此用static修饰，而且还不能被修改，有需要加fianl修饰
    //因此：public static final 是列举枚举类的修饰词。
    public static final Season SPRING = new Season("春天","迎春花");
    public static final Season SUMMER = new Season("夏天","美人娇");
    public static final Season FALL = new Season("秋天","菊花");
    public static final Season WINTER = new Season("冬天","梅花");

    public String getSEASON() {
        return SEASON;
    }

    public String getDESC() {
        return DESC;
    }

    @Override
    public String toString() {
        return "Season{" +
                "SEASON='" + SEASON + '\'' +
                ", DESC='" + DESC + '\'' +
                '}';
    }
}


//赋值的细节，一共有哪三种方式？
//单例模式都有什么？
//程序/项目是什么样的？