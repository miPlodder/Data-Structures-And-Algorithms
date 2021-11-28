package datastructures.linkedlist.type2;

import java.util.List;

//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = addAtStart(null, 1);
        head = addAtStart(head, 2);
        head = addAtStart(head, 3);
        head = addAtStart(head, 1);
        head = addAtStart(head, 2);
        head = addAtStart(head, 3);
        print(head);
        System.out.print(isPalindrome(head));
    }

    private static boolean isPalindrome(ListNode head) {
//        finding middle of the Linked List
        ListNode slow = findMiddleLinkedList(head);
//        reverse the second half of the linked list
        slow.next = reverseLinkedList(null, slow.next);
//        compare data of ith index with mid+ith index
        boolean isPalindrome = true;
        ListNode i = head, j = slow.next;
        while (j != null) {
            if (i.val != j.val) {
                isPalindrome = false;
                break;
            }
            i = i.next;
            j = j.next;
        }
//        reversing the 2nd half of the array
        slow.next = reverseLinkedList(null, slow.next);
        return isPalindrome;
    }

    private static ListNode findMiddleLinkedList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverseLinkedList(ListNode prev, ListNode curr) {
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode addAtStart(ListNode head, int data) {
        ListNode node = new ListNode();
        node.val = data;
        node.next = head;
        return node;
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static class ListNode {
        int val;
        ListNode next;
    }
}
