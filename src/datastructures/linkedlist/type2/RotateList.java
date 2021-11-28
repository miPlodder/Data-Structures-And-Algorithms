package datastructures.linkedlist.type2;

//https://leetcode.com/problems/rotate-list/description/
public class RotateList {

    public static void main(String[] args) {
        ListNode head = addAtHead(null, 6);
        head = addAtHead(head, 5);
        head = addAtHead(head, 4);
//        head = addAtHead(head, 3);
//        head = addAtHead(head, 2);
//        head = addAtHead(head, 1);
        print(head);
        head = rotateRight_proImpl(head, 3);
//        rotateRight_NaiveApproach(null, 0);
        System.out.print("Output => ");
        print(head);
    }

    static class ListNode {
        int val;
        ListNode next;
    }

    private static ListNode rotateRight_proImpl(ListNode head, int k) {
//        edge cases
        if (head == null || head.next == null || k == 0) {
            return head;
        }
//        compute the length of linkedList
//        finding the tail of linkedList
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }
        curr.next = head;
        k = k % len;
        k = len - k;
        while (k-- > 0) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }

    private static ListNode rotateRight_noobImpl(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode temp = head, tail = head;
        while (temp != null) {
            len++;
            if (temp.next == null) {
                tail = temp;
            }
            temp = temp.next;
        }
        if (k == 0 || k % len == 0) {
            return head;
        }
        int counter = 0;
        temp = head;
        while ((len - (k % len) - 1) != counter) {
            counter++;
            temp = temp.next;
        }
        ListNode node1 = head, node2 = temp.next;
        temp.next = null;
        head = node2;
        tail.next = node1;
        return head;
    }

    private static ListNode addAtHead(ListNode head, int val) {
        ListNode node = new ListNode();
        node.val = val;
        node.next = head;
        return node;
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
        System.out.println();
    }

}
