/**
 * Created by zy812818
 * Created @ 2017/12/19.
 * leetcode Trapping Rain Water
 **/
public class exercise9 {


    public int trap(int[] height) {

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int result = 0;
        for(int i = 0; i<left.length ; i++){
            left[i] = i==0?height[0]:Math.max(left[i-1],height[i]);
        }

        for(int i = height.length -1 ;i>=0;i--){
            right[i] = i==height.length-1?height[height.length-1]:Math.max(right[i+1],height[i]);
        }

        for(int i = 0 ;i<height.length;i++){
            result+=Math.min(left[i],right[i]) - height[i];
        }

        return result;
    }


    public static void main(String[] args){
        exercise9 exercise9 = new exercise9();
        System.out.println(exercise9.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
