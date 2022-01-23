package datastructures.tree.binarytree.bfs;

import static datastructures.tree.binarytree.BinaryTreeUtility.TreeNode;

import datastructures.tree.binarytree.BinaryTreeUtility;

import java.util.Queue;
import java.util.LinkedList;

public class WidthOfBinaryTree {


    public static void main(String[] args) {
        int[] levelOrderTraversal = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = BinaryTreeUtility.constructBinaryTreeFromLevelOrderTraversal(levelOrderTraversal);
        BinaryTreeUtility.printBFS(root);
        System.out.println("Width Of Binary Tree -> " + width(root));
    }

    private static class Pair {
        int x;
        TreeNode node;

        Pair(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    public static int width(TreeNode root) {
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

        return Math.abs(minMax[0]) + minMax[1] + 1;
    }
}
