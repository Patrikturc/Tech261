package sparta.com.pt;

public class ExceptionCreator {
    static void getException() throws ArithmeticException {
        System.out.println(1 / 0);
    }

    public static void getCheckedException() throws InterruptedException {
        throw new InterruptedException("Checked Exception");
    }
}