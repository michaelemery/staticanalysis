package checker.nullness;

/**
 * Assign a null reference via inter-procedural assignment.
 */
public class InterProcedural {

    Object o;

    InterProcedural() {
        this.o = "init";
    }

    public static void main(String[] args) throws NullPointerException {
        InterProcedural i = new InterProcedural();

        /* safe: set object to non-null */
        i.set(true);
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        i.set(false);
        System.out.println(i.o.toString());  // NullPointerException
    }

    public void set(Boolean safe) {
        this.o = safe ? "safe" : null;
    }
}