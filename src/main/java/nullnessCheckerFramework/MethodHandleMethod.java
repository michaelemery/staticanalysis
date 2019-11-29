package nullnessCheckerFramework;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Check nullness of local object set by invoking virtual (non-static) method handle.
 */
public class MethodHandleMethod {
    @org.checkerframework.checker.nullness.qual.Nullable
    Object getObject(Object object) {
        return object;
    }

    java.lang.invoke.MethodHandle getMethodHandle(String methodName) throws Exception {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(Object.class, Object.class);
        return lookup.findVirtual(MethodHandleMethod.class, methodName, type);
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() throws Throwable {
        MethodHandleMethod i = new MethodHandleMethod();
        Object foo = i.getMethodHandle("getObject").invoke(i, new Object());
        foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     * @throws NullPointerException
     */
    public static void setFooToNull() throws Throwable {
        MethodHandleMethod i = new MethodHandleMethod();
        Object foo = i.getMethodHandle("getObject").invoke(i, (Object) null);
        foo.toString();
    }
}
