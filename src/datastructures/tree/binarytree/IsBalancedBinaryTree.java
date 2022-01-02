package datastructures.tree.binarytree;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

//https://leetcode.com/problems/balanced-binary-tree/
public class IsBalancedBinaryTree {

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
        System.out.println("Is Balanced Binary Tree -> " + isBalancedBT(root).isBalanced);
    }

    static class BalPair {
        int height;
        boolean isBalanced;
    }

    private static BalPair isBalancedBT(Node node) {
        BalPair balPair = new BalPair();
        if (node == null) {
            balPair.isBalanced = true;
            balPair.height = 0;
            return balPair;
        }

        BalPair leftBalPair = isBalancedBT(node.left);
        BalPair rightBalPair = isBalancedBT(node.right);

        balPair.height = Math.max(leftBalPair.height, rightBalPair.height) + 1;
        balPair.isBalanced = (Math.abs(leftBalPair.height - rightBalPair.height) <= 1 ? true : false) && leftBalPair.isBalanced && rightBalPair.isBalanced;
        return balPair;
    }

}
