package nullness;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Check nullness of field set by invoking virtual (non-static) method handle.
 */
public class MethodHandleMethod {

    Object foo;

    void setFoo(Object object) {
        this.foo = object;
    }

    java.lang.invoke.MethodHandle getSetFooMethodHandle() throws Exception {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(void.class, Object.class);
        return lookup.findVirtual(MethodHandleMethod.class, "setFoo", type);
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() throws Throwable {
        MethodHandleMethod i = new MethodHandleMethod();
        i.getSetFooMethodHandle().invoke(i, new Object());
        i.foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     * @throws NullPointerException
     */
    public static void setFooToNull() throws Throwable {
        MethodHandleMethod i = new MethodHandleMethod();
        i.getSetFooMethodHandle().invoke(i, (Object) null);
        i.foo.toString();
    }
}
