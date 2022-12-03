import java.util.Arrays;

public class Z0912 {
    public static void main(String[] args) {
        int arr[] = {0,4,3,0,4};
        int result = specialArray(arr);
        System.out.println(result);

    }

    public static int specialArray(int[] nums) {
        //方法一：
        /*{
        Arrays.sort(nums);
        if (nums[0] >= nums.length)
            return nums.length;
        for (int i = 1; i <= nums.length; i++) {
            if (i <= nums[nums.length - i] && i > nums[nums.length - i - 1])
                return i;
        }
        return -1;
        }*/

        /*//方法二：
        {
            int n = nums.length;
            for (int i = 0; i <= n; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] >= i)
                        sum++;
                }
                if (sum == i)
                    return i;
            }
            return -1;
        }*/


        Arrays.sort(nums);
        int n=nums.length;
        if(nums[0]>=n){return n;}
        int l=1,r=n-1;
        while(l<r){
            int mid=(l+r)>>1;
            if(nums[n-mid]>=mid&&nums[n-mid-1]<mid){return mid;}
            else if(nums[n-mid]<mid){r=mid-1;}
            else{l=mid+1;}
            if(l>=r-1){
                if(nums[n-l]>=l&&nums[n-l-1]<l){return l;}
                if(nums[n-r]>=r&&nums[n-r-1]<r){return r;}
                break;
            }
        }
        return -1;

    }

}
