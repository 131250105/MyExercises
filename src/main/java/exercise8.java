import java.util.Arrays;

/**
 * Created by zy812818
 * Created @ 2017/12/7.
 * leetcode Longest Palindromic Substring
 **/
public class exercise8 {


    public String longestPalindrome(String s) {

        if(s.length() == 0 ){
            return "";
        }
        if(s.length() == 1){
            return s;
        }

        int[][] dp = new int[s.length()][s.length()];
        dp[s.length()-1][s.length()-1] = 1;
        for(int i = 0 ; i<s.length() ; i++) {
            for(int j =0 ;j<s.length();j++){
                if(i>=j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        int maxLength = 0;
        int start = 0;
        int end = 0;
        for(int k = 1; k<s.length();k++){
            for(int i = 0;i+k<s.length();i++){
                int j = i+k;
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i+1][j-1];
                }

                if(dp[i][j] == 1){
                    if(j-i+1 > maxLength) {
                        maxLength = j-i+1;
                        start = i;
                        end = j+1;
                    }
                }
            }
        }

        if(end==0)
            return s.substring(0,1);

        return s.substring(start,end);
    }



    public static void main(String[] args){
        exercise8 exercise8 = new exercise8();
//        System.out.println(exercise8.getLongestPalindrome("abcda"));


    }
}
