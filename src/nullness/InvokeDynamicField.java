package nullness;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * Nullness for field set via dynamic field access invocation.
 */
public class InvokeDynamicField {

    Object foo;

    InvokeDynamicField() {
        this.foo = new Object();
    }

    static MethodHandle getSetterMethodHandle() throws Exception {
        MethodHandles.Lookup l = MethodHandles.lookup();
        return l.findSetter(InvokeDynamicField.class, "foo", Object.class);
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Throwable {
        InvokeDynamicField i = new InvokeDynamicField();
        getSetterMethodHandle().invoke(i, new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Throwable {
        InvokeDynamicField i = new InvokeDynamicField();
        getSetterMethodHandle().invoke(i, null);
        i.foo.toString();
    }
}
