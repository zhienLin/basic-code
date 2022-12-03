public class Z0922_1 {
    public static void main(String[] args) {
       int [] arr = {91,4,64,5,78};
        int [] [] pieces = {{5,78},{4,64,3},{91}};
        System.out.println(canFormArray(arr, pieces));
    }


    public static boolean canFormArray(int[] arr, int[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            int oneIndex=-1;
            //拿着每一个二维数组的第一个去查找，如果未找到了，直接返回false；
            //如果找到了就标记当前的一维数组的索引
                for (int k = 0; k < arr.length; k++) {
                    if(pieces[i][0] == arr[k]) {
                        oneIndex = k;
                        break;
                    }
                }
                if(oneIndex == -1)
                    return false;//未找到
                // 找到了：拿着该行数组去做对比。
                else{
                    for (int j = 1; j < pieces[i].length ; j++) {
                        if(++oneIndex>=arr.length)
                            return false;
                        if(pieces[i][j] != arr[oneIndex])
                            return false;
                    }
                }
        }
        return true;
    }

    //别人的程序，但是有问题，自己改进
/*    public static boolean canFormArray ( int[] arr, int[][] pieces){
        for (int i = 0; i < arr.length; ) {
            int k = 0;
            //寻找
            while (k < pieces.length && pieces[k][0] != arr[i]) {
                ++k;
            }
            //没有找到
            if (k == pieces.length) {
                return false;
            }
            //找到了首元素，在这一排去寻找;
            int j = 0;
            while (j < pieces[k].length && arr[i] == pieces[k][j]) {
                ++i;
                ++j;
            }
            //下面的是新加的判断。
            if (j != pieces[k].length )
                return false;
            //如果真的没有遍历完，就不存在不符合的项，那就进入下一个循环，在下一个循环里肯定找不到这个未重复的数值
        }
        return true;
    }*/
}



