package oops;

import java.util.Arrays;
import java.util.Stack;

public class Introduction {

    private static void method(String a) {
        System.out.println("string" + a);
    }

    private static void method(Object a) {
        System.out.println("object" + a);
    }

    public static void main(String[] args) {
        char[] arr = "saksham".toCharArray();
        Arrays.sort(arr);
        //    question - method overriding
        method("-> saksham");
        method((Object) "-> saksham");
        method(new Object());
        //10 to the power of 8
        System.out.println(1e8 + 1);

        Stack<Integer> stack = new Stack<>();
        //stack.peek();

        System.out.println(Arrays.toString(missingNumberHelper(new int[]{2,2,3,4,5,4}, 6)));
    }



    private static int[] missingNumberHelper(int[] arr, int len) {
        int size = 0;
        for (int i=0; i<arr.length;) {
            if (arr[i]-1 == i) i++;
            else {
                if (arr[arr[i]-1] == arr[i]) {
                    size++;
                    i++;
                } else {
                    swap(arr, i, arr[i] -1);
                }
            }
        }
        int[] result = new int[size];
        int idx = 0;
        for (int i=0; i<arr.length;i++){
            if (arr[i] != i+1) result[idx++] = i+1;
        }
        return result;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
