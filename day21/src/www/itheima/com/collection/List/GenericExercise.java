package www.itheima.com.collection.List;

import java.util.ArrayList;

public class GenericExercise {
    /*需求:
        定义一个继承结构:
                      动物
             猫                  狗
     波斯猫       狸花猫    泰迪       哈士奇

        属性:名字，年龄
        行为:吃东西
        方法体打印:一只叫做XXX的，X岁的波斯猫，正在吃小饼干
        方法体打印:一只叫做XXX的，X岁的狸花猫，正在吃鱼
        方法体打印:一只叫做XXX的，X岁的泰迪，正在吃骨头，边吃边蹭
        方法体打印:一只叫做XXX的，X岁的哈士奇，正在吃骨头，边吃边拆家


        测试类中定义一个方法用于饲养动物
        public static void keepPet(ArrayList<???> list)i
        //遍历集合，调用动物的eat方法
        }
        要求1:该方法能养所有品种的猫，但是不能养狗
        要求2:该方法能养所有品种的狗，但是不能养猫
        要求3:该方法能养所有的动物，但是不能传递其他类型
*/

    public static void main(String[] args) {
        PoSiCat pc1 = new PoSiCat("小波1",1);
        PoSiCat pc2 = new PoSiCat("小波2",2);
        LiHuaCat lc = new LiHuaCat("小狸",4);
        TaiDiDog td = new TaiDiDog("小泰",2);
        HaShiDog hd = new HaShiDog("小哈",3);

        ArrayList<PoSiCat> list1 = new ArrayList<>();
        ArrayList<LiHuaCat> list2 = new ArrayList<>();
        ArrayList<TaiDiDog> list3 = new ArrayList<>();
        ArrayList<HaShiDog> list4 = new ArrayList<>();
        list1.add(pc1);
        list1.add(pc2);
        list2.add(lc);
        list3.add(td);
        list4.add(hd);

        FeedCat.keepPet(list1);
        FeedAnimal.keepPet(list2);
        FeedDog.keepPet(list3);
        FeedAnimal.keepPet(list4);

    }
}

//父-子类
abstract class Animal{
    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat();

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

    public String toString() {
        return "Animal{name = " + name + ", age = " + age + "}";
    }
}
class Cat extends Animal{
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的");
    }
}
class Dog extends Animal{
    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的");
    }
}

class PoSiCat extends Cat{
    public PoSiCat() {
    }

    public PoSiCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的"+"波斯猫，正在吃小饼干");
    }
}
class LiHuaCat extends Cat{
    public LiHuaCat() {
    }

    public LiHuaCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的"+"狸花猫，正在吃鱼");
    }
}
class TaiDiDog extends Dog{
    public TaiDiDog() {
    }

    public TaiDiDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的"+"泰迪，正在吃骨头，边吃边蹭");
    }
}
class HaShiDog extends Dog{
    public HaShiDog() {
    }

    public HaShiDog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("一只叫做"+getName()+"的，"+getAge()+"岁的"+"哈士奇，正在吃骨头，边吃边拆家");
    }
}

//测试类
//要求1:该方法能养所有品种的猫，但是不能养狗
class FeedCat{
    private FeedCat() {}
    public static void keepPet(ArrayList<?extends Cat> list){
        for (Animal animal : list) {
            animal.eat();
        }
    }
}

//要求2:该方法能养所有品种的狗，但是不能养猫
class FeedDog{
    private FeedDog() {}
    public static void keepPet(ArrayList<?extends Dog> list){
        for (Animal animal : list) {
            animal.eat();
        }
    }
}

//要求3:该方法能养所有的动物，但是不能传递其他类型
 class FeedAnimal{
    private FeedAnimal() {}
    public static void keepPet(ArrayList<?extends Animal> list){
        for (Animal animal : list) {
            animal.eat();
        }
    }
}