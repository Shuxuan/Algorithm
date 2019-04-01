package main.study.algorithm.Array;

public class MaximumAverageSubarrayII {

    public double findMaxAverage(int[] nums, int k) {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        // 寻找最值
        for (int n: nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        double last_mid = max, error = Integer.MAX_VALUE;
        while (max-min > 0.00001) {
            double mid = (max + min) / 2.0;
            if (check(nums, mid, k))
                min = mid;
            else
                max = mid;
            error = Math.abs(last_mid - mid);
            last_mid = mid;
        }
        return min;
    }


    // 判断这个区间里面，是否有一段大于等于K的长度的最长序列，满足要求，就是最大的累计和，减去最小的累积和
    public boolean check(int[] nums, double mid, int k) {
        double sum = 0, prev = 0, min_sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i] - mid;
        if (sum >= 0)
            return true;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prev += nums[i - k] - mid;
            min_sum = Math.min(prev, min_sum);
            if (sum >= min_sum)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};

        int k = 4;

        MaximumAverageSubarrayII myObj = new MaximumAverageSubarrayII();
        System.out.println(myObj.findMaxAverage(nums, k));
    }

}
