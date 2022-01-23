package datastructures.tree.binarytree.bfs;

import static datastructures.tree.binarytree.BinaryTreeUtility.TreeNode;

import datastructures.tree.binarytree.BinaryTreeUtility;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfBinaryTree {

    public static void main(String[] args) {
        int[] levelOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = BinaryTreeUtility.constructBinaryTreeFromLevelOrderTraversal(levelOrder);
        BinaryTreeUtility.printBFS(root);
        System.out.println("Top View Of Binary Tree -> " + topViewOfBinaryTree(root));
    }

    static class Pair {
        int x;
        TreeNode node;

        Pair(int x, TreeNode node) {
            this.x = x;
            this.node = node;
        }
    }

    private static List<Integer> topViewOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int[] minMax = minMax(root);
        for (int i = 0; i < Math.abs(minMax[0]) + minMax[1] + 1; i++) result.add(null);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(Math.abs(minMax[0]), root));
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            if (result.get(pair.x) == null) result.set(pair.x, pair.node.data);

            if (pair.node.left != null) queue.add(new Pair(pair.x - 1, pair.node.left));
            if (pair.node.right != null) queue.add(new Pair(pair.x + 1, pair.node.right));
        }

        return result;
    }

    private static int[] minMax(TreeNode root) {
        int[] minMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();

            minMax[0] = Math.min(pair.x, minMax[0]);
            minMax[1] = Math.max(pair.x, minMax[1]);

            if (pair.node.left != null) queue.add(new Pair(pair.x - 1, pair.node.left));
            if (pair.node.right != null) queue.add(new Pair(pair.x + 1, pair.node.right));

        }
        return minMax;
    }


}
