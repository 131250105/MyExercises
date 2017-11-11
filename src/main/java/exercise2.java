/*
DP之背包问题，解得并不优雅。。
 */



public class exercise2 {


    public int[][] getBigestWeight(int[] weight, int[] values, int n ){
        int[][] matrix = new int[weight.length][n];
        for(int i = 0; i<weight.length ;i++){
            for(int j = 0; j<n ; j++){

                if((j+1) - weight[i] <0){
                    if(i == 0){
                        matrix[i][j] = 0;
                    }else{
                        matrix[i][j] = matrix[i-1][j];
                    }
                }else if((j+1) - weight[i] == 0){
                    if(i == 0){
                        matrix[i][j] = values[i];
                    }else {
                        matrix[i][j] = Math.max(values[i], matrix[i-1][j]);
                    }
                }else{
                    if(i == 0){
                        matrix[i][j] = values[i];
                    }else{
                        matrix[i][j] = Math.max(values[i]+matrix[i-1][j-weight[i]],matrix[i-1][j]);
                    }
                }

            }
        }

        return matrix;
    }


    public static void main(String[] args){
        exercise2 exercise2 = new exercise2();
        int[][] result =exercise2.getBigestWeight(new int[]{2,2,6,5,4},new int[]{6,3,5,4,6},10);
        System.out.println(result[4][9]);
    }
}
