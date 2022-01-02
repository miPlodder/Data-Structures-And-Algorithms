package datastructures.tree.binarytree;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class RemoveLeaves {
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
        removeLeaves(root);
        printBreadthFirstSearch(root);
    }

    private static Node removeLeaves(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }
}
