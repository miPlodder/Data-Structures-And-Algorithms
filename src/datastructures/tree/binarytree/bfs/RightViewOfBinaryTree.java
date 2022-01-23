package datastructures.tree.binarytree.bfs;

import datastructures.tree.binarytree.BinaryTreeUtility;
import datastructures.tree.binarytree.BinaryTreeUtility.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

//https://leetcode.com/problems/binary-tree-right-side-view/
public class RightViewOfBinaryTree {

    public static void main(String[] args) {
        int[] levelOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = BinaryTreeUtility.constructBinaryTreeFromLevelOrderTraversal(levelOrder);
        BinaryTreeUtility.printBFS(root);
        System.out.println("Right View Of Binary Tree -> " + rightViewOfBinaryTree(root));
    }

    private static List<Integer> rightViewOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            result.add(queue.peek().data);

            while (size-- > 0) {
                TreeNode node = queue.remove();
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);

            }
        }
        return result;
    }
}
