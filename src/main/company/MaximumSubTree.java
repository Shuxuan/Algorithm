package main.company;

import main.study.algorithm.Tree.TreeNode;

public class MaximumSubTree {

    int max = Integer.MIN_VALUE;
    TreeNode res = null;
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        sum(root);
        return res;
    }


    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int val = root.val;
        int left_val = sum(root.left);
        if (left_val > max) {
            res = root.left;
            max = left_val;
        }

        int right_val = sum(root.right);

        if (right_val > max) {
            max = right_val;
            res = root.right;
        }

        int sum = val + right_val + left_val;

        if ( sum > max) {
            max = sum;
            res = root;
        }
        return val + left_val + right_val;
    }
}
