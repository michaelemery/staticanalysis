package nullness;

/**
 * Inter-procedural assignment to a null reference.
 */
public class InterVanilla {

    String s;

    public InterVanilla(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // inter-procedural assignment of a non-null reference (correct)
        InterVanilla foo = new InterVanilla(returnReceivedString("text"));
        System.out.println(foo.s.toString());  // "text"

        // inter-procedural assignment of a null reference (fail)
        InterVanilla bar = new InterVanilla(returnReceivedString(null));
        System.out.println(bar.s.toString());  // NullPointerException

    }

    public static String returnReceivedString(String s) {
        return s;
    }

}