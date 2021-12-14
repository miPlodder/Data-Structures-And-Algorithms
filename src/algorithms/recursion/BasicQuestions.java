package algorithms.recursion;

import java.util.ArrayList;

public class BasicQuestions {

    public static void main(String[] args) {
        System.out.println("Sum Of Digits => " + sumOfDigits(43564));
        System.out.println("Reverse Number => " + reverseNumber(4356, 0));
        System.out.println("Is Palindrome => " + isPalindrome("nitin", 0, 4));
        System.out.println("Is Palindrome => " + isPalindrome("saksham", 0, 6));
        System.out.println("Count Zeroes In Number => " + countZeroesInNumber(10203040));
        System.out.println("Is Array Sorted => " + isArraySorted(new int[]{1, 3, 5, 7, 9}, 0));
        System.out.println("Is Array Sorted => " + isArraySorted(new int[]{1, 3, 6, 5, 7, 9}, 0));
        System.out.println("Is Array Sorted 2 => " + isArraySorted2(new int[]{1, 3, 5, 7, 9}, 0));
        System.out.println("Is Array Sorted 2 => " + isArraySorted2(new int[]{1, 3, 6, 5, 7, 9}, 0));
        System.out.println("Linear Search => " + linearSearch(new int[]{1, 3, 6, 5, 7, 9}, 3, 0));
        System.out.println("Linear Search => " + linearSearch(new int[]{1, 3, 6, 5, 7, 9}, 10, 0));
        ArrayList<Integer> al = new ArrayList<>();
        findAllOccurance(new int[]{1, 3, 4, 1, 5, 1, 1}, 1, al, 0);
        System.out.println("find All Occurences => " + al);
    }

    private static int sumOfDigits(int num) {
        if (num == 0) return 0;
        return num % 10 + sumOfDigits(num / 10);
    }

    private static int reverseNumber(int num, int rev) {
        if (num == 0) return rev;
        return reverseNumber(num / 10, (num % 10) + rev * 10);
    }

    private static boolean isPalindrome(String str, int start, int end) {
        if (start > end) return true;
        return (str.charAt(start) == str.charAt(end)) ? isPalindrome(str, start + 1, end - 1) : false;
    }

    private static int countZeroesInNumber(int N) {
        if (N == 0) return 0;
        return (N % 10 == 0) ? 1 + countZeroesInNumber(N / 10) : countZeroesInNumber(N / 10);
    }

    private static boolean isArraySorted(int[] array, int index) {
        if (index == array.length - 1) return true;
        return (array[index] < array[index + 1]) ? isArraySorted(array, index + 1) : false;
    }

    /**
     * && is used here, since if any comparison is false, then array is not sorted
     */
    private static boolean isArraySorted2(int[] array, int index) {
        if (index == array.length - 1) return true;
        return (array[index] < array[index + 1]) && isArraySorted2(array, index + 1);
    }

    /**
     * || is used here, since if any comparison is true, then target is found
     */
    private static boolean linearSearch(int[] array, int target, int index) {
        if (index == array.length) return false;
        return array[index] == target || linearSearch(array, target, index + 1);
    }

    private static void findAllOccurance(int[] array, int target, ArrayList<Integer> al, int index) {
        if (array.length == index) return;
        if (array[index] == target) al.add(index);
        findAllOccurance(array, target, al, index + 1);
    }
}
