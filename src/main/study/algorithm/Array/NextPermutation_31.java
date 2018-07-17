package main.study.algorithm.Array;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class NextPermutation_31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        // find first decreasing element
        int x = nums.length - 2;
        while (x >= 0 && nums[x] >= nums[x+1]) {
                x--;
        }

        // find y in the right, just bigger than x， scan from the end to x+1 position.
        if (x >= 0) {
            int y = nums.length - 1;
            while (y >= 0 && nums[y] <= nums[x]) {
                y--;
            }
            // swap x and y
            swap(nums, x, y);
        }
        // reverse from x+1 to the end
        reverse(nums,  x + 1);
    }

    private void reverse(int[] nums, int start) {
        int tail = nums.length - 1;
        while (start < tail) {
            int tmp = nums[start];
            nums[start] = nums[tail];
            nums[tail] = tmp;
            tail--;
            start++;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        NextPermutation_31 myclass = new NextPermutation_31();
        myclass.nextPermutation(nums);
        for (int item : nums) {
            System.out.println(item);
        }
    }
}
