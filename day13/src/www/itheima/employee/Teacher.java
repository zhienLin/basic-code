package www.itheima.employee;

public class Teacher extends Employee{
    private String studentclass;
    public Teacher() {
    }

    public Teacher(String id, String name, String work, String studentclass) {
        super(id, name, work);
        this.studentclass = studentclass;
    }

    @Override
    public void work(){
        System.out.println("完成教学任务");
    }
}
