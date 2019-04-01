package main.company.fb;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = 0;
        int res = Integer.MIN_VALUE;

        for (int num  : nums) {
            maxSum = Math.max(maxSum + num, num);
            res = Math.max(res, maxSum);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray myObj = new MaximumSubarray();
        int rst = myObj.maxSubArray(nums);
        System.out.println(rst);
    }
}
