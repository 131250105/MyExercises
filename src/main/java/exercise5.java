import java.util.Arrays;

/**
 * Created by zy812818
 * Created @ 2017/10/12.
 * 编程之美 1.4 买书问题 动态规划解法
 **/
public class exercise5 {

    public double buyBooks(int num1, int num2, int num3, int num4, int num5) {
        if (num1 == 0 && num2 == 0 && num3 == 0 && num4 == 0 && num5 == 0)
            return 0;
        else {
            int[] nums = new int[5];
            nums[4] = num1;
            nums[3] = num2;
            nums[2] = num3;
            nums[1] = num4;
            nums[0] = num5;
            Arrays.sort(nums);
            double[] prices = new double[5];
            double min = Double.MAX_VALUE;
            if (nums[0] > 0)
                prices[0] = buyBooks(nums[4] - 1, nums[3] - 1, nums[2] - 1, nums[1] - 1, nums[0] - 1) + 5 * 8 * 0.75;
            if (nums[1] > 0)
                prices[1] = buyBooks(nums[4] - 1, nums[3] - 1, nums[2] - 1, nums[1] - 1, nums[0]) + 4 * 8 * 0.8;
            if (nums[2] > 0)
                prices[2] = buyBooks(nums[4] - 1, nums[3] - 1, nums[2] - 1, nums[1], nums[0]) + 3 * 8 * 0.9;
            if (nums[3] > 0)
                prices[3] = buyBooks(nums[4] - 1, nums[3] - 1, nums[2], nums[1], nums[0]) + 2 * 8 * 0.95;
            if (nums[4] > 0)
                prices[4] = buyBooks(nums[4] - 1, nums[3], nums[2], nums[1], nums[0]) + 1 * 8;

            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < min)
                    min = prices[i];
            }
            return min;
        }
    }

    public static void main(String[] args) {
        exercise5 exercise5 = new exercise5();
        System.out.println(exercise5.buyBooks(2, 2, 2, 1, 1));
    }

}
