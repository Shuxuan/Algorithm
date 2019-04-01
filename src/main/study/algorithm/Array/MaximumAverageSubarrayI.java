package main.study.algorithm.Array;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums is null or empty");
        }
        int N = nums.length;
        int[] sum = new int[N];
        sum[0] = nums[0];

        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        int start = 0;
        int end = k - 1;
        double res = Integer.MIN_VALUE;
        while (end < N) {
            int tmp = start == 0 ? 0 : sum[start-1];
            double ave = (double) ((sum[end] - tmp) * 1.0 / k);
            res = Math.max(res, ave);
            start++;
            end++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};

        int k = 4;

        MaximumAverageSubarrayI myObj = new MaximumAverageSubarrayI();
        System.out.println(myObj.findMaxAverage(nums, k));
    }

}
