package nullnessAnnotationJavax;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Check nullness of field set by invoking constructor method handle.
 */
public class MethodHandleConstructor {
    @javax.annotation.Nullable
    Object foo;

    MethodHandleConstructor(Object object) {
        this.foo = object;
    }

    static MethodHandle getConstructorMethodHandle() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, Object.class);
        return lookup.findConstructor(MethodHandleConstructor.class, methodType);
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() throws Throwable {
        MethodHandleConstructor i = (MethodHandleConstructor)
                getConstructorMethodHandle().invoke(new Object());
        i.foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     * @throws NullPointerException
     */
    public static void setFooToNull() throws Throwable {
        MethodHandleConstructor i = (MethodHandleConstructor)
                getConstructorMethodHandle().invoke(null);
        i.foo.toString();
    }
}
