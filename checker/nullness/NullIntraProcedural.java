package nullness;

/**
 * Intra-Procedural assignment of a null reference.
 */
public class NullIntraProcedural {

    String s;

    public NullIntraProcedural(String s) {
        this.s = s;
    }

    public static void main(String[] args) throws NullPointerException {

        // intra-procedural assignment of a non-null reference (correct)
        NullIntraProcedural foo = new NullIntraProcedural("text");
        System.out.println(foo.s.toString());  // "text"

        // intra-procedural assignment of a null reference (fail)
        foo = null;
        System.out.println(foo.s.toString());  // NullPointerException

    }

}