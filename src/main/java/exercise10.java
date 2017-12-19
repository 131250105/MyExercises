/**
 * Created by zy812818
 * Created @ 2017/12/19.
 * leetcode Container With Most Water
 **/
public class exercise10 {

    public int maxArea(int[] height) {
        int bestResult = 0;
        int i = 0, j = height.length-1;
        while(i < j){
            int tmp = Math.min(height[i],height[j])*(j-i);
            if(tmp>bestResult)
                bestResult = tmp;
            if(height[i] < height[j])
                i++;
            else
                j--;

        }
        return bestResult;
    }

    public static void main(String[] args){
        exercise10 exercise10 = new exercise10();
//        exercise10.maxArea();
    }
}
