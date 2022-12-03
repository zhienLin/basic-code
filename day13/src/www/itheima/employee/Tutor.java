package www.itheima.employee;

public class Tutor extends Teacher{
    private String content;

    public Tutor(String content) {
        this.content = content;
    }

    public Tutor(String id, String name, String work, String studentclass, String content) {
        super(id, name, work, studentclass);
        this.content = content;
    }
    @Override
    public void work()
    {
        System.out.println("辅导");
    }
}
