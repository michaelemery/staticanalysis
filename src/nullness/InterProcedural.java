package nullness;

/**
 * Check nullness of field set via inter-procedural return.
 */
public class InterProcedural {

    Object foo;

    static Object getObject(Object object) {
        return object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() {
        InterProcedural i = new InterProcedural();
        i.foo = getObject(new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() {
        IntraProcedural i = new IntraProcedural();
        i.foo = getObject(null);
        i.foo.toString();
    }
}
