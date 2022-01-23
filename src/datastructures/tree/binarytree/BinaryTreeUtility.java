package datastructures.tree.binarytree;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeUtility {

    public static class TreeNode {
        public int data;
        public TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * Returns the Root of the BinaryTree from levelOrder traversal
     */
    public static TreeNode constructBinaryTreeFromLevelOrderTraversal(int[] levelOrder) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        for (int item : levelOrder) {
            TreeNode node = new TreeNode(item);
            if (root == null) root = node;
            else if (queue.peek().left == null) queue.peek().left = node;
            else {
                queue.peek().right = node;
                queue.remove();
            }
            queue.add(node);
        }

        return root;
    }

    /**
     * Prints the Binary Tree in levelOrder fashion
     */
    public static void printBFS(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        System.out.print("Level Order Traversal of Binary Tree - ");
        while (!que.isEmpty()) {
            TreeNode node = que.remove();
            System.out.print(node.data + " , ");
            if (node.left != null) que.add(node.left);
            if (node.right != null) que.add(node.right);
        }
        System.out.println();
    }

}
