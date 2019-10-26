package nullness;

/**
 * Check nullness of field set via direct value assignment.
 */
public class IntraProcedural {

    Object foo = new Object();

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() {
        IntraProcedural i = new IntraProcedural();
        i.foo = new Object();
        i.foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN)
     * @throws NullPointerException
     */
    public static void setFooToNull() {
        IntraProcedural i = new IntraProcedural();
        i.foo = null;
        i.foo.toString();
    }
}
