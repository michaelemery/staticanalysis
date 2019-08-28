package init;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Check initialisation of field set via dynamic invocation of a constructor.
 */
public class InvokeDynamicConstructor {

    Object foo;

    InvokeDynamicConstructor(Object object) throws Throwable {
        this.foo = object;
        this.foo.toString();
    }

    static MethodHandle getConstructorMethodHandle() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(void.class, Object.class);
        return lookup.findConstructor(InvokeDynamicConstructor.class, methodType);
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Throwable {
        getConstructorMethodHandle().invoke(new Object());
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Throwable {
        getConstructorMethodHandle().invoke(null);
    }
}
