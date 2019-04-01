package main.study.algorithm.Array;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                }
                if (res == Integer.MAX_VALUE) res = sum;
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }

                if (sum < target) l++;
                else r--;

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};

        int target = 1;

        ThreeSumClosest myObj = new ThreeSumClosest();
        System.out.println(myObj.threeSumClosest(nums, target));
    }
}
