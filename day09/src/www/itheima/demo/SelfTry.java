package www.itheima.demo;

public class SelfTry {
    public static void main(String[] args) {
        TestTry r1 = new TestTry("李白", 100, '男');
        TestTry r2 = new TestTry("妲己", 100, '女');

        while(true){
            r1.beat(r2);
            if(r2.getBlood() == 0) {
                System.out.println(r1.getName() + "胜利");
                break;
            }
            r2.beat(r1);
            if(r1.getBlood() == 0) {
                System.out.println(r2.getName() + "胜利");
                break;
            }

        }


    }
}
