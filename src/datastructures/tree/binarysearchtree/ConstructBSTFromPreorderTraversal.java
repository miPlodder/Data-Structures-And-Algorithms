package datastructures.tree.binarysearchtree;

import java.util.*;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class ConstructBSTFromPreorderTraversal {


    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode constructBSTFromPreOrderTraversal(int[] preorder) {
        return constructBSTFromPreOrderTraversalHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static int index = 0;

    private static TreeNode constructBSTFromPreOrderTraversalHelper(int[] inorder, int min, int max) {
        if (index == inorder.length || inorder[index] < min || inorder[index] > max) return null;

        TreeNode node = new TreeNode(inorder[index++]);
        node.left = constructBSTFromPreOrderTraversalHelper(inorder, min, node.val);
        node.right = constructBSTFromPreOrderTraversalHelper(inorder, node.val, max);
        return node;
    }


    private static void breadthFirstSearch(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.val + " , ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        int[] preorder = {30, 20, 10, 15, 25, 23, 39, 35, 42};
        TreeNode root = constructBSTFromPreOrderTraversal(preorder);
        breadthFirstSearch(root);
    }

}
