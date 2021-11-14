package datastructures.linkedlist.type1;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = addAtFirst(null, 5);
        head = addAtFirst(head, 4);
        head = addAtFirst(head, 3);
        head = addAtFirst(head, 2);
        head = addAtFirst(head, 1);
        head = addAtFirst(head, 6);
        print(head);
        head = reverseList(head);
        print(head);
    }

    private static ListNode addAtFirst(ListNode head, int data) {
        ListNode listNode = new ListNode();
        listNode.data = data;
        if (head != null) {
            listNode.next = head;
        }
        return listNode;
    }

    private static void print(ListNode node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.data + ",");
            node = node.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static class ListNode {
        private int data;
        private ListNode next;
    }


}
