package oops;

public class Introduction {

    private static void method(String a) {
        System.out.println("string" + a);
    }

    private static void method(Object a) {
        System.out.println("object" + a);
    }

    public static void main(String[] args) {
//    question - method overriding
        method("-> saksham");
        method((Object) "-> saksham");
        method(new Object());
        //10 to the power of 8
        System.out.println(1e8 + 1);
    }


}
