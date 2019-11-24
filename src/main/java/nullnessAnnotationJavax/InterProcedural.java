package nullnessAnnotationJavax;

/**
 * Check nullness of field set via inter-procedural return.
 */
public class InterProcedural {

    @javax.annotation.Nullable
    Object getObject(Object object) {
        return object;
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() {
        InterProcedural i = new InterProcedural();
        Object foo = i.getObject(new Object());
        foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     * @throws NullPointerException
     */
    public static void setFooToNull() {
        InterProcedural i = new InterProcedural();
        Object foo = i.getObject(null);
        foo.toString();
    }
}