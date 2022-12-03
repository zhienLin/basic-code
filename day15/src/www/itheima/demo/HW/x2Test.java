package www.itheima.demo.HW;

public class x2Test {
    public static void main(String[] args) {
        x2New n = new x2New();
        x2Old o = new x2Old();
        use(n);
        use(o);

    }
    public static void use(x2Phone p){
        if(p instanceof x2New)
        {
            x2New n = (x2New)p;
            n.call();
            n.play();
        }
        else{
            x2Old d = (x2Old)p;
            d.call();

        }
    }
}
