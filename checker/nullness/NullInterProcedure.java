package nullness;

/**
 * Inter-Procedural assignment to a null reference.
 */
public class NullInterProcedure {

    String s;

    public NullInterProcedure(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // inter-procedural assignment of a non-null reference (correct)
        NullInterProcedure foo = new NullInterProcedure(returnReceivedString("text"));
        System.out.println(foo.s.toString());  // "text"

        // inter-procedural assignment of a null reference (fail)
        NullInterProcedure bar = new NullInterProcedure(returnReceivedString(null));
        System.out.println(bar.s.toString());  // NullPointerException

    }

    public static String returnReceivedString(String s) {
        return s;
    }

}