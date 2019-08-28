package init;

/**
 * Check initialisation of field set via direct value assignment.
 */
public class IntraProcedural {

    Object foo;

    IntraProcedural(Object object) {
        this.foo = object;
    }

    // field is accessed before initialised
    IntraProcedural(Object object, int x) {
        this.foo.toString();
        this.foo = object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() {
        new IntraProcedural(new Object()).foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() {
        new IntraProcedural(null).foo.toString();
    }

    /**
     * Field accessed before set always throws NullPointerException.
     */
    public static void accessFooBeforeSet() {
        new IntraProcedural(new Object(), 1);
    }
}
