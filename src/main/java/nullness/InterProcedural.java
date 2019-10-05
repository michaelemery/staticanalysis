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
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() {
        InterProcedural i = new InterProcedural();
        i.foo = i.getObject(new Object());
        i.foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     * @throws NullPointerException
     */
    public static void setFooToNull() {
        InterProcedural i = new InterProcedural();
        i.foo = i.getObject(null);
        i.foo.toString();
    }
}
