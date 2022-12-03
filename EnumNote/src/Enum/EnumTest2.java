package Enum;

/**
 * 使用enum关键字定义枚举类
 * 说明:定义的枚举类默认继承于java.Lang.Enum类
 * @author zzy
 * @date 2022-10-12 20:23
 */
public class EnumTest2 {
    public static void main(String[] args) {

        @SuppressWarnings({})
        Season2 spring = Season2.SPRING;
        System.out.println(spring);
        spring.show();
        //这里哪怕没有重新写toString的方法，这里打印的也不是地址值
        //因为它继承的父类Enum重写了toString的方法，也就是返回当前枚举类对象的名称
        System.out.println(Season2.class.getSuperclass());//class java.lang.Enum

        //values()方法
        Season2[] values = Season2.values();
        for (Season2 value : values) {
            System.out.println(value);
        }

        //valueOf(String)
        Season2 fall = Season2.valueOf("FALL");
        System.out.println(fall);


        //toString()
        System.out.println(fall.toString());


    }
}
//方式二：开发者想要定义的可列举的、内容相关的常量
// 1.用:常量名1（属性1.属性2，...）,常量名1（属性1.属性2，...）,...常量名n（属性1.属性2，...）;
// 2.根据属性的去说明相应的属性，用private final修饰
// 3.设计私有化带参的构造器，
// 4，提供get方法，如想重写toString()的方法，那就重新写一下。
enum Season2 implements  Info{
    //多个对象之间用","隔开，末尾对象";"结束
    SPRING("春天","迎春花"){
        @Override
        public void show() {
            System.out.println("柔柔的阳光");
        }
    },
    SUMMER("夏天","美人娇"){
        @Override
        public void show() {
            System.out.println("凉爽的夜晚");
        }
    },
    FALL("秋天","菊花"){
        @Override
        public void show() {
            System.out.println("湛蓝的天空");
        }
    },
    WINTER("冬天","梅花"){
        @Override
        public void show() {
            System.out.println("温暖的火炉");
        }
    };

    private final String SEASON;
    private final String DESC;

    private Season2(String SEASON,String DESC){
        this.SEASON=SEASON;
        this.DESC =DESC;
    }


    public String getSEASON() {
        return SEASON;
    }

    public String getDESC() {
        return DESC;
    }

/*    @Override
    public void show() {
        System.out.println("This is a season.");
    }*/
}

interface Info{
    void show();
}