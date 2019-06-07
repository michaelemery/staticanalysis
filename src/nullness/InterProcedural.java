package nullness;

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
        i.set("safe");
        System.out.println(i.o.toString());

        /* unsafe: set object to null */
        i.set(null);
        System.out.println(i.o.toString());
    }

    public void set(Object obj) {
        this.o = obj;
    }
}