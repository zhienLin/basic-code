package www.itheima.polymorphic02;

public class KeepPets {
    public static void main(String[] args) {
        Person p1  = new Person("老王",30);
        Person p2  = new Person("老李",23);
        Animal dog = new Dog("黑色",2);
        Animal cat = new Cat("白色",3);
        p1.keepPet(dog,"骨头");
        p2.keepPet(cat,"鱼");



    }
}
