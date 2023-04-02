package code_wars.level_8kyu.arrays;

import java.util.Arrays;

public class SumArrays {
    public static void main(String[] args) {
        sum(new double[5]);
    }

    static double sum(double[] numbers) {

        var x = Arrays.stream(numbers).sum();
        System.out.println(x);
        return x;
    }
}
