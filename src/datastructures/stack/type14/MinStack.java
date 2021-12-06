package datastructures.stack.type14;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
public class MinStack {

    public static void main(String[] args) {
        MiniStack miniStack = new MiniStack_Optimal();
        miniStack.push(7);
        miniStack.push(2);
        miniStack.push(1);
        System.out.println("Top -> " + miniStack.top());
        System.out.println("Min -> " + miniStack.getMin());
        miniStack.push(1);
        miniStack.print();
        System.out.println("Top -> " + miniStack.top());
        System.out.println("Min -> " + miniStack.getMin());
        miniStack.pop();
        miniStack.pop();
        miniStack.pop();
        miniStack.pop();
        miniStack.push(6);
        System.out.println("Top -> " + miniStack.top());
        System.out.println("Min -> " + miniStack.getMin());
    }

    private interface MiniStack {
        void push(int val);

        void pop();

        int top();

        int getMin();

        default void print() {
        }
    }

    /**
     * TC = O(1)
     * SC = O(2n)
     */
    private static class MinStack_Naive1 implements MiniStack {
        Stack<Integer> stack, msf;

        public MinStack_Naive1() {
            stack = new Stack<>();
            msf = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (msf.isEmpty() || (!msf.isEmpty() && val <= msf.peek())) {
                msf.push(val);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                int previousPeek = stack.pop();
                if (previousPeek == msf.peek()) {
                    msf.pop();
                    return;
                }
            }
            System.out.println("Underflow condition");
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            return -1;
        }

        public int getMin() {
            if (!stack.isEmpty()) {
                return msf.peek();
            }
            return -1;
        }
    }


    private static class MiniStack_Optimal implements MiniStack {
        Stack<Integer> stack;
        int min = 0;

        public MiniStack_Optimal() {
            stack = new Stack<>();
        }

        @Override
        public void push(int val) {
            if (stack.isEmpty()) {
                min = val;
                stack.add(val);
            } else {
                if (min < val) {
                    stack.add(val);
                } else {
//                    decrypted value will be less than min
//                    (val -min) < 0 always
                    int decrypt = val + (val - min);
                    stack.add(decrypt);
                    min = val;
                }
            }
        }

        @Override
        public void pop() {
            if (!stack.isEmpty()) {
                int peek = stack.pop();
                if (peek < min) {
                    min = (2 * min) - peek;
                }
            }
        }

        @Override
        public int top() {
            if (stack.isEmpty()) {
                return -1;
            } else {
                int top = stack.peek();
                if (top < min) {
                    return min;
                }
                return top;
            }
        }

        @Override
        public int getMin() {
            return min;
        }

        public void print() {
            System.out.println("Print -> " + stack);
        }
    }

}
