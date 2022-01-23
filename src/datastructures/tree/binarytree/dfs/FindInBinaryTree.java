package datastructures.tree.binarytree.dfs;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class FindInBinaryTree {

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

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private static Node construct(Integer[] preOrderArray) {
        Stack<Pair> stack = new Stack<>();
        int idx = 0;
        Node root = new Node(preOrderArray[idx++]);
        stack.add(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair peek = stack.peek();
            if (peek.state == 1) {
                if (preOrderArray[idx] != null) {
                    peek.node.left = new Node(preOrderArray[idx]);
                    stack.add(new Pair(peek.node.left, 1));
                }
                idx++;
                peek.state++;
            } else if (peek.state == 2) {
                if (preOrderArray[idx] != null) {
                    peek.node.right = new Node(preOrderArray[idx]);
                    stack.add(new Pair(peek.node.right, 1));
                }
                peek.state++;
                idx++;
            } else {
                stack.pop();
            }
        }
        return root;
    }

    private static void breadthFirstSearch(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node top = queue.remove();
            System.out.print(top.data + " , ");
            if (top.left != null) queue.add(top.left);
            if (top.right != null) queue.add(top.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] preOrderArray = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 80, null, null, 87, null, null};
        Node root = construct(preOrderArray);
        breadthFirstSearch(root);
        System.out.println("Found -> " + find(root, 87));
        System.out.println("Path Found -> " + findNodeAndReturnPath(root, 87));
        System.out.println("Not Found -> " + find(root, 187));
        System.out.println("Path Not Found -> " + findNodeAndReturnPath(root, 187));
    }


    private static boolean find(Node node, int target) {
        if (node == null) return false;

        if (node.data == target) return true;
        if (find(node.left, target)) return true;
        if (find(node.right, target)) return true;

        return false;
    }

    private static ArrayList<Integer> findNodeAndReturnPath(Node node, int target) {
        if (node == null) return null;

        if (node.data == target) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(node.data);
            return al;
        }
        ArrayList<Integer> leftAl = findNodeAndReturnPath(node.left, target);
        if (leftAl != null) {
            leftAl.add(node.data);
            return leftAl;
        }
        ArrayList<Integer> rightAl = findNodeAndReturnPath(node.right, target);
        if (rightAl != null) {
            rightAl.add(node.data);
            return rightAl;
        }
        return null;
    }
}
