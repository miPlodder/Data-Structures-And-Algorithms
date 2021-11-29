package datastructures.queue;

import java.util.Arrays;

public class Introduction {

    private static class Queue {

        private int[] nums;
        private int front = 0, rear = -1;
        private int size = 0;

        public Queue(int initialCapacity) {
            nums = new int[initialCapacity];
        }

        public void enqueue(int x) {
            if (size == nums.length) {
                System.out.println("Queue's capacity is full");
                return;
            }
            nums[++rear % nums.length] = x;
            size++;
        }

        public int dequeue() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            size--;
            front++;
            int temp = nums[(front - 1) % nums.length];
            nums[(front - 1) % nums.length] = -1;
            return temp;
        }

        public int peek() {
            if (size == 0) {
                return -1;
            }
            return nums[front % nums.length];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void print() {
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        System.out.println("Dequeue -> " + queue.dequeue());
        queue.enqueue(10);
        //System.out.println("Peek -> " + queue.peek());
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Dequeue -> " + queue.dequeue());
        System.out.println("Peek -> " + queue.peek());
        System.out.println("Size -> " + queue.size);
        System.out.println("Dequeue -> " + queue.dequeue());
        System.out.println("Dequeue -> " + queue.dequeue());
        queue.enqueue(50);
        System.out.println("Size -> " + queue.size());
        queue.print();
        queue.enqueue(60);
        queue.print();
        queue.enqueue(70);
        queue.print();
        queue.enqueue(80);
        queue.print();
        queue.enqueue(80);
        queue.print();
        System.out.println("Dequeue -> " + queue.dequeue());
        queue.print();
        System.out.println("Dequeue -> " + queue.dequeue());
        queue.print();
        System.out.println("Dequeue -> " + queue.dequeue());
        queue.print();
        System.out.println("Dequeue -> " + queue.dequeue());
        queue.print();
        queue.enqueue(90);
        queue.print();
        queue.enqueue(100);
        queue.print();
        queue.enqueue(110);
        queue.print();
        System.out.println("Peek -> " + queue.peek());
    }
}
