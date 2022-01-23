package datastructures.tree.binarytree.dfs;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        int state;
        Node node;

        Pair(int state, Node node) {
            this.state = state;
            this.node = node;
        }
    }

    private static Node construct(Integer[] preOrderArray) {
        Stack<Pair> stack = new Stack<>();
        int idx = 0;
        Pair rootPair = new Pair(1, new Node(preOrderArray[idx++]));
        stack.add(rootPair);

        while (!stack.isEmpty()) {
            Pair pair = stack.peek();
            if (pair.state == 1) {
                if (preOrderArray[idx] != null) {
                    pair.node.left = new Node(preOrderArray[idx]);
                    stack.add(new Pair(1, pair.node.left));
                }
                idx++;
                pair.state++;
            } else if (pair.state == 2) {
                if (preOrderArray[idx] != null) {
                    pair.node.right = new Node(preOrderArray[idx]);
                    stack.add(new Pair(1, pair.node.right));
                }
                idx++;
                pair.state++;
            } else {
                stack.pop();
            }
        }
        return rootPair.node;
    }

    private static void printBreadthFirstSearch(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.data + " , ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] preOrderArray = {1, 2, 3, 4, null, null, null, 5, null, null, 6, null, 7, 8, null, null, 9, null, null};
        Node root = construct(preOrderArray);
        printBreadthFirstSearch(root);
        System.out.println("Height Of the Tree -> " + height(root));
        System.out.println("Diameter using In-Efficient Solution -> " + diameter_inEfficient(root));
        System.out.println("Diameter using Efficient Solution -> " + diameter_efficient(root).diameter);
    }

    private static int diameter_inEfficient(Node node) {
        if (node == null) return 0;

        int maxLeftDiameter = diameter_inEfficient(node.left);
        int maxRightDiameter = diameter_inEfficient(node.right);
        int includingNode = height(node.left) + height(node.right) + 2;
        return Math.max(maxLeftDiameter, Math.max(maxRightDiameter, includingNode));
    }

    static class DiaPair {
        int height;
        int diameter;
    }

    private static DiaPair diameter_efficient(Node node) {
        DiaPair diaPair = new DiaPair();

        if (node == null) {
            diaPair.diameter = 0;
            diaPair.height = -1;
            return diaPair;
        }

        DiaPair leftDiaPair = diameter_efficient(node.left);
        DiaPair rightDiaPair = diameter_efficient(node.right);

        diaPair.height = Math.max(leftDiaPair.height, rightDiaPair.height) + 1;
        diaPair.diameter = Math.max(leftDiaPair.diameter, Math.max(rightDiaPair.diameter, leftDiaPair.height + rightDiaPair.height + 2));

        return diaPair;
    }

    private static int height(Node node) {
        if (node == null) return -1;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}