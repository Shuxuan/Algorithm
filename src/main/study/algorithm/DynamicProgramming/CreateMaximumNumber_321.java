package main.study.algorithm.DynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/create-maximum-number/description/
 *
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 *
 * Note: You should try to optimize your time and space complexity.
 *
 * Example 1:
 *
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * Example 2:
 *
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * Example 3:
 *
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 */
public class CreateMaximumNumber_321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        /**
         * 由于k的大小不定，所以有三种可能，
         *
         * 第一种是当k为0时，两个数组中都不取数；
         *
         * 第二种是当k不大于其中一个数组的长度时，有可能只从一个数组中取数；
         *
         * 第三种情况是k大于其中一个数组的长度，则需要从两个数组中分别取数，至于每个数组中取几个，每种情况都要考虑到，然后每次更结果即可。
         * 对于分别从两个数组中取数字的情况，我们需要将两个取出的小数组混合排序成一个数组，小数组中各自的数字之间的相对顺序不变。
         *
         * 我们还需要一个函数来从数组中取若干个数字的函数，而且取出的数要最大。比如当前数组长度为n，需要取出k个数字，
         * 我们定义一个变量drop = n - k，表示需要丢弃的数字的个数，我们遍历数组中的数字，进行下列循环，如果此时drop为整数，且结果数组长度不为0，结果数组的尾元素小于当前遍历的元素，则去掉结果数组的尾元素，此时drop自减1，重复循环直至上述任意条件不满足为止，然后把当前元素加入结果数组中，最后我们返回结果数组中的前k个元素。对于两个数组的混合，我们只要从两个数组开头每次取两个，把大的加入结果数组，然后删掉这个大的，然后继续取一对比较，直到两个数组都为空停止。
         */
        int len1 = nums1.length;
        int len2 = nums2.length;


        int[] rst = null;

        for (int i = 0; i <= k; i++) {
            if (i <= nums1.length && k-i <= nums2.length) {
                int[] part1 = maxNo(nums1, i);
                int[] part2 = maxNo(nums2, k-i);
                int[] tmp = merge(part1, part2, k);
                rst = compare(rst, tmp);
            }
        }

        return rst;

    }


    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] results = new int[k];
        if (k == 0) return results;
        int i = 0, j = 0;
        for(int l = 0; l < k; ++l) {
            results[l] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return results;
    }

    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        if (nums1 == null) {
            return false;
        }
        if (nums2 == null) {
            return true;
        }
        for(; i < nums1.length && j < nums2.length; ++i, ++j) {
            if (nums1[i] > nums2[j])
                return true;
            if (nums1[i] < nums2[j])
                return false;
        }

        //已经到了i的尾部，i== nums1.lenght,所以永远要返回false
        return i != nums1.length;
    }


    public int[] compare(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return nums2;
        }

        if (nums2 == null) {
            return nums1;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[i]) {
                return nums1;
            } else if (nums1[i] == nums2[i]) {
                continue;
            }else {
                return nums2;
            }
        }

        return nums1;
    }

    public int[] maxNo(int[] nums, int k) {
        if (k == 0) {
            return null;
        }
        if (k >= nums.length) {
            return nums;
        }

        int drop = nums.length - k;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && drop > 0 && stack.peek() < nums[i]) {
                drop--;
                stack.pop();
            }

            stack.push(nums[i]);
        }

        while (stack.size() > k) {
            stack.pop();
        }

        int[] rst = new int[k];
        while (!stack.isEmpty() && k > 0){
            rst[--k] = stack.pop();
        }


        return rst;
    }

    public static void main(String[] args) {

        CreateMaximumNumber_321 myObj = new CreateMaximumNumber_321();


        int[] nums1 = {8,6,9};
        int[] nums2 = {1,7,5};

        int[] rst3 = myObj.maxNumber(nums1, nums2, 3);

        System.out.println(Arrays.toString(rst3));
    }

}
