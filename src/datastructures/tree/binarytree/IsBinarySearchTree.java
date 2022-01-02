package datastructures.tree.binarytree;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

//https://leetcode.com/problems/validate-binary-search-tree/
public class IsBinarySearchTree {

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
        System.out.println("Is BST" + isBST(root).isBST);
    }

    /**
     * This approach to return a custom set of values
     */
    static class BSTPair {
        int min;
        int max;
        boolean isBST;
    }

    /**
     * Since, custom set of values is needed, hence created a custom class BSTPair
     */
    private static BSTPair isBST(Node node) {
        BSTPair pair = new BSTPair();
        if (node == null) {
            pair.isBST = true;
            pair.min = Integer.MAX_VALUE;
            pair.max = Integer.MIN_VALUE;
            return pair;
        }
        BSTPair leftPair = isBST(node.left);
        BSTPair rightPair = isBST(node.right);

        pair.isBST = leftPair.isBST && rightPair.isBST && (node.data > leftPair.max && node.data < rightPair.min);
        pair.min = Math.min(node.data, Math.min(leftPair.min, rightPair.min));
        pair.max = Math.max(node.data, Math.max(leftPair.max, rightPair.max));

        return pair;
    }

}
