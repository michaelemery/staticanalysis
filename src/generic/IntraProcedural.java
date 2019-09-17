package generic;

/**
 * Check nullness for field set via direct value assignment.
 */
public class IntraProcedural {

    Object foo;

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() {
        IntraProcedural i = new IntraProcedural();
        i.foo = new Object();
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() {
        IntraProcedural i = new IntraProcedural();
        i.foo = null;
        i.foo.toString();
    }
}
