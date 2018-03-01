package nullness;

/**
 * Intra-procedural assignment of a null reference.
 */
public class IntraVanilla {

    String s;

    public IntraVanilla(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // intra-procedural assignment of a non-null reference (correct)
        IntraVanilla foo = new IntraVanilla("text");
        System.out.println(foo.s.toString());  // "text"

        // intra-procedural assignment of a null reference (fail)
        foo = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}