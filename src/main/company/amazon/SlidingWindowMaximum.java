package main.company.amazon;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        left[n-1] = nums[n-1];

        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i-1], nums[i]);
            }

            // from right to left
            int j = n - 1 - i;
            if ((j + 1) % k == 0)
                right[j] = nums[j];  // block_end
            else
                right[j] = Math.max(right[j + 1], nums[j]);

        }
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = Math.max(right[i], left[i + k - 1]);
        }


        return output;
    }

    public static void main(String[] args) {

    }
}
