import java.util.ArrayList;
import java.util.List;

public class Z1007 {
    /*给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
    子数组是数组中的一个连续数字序列。
    已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），
    numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作升序子数组。
*/
    public static void main(String[] args) {
        int nums[] = {10, 20, 30, 40,50};
        int maxSum = maxAscendingSum(nums);
        System.out.println("升序子数组最大可能元素的和是：" + maxSum);
    }

    public static int maxAscendingSum(int[] nums) {

        int max = 0;
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] < nums[i])
                sum += nums[i];
            else
                sum = nums[i];
            max = Math.max(max, sum);
        }
        return max;






/*        List<Integer> list = new ArrayList<>();
        list.add(0);
        int max = nums[0];
        for (int i = 0; i < nums.length -1; i++) {
            if(nums[i]>=nums[i+1]) {
                list.add(i + 1);
            }
        }
        list.add(nums.length);

        for (int i = 0; i < list.size() -1; i++) {
            int sum = 0;
            for(int j = list.get(i); j < list.get(i+1);j++){
                sum = sum + nums[j];
            }
            if(sum > max)
                max = sum;
            System.out.println(sum);
        }
        //return max;*/

    }
}
