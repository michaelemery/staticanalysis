package checker.nullness;

/**
 * Assign a null reference via intra-procedural assignment.
 */
public class IntraProcedural {

    Object o;

    IntraProcedural(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws NullPointerException {

        /* safe: set object to non-null */
        System.out.println(
                new IntraProcedural("safe").o.toString());  // safe

        /* unsafe: set object to null */
        System.out.println(
                new IntraProcedural(null).o.toString());    // NullPointerException
    }
}
