package datastructures.tree.binarytree;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

//https://www.pepcoding.com/resources/online-java-foundation/binary-tree/binary-tree-path-to-leaves-from-root-official/ojquestion
public class TransformToLeftClonedTree {


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
//        transformToLeftClonedTree_preOrder(root);
        transformToLeftClonedTree_postOrder(root);
        printBreadthFirstSearch(root);
    }

    /**
     * Work is done at pre-order place
     */
    private static void transformToLeftClonedTree_preOrder(Node node) {
        if (node == null) return;

        Node clone = new Node(node.data);
        clone.left = node.left;
        node.left = clone;
        transformToLeftClonedTree_preOrder(node.left.left);
        transformToLeftClonedTree_preOrder(node.right);
    }

    /**
     * Work is done at post-order place
     */
    private static void transformToLeftClonedTree_postOrder(Node node) {
        if (node == null) return;

        transformToLeftClonedTree_postOrder(node.left);
        transformToLeftClonedTree_postOrder(node.right);
        Node clone = new Node(node.data);
        clone.left = node.left;
        node.left = clone;
    }
}
