package nullness;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Check nullness for field set via dynamic virtual (non-static) method invocation.
 */
public class InvokeDynamicMethod {

    Object foo;

    void setFoo(Object object) {
        this.foo = object;
    }

    static MethodHandle getSetFooMethodHandle() throws Exception {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(void.class, Object.class);
        return lookup.findVirtual(InvokeDynamicMethod.class, "setFoo", type);
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Throwable {
        InvokeDynamicMethod i = new InvokeDynamicMethod();
        getSetFooMethodHandle().invoke(i, new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Throwable {
        InvokeDynamicMethod i = new InvokeDynamicMethod();
        getSetFooMethodHandle().invoke(i, (Object) null);
        i.foo.toString();
    }
}
