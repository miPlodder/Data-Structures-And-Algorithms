package datastructures.linkedlist.type2;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
//bloomberg, afry, amazon, ms, mckinsy
public class IntersectionOfTwoLinkedList {

    public static void main(String[] args) {
        ListNode headA = addAtStart(null, 5);
        headA = addAtStart(headA, 4);
        ListNode intersection = headA = addAtStart(headA, 3);
        headA = addAtStart(headA, 2);
        headA = addAtStart(headA, 1);
        print(headA);

        ListNode headB = addAtStart(null, 10);
        headB = addAtStart(headB, 11);
        headB = addAtStart(headB, 12);
//        addAtEnd(headB, intersection);
        headB = addAtStart(headB, 13);
        print(headB);
        System.out.println(getIntersectionNode(headA, headB));
        System.out.println(getIntersectionNode(null, null));
    }

    private static ListNode addAtStart(ListNode head, int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        return node;
    }

    private static void addAtEnd(ListNode head, ListNode node) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    private static void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.data + ", ");
            node = node.next;
        }
        System.out.println();
    }

    private static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;

        while (tempA != tempB) {
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }
        return tempA;
    }
}
