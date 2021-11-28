package datastructures.linkedlist.type3;

//https://leetcode.com/problems/copy-list-with-random-pointer/
public class CloneLinkedList {
    //8:02pm
    public static void main(String[] args) {
        Node head = addAtHead(null, 6);
        head = addAtHead(head, 5);
        head = addAtHead(head, 4);
        head = addAtHead(head, 3);
        head = addAtHead(head, 2);
        head = addAtHead(head, 1);
        print(head);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }

    private static void print(Node head) {
        Node iterator = head;
        while (iterator != null) {
            System.out.print(iterator.val + " , ");
            iterator = iterator.next;
        }
        System.out.println();
    }

    private static Node addAtHead(Node head, int val) {
        Node node = new Node(val);
        node.next = head;
        node.random = head;
        return node;
    }

    private Node cloneLinkedList(Node originalHead) {
//         edge case
        if (originalHead == null) {
            return null;
        }
// append clone nodes
        Node iterator = originalHead;
        while (iterator != null) {
            Node node = new Node(iterator.val);
            node.next = iterator.next;
            node.random = iterator.random;
            iterator.next = node;
            iterator = iterator.next.next;
        }
//correct random of the clone nodes
        iterator = originalHead.next;
        while (iterator != null) {
            iterator.random = iterator.random == null ? null : iterator.random.next;//npe
            iterator = iterator.next == null ? null : iterator.next.next;//npe
        }
// decouple orginal and clone nodes
        Node cloneHead = originalHead.next;
        iterator = originalHead;
        while (iterator != null) {
            Node clone = iterator.next;
            iterator.next = iterator.next.next;
            clone.next = clone.next == null ? null : clone.next.next;
            iterator = iterator.next;
        }
        return cloneHead;
    }


}
