package example;

public class StringExample {

    public static void main(String[] args) {



        String string1 = "Hello";
        String string2 = "Hello";
        String string3 = "Hello";
        String string4 = "Hello";

        string1.toUpperCase(); //Strings are immutable so must create a new object of String
        string1 = string1.toUpperCase(); //immutable
        String upperString1 = string1.toUpperCase();
        System.out.println(string1);

        System.out.println(string1.toCharArray());

        String string = String.valueOf(100);

        String name = "Manish";
        System.out.println("Hello " + name);

        System.out.println(string1.hashCode());
        System.out.println(string2.hashCode());
        System.out.println(string3.hashCode());
        System.out.println(string4.hashCode());
        System.out.println("");
        System.out.println(string1 == string3);
        System.out.println(string1.equals(string3));
        System.out.println(System.identityHashCode(string1));
        System.out.println(System.identityHashCode(string2));
        System.out.println(System.identityHashCode(string3));
        System.out.println(System.identityHashCode(string4));

        //new StringBuilder().reverse();
    }

}
