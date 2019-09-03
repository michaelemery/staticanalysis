package nullness;

/**
 * Check nullness of field set via inter-procedural return.
 */
public class InterProcedural {

    Object foo;

    Object getObject(Object object) {
        return object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() {
        InterProcedural i = new InterProcedural();
        i.foo = i.getObject(new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() {
        InterProcedural i = new InterProcedural();
        i.foo = i.getObject(null);
        i.foo.toString();
    }
}
