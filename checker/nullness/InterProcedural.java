package nullness;

/**
 * InterProcedural assignment to a null reference.
 */
public class InterProcedural {

    String s;

    public InterProcedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // assignment to a non-null reference from method InterProcedural (correct)
        InterProcedural foo = new InterProcedural(returnReceivedString("text"));
        System.out.println(foo.s.toString());  // "text"

        // assignment to a null reference from method InterProcedural (fail)
        InterProcedural bar = new InterProcedural(returnReceivedString(null));
        System.out.println(bar.s.toString());  // NullPointerException

    }

    public static String returnReceivedString(String s) {
        return s;
    }

}