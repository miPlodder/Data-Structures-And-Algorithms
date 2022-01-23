package datastructures.tree.binarytree.dfs;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PrintKLevelDown {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Pair {
        int status;
        Node node;

        Pair(int status, Node node) {
            this.status = status;
            this.node = node;
        }
    }

    private static Node construct(Integer[] preOrderArray) {
        Stack<Pair> stack = new Stack<>();
        int idx = 0;
        Node root = new Node(preOrderArray[idx++]);
        stack.add(new Pair(1, root));
        while (!stack.isEmpty()) {
            Pair pair = stack.peek();
            if (pair.status == 1) {
                if (preOrderArray[idx] != null) {
                    pair.node.left = new Node(preOrderArray[idx]);
                    stack.add(new Pair(1, pair.node.left));
                }
                pair.status++;
                idx++;
            } else if (pair.status == 2) {
                if (preOrderArray[idx] != null) {
                    pair.node.right = new Node(preOrderArray[idx]);
                    stack.add(new Pair(1, pair.node.right));
                }
                pair.status++;
                idx++;
            } else {
                stack.pop();
            }
        }
        return root;
    }

    private static void breathFirstSearch(Node root) {
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
        Node root = construct(preOrderArray);
        breathFirstSearch(root);
        printKLevelDown(root, 3);
    }

    private static void printKLevelDown(Node node, int k) {
        if (node == null || k < 0) return;
        if (k == 0) System.out.print(node.data + " , ");
        printKLevelDown(node.left, k - 1);
        printKLevelDown(node.right, k - 1);
    }
}
