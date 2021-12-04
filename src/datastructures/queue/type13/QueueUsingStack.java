package datastructures.queue.type13;

import java.util.Stack;

//https://leetcode.com/problems/implement-queue-using-stacks/
public class QueueUsingStack {

    public static void main(String[] args) {
        Queue q = new AmortizedQueue();
        q.pop();
        q.peek();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.print();
        System.out.println(q.pop());
        q.print();
        System.out.println(q.peek());
        q.push(4);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.pop());
        q.print();
    }

    private interface Queue {
        void push(int x);

        int pop();

        int peek();

        boolean isEmpty();

        void print();
    }

    private static class NaiveQueue implements Queue {
        Stack<Integer> stack;

        public NaiveQueue() {
            stack = new Stack<>();
        }

        public void push(int x) {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty())
                temp.push(stack.pop());

            temp.push(x);
            while (!temp.isEmpty())
                stack.push(temp.pop());
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Q is empty, no pop");
                return -1;
            }
            return stack.pop();
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Q is empty, no peek");
                return -1;
            }
            return stack.peek();
        }

        public boolean isEmpty() {
            return (stack.size() == 0);
        }

        public void print() {
            System.out.println(stack.toString());
        }
    }

    //    Amortized means in the majority of the cases TC is O(1), and minority of cases TC is O(N)
    private static class AmortizedQueue implements Queue {
        Stack<Integer> input, output;

        public AmortizedQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        @Override
        public void push(int x) {
            input.push(x);
        }

        @Override
        public int pop() {
            if (isEmpty()) {
                System.out.println("Q is empty");
                return -1;
            }
            if (!output.isEmpty()) {
                return output.pop();
            }
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.pop();
        }

        @Override
        public int peek() {
            if (isEmpty()) {
                System.out.println("Q is empty");
                return -1;
            }
            if (!output.isEmpty()) {
                return output.peek();
            }
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.peek();
        }

        @Override
        public boolean isEmpty() {
            return input.size() + output.size() == 0;
        }

        @Override
        public void print() {
            System.out.println(output.toString() + ", " + input.toString());
        }
    }
}
