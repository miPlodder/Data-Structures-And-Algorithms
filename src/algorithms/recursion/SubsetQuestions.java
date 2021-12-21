package algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetQuestions {

    public static void main(String[] args) {
        subset_recursive1_byPrinting("abc", "");
        System.out.println();
        ArrayList<String> al = new ArrayList<>();
        subset_recursive2_usingArrayListAsArgument("abc", "", al);
        System.out.println(al);
        System.out.println(subset_recursive3_returningArrayListAndNoArgument("abc", ""));
        System.out.println(subset_PresentOrNotPresentOrAsciiPresent("abc", ""));
        System.out.println(subset_IterativeSolution("abc"));
        System.out.println(subset_IterativeSolution2(new int[]{1, 2, 3}));
        System.out.println(subset_withDuplicate_Iterative(new int[]{1, 2, 3, 2}));
    }

    private static void subset_recursive1_byPrinting(String ros, String rsf) {
        if (ros.isEmpty()) {
            System.out.print(rsf + ", ");
            return;
        }
        char ch = ros.charAt(0);
        subset_recursive1_byPrinting(ros.substring(1), rsf + ch);
        subset_recursive1_byPrinting(ros.substring(1), rsf);
    }

    private static void subset_recursive2_usingArrayListAsArgument(String ros, String rsf, ArrayList<String> al) {
        if (ros.isEmpty()) {
            al.add(rsf);
            return;
        }
        char ch = ros.charAt(0);
        subset_recursive2_usingArrayListAsArgument(ros.substring(1), rsf, al);
        subset_recursive2_usingArrayListAsArgument(ros.substring(1), rsf + ch, al);
    }

    private static ArrayList<String> subset_recursive3_returningArrayListAndNoArgument(String ros, String rsf) {
        if (ros.isEmpty()) {
            ArrayList<String> al = new ArrayList<>();
            al.add(rsf);
            return al;
        }
        char ch = ros.charAt(0);
        ArrayList<String> left = subset_recursive3_returningArrayListAndNoArgument(ros.substring(1), rsf + ch);
        ArrayList<String> right = subset_recursive3_returningArrayListAndNoArgument(ros.substring(1), rsf);

        left.addAll(right);
        return left;
    }

    private static ArrayList<String> subset_PresentOrNotPresentOrAsciiPresent(String ros, String rsf) {
        if (ros.isEmpty()) {
            ArrayList<String> al = new ArrayList<>();
            al.add(rsf);
            return al;
        }
        char ch = ros.charAt(0);
        ArrayList<String> left = subset_PresentOrNotPresentOrAsciiPresent(ros.substring(1), rsf + ch);
        ArrayList<String> mid = subset_PresentOrNotPresentOrAsciiPresent(ros.substring(1), rsf);
        /**
         * (ch+0) -> converts character to ASCII
         */
        ArrayList<String> right = subset_PresentOrNotPresentOrAsciiPresent(ros.substring(1), rsf + (ch + 0));

        left.addAll(mid);
        left.addAll(right);
        return left;
    }

    private static ArrayList<String> subset_IterativeSolution(String input) {
        ArrayList<String> result = new ArrayList<>();
        result.add("");
        for (char ch : input.toCharArray()) {
            ArrayList<String> secondPart = new ArrayList<>();
            for (String item : result) {
                secondPart.add(item + ch);
            }
            result.addAll(secondPart);
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> subset_IterativeSolution2(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int val : arr) {
            ArrayList<ArrayList<Integer>> secondPart = new ArrayList<>();
            for (ArrayList<Integer> item : result) {
                ArrayList<Integer> al = new ArrayList<>(item);
                al.add(val);
                secondPart.add(al);
            }
            result.addAll(secondPart);
        }
        return result;
    }

    private static ArrayList<ArrayList<Integer>> subset_withDuplicate_Iterative(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            if (i > 0 && arr[i - 1] == arr[i]) j = result.size() / 2;
            ArrayList<ArrayList<Integer>> secondPart = new ArrayList<>();
            for (; j < result.size(); j++) {
                ArrayList<Integer> al = new ArrayList<>(result.get(j));
                al.add(arr[i]);
                secondPart.add(al);
            }
            result.addAll(secondPart);
        }
        return result;
    }

}
