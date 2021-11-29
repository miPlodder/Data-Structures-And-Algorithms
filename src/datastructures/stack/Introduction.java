package datastructures.stack;

public class Introduction {

    private static class Stack {
        int[] nums;
        int top;

        public Stack(int initialCapacity) {
            nums = new int[initialCapacity];
            top = -1;
        }

        public void push(int val) {
            if (top == nums.length - 1) {
                System.out.println("Stack is full");
                return;
            }
            nums[++top] = val;
        }

        public int pop() {
            if (top == -1) {
                System.out.println("Stack is empty");
                return -1;
            }
            return nums[top--];
        }

        public int top() {
            return nums[top];
        }

        public int size() {
            return top + 1;
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        System.out.println("Popping => " + stack.pop());
        System.out.println("isEmpty => " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println("Top => " + stack.top());
        System.out.println("isEmpty => " + stack.isEmpty());
        System.out.println("Popping => " + stack.pop());
        System.out.println("Popping => " + stack.pop());
        System.out.println("Size => " + stack.size());
        System.out.println("Popping => " + stack.pop());
        System.out.println("Popping => " + stack.pop());
        System.out.println("Popping => " + stack.pop());
    }

}
