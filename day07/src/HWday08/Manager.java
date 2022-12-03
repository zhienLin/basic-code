package HWday08;

public class Manager {
    private String name;
    private int id;
    private int salary;
    private int bonus;


    public Manager() {
    }

    public Manager(String name, int id, int salary, int bonus) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.bonus = bonus;
    }

    public void work(String name, int id, int salary, int bonus){
        System.out.println("工号为"+id+"基本工资为"+salary+"奖金为"+bonus+"的项目经理"+name+"正在努力的做着管理工作, " +
                "分配任务,检查员工提交上来的代码");

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
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * 设置
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * 获取
     * @return bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * 设置
     * @param bonus
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String toString() {
        return "Manager{name = " + name + ", id = " + id + ", salary = " + salary + ", bonus = " + bonus + "}";
    }
}
