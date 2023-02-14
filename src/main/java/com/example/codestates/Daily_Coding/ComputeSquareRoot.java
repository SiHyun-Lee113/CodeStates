package com.example.codestates.Daily_Coding;

public class ComputeSquareRoot {
    public static void main(String[] args) {
        String output = computeSquareRoot(9);
        System.out.println(output); // --> "3.00"

        output = computeSquareRoot(6);
        System.out.println(output); // --> "2.45"
    }
    public static String computeSquareRoot(int num) {
        // TODO:
        double[] diffs = new double[]{1, 0.1, 0.01, 0.001};
        double base = 1;
        for(int i = 0; i < diffs.length; i++) {
          while (base * base < num) {
            base = base + diffs[i];
          }
          if(base * base == num) {
            return String.format("%.2f", base);
          }else {
            base = base - diffs[i];
          }
        }
        return String.format("%.2f", base);
    }
}
