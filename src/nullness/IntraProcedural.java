package nullness;

/**
 * Nullness for field set via direct value assignment.
 */
public class IntraProcedural {

    Object foo;

    IntraProcedural() {
        this.foo = new Object();
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() {
        IntraProcedural i = new IntraProcedural();
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     *
     * @throws NullPointerException Checker should warn on compile.
     */
    public static void setFooToNull() {
        IntraProcedural i = new IntraProcedural();
        i.foo = null;
        i.foo.toString();
    }
}
