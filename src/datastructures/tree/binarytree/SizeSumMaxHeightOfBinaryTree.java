package datastructures.tree.binarytree;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class SizeSumMaxHeightOfBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private static Node constructBinaryTree(Integer[] preOrderArray) {
        Pair rootPair = new Pair(new Node(preOrderArray[0]), 1);
        Stack<Pair> stack = new Stack<>();
        int idx = 1;
        stack.add(rootPair);
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if (top.state == 1) {
                if (preOrderArray[idx] != null) {
                    top.node.left = new Node(preOrderArray[idx]);
                    stack.add(new Pair(top.node.left, 1));
                }
                top.state++;
                idx++;
            } else if (top.state == 2) {
                if (preOrderArray[idx] != null) {
                    top.node.right = new Node(preOrderArray[idx]);
                    stack.add(new Pair(top.node.right, 1));
                }
                top.state++;
                idx++;
            } else {
                stack.pop();
            }
        }
        return rootPair.node;
    }

    private static void breadthFirstSearch(Node root) {
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
        Integer[] preOrderArray = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 80, null, null, 87, null, null};
        Node root = constructBinaryTree(preOrderArray);
        breadthFirstSearch(root);
        System.out.println("Size Of Binary Tree -> " + size(root));
        System.out.println("Sum Of Binary Tree -> " + sumOfAllNodes(root));
        System.out.println("Maximum Node Of Binary Tree -> " + maxOfAllNodes(root));
        System.out.println("Height Of Binary Tree -> " + heightOfBinaryTree(root));
    }

    private static int size(Node node) {
        if (node == null) return 0;

        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return leftSize + rightSize + 1;
    }

    private static int sumOfAllNodes(Node node) {
        if (node == null) return 0;

        int leftSum = sumOfAllNodes(node.left);
        int rightSum = sumOfAllNodes(node.right);
        return leftSum + rightSum + node.data;
    }

    private static int maxOfAllNodes(Node node) {
        if (node == null) return Integer.MIN_VALUE;

        int leftMax = maxOfAllNodes(node.left);
        int rightMax = maxOfAllNodes(node.right);
        return Math.max(node.data, Math.max(leftMax, rightMax));
    }

    private static int heightOfBinaryTree(Node node) {
        if (node == null) return 0; //0 for nodes, -1 for nodes

        int leftSubTreeHeight = heightOfBinaryTree(node.left);
        int rightSubTreeHeight = heightOfBinaryTree(node.right);

        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }
}
