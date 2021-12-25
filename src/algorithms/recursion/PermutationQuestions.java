package algorithms.recursion;

import java.util.ArrayList;

public class PermutationQuestions {

    public static void main(String[] args) {
        permutation_print("", "abc");
        System.out.println();
        System.out.println(permutation_usingArrayList("", "abc"));
        System.out.println(countPermutation("", "abc"));
    }

    private static void permutation_print(String rsf, String ros) {
        if (ros.isEmpty()) {
            System.out.print(rsf + ", ");
            return;
        }
        char ch = ros.charAt(0);
        for (int i = 0; i <= rsf.length(); i++) {
            permutation_print(rsf.substring(0, i) + ch + rsf.substring(i), ros.substring(1));
        }
    }

    private static ArrayList<String> permutation_usingArrayList(String rsf, String ros) {
        ArrayList<String> result = new ArrayList<>();
        if (ros.isEmpty()) {
            result.add(rsf);
            return result;
        }
        char ch = ros.charAt(0);
        for (int i = 0; i <= rsf.length(); i++) {
            ArrayList<String> interimResult = permutation_usingArrayList(rsf.substring(0, i) + ch + rsf.substring(i), ros.substring(1));
            result.addAll(interimResult);
        }
        return result;
    }

    private static int countPermutation(String rsf, String ros) {
        int result = 0;
        if (ros.isEmpty()) {
            return ++result;
        }
        char ch = ros.charAt(0);
        for (int i = 0; i <= rsf.length(); i++) {
            result += countPermutation(rsf.substring(0, i) + ch + rsf.substring(i), ros.substring(1));

        }
        return result;
    }

}
