package nullnessAnnotationCheckerFramework;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Check nullness of field set via inter-procedural return.
 */
public class InterProcedural {

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() {
        @NonNull Object foo = getObject(new Object());
        foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     * @throws NullPointerException
     */
    public static void setFooToNull() {
        @NonNull Object foo = getObject(null);
        foo.toString();
    }

    static Object getObject(Object object) {
        return object;
    }
}