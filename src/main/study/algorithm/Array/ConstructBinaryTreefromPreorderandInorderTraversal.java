package main.study.algorithm.Array;

import main.study.algorithm.Tree.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start_pre, int end_pre, int[] inorder, int start_in, int end_in) {

        System.out.println("start_pre : " + start_pre);
        System.out.println("end_pre   : " + end_pre);

        System.out.println("start_in : " + start_in);
        System.out.println("end_in   : " + end_in);
        if (start_pre > end_pre || start_pre >= preorder.length || start_in > end_in || start_in >= inorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start_pre]);
        if (start_pre == end_pre) {
            return root;
        }

        // find root in inorder
        int i = start_in;
        while(inorder[i] != preorder[start_pre]) {
            i++;
        }
        System.out.println("root in in order : " + i);
        // i is pointing root

        int left_count = i - start_in;

        root.left = helper(preorder, start_pre+1, start_pre + left_count, inorder, start_in, i-1);
        root.right = helper(preorder, start_pre + left_count + 1, end_pre, inorder, i+1, end_in);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,3};
        int[] in  = {1,2,3,4};

        ConstructBinaryTreefromPreorderandInorderTraversal myObj = new ConstructBinaryTreefromPreorderandInorderTraversal();
        myObj.buildTree(pre, in);
    }

}
