package main.company.ama3.dp;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int N = nums.length;

        int max = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max + nums[i], nums[i]);
            res = Math.max(res, max);
        }

        return 0;
    }

}
