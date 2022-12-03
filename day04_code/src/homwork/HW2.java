package homwork;


public class HW2 {
    /*需求：红茶妹妹有21元钱，她攒了几天钱之后自己的钱比原来的两倍还多三块。
     绿茶妹妹有24元钱，她攒了几天钱之后自己的钱正好是原来的两倍。
     那么红茶和绿茶现在的钱一样多，请问对么？*/
    public static void main(String[] args) {
        int redMoney = 21;
        int GreenMoney = 24;
        if((redMoney*2+3) == (GreenMoney*2))
            System.out.println("红茶妹妹和绿茶妹妹钱数一样多");
        else
            System.out.println("红茶妹妹和绿茶妹妹钱数不一样多");

    }



}
