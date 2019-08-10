package nullness;

/**
 * Assign a null reference via intra-procedural assignment.
 */
public class IntraProcedural {

    Object object;

    IntraProcedural(Object obj) {
        this.object = obj;
        System.out.println(this.object.toString());
    }

    public static void main(String[] args) throws NullPointerException {
        IntraProcedural i = new IntraProcedural("init");

        /* safe: set object to non-null */
        i.object = "safe";
        System.out.println(i.object.toString());

        /* unsafe: set object to null */
        i.object = null;
        System.out.println(i.object.toString());
    }
}
