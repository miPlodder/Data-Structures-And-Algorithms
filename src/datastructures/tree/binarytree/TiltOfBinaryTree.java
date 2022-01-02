package datastructures.tree.binarytree;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-tilt/
public class TiltOfBinaryTree {

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

    private static int tilt = 0;

    public static void main(String[] args) {
        Integer[] preOrderArray = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 80, null, null, 87, null, null};
        Node root = constructBinaryTree(preOrderArray);
        breadthFirstSearch(root);
        findTilt(root);
        System.out.println("Tilt Of Binary Tree -> " + tilt);
        System.out.println("Tilt Of Binary Tree -> " + findTilt2(root)[1]);
    }

    private static int findTilt(Node node) {
        if (node == null) return 0;
        int leftSum = findTilt(node.left);
        int rightSum = findTilt(node.right);

        tilt = Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.data;
    }

    // 0 -> sum, 1 -> tilt
    private static int[] findTilt2(Node node) {
        if (node == null) return new int[]{0, 0};
        int[] leftRes = findTilt2(node.left);
        int[] rightRes = findTilt2(node.right);

        int tilt = Math.abs(leftRes[0] - rightRes[0]);
        return new int[]{leftRes[0] + rightRes[0] + node.data, tilt};
    }
}
