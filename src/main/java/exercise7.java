import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zy812818
 * Created @ 2017/11/15.
 * leetcode1,15,18 2Sum,3Sum,4Sum
 **/
public class exercise7 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();


        for(int i = 0; i<nums.length;i++){
            threeSumFor4Sum(nums,target-nums[i],i,result,nums[i]);
        }

        return result;
    }


    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for(int i = 0; i<nums.length -2 ; i++) {
            if ( i==0 || (i>0 && nums[i] != nums[i-1])) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }

                }
            }
        }

        return result;
    }


    public List<List<Integer>> threeSumFor4Sum(int[] nums, int target, int start, List<List<Integer>> result, int num){



        for(int i = start; i<nums.length -2 ; i++) {
            if ( i==0 || (i>0 && nums[i] != nums[i-1])) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = target - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        result.add(Arrays.asList(num,nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }

                }
            }
        }

        return result;
    }


    public static void main(String[] args){
        exercise7 exercise7 = new exercise7();
        List<List<Integer>> result = exercise7.fourSum(new int[]{0,0,0,0},0);
        System.out.println(result);
    }

}
