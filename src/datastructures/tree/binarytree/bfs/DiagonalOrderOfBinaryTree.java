package datastructures.tree.binarytree.bfs;

import datastructures.tree.binarytree.BinaryTreeUtility;
import datastructures.tree.binarytree.BinaryTreeUtility.TreeNode;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

//https://www.techiedelight.com/print-diagonal-traversal-binary-tree/
public class DiagonalOrderOfBinaryTree {
    public static void main(String[] args) {
        int[] levelOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = BinaryTreeUtility.constructBinaryTreeFromLevelOrderTraversal(levelOrder);
        BinaryTreeUtility.printBFS(root);
        System.out.println("Right View Of Binary Tree -> " + diagonalOrderBinaryTree(root));
    }

    private static List<List<Integer>> diagonalOrderBinaryTree(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> al = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.remove();
                while (node != null) {
                    al.add(node.data);
                    if (node.left != null) queue.add(node.left);
                    node = node.right;
                }
            }
            result.add(al);
        }
        return result;
    }

}