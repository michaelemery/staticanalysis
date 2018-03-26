package nullness;

/**
 * Interprocedural assignment to a null reference.
 */
public class VanillaInterProcedural {

    public static void main(String[] args) throws NullPointerException {
        String s;

        // interprocedural assignment of a non-null reference
        s = returnReceivedString("text");  // safe
        System.out.println(s.toString());  // "text"

        // interprocedural assignment of a null reference (fail)
        s = returnReceivedString(null);  // unsafe
        System.out.println(s.toString());  // NullPointerException
    }

    public static String returnReceivedString(String s) {
        return s;
    }
}
