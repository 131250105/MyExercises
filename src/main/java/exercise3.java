/*
最长公共子序列问题(LCS问题)，DP解法
 */



public class exercise3 {



    public String LCS(char[] str1, char[] str2, int str1Pos, int str2Pos,String result){
        if(str1Pos<0 || str2Pos<0)
            return result;
        else{
            if(str1[str1Pos] == str2[str2Pos])
                return LCS(str1,str2,str1Pos-1,str2Pos-1,str1[str1Pos]+result);
            else{
                String left = LCS(str1,str2,str1Pos,str2Pos-1,result);
                String right = LCS(str1,str2,str1Pos-1,str2Pos,result);
                return left.length()<right.length()?right:left;
            }
        }
    }

    public static void main(String[] args){
        exercise3 exercise3 = new exercise3();
        String result = exercise3.LCS("ABCBDAB".toCharArray(),"BDCABA".toCharArray(),6,5,"");
        System.out.println(result);
    }
}
