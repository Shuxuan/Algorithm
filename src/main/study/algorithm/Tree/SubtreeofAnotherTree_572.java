package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */
public class SubtreeofAnotherTree_572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (sameTree(s, t)) {
            return true;
        }

        if (s != null && (sameTree(t, s.left) || sameTree(t, s.right))) {
            return true;
        }

        if (s != null && (isSubtree(s.left, t) || isSubtree(s.right, t)))
            return true;

        return false;
    }

    private boolean sameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }

}
