package Test;

public class Test1 {
    public static void main(String[] args) {
        int shiwei, gewei, remainder;

/*        for (int i = 1; i <= 100; i++) {
            shiwei = i / 10;
            gewei = i - shiwei*10;
            remainder = i % 7;
             if (shiwei ==7 || gewei ==7 || remainder ==0){

             }else
                 System.out.println(i);
        }*/
        for (int i = 1; i <= 100; i++){

            if(i % 10 == 7 || i / 10 == 7 || i % 7 ==0){
                System.out.println("过");
                continue;
            }
            System.out.println(i);


        }


    }
}
