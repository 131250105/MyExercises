/*
    自己实现的感知器
 */

public class exercise1 {


    private double[] w;

    public void perceptron_Train(double[][] x, double[] W, double[] y, double rate) {
        this.w = W;

        boolean isAllcorrect = false;

        while(!isAllcorrect) {
            for (int i = 0; i < x.length; i++) {
                while (cal(x[i], this.w)  != y[i]) {

                    if(y[i] == 0) {
                        for (int j = 0; j < x[i].length; j++) {
                            this.w[j] = this.w[j] - x[i][j]  * rate;
                        }
                    }else{
                        for (int j = 0; j < x[i].length; j++) {
                            this.w[j] = this.w[j] + x[i][j]  * rate;
                        }
                    }
                }
            }

            isAllcorrect = true;

            for (int i = 0; i < x.length; i++) {
                if(test(x[i]) != y[i])
                    isAllcorrect = false;
            }

        }
    }

    public double test(double[] x) {
        return cal(x, this.w);
    }

    public double cal(double[] x, double[] w) {

        double result = 0.0;
        for (int i = 0; i < x.length; i++) {
            result = result + x[i] * w[i];
        }

        if(result>=0)
            return 1;
        else
            return 0;

    }

    public static void main(String[] args) {

        //感知器训练 AND 模型
        double[][] x = new double[][]{
                {1, 1, 1},
                {1, 0, 1},
                {0, 0, 1},
                {0, 1, 1}
        };

        double[] w = new double[]{0, 0, 0};

        //为了编写方便,将0改成-1
        double[] y = new double[]{1, 0, 0, 0};

        double rate = 1;

        exercise1 exercise1 = new exercise1();

        exercise1.perceptron_Train(x, w, y, rate);

        System.out.println(exercise1.test(new double[]{1, 1, 1}));
        System.out.println(exercise1.test(new double[]{1, 0, 1}));
        System.out.println(exercise1.test(new double[]{0, 0, 1}));
        System.out.println(exercise1.test(new double[]{0, 1, 1}));

    }

}
