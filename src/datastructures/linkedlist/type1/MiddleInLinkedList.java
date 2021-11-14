package datastructures.linkedlist.type1;

//https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleInLinkedList {
    public static void main(String[] args) {
        ListNode head = addFirst(null, 5);
        head = addFirst(head, 4);
        head = addFirst(head, 3);
        head = addFirst(head, 2);
        head = addFirst(head, 1);
        head = addFirst(head, 0);
        display(head);
//        ListNode middleNode = findMiddleInLinkedList(head);
        ListNode middleNode = findMiddleInLinkedList2(head);
        display(middleNode);
    }

    private static ListNode addFirst(ListNode head, int data) {
        ListNode node = new ListNode();
        node.data = data;
        if (head != null) {
            node.next = head;
        }
        return node;
    }

    private static void display(ListNode node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.data + ",");
            node = node.next;
        }
        System.out.println();
    }

    // AKA tortoise method
    // Even LL has 2 centers, 2nd center node will be returned
    public static ListNode findMiddleInLinkedList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // AKA tortoise method
    // Even LL has 2 centers, 1st center node will be returned
    public static ListNode findMiddleInLinkedList2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static class ListNode {
        int data;
        ListNode next;
    }
}
