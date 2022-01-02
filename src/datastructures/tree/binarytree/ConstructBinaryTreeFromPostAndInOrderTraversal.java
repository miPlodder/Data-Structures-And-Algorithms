package datastructures.tree.binarytree;

import java.util.Queue;
import java.util.LinkedList;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructBinaryTreeFromPostAndInOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode construct(int[] inOrder, int[] postOrder) {
        return constructHelper(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
    }

    private static TreeNode constructHelper(int[] inOrder, int ios, int ioe, int[] postOrder, int pos, int poe) {
        if (ios > ioe) return null;

        TreeNode node = new TreeNode(postOrder[poe]);
        int idx = ios;
        while (inOrder[idx] != postOrder[poe]) idx++;
        int len = idx - ios;

        node.left = constructHelper(inOrder, ios, idx - 1, postOrder, pos, pos + len - 1);
        node.right = constructHelper(inOrder, idx + 1, ioe, postOrder, pos + len, poe - 1);

        return node;
    }

    private static void breadthFirstSearch(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            TreeNode n = queue.remove();
            System.out.print(n.val + " , ");

            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    public static void main(String[] args) {
        int[] inOrder = {7, 3, 8, 1, 9, 4, 10, 0, 11, 5, 2, 6};
        int[] postOrder = {7, 8, 3, 9, 10, 4, 1, 11, 5, 6, 2, 0};

        TreeNode root = construct(inOrder, postOrder);
        breadthFirstSearch(root);
    }
}
