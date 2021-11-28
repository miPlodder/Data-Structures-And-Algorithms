package datastructures.linkedlist.type2;

import java.util.HashSet;

//https://leetcode.com/problems/linked-list-cycle/
public class DetectCycleInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        addLast(head, 2);
//        ListNode cycle = addLast(head, 3);
//        addLast(head, 4);
//        ListNode tail = addLast(head, 5);
//        tail will initiate a cycle always
//        tail.next = cycle;
        print(head);
        System.out.println(hasCycle(head));
    }

    private static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    private static boolean hasCycle_NaiveApproach(ListNode head) {
        ListNode temp = head;
        HashSet<ListNode> set = new HashSet<>();
        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static ListNode addLast(ListNode head, int data) {
        ListNode node = new ListNode(data);
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return node;
    }

    private static void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println();
    }

}
