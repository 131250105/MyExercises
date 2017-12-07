/*
最长公共子序列问题(LCS问题)，DP解法
 */


public class exercise3 {



    public String LCS(char[] str1,char[] str2){
        int[][] dp = new int[str1.length+1][str2.length+1];
        for(int i = 0;i<str1.length;i++){
            for(int j = 0 ;j<str2.length;j++){
                if(str1[i] == str2[j])
                    dp[i+1][j+1] = dp[i][j]+1;
                else{
                    if(dp[i][j+1] >= dp[i+1][j])
                        dp[i+1][j+1] = dp[i][j+1];
                    else
                        dp[i+1][j+1] = dp[i+1][j];
                }

            }
        }

        int length = dp[str1.length][str2.length];
        char[] n = new char[length];
        getLCS(dp,str1.length,str2.length,str1,str2,n,length-1);
        return String.valueOf(n);
//        return "";
    }

    private void getLCS(int[][] dp,int i,int j,char[] c,char[] d,char[] result,int length){

        if(i==0 || j==0)
            return;

        if(c[i-1] == d[j-1]) {
            result[length] = c[i-1];
            getLCS(dp, i - 1, j - 1, c, d, result,length-1);
        }
        else{
            if(dp[i-1][j] >= dp[i][j-1]){
                getLCS(dp,i-1,j,c,d,result,length);
            }else{
                getLCS(dp,i,j-1,c,d,result,length);
            }
        }
    }

    public static void main(String[] args){
        exercise3 exercise3 = new exercise3();
        System.out.println(exercise3.LCS(new char[]{'a','b','c','d','a'},new char[]{'a','d','c','b','a'}));
    }
}
