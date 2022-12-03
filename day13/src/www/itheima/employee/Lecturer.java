package www.itheima.employee;

public class Lecturer extends Teacher{
    private String subject;

    public Lecturer(String subject) {
        this.subject = subject;
    }

    public Lecturer(String id, String name, String work, String studentclass, String subject) {
        super(id, name, work, studentclass);
        this.subject = subject;
    }
    @Override
    public void work()
    {
        System.out.println("讲课");
    }
}
