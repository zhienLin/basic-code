package www.itheima.demo.InnerClass;

public class Outer {
    String  name;
    private int a = 30;
     class Inner{
        private int a = 30;
        String  color;
        public void show(){
            int a = 10;
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(Outer.this.a);
        }
    }
    public Inner getInstance(){
        return new Inner();//这里不要忘了关键字new,代表新建一个对象。
    }
}
