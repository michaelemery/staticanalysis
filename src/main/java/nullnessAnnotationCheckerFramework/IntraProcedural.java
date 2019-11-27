package nullnessAnnotationCheckerFramework;

import org.checkerframework.checker.nullness.qual.*;

/**
 * Check nullness of field set via direct value assignment.
 */
public class IntraProcedural {

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() {
        @Nullable Object foo = new Object();
        foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN)
     * @throws NullPointerException
     */
    public static void setFooToNull() {
        @Nullable Object foo = null;
        foo.toString();
    }
}
