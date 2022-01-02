package datastructures.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeUsingPreAndInOrder {

    public static void main(String[] args) {
        int[] inorder = {7, 3, 8, 1, 9, 4, 10, 0, 11, 5, 2, 6};
        int[] preorder = {0, 1, 3, 7, 8, 4, 9, 10, 2, 5, 11, 6};
        Node root = construct(inorder, preorder);
        breadthFirstSearch(root);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void breadthFirstSearch(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.remove();
            System.out.print(n.data + " , ");
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
        System.out.println();
    }

    private static Node construct(int[] inorder, int[] preorder) {
        return constructHelper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private static Node constructHelper(int[] inorder, int ios, int ioe, int[] preorder, int pos, int poe) {
        if (ios > ioe) return null;

        Node node = new Node(preorder[pos]);
        int idx = ios;
        while (preorder[pos] != inorder[idx]) idx++;
        int size = idx - ios;

        node.left = constructHelper(inorder, ios, idx - 1, preorder, pos + 1, pos + size);
        node.right = constructHelper(inorder, idx + 1, ioe, preorder, pos + size + 1, poe);

        return node;
    }
}
