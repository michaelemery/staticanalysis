package nullnessJavax;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * Check nullness of field set by invoking setter method handle.
 */
public class MethodHandleField {

    @javax.annotation.Nullable
    Object foo;

    MethodHandleField() {
        this.foo = new Object();
    }

    static MethodHandle getSetterMethodHandle() throws Exception {
        MethodHandles.Lookup l = MethodHandles.lookup();
        return l.findSetter(MethodHandleField.class, "foo", Object.class);
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() throws Throwable {
        MethodHandleField i = new MethodHandleField();
        getSetterMethodHandle().invoke(i, new Object());
        i.foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     * @throws NullPointerException
     */
    public static void setFooToNull() throws Throwable {
        MethodHandleField i = new MethodHandleField();
        getSetterMethodHandle().invoke(i, null);
        i.foo.toString();
    }
}
