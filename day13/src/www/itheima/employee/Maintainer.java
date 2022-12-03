package www.itheima.employee;

public class Maintainer extends Employee{
    private String salary;
    public Maintainer() {
    }

    public Maintainer(String id, String name, String work, String salary) {
        super(id, name, work);
        this.salary = salary;
    }

    @Override
    public void work(){
        System.out.println("完成管理任务");
    }
}
