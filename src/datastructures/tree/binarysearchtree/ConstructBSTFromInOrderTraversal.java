package datastructures.tree.binarysearchtree;

import java.util.Queue;
import java.util.LinkedList;

public class ConstructBSTFromInOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode constructBSTFromInOrderTraversal(int[] inorder) {
        return constructBSTFromInOrderTraversalHelper(inorder, 0, inorder.length - 1);
    }

    private static TreeNode constructBSTFromInOrderTraversalHelper(int[] inorder, int startIndex, int endIndex) {
        if (startIndex > endIndex) return null;


        int mid = (startIndex + endIndex) / 2;
        TreeNode node = new TreeNode(inorder[mid]);
        node.left = constructBSTFromInOrderTraversalHelper(inorder, startIndex, mid - 1);
        node.right = constructBSTFromInOrderTraversalHelper(inorder, mid + 1, endIndex);

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
        int[] inorder = {9, 12, 14, 17, 19, 23, 50, 54, 67, 72, 76};
        TreeNode root = constructBSTFromInOrderTraversal(inorder);
        breadthFirstSearch(root);
    }
}
