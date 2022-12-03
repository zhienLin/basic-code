package www.itheima.inherit;
/*
现在有四种动物:布偶猫、中国狸花猫、哈士奇、泰迪。暂时不考虑属性，只要考虑行为。
请按照继承的思想特点进行继承体系的设计。
四种动物分别有以下的行为:
布偶猫:吃饭、喝水、抓老鼠
中国狸花猫:吃饭、喝水、抓老鼠
哈士奇:吃饭、喝水、看家、拆家
泰迪:吃饭、喝水、看家、蹭一蹭
*/


public class Animal {
    public Animal(){}
    public void eat(){
        System.out.println("吃饭");
    }
    public void drink(){
        System.out.println("喝水");
    }

}

//在这个类当中，如果方法前面的修饰符变成了private的类型，那么别的子类就不能使用了，只能在本类当中使用。
//也就爸爸的私房钱只能由爸爸自己使用
//子类只能访问父类的非私有的成员

