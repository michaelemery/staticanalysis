package init;

/**
 * Check initialisation of field set via inter-procedural return.
 */
public class InterProcedural {

    Object foo;

    InterProcedural(Object object) {
        this.foo = getObject(object);
    }

    // field is accessed before initialised
    InterProcedural(Object object, int x) {
        this.foo.toString();
        this.foo = getObject(object);
    }

    static Object getObject(Object object) {
        return object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() {
        new InterProcedural(new Object()).foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() {
        new InterProcedural(null).foo.toString();
    }

    /**
     * Field accessed before set always throws NullPointerException.
     */
    public static void accessFooBeforeSet() {
        new InterProcedural(new Object(), 1).foo.toString();
    }
}
