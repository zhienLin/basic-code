package www.itheima.demo;

public class GameTest {
    public static void main(String[] args) {
        Role r1 = new Role("李白",100);
        Role r2 = new Role("妲己",100);
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
