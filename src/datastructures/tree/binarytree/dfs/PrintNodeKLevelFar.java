package datastructures.tree.binarytree.dfs;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class PrintNodeKLevelFar {

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

    private static Node constructBinaryTree(Integer[] preOrderArray) {
        Stack<Pair> stack = new Stack<>();
        int idx = 0;
        Pair rootPair = new Pair(1, new Node(preOrderArray[idx++]));
        stack.add(rootPair);
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
        System.out.println(nodesKLevelFar(root, 75, 2));
    }

    private static List<Integer> nodesKLevelFar(Node node, int target, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Node> paths = targetNodeToRootPath(node, target);
        for (int i = 0; i < paths.size(); i++) {
            ArrayList<Integer> al = printKLevelDown(paths.get(i), k - i, i == 0 ? null : paths.get(i - 1));
            if (al != null)
                result.addAll(al);
        }
        return result;
    }

    private static ArrayList<Integer> printKLevelDown(Node node, int k, Node blocker) {
        if (node == null || k < 0 || node == blocker) {
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (k == 0) {
            result.add(node.data);
        }
        ArrayList<Integer> leftAl = printKLevelDown(node.left, k - 1, blocker);
        if (leftAl != null)
            result.addAll(leftAl);
        ArrayList<Integer> rightAl = printKLevelDown(node.right, k - 1, blocker);
        if (rightAl != null)
            result.addAll(rightAl);
        return result;
    }

    private static ArrayList<Node> targetNodeToRootPath(Node node, int target) {
        if (node == null) return null;
        if (node.data == target) {
            ArrayList<Node> al = new ArrayList<>();
            al.add(node);
            return al;
        }
        ArrayList<Node> leftAl = targetNodeToRootPath(node.left, target);
        if (leftAl != null) {
            leftAl.add(node);
            return leftAl;
        }
        ArrayList<Node> rightAl = targetNodeToRootPath(node.right, target);
        if (rightAl != null) {
            rightAl.add(node);
            return rightAl;
        }
        return null;
    }

}
