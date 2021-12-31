package datastructures.tree.binarytree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeTraversal {

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


    private static Node constructBinaryTree(Integer[] arr) {
        Stack<Pair> st = new Stack<>();
        Node node = new Node(arr[0]);

        Pair rootPair = new Pair(node, 1);
        st.add(rootPair);
        int idx = 1;
        while (!st.isEmpty()) {
            Pair pair = st.peek();
            if (pair.state == 1) {
                if (arr[idx] != null) {
                    pair.node.left = new Node(arr[idx]);
                    st.add(new Pair(pair.node.left, 1));
                }
                pair.state++;
                idx++;
            } else if (pair.state == 2) {
                if (arr[idx] != null) {
                    pair.node.right = new Node(arr[idx]);
                    st.add(new Pair(pair.node.right, 1));
                }
                pair.state++;
                idx++;
            } else {
                st.pop();
            }
        }
        return rootPair.node;
    }

    /**
     * Legacy Approach for preparing Tree
     */
    private static Node prepareBT() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);
        return root;
    }

    public static void main(String[] args) {
//        Node root = prepareBT();
        Integer[] preOrder = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, null};
        Node root = constructBinaryTree(preOrder);
        System.out.println("Pre-Order Traversal");
        preOrderTraversal_recursive(root);
        System.out.println();
        preOrderTraversal_iterative(root);
        System.out.println();
        System.out.println("In-Order Traversal");
        inOrderTraversal_recursive(root);
        System.out.println();
        inOrderTraversal_iterative(root);
        System.out.println();
        System.out.print("Post-Order Traversal");
        System.out.println();
        postOrderTraversal_recursive(root);
        System.out.println();
        postOrderTraversal_iterative_using2Stacks(root);
        System.out.println();
        System.out.print("Level-Order Traversal");
        System.out.println();
        levelOrderTraversal(root);
        System.out.println();
        printPreOrderInOrderPostOrder(root);
    }

    private static void printPreOrderInOrderPostOrder(Node node) {
        String preOrder = "";
        String inOrder = "";
        String postOrder = "";
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(node, 1));

        while (!stack.isEmpty()) {
            Pair peek = stack.peek();
            if (peek.state == 1) {//pre,state++,left
                preOrder += peek.node.data + " , ";
                peek.state++;
                if (peek.node.left != null) {
                    stack.add(new Pair(peek.node.left, 1));
                }
            } else if (peek.state == 2) {//in,state++,right
                inOrder += peek.node.data + " , ";
                peek.state++;
                if (peek.node.right != null) {
                    stack.add(new Pair(peek.node.right, 1));
                }
            } else {//post,pop
                postOrder += peek.node.data + " , ";
                stack.pop();
            }
        }
        System.out.println("Pre-order -> " + preOrder);
        System.out.println("In-order -> " + inOrder);
        System.out.println("Post-order -> " + postOrder);
    }

    private static void preOrderTraversal_recursive(Node node) {
        if (node == null) return;

        System.out.print(node.data + " , ");
        preOrderTraversal_recursive(node.left);
        preOrderTraversal_recursive(node.right);
    }

    private static void preOrderTraversal_iterative(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            System.out.print(top.data + " , ");
            if (top.right != null)
                stack.add(top.right);
            if (top.left != null)
                stack.add(top.left);
        }
    }

    private static void inOrderTraversal_recursive(Node node) {
        if (node == null) return;

        inOrderTraversal_recursive(node.left);
        System.out.print(node.data + " , ");
        inOrderTraversal_recursive(node.right);
    }

    private static void inOrderTraversal_iterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (true) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                System.out.print(node.data + " , ");
                node = node.right;
            }
        }

    }

    private static void postOrderTraversal_recursive(Node node) {
        if (node == null) return;

        postOrderTraversal_recursive(node.left);
        postOrderTraversal_recursive(node.right);
        System.out.print(node.data + " , ");
    }

    private static void postOrderTraversal_iterative_using2Stacks(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(node);
        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        while (!stack2.isEmpty()) System.out.print(stack2.pop().data + " , ");
    }

    private static void postOrderTraversal_iterative_using1Stacks(Node node) {

    }

    private static void levelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node top = queue.remove();
            System.out.print(top.data + " , ");
            if (top.left != null)
                queue.add(top.left);
            if (top.right != null)
                queue.add(top.right);
        }
    }

}
