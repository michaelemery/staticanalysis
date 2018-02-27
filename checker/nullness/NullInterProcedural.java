package nullness;

/**
 * Inter-Procedural assignment to a null reference.
 */
public class NullInterProcedural {

    String s;

    public NullInterProcedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // inter-procedural assignment of a non-null reference (correct)
        NullInterProcedural foo = new NullInterProcedural(returnReceivedString("text"));
        System.out.println(foo.s.toString());  // "text"

        // inter-procedural assignment of a null reference (fail)
        NullInterProcedural bar = new NullInterProcedural(returnReceivedString(null));
        System.out.println(bar.s.toString());  // NullPointerException

    }

    public static String returnReceivedString(String s) {
        return s;
    }

}