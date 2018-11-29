package main.study.algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/description/
 *
 *
 */
public class MaximumWidthofBinaryTree_662 {

    /**
     * 这道题的意思是：给一个有着满二叉树结构，但是有部分节点是null的树，然后求出这个树最宽的那一层的宽度。
     * 这个宽度就是每一层的最右和最左的距离的最大值。看起来不是很难做，有一个很暴力的方法就是把一层的节点都保存下来不管空不空，然后一个一个去遍历找到最左和最右的下标。
     *
     * 这里要用到树的一个特点。每个节点的下标如果是i，那么它的左节点是 2 * i, 右节点是 2 * i + 1。
     * 然后，我们只要将每个节点和它的位置保存下来，做层序遍历。
     * 开始一层的遍历时，定义一个最左和一个最右的变量，
     * 将这层第一个节点的位置保存下来，然后每遍历这层的一个节点，将该节点的位置更新为最右变量的值。
     * 这一层遍历完后就可以得到这层的宽度，然后跟当前最大的宽度比较，然后更新最大值即可。
     *
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        int width = 0;
        if (root == null) {
            return width;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> posQueue = new LinkedList<>();
        queue.add(root);
        posQueue.add(1);

        while (!queue.isEmpty()) {
            int size = queue.size();
            width = Math.max(width, (((LinkedList<Integer>) posQueue).getLast() - ((LinkedList<Integer>) posQueue).getFirst() + 1));

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                int pos = posQueue.remove();
                if (cur.left != null) {
                    queue.add(cur.left);
                    posQueue.add(pos * 2);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                    posQueue.add(pos * 2 + 1);
                }

            }

        }
        return width;
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n7;

        MaximumWidthofBinaryTree_662 myObj = new MaximumWidthofBinaryTree_662();
        int width = myObj.widthOfBinaryTree(n1);

        System.out.println(width);




    }

}
