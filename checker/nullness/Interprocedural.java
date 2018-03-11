package nullness;

/**
 * Interprocedural assignment to a null reference.
 */
public class Interprocedural {

    public static void main(String[] args) throws NullPointerException {
        String s;

        // interprocedural assignment of a non-null reference (correct)
        s = returnReceivedString("text");
        System.out.println(s.toString());  // "text"

        // interprocedural assignment of a null reference (fail)
        s = returnReceivedString(null);
        System.out.println(s.toString());  // NullPointerException

    }

    public static String returnReceivedString(String s) {
        return s;
    }
}
