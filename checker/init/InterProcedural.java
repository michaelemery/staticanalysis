package checker.init;

/**
 * Initialise with a null reference via intra-procedural assignment.
 */

public class InterProcedural {

    Object o;

    public InterProcedural() {
        this.o = "safe";
        System.out.println(this.o);  // safe
    }

    public InterProcedural(int x) {
        m();  // NullPointerException
        o = new InterProcedural();
    }

    public void m() {
        System.out.println(this.o.toString());
    }

    public static void main(String[] args) {

        /* safe: set object to non-null */
        new InterProcedural();

        /* unsafe: set object to null */
        new InterProcedural(1);
    }
}