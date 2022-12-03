package www.itheima.demo;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        arr[0] = new Student("heima001", "筱筱", 17);
        arr[1] = new Student("heima002", "之意", 18);
        arr[2] = new Student("heima003", "顾瑀", 19);

        //要求1:添加新的学生对象
        Student[] arrA = add(arr);

        //要求2:遍历所有学生信息
        for (int i = 0; i < arrA.length; i++) {
            System.out.println(arrA[i].getName() + ", " + arrA[i].getAge() +
                    ", " + arrA[i].getId() + ".");
        }

        //要求3:通过id删除学生信息
        Scanner s = new Scanner(System.in);
        System.out.print("请输入您想删除的id:");
        String iddelete = s.next();
        Student[] arrD = delete(arrA, iddelete);

        //要求4:遍历所有学生信息
        for (int i = 0; i < arrD.length; i++) {
            System.out.println(arrD[i].getName() + ", " + arrD[i].getAge() +
                    ", " + arrD[i].getId() + ".");
        }

        //要求5:通过id查询信息
        System.out.print("请输入您想查询的id:");
        String idinquire = s.next();
        Student[] arrI = inquire(arrD, idinquire);
        if (arrI[0].getId().equals(idinquire)) {
            System.out.println(arrI[0].getName() + ", " + arrI[0].getAge() +
                    ", " + arrI[0].getId() + ".");
        } else
            System.out.println("抱歉，您想要查询的信息不存在");
    }

    //add
    public static Student[] add(Student[] arr) {
        Student[] arrAdd = new Student[arr.length + 1];//默认初始值是null,后面接set/get的时候会报错。
        //Student arrAdd1 = new Student();
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arrAdd[i] = arr[i];
        }
        //录入学号，并进行唯一性的判断
        System.out.print("输入你想要添加学生的学号：");
        String id = s.next();
        for (int i = 0; i < arr.length; ) {
            if (id.equals(arr[i].getId())) {
                System.out.print("抱歉，您输入的学号已存在，请重新输入:");
                id = s.next();
            } else
                i++;
        }
        //arrAdd1.setId(id);
        //录入姓名
        System.out.print("输入你想要添加学生的姓名：");
        String name = s.next();
        //arrAdd1.setName(id);
        //录入年龄
        System.out.print("输入你想要添加学生的年龄：");
        int age = s.nextInt();
        //arrAdd1.setAge(age);
        //arrAdd[arr.length] = arrAdd1;
        arrAdd[arr.length] = new Student(id, name, age);
        return arrAdd;
    }

    //delete
    public static Student[] delete(Student[] arr, String id) {
        Student[] arrDelete = new Student[arr.length - 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = id.equals(arr[i].getId());
            if (!flag)
                index++;
        }
        if (index == arr.length) {
            System.out.println("此id不存在，删除失败。");
            return arr;
        } else {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                boolean flag = id.equals(arr[i].getId());
                if (!flag) {
                    arrDelete[count++] = arr[i];
                }
            }
        }
        return arrDelete;

    }

    //inquire
    public static Student[] inquire(Student[] arr, String id) {
        Student[] arrinquire = new Student[1];
        arrinquire[0] = new Student("00", "null", 18);
        for (int i = 0; i < arr.length; i++) {
            boolean flag = id.equals(arr[i].getId());
            if (flag) {
                int originalAge = arr[i].getAge();
                int finallAge = originalAge + 1;
                arr[i].setAge(finallAge);
                arrinquire[0] = arr[i];
            }
        }
        return arrinquire;
    }
}
//问题1：为什么在录入新的名字的时候，在新建的方法体中，我们定义的需要重新返回的数组不能用get和set方法呢？
//就是在add方法中，没有办法直接使用“arrAdd.setId(id)”
//NullPointerException 是一个运行时异常，当 Java 尝试调用真实对象上的任何方法但在运行时该对象引用Null引用时会引发该异常。