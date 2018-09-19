package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
public class TwoSumIV_InputisaBST_653 {

    public boolean findTarget(TreeNode root, int k) {
        List< Integer > list = new ArrayList();
        inorder(root, list);
        for (int item : list) {
            if (item != k - item && search(list, k - item))
                return true;
        }
        return false;
    }

    private boolean search(List<Integer> list, int i) {
        if (i < list.get(0) || i > list.get(list.size()-1)) {
            return false;
        }

        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) == i) {
                return true;
            } else if (list.get(mid) > i) {
                end = mid - 1;
            } else
                start = mid +1;

        }

        return false;
    }

    public boolean findTarget2(TreeNode root, int k) {
        List< Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


}
