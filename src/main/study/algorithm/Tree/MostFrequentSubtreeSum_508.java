package main.study.algorithm.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 *
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 *
 */
public class MostFrequentSubtreeSum_508 {

    int maxCount = 0;
    int count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        sum(root);

        int[] rst = new int[count];
        int index = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) {
                rst[index++] = key;
            }
        }

        return rst;

    }

    private int sum(TreeNode root) {
        int sum = 0;
        if (root != null) {
            sum = root.val + sum(root.left) + sum(root.right);
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else
                map.put(sum ,1);
            if (maxCount == map.get(sum)) {
                count++;
            } else if (maxCount < map.get(sum)){
                count = 1;
                maxCount = map.get(sum);
            }

        }


        return sum;
    }
}
