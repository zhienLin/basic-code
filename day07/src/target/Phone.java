package target;

public class Phone {
    //私有之后的只能在本类里面使用，不能在别的类中使用。
    //主要是出于安全性的考虑。
    private String brand;
    private double price;


    //对于每一个私有化的成员变量，都要提供get和set的方法
    //set方法：给成员变量赋值
    //get方法：对外提供成员变量的值

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String setBrand(){
        return brand;
    }

    public void setPrice(double price){
        if(price < 0 || price > 1000000)
            System.out.println("非法参量");
        else
            this.price = price;
    }

    public double setPrice(){
        return price;
    }

    public void call() {
        System.out.println("手机在打电话");
    }

    public void playGame() {
        System.out.println("手机在打游戏");
    }


   // ============================================
    private int weight = 90;
    public void method(){
        int weight = 95;
        System.out.println(this.weight);
    }

    //当成员变量和局部变量重名的时候，一般会采取就近原则，
    // 但是如果变量前面加了this.的前缀，会选取成员变量的值。


}
