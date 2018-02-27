package nullness;

/**
 * Intra-Procedural assignment of a null reference.
 */
public class NullIntraProcedure {

    String s;

    public NullIntraProcedure(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // intra-procedural assignment of a non-null reference (correct)
        NullIntraProcedure foo = new NullIntraProcedure("text");
        System.out.println(foo.s.toString());  // "text"

        // intra-procedural assignment of a null reference (fail)
        foo = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}