package www.itheima.employee;

public class Buyer extends Maintainer{
    public Buyer() {
    }

    public Buyer(String id, String name, String work, String salary) {
        super(id, name, work, salary);
    }

    @Override
    public void work()
    {
        System.out.println("采购");
    }
}
