public class App {
    public static void main(String[] args) {
        Spartan spartan1 = new Spartan("Manish", "Gadhvi");
        Spartan spartan2 = new Spartan("Manish", "Gadhvi");

        System.out.println(spartan1 == spartan2);
        System.out.println(spartan1.equals(spartan2));
        System.out.println(spartan1.hashCode());
        System.out.println(spartan2.hashCode());
    }
}
