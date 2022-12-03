package www.itheima.com.collection.Set;

/*
        需求:创建5个学生对象
        属性:(姓名,年龄，语文成绩,数学成绩,英语成绩),
        按照总分从高到低输出到控制台
        如果总分一样，按照语文成绩排
        如果语文一样，按照数学成绩排
        如果数学成绩一样，按照年龄排
        如果年龄一样，按照姓名的字母顺序排
        如果都一样，认为是同一个学生，不存。
*/


import java.util.TreeSet;

public class TreeSetExercise {
    public static void main(String[] args) {
        Stu s1 = new Stu("ahua",16,120,120,120);
        Stu s2 = new Stu("bhua",17,121,120,119);
        Stu s3 = new Stu("chua",15,121,119,120);
        Stu s4 = new Stu("dhua",17,120,120,120);
        Stu s5 = new Stu("ahub",17,120,120,120);
        Stu s6 = new Stu("ahua",16,120,120,120);
        Stu s7 = new Stu("ahua",16,121,120,120);

        TreeSet<Stu> ts = new TreeSet<>();
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);
        ts.add(s7);
        for (Stu t : ts) {
            System.out.println(t);
        }


    }
}

class Stu implements Comparable<Stu>{
    private String name;
    private int age;
    private int gradeChinese;
    private int gradeMath;
    private int gradeEnglish;

    public Stu(){
    }

    public Stu(String name, int age, int gradeChinese, int gradeMath, int gradeEnglish) {
        this.name = name;
        this.age = age;
        this.gradeChinese = gradeChinese;
        this.gradeMath = gradeMath;
        this.gradeEnglish = gradeEnglish;
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

    /**
     * 获取
     * @return gradeChinese
     */
    public int getGradeChinese() {
        return gradeChinese;
    }

    /**
     * 设置
     * @param gradeChinese
     */
    public void setGradeChinese(int gradeChinese) {
        this.gradeChinese = gradeChinese;
    }

    /**
     * 获取
     * @return gradeMath
     */
    public int getGradeMath() {
        return gradeMath;
    }

    /**
     * 设置
     * @param gradeMath
     */
    public void setGradeMath(int gradeMath) {
        this.gradeMath = gradeMath;
    }

    /**
     * 获取
     * @return gradeEnglish
     */
    public int getGradeEnglish() {
        return gradeEnglish;
    }

    /**
     * 设置
     * @param gradeEnglish
     */
    public void setGradeEnglish(int gradeEnglish) {
        this.gradeEnglish = gradeEnglish;
    }

    public String toString() {
        return "Stu{name = " + name + ", age = " + age + ", gradeSum = " + (gradeChinese+gradeMath+gradeEnglish)+ ", gradeChinese = " + gradeChinese + ", gradeMath = " + gradeMath + ", gradeEnglish = " + gradeEnglish + "}";


    }


    @Override
    public int compareTo(Stu o) {
        int rule = (o.getGradeChinese()+o.getGradeMath()+o.getGradeEnglish()-
                this.getGradeChinese()-this.getGradeMath()-this.getGradeEnglish());
        rule=rule == 0?  o.getGradeChinese() - this.getGradeChinese():rule;
        rule=rule == 0?  o.getGradeMath() - this.getGradeMath():rule;
        rule=rule == 0?  o.getAge() - this.getAge():rule;
        rule=rule == 0?  o.getName().compareTo(this.getName()):rule;
        return rule;
    }
}
