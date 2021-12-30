package oops;

public class Introduction {

    private static void method(String a){
        System.out.println("string");
    }

    private static void method(Object a){
        System.out.println("object");
    }

    public static void main(String[] args) {
        method((Object)"");
        method(new Object());
    }


}
