package www.itheima.com.collection.Father;

import java.util.Arrays;

/**
 * Created by Administrator on 2022/9/01.
 */
public class CityTravel {

    static int cityCount = 7;  //城市数量
    static int maxstep = cityCount - 1;  //最大的步长
    int shortestval = Integer.MAX_VALUE;    //最小的值
    int[] shortestarr = new int[cityCount]; //最小的集合
    int stepval = 0;
    int[] steparr = new int[cityCount];
    int[] choosecity = new int[cityCount];
    int[][] citydistanceArr = null;

    public static void main(String[] args) {
        //定义各个城市之间的距离，组成网络图。
        int[][] citydistanceArr = {
                {0, 27, 48, 80, 41, 67, 80},
                {27, 0, 42, 56, 13, 40, 57},
                {48, 42, 0, 50, 45, 59, 93},
                {80, 56, 50, 0, 46, 31, 72},
                {41, 13, 45, 46, 0, 26, 47},
                {67, 40, 59, 31, 26, 0, 41},
                {80, 57, 93, 72, 47, 41, 0}};

        CityTravel cityTravel = new CityTravel();
        cityTravel.citydistanceArr = citydistanceArr;

        for (int i = 0; i < cityCount; i++) {
            cityTravel.steparr[i] = -1;// key表示第几步,value表示选择的城市，用于表示当前路线
            cityTravel.choosecity[i] = 0;//key表示城市编号,value表示是否选择，判断当前路线是否已经存在该城市，用于去重
        }

        //城市编号为 0,1,2,3,4,5,6
        //固定第一步走城市0
        cityTravel.steparr[0] = 0;//  step的值表示走过的城市编号，表示第0步选择城市0
        cityTravel.choosecity[0] = 1;
        cityTravel.travel(1);

        System.out.println(" 最短距离 " + cityTravel.shortestval);
        System.out.println(" 最短路线 " + Arrays.toString(cityTravel.shortestarr));

    }

    public void travel(int step) {
        if (step >= maxstep + 1) {
            //表示走完了所有城市
            if (stepval < shortestval) {
                shortestarr = Arrays.copyOf(steparr, 7);
                shortestval = stepval;
            }
            return;
        }
        //继续下一步
        for (int i = 0; i < cityCount; i++) {
            //下一步没有走过，并且可达，则选中
            if (choosecity[i] == 0 && citydistanceArr[steparr[step - 1]][i] != -1) {
                steparr[step] = i;
                stepval += citydistanceArr[steparr[step - 1]][i];
                choosecity[i] = 1;
                travel(step + 1);
                //这里是退回到上一步
                steparr[step] = -1;
                choosecity[i] = 0;
                stepval -= citydistanceArr[steparr[step - 1]][i];
            }
        }
    }

}