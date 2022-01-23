package datastructures.tree.binarytree.bfs;

import datastructures.tree.binarytree.BinaryTreeUtility.TreeNode;
import datastructures.tree.binarytree.BinaryTreeUtility;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
public class LeftViewOfBinaryTree {

    public static void main(String[] args) {
        int[] levelOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = BinaryTreeUtility.constructBinaryTreeFromLevelOrderTraversal(levelOrder);
        BinaryTreeUtility.printBFS(root);
        System.out.println("Left View of Binary Tree -> " + leftViewOfBinaryTree(root));
    }

    private static List<Integer> leftViewOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            result.add(queue.peek().data);
            while (size-- > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }
}
