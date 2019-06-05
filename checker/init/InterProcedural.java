package checker.init;

/**
 * Initialise with a null reference via intra-procedural assignment.
 */

public class InterProcedural {

    Object o;

    public InterProcedural() {
        this.o = "safe";
    }

    public InterProcedural(int x) {
        m();
        o = new Object();
    }

    public void m() {
        this.o.toString();
    }

    public static void main(String[] args) {

        /* safe: set object to non-null */
        System.out.println(
                new InterProcedural().o.toString());  // safe

        /* safe: set object to non-null */
        System.out.println(
                new InterProcedural(1).o.toString());  // NullPointerException
    }
}