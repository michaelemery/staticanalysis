package nullness;

/**
 * Nullness of field set via inter-procedural return.
 */
public class InterProcedural {

    Object foo;

    InterProcedural() {
        this.foo = new Object();
    }

    static Object getObject(Object object) {
        return object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() {
        InterProcedural i = new InterProcedural();
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     *
     * @throws NullPointerException Checker should warn on compile.
     */
    public static void setFooToNull() {
        IntraProcedural i = new IntraProcedural();
        i.foo = getObject(null);
        i.foo.toString();
    }
}
