package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 *
 * Return any binary tree that matches the given preorder and postorder traversals.
 *
 * Values in the traversals pre and post are distinct positive integers.
 *
 *
 *
 * Example 1:
 *
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *
 *
 * Note:
 *
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class ConstructBinaryTreefromPreorderandPostorderTraversal_889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        System.out.println("preStart = " + preStart);
        System.out.println("preEnd   = " + preEnd);

        System.out.println("postStart = " + postStart);
        System.out.println("postEnd   = " + postEnd);
        if (preStart > preEnd || preStart > pre.length - 1 || postStart > postEnd || postStart > post.length - 1) {
            return null;
        }

        TreeNode root = new TreeNode(post[postEnd]);

        if (postStart == postEnd)
            return root;

        int rightRootVal = post[postEnd - 1];

        int index = preStart + 1;
        while (pre[index] != rightRootVal) {
            index++;
        }
        int rightLen = preEnd - index + 1;
        int leftLen = index - preStart - 1;

        System.out.println("leftlen = "  + leftLen);
        System.out.println("rightLen = " + rightLen);
        root.left = helper(pre, preStart+1, index - 1, post,  postStart, postStart + leftLen - 1);
        root.right = helper(pre, index, preEnd, post, postEnd - 1 - rightLen + 1, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};

        ConstructBinaryTreefromPreorderandPostorderTraversal_889 myObj = new ConstructBinaryTreefromPreorderandPostorderTraversal_889();
        TreeNode root = myObj.constructFromPrePost(pre, post);
    }

}
