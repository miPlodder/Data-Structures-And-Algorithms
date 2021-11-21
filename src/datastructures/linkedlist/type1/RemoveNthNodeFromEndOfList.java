package datastructures.linkedlist.type1;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = addAtEnd(null, 1);
        head = addAtEnd(head, 2);
        head = addAtEnd(head, 3);
        head = addAtEnd(head, 4);
        head = addAtEnd(head, 5);
        print(head);
        printAt(head, 0);
//        head = removeNthFromEnd_naiveApproach(head, 1);
        head = removeNthFromEnd(head, 1);
        print(head);
    }

    static class ListNode {
        int val;
        ListNode next;
    }

    private static void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
    }

    private static void printAt(ListNode head, int i) {
        int index = 0;
        ListNode temp = head;
        while (temp != null && index < i) {
            temp = temp.next;
            index++;
        }
        System.out.println(temp.val);
    }

    private static ListNode addAtEnd(ListNode head, int val) {
        ListNode tail = new ListNode();
        tail.val = val;
        if (head == null) {
            return tail;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = tail;
        return head;
    }

    private static ListNode removeNthFromEnd_naiveApproach(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (size == n) {
            return head.next;
        }
        int ptr = 0;
        temp = head;
        while (ptr < size - n - 1) {
            temp = temp.next;
            ptr++;
        }
        temp.next = temp.next.next;

        return head;
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        int seeding = 0;
        while (seeding < n) {
            fast = fast.next;
            seeding++;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
