/**
 * Created by zy812818
 * Created @ 2018/1/29.
 * * leetcode Maximum Subarray
 **/
public class exercise11 {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            result = Math.max(result,sum);
            if(sum<0)
                sum = 0;
        }
        return result;
    }
}
