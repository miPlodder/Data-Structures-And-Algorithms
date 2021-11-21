package datastructures.linkedlist.type1;

import java.util.List;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeInLinkedList {

    public static void main(String[] args) {
        ListNode head = addAtFirst(null, 5);
        ListNode input;
        head = addAtFirst(head, 4);
        head = addAtFirst(head, 3);
        input = head;
        head = addAtFirst(head, 2);
        head = addAtFirst(head, 1);
        print(head);
        deleteNode(input);
        print(head);
    }

    static class ListNode {
        int data;
        ListNode next;
    }

    public static ListNode addAtFirst(ListNode previousHead, int data) {
        ListNode node = new ListNode();
        node.data = data;
        node.next = previousHead;
        return node;
    }

    public static void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void deleteNode(ListNode node) {
        System.out.println(node.data);
        node.data = node.next.data;
        node.next = node.next.next;
    }


}
