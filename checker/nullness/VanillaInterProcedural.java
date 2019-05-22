package checker.nullness;

/**
 * Interprocedural assignment to a null reference.
 */
public class VanillaInterProcedural {

    public static void main(String[] args) throws NullPointerException {
        String s;

        // interprocedural assignment of a non-null reference
        s = returnReceivedString("text");  // safe
        System.out.println(s.toString());  // "text"

        // interprocedural assignment of a null reference
        s = returnReceivedString(null);  // unsafe
        System.out.println(s.toString());  // NullPointerException
    }

    private static String returnReceivedString(String s) {
        return s;
    }
}
