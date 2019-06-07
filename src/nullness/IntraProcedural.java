package nullness;

/**
 * Assign a null reference via intra-procedural assignment.
 */
public class IntraProcedural {

    Object o;

    IntraProcedural(Object obj) {
        this.o = obj;
        System.out.println(this.o.toString());
    }

    public static void main(String[] args) throws NullPointerException {
        IntraProcedural i = new IntraProcedural("init");

        /* safe: set object to non-null */
        i.o = "safe";
        System.out.println(i.o.toString());

        /* unsafe: set object to null */
        i.o = null;
        System.out.println(i.o.toString());
    }
}
