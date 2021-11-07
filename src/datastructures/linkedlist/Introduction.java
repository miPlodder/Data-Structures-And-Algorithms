package datastructures.linkedlist;

//https://www.pepcoding.com/resources/online-java-foundation/linked-lists
public class Introduction {

    static class Node {
        int data;
        Node next;
    }

    static class LinkedList {

        // for traversing use head node
        static Node head = null;
        // for doing any op at the last, use the tail node
        static Node tail = null;
        static int size = 0;

        static int size() {
            return size;
        }

        static void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + ",");
                temp = temp.next;
            }
            System.out.println();
        }

        // ==============GET=========================================
        static int getFirst() {
            if (size == 0) {
                return -1;
            }
            return head.data;
        }

        static int getLast() {
            if (size == 0) {
                return -1;
            }
            return tail.data;
        }

        // traverse from head to tail
        static int getAt(int idx) {
            if (size <= 0 || idx >= size) {
                return -1;
            }
            Node temp = head;
            for (int i = 1; i <= idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }

        // ============ADD=============================================
        static void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if (size == 0) {
                head = tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }
            size++;
        }

        static void addLast(int val) {
            Node node = new Node();
            node.data = val;
            node.next = null;

            if (size == 0) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        static void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid Index");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;
                node.next = null;

                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }

        //===================REMOVE================================
        static void removeFirst() {
            if (size == 0) {
                return;
            } else if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }
            size--;
        }

        static void removeLast() {
            if (size == 0) {
                System.out.println("LinkedList empty");
            } else if (size == 1) {
                head = tail = null;
                size--;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                size--;
            }
        }

        static void removeAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid Index");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }

        //===============Reverse-LinkedList====================
        private static Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i <= idx - 1; i++) {
                temp = temp.next;
            }
            return temp;
        }

        // O(n^2) -> quadratic time complexity
        // o(1) -> constant time complexity
        static void reverseLinkedList_byModifyingData() {
            int start = 0, end = size - 1;
            while (start < end) {
                Node n1 = getNodeAt(start);
                Node n2 = getNodeAt(end);
                //swap
                int temp = n1.data;
                n1.data = n2.data;
                n2.data = temp;
                start++;
                end--;
            }
        }

        static void reverseLinkedList_byModifyingNext() {
            Node prev = null;
            Node curr = head;

            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }

        public static void main(String[] args) {
//            addAt(0, 100);
//            display();
//            addLast(5);
//            addLast(2);
//            System.out.println("getAt => " + getAt(0));
//            removeFirst();
//            display();
//            addLast(9);
//            removeFirst();
//            display();
            addFirst(1);
            addFirst(2);
            addFirst(3);
            addFirst(4);
            addFirst(5);
            addLast(6);
            addLast(7);
            addLast(8);
            display();
//            addAt(4, 100);
            removeLast();
            display();
//            removeLast();
//            display();
//            removeLast();
//            display();
//            removeLast();
//            display();
//            removeLast();
//            display();
//            removeLast();
//            display();
            System.out.println("size => " + size());
            reverseLinkedList_byModifyingData();
            display();
            reverseLinkedList_byModifyingNext();
            display();
            reverseLinkedList_byModifyingNext();
            display();
            reverseLinkedList_byModifyingNext();
            display();
            removeAt(0);
            display();
        }
    }
}
