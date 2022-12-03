package www.itheima.demo;

public class ReGameTest {
    public static void main(String[] args) {
        ReRole r1 = new ReRole("李白",100,'男');
        ReRole r2 = new ReRole("妲己",100,'女');
        r1.ShowInFo();
        r2.ShowInFo();
        //回合制游戏
        while(true){

            r1.beat(r2);
            if(r2.getBlood()==0){
                System.out.println(r1.getName()+"胜利");
                break;
            }

            r2.beat(r1);
            if(r1.getBlood()==0){
                System.out.println(r2.getName()+"胜利");
                break;
            }
        }


    }
}
