package www.itheima.com.find;

public class BlockFind1 {

    /*分块查找：块内无序，块间有序
    实现的步骤：
    1、先创建一个数组用来存放每一块对象的信息
    2、确定所寻找的值属于那一块
    3、在块内进行查找就可以了
    在定义每一个快的对象的时候，需要知道块中的最大值、起始索引和结束索引这三项
    */
    public static void main(String[] args) {
        int findNum = 52;
        int arr[] = {16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 60};
        Block arrBlock[] = new Block[3];
        arrBlock[0] = new Block(21, 0, 5);
        arrBlock[1] = new Block(45, 6, 11);
        arrBlock[2] = new Block(73, 12, 17);

        int index = findIndex11(arrBlock, arr, findNum);
        if (index != -1)
            System.out.println(arr[index] + " " + index);
        else
            System.out.println("对不起，您想要查找的数不在集合中");
    }

    private static int findIndex11(Block arrBlock[], int arr[], int findNum) {
        int blockIndex = findBlockIndex(arrBlock, findNum);
        int minIndex = arrBlock[blockIndex].getStartIndex();
        int maxIndex = arrBlock[blockIndex].getEndtIndex();
        for (int i = minIndex; i <= maxIndex; i++) {
            if (arr[i] == findNum)
                return i;
        }
        return -1;

    }

    private static int findBlockIndex(Block[] arrBlock, int findNum) {
        for (int i = 0; i < arrBlock.length; i++) {
            if (findNum <= arrBlock[i].getMax())
                return i;
        }
        return -1;
    }


    static class Block {
        private int max;
        private int startIndex;
        private int endtIndex;

        public Block() {
        }

        public Block(int max, int startIndex, int endtIndex) {
            this.max = max;
            this.startIndex = startIndex;
            this.endtIndex = endtIndex;
        }

        /**
         * 获取
         *
         * @return max
         */
        public int getMax() {
            return max;
        }

        /**
         * 设置
         *
         * @param max
         */
        public void setMax(int max) {
            this.max = max;
        }

        /**
         * 获取
         *
         * @return startIndex
         */
        public int getStartIndex() {
            return startIndex;
        }

        /**
         * 设置
         *
         * @param startIndex
         */
        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        /**
         * 获取
         *
         * @return endtIndex
         */
        public int getEndtIndex() {
            return endtIndex;
        }

        /**
         * 设置
         *
         * @param endtIndex
         */
        public void setEndtIndex(int endtIndex) {
            this.endtIndex = endtIndex;
        }

        public String toString() {
            return "Block{max = " + max + ", startIndex = " + startIndex + ", endtIndex = " + endtIndex + "}";
        }
    }

}

//首先对数组进行分块，按照数组长度的根号取整数就可以了
//然后定义块的类，并添加到一个块的数组当中
//根据数值，先去找块，位于那个块的区间内。
//然后在块的区间内去寻找索引值就可以了