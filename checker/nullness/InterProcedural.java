package nullness;

/**
 * Inter-procedural assignment to a null reference.
 */
public class Interprocedural {

    String s;

    public Interprocedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // inter-procedural assignment of a non-null reference (correct)
        Interprocedural foo = new Interprocedural(returnReceivedString("text"));
        System.out.println(foo.s.toString());  // "text"

        // inter-procedural assignment of a null reference (fail)
        Interprocedural bar = new Interprocedural(returnReceivedString(null));
        System.out.println(bar.s.toString());  // NullPointerException

    }

    public static String returnReceivedString(String s) {
        return s;
    }

}