package main.company.vmw;

import main.study.algorithm.Tree.TreeNode;

public class LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode rst = helper(root, p, q);

        return rst;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }
        TreeNode l = helper(root.left, p, q);
        TreeNode r = helper(root.right, p, q);

        if (l != null && r != null) {
            return root;
        }

        if (l == null) {
            return r;
        }

        return l;

    }

}
