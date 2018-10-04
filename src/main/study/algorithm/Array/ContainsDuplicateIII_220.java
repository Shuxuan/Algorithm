package main.study.algorithm.Array;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/description/
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 * “滑动窗口” + TreeSet
 * 参考LeetCode Discuss：https://leetcode.com/discuss/38177/java-o-n-lg-k-solution
 *
 * TreeSet数据结构（Java）使用红黑树实现，是平衡二叉树的一种。
 *
 * 该数据结构支持如下操作：
 *
 * 1. floor()方法返set中≤给定元素的最大元素；如果不存在这样的元素，则返回 null。
 *
 * 2. ceiling()方法返回set中≥给定元素的最小元素；如果不存在这样的元素，则返回 null。
 *
 * public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
 *         if(k < 1 || t < 0)
 *             return false;
 *         TreeSet<Integer> set = new TreeSet<Integer>();
 *         for(int i = 0; i < nums.length; i++){
 *             int n = nums[i];
 *             if(set.floor(n) != null && n <= t + set.floor(n) ||
 *                     set.ceiling(n) != null && set.ceiling(n) <= t + n)
 *                 return true;
 *             set.add(n);
 *             if (i >= k)
 *                 set.remove(nums[i - k]);
 *         }
 *         return false;
 *     }
 */
public class ContainsDuplicateIII_220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0)
            return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if(set.floor(n) != null && n <= t + set.floor(n) ||
                    set.ceiling(n) != null && set.ceiling(n) <= t + n)
                return true;
            set.add(n);
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}
