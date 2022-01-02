package datastructures.tree.binarysearchtree;

import java.util.*;

public class ConstructBSTFromPostOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static int index = 0;

    private static TreeNode constructBSTFromPostOrderTraversal(int[] preorder) {
        index = preorder.length - 1;
        return constructBSTFromPostOrderTraversalHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode constructBSTFromPostOrderTraversalHelper(int[] inorder, int min, int max) {
        if (index == -1 || inorder[index] < min || inorder[index] > max) return null;

        TreeNode node = new TreeNode(inorder[index--]);
        node.right = constructBSTFromPostOrderTraversalHelper(inorder, node.val, max);
        node.left = constructBSTFromPostOrderTraversalHelper(inorder, min, node.val);
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
        int[] postOrder = {15, 10, 23, 25, 20, 35, 42, 39, 30};
        TreeNode node = constructBSTFromPostOrderTraversal(postOrder);
        breadthFirstSearch(node);
    }
}
