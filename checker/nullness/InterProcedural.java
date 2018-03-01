package nullness;

/**
 * Inter-procedural assignment to a null reference.
 */
public class InterProcedural {

    String s;

    public InterProcedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // inter-procedural assignment of a non-null reference (correct)
        InterProcedural foo = new InterProcedural(returnReceivedString("text"));
        System.out.println(foo.s.toString());  // "text"

        // inter-procedural assignment of a null reference (fail)
        InterProcedural bar = new InterProcedural(returnReceivedString(null));
        System.out.println(bar.s.toString());  // NullPointerException

    }

    public static String returnReceivedString(String s) {
        return s;
    }

}