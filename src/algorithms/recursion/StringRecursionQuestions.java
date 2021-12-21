package algorithms.recursion;

public class StringRecursionQuestions {

    public static void main(String[] args) {
        System.out.println(skip_ApproachUsingArguments("cccbababbb"));
        System.out.println(skip_ApproachUsingMethodBody("cccbababbb"));
    }

    private static String skip_ApproachUsingArguments(String unprocessed) {
        return skipHelper_ApproachUsingArguments(unprocessed, "");
    }

    private static String skipHelper_ApproachUsingArguments(String unprocessed, String processed) {
        if (unprocessed.isEmpty()) return processed;

        char ch = unprocessed.charAt(0);

        if (ch == 'a')
            return skipHelper_ApproachUsingArguments(unprocessed.substring(1), processed);

        return skipHelper_ApproachUsingArguments(unprocessed.substring(1), processed + ch);
    }

    private static String skip_ApproachUsingMethodBody(String unprocessed) {
        if (unprocessed.isEmpty()) return "";

        char ch = unprocessed.charAt(0);

        if (ch == 'a')
            return skip_ApproachUsingMethodBody(unprocessed.substring(1));

        return ch + skip_ApproachUsingMethodBody(unprocessed.substring(1));
    }
}
