package www.itheima.com.collection.Father;

public class Hahah {

    public static void main(String[] args) {
        // 城市的数量
        int n = 7;
        //各个城市的之间的距离表格图
        int[][] graph = {
                {0, 27, 48, 80, 41, 67, 80},
                {27, 0, 42, 56, 13, 40, 57},
                {48, 42, 0, 50, 45, 59, 93},
                {80, 56, 50, 0, 46, 31, 72},
                {41, 13, 45, 46, 0, 26, 47},
                {67, 40, 59, 31, 26, 0, 41},
                {80, 57, 93, 72, 47, 41, 0}
        };
        // boolean类型的数组 v 用来标记一个城市结点是否被访问过
        boolean[] v = new boolean[n];
        // 标记第0个结点已经被访问过，所以v[0]=true
        v[0] = true;
        int ans = Integer.MAX_VALUE;

        // 查找最小权重的汉密尔顿回路 Hamiltonian Cycle
        ans = tsp(graph, v, 0, n, 1, 0, ans);

        // 输出结果ans就是最小权重的汉密尔顿回路（ Hamiltonian Cycle）
        System.out.println(ans);

    }

    static int tsp(int[][] graph, boolean[] v, int currPos, int n, int count, int cost, int ans) {

        if (count == n && graph[currPos][0] > 0) {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }
        /*
         * 回溯步骤（BACKTRACKING STEP）
         * 循环遍历currPos结点的邻接表，将计数增加1，并按graph[currPos][i]值增加成本
         * cost + graph[currPos][i]
         */
        for (int i = 0; i < n; i++) {
            if (v[i] == false && graph[currPos][i] > 0) {
                //标记结点被访问过
                v[i] = true;
                ans = tsp(graph, v, i, n, count + 1, cost + graph[currPos][i], ans);
                //标记结点没有被访问过
                v[i] = false;
            }
        }
        return ans;
    }

}
