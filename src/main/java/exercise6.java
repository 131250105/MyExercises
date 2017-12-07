/**
 * Created by zy812818
 * Created @ 2017/11/12.
 **/
public class exercise6 {


    private class Node{
        private Node left;
        private Node right;
        private double[] value;
    }

    private double findKth(double[][] x, int dimension, int kth){
        double[] xi = new double[x.length];
        for(int i = 0; i<x.length ;i++){
            xi[i] = x[i][dimension];
        }
        return find(xi,0,xi.length,kth);
    }


    private double find(double[] x , int start, int end, int kth){
        if(start >= end)
            return x[start];
        else{
            int i = start;
            int j = end - 1;
            while(i<j){
                //取首元素为轴时一定要先移j
                while(x[start] <= x[j] && i<j)
                    j--;
                while(x[start] >= x[i] && i<j)
                    i++;
                if(i!=j)
                    swap(x, i, j);

            }
                swap(x,i,start);
            if(i<kth)
                return find(x,i+1,end,kth-i);
            else if(i>kth){
                return find(x,start,i-1,kth);
            }else{
                return x[i];
            }
        }


    }

    private void swap(double[] x, int i,int j){
        double tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }


    public static void main(String[] args){
        double[][] x = new double[][]{
                {2,3},
                {5,4},
                {9,6},
                {4,7},
                {8,1},
                {7,2},

        };
        exercise6 exercise6 = new exercise6();
        System.out.println(exercise6.findKth(x,0,4));
    }
}
