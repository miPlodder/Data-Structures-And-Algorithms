package datastructures.tree.binarytree.bfs;

import static datastructures.tree.binarytree.BinaryTreeUtility.TreeNode;

import datastructures.tree.binarytree.BinaryTreeUtility;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

//https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class BottomViewOfBinaryTree {

    public static void main(String[] args) {
        int[] levelOrder = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = BinaryTreeUtility.constructBinaryTreeFromLevelOrderTraversal(levelOrder);
        BinaryTreeUtility.printBFS(root);
        System.out.println("Bottom View Of Binary Tree -> " + bottomViewOfBinaryTree(root));
    }

    static class Pair {
        int x;
        TreeNode node;

        Pair(TreeNode node, int x) {
            this.x = x;
            this.node = node;
        }
    }

    private static List<Integer> bottomViewOfBinaryTree(TreeNode root) {
        int[] minMax = minMax(root);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.abs(minMax[0]) + minMax[1] + 1; i++) result.add(null);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, Math.abs(minMax[0])));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            result.set(pair.x, pair.node.data);

            if (pair.node.left != null) queue.add(new Pair(pair.node.left, pair.x - 1));
            if (pair.node.right != null) queue.add(new Pair(pair.node.right, pair.x + 1));
        }

        return result;
    }

    private static int[] minMax(TreeNode root) {
        int[] minMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();

            minMax[0] = Math.min(minMax[0], pair.x);
            minMax[1] = Math.max(minMax[1], pair.x);

            if (pair.node.left != null) queue.add(new Pair(pair.node.left, pair.x - 1));
            if (pair.node.right != null) queue.add(new Pair(pair.node.right, pair.x + 1));
        }

        return minMax;
    }
}
