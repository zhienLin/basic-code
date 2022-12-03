package www.itheima.demo.HW;

public class x3Zi{
    public static void main(String[] args) {
        new x2Play(){
            @Override
            public void play() {
                System.out.println("玩游戏");
            }
        }.play();
    }
}
