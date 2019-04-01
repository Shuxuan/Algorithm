package main.company.vmw;

import main.study.algorithm.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    LinkedList<Integer> list;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        list = new LinkedList<>();
        inorder(root);

    }

    private void inorder(TreeNode root) {
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
    }

    /** @return the next smallest number */
    public int next() {
        int val = list.getFirst();
        list.removeFirst();
        return val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (list.size() > 0) {
            return true;
        }

        return false;
    }
}
