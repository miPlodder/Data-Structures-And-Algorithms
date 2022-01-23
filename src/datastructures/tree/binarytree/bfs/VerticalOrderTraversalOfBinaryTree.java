package datastructures.tree.binarytree.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalOrderTraversalOfBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static TreeNode constructBTFromLevelOrderTraversal(Integer[] data) {
        TreeNode root = null;
        Queue<TreeNode> que = new LinkedList<>();

        for (Integer item : data) {
            TreeNode node = new TreeNode(item);
            if (root == null) {
                root = node;
            } else if (que.peek().left == null) {
                que.peek().left = node;
            } else {
                que.peek().right = node;
                que.remove();
            }
            que.add(node);
        }

        return root;
    }

    static void print(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode node = que.remove();
            System.out.print(node.data + " , ");
            if (node.left != null) que.add(node.left);
            if (node.right != null) que.add(node.right);
        }
    }

    public static void main(String[] args) {
        Integer[] levelOrder = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = constructBTFromLevelOrderTraversal(levelOrder);
        print(root);
        System.out.println();
        System.out.println("Vertical Order Traversal Of Binary Tree (Method 1) - " + verticalOrderTraversalOfBinaryTree_method1(root));
        System.out.println("VerticalOrder Traversal Of Binary Tree (Method 2) - " + verticalOrderTraversalOfBinaryTree_method2(root));
    }

    static class Pair {
        int x;
        TreeNode node;

        Pair(TreeNode node, int x) {
            this.node = node;
            this.x = x;
        }
    }

    // method - 1 > Using Axis logic + HashMap
    private static List<List<Integer>> verticalOrderTraversalOfBinaryTree_method1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (result == null) return result;

        int[] minMax = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        Map<Integer, List<Integer>> temp = new HashMap<>();
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 0));
        while (!que.isEmpty()) {
            Pair pair = que.remove();
            minMax[0] = Math.min(minMax[0], pair.x);
            minMax[1] = Math.max(minMax[1], pair.x);
            /*if (temp.get(pair.x) == null) {
                temp.put(pair.x, new ArrayList<>());
            }*/
            temp.putIfAbsent(pair.x, new ArrayList<>());//can be used instead of above if-else check
            temp.get(pair.x).add(pair.node.data);

            if (pair.node.left != null) que.add(new Pair(pair.node.left, pair.x - 1));
            if (pair.node.right != null) que.add(new Pair(pair.node.right, pair.x + 1));
        }
        for (int i = minMax[0]; i <= minMax[1]; i++) {
            result.add(i + Math.abs(minMax[0]), temp.get(i));
        }
        return result;
    }

    // method - 2 > Using Axis logic without HashMap by calculating width of the Binary Tree
    private static List<List<Integer>> verticalOrderTraversalOfBinaryTree_method2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return null;
        int[] minMax = minMax(root);
        for (int i = 0; i < Math.abs(minMax[0]) + minMax[1] + 1; i++) result.add(new ArrayList<>());

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, Math.abs(minMax[0])));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            result.get(pair.x).add(pair.node.data);

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
