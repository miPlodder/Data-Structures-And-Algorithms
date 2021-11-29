package datastructures.stack.type13;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/implement-stack-using-queues/
public class StackUsingQueue {

    private static class StackUsing2Q {

        private Queue<Integer> q1, q2;

        public StackUsing2Q() {
            q1 = new ArrayDeque();
            q2 = new ArrayDeque();
        }

        public void push(int val) {
            q2.add(val);
//          add q1 to q2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
//            copy q2 to q1
            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }

        public int pop() {
            return q1.remove();
        }

        public Integer top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }

        public int size() {
            return q1.size();
        }

    }

    private static class StackUsing1Q {

        private Queue<Integer> q;

        public StackUsing1Q() {
            q = new ArrayDeque<>();
        }

        public void push(int val) {
            q.add(val);
            for (int i = 0; i < size() - 1; i++) {
                q.add(q.remove());
            }
        }

        public int pop() {
            return q.remove();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }

        public int size() {
            return q.size();
        }
    }

    public static void main(String[] args) {
        StackUsing2Q stackUsing2Q = new StackUsing2Q();
        System.out.println("isEmpty -> " + stackUsing2Q.empty());
        stackUsing2Q.push(10);
        stackUsing2Q.push(20);
        stackUsing2Q.push(30);
        System.out.println("Size -> " + stackUsing2Q.size());
        System.out.println("Pop -> " + stackUsing2Q.pop());
        System.out.println("Pop -> " + stackUsing2Q.pop());
        stackUsing2Q.push(40);
        stackUsing2Q.push(50);
        stackUsing2Q.push(60);
        System.out.println("Top -> " + stackUsing2Q.top());
        System.out.println("isEmpty -> " + stackUsing2Q.empty());
        System.out.println("===================================================");
        StackUsing1Q stackUsing1Q = new StackUsing1Q();
        System.out.println("isEmpty -> " + stackUsing1Q.empty());
        stackUsing1Q.push(10);
        stackUsing1Q.push(20);
        stackUsing1Q.push(30);
        stackUsing1Q.push(40);
        System.out.println("Popping -> " + stackUsing1Q.pop());
        System.out.println("Popping -> " + stackUsing1Q.pop());
        System.out.println("Top -> " + stackUsing1Q.top());
        System.out.println("isEmpty -> " + stackUsing1Q.empty());
        System.out.println("Size -> " + stackUsing1Q.size());

    }


}
