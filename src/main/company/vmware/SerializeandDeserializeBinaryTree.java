package main.company.vmware;

import main.study.algorithm.Tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 *
 */
public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //pre-order to triverse the tree and do the serialize in recurison
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);

        return sb.toString().substring(0, sb.toString().length()-1);

    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("NULL").append(",");
        } else {
            sb.append(root.val).append(",");
            buildString(root.left, sb);
            buildString(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        TreeNode rst = buildTree(nodes);

        return rst;

    }

    private TreeNode buildTree(Queue nodes) {

/*        if (nodes == null || nodes.isEmpty()) {
            return null;
        }*/

        String val = (String) nodes.remove();
        if (val.equals("NULL")){
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }


    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            System.out.println("NULL");
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        root.left = n2;
        root.right = n3;

        n3.left = n4;
        n3.right = n5;

        SerializeandDeserializeBinaryTree myObj = new SerializeandDeserializeBinaryTree();
        String rst = myObj.serialize(root);

        System.out.println(rst);
        rst = "NULL";
        root = myObj.deserialize(rst);
        myObj.preOrder(root);

     }
}
