package www.itheima.demo;

public class MoneyChange {
    public static void main(String[] args) {
        int num = 1234567;
        int mid = num;
        int index = 0;
        while(num != 0){
            index++;
            num = num / 10;
        }
        if(index > 7 ){
            System.out.println("您的钱数太大，无法完成金额转换");
        }
        else {
            String result = change(mid, index);
            System.out.print(result);

        }

    }

    public static String change(int num, int index){
        char [] chs1 = {'零','佰','零','拾','零','万','零','仟','零','佰','零','拾','零','元'};
        char [] chs2 ={'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
        int mid = num;
        for (int i = 0; i < index; i++) {
            chs1[chs1.length - 2 * i - 2] = chs2[mid % 10];
            mid = mid / 10;
        }
        String s = new String (chs1);
        return s;
    }
}

//在字符串拼接的时候，我们可以通过改变拼接的前后顺序来调整我们想要的结果。比如 num = num + b / num = b + num ,最后得到的结果都不一样
//如果就像按原来的顺序输出，那就num（空字符串）在前；反之在后。
//打印字符串的时候是可以直接打印的，并不需要逐个遍历。