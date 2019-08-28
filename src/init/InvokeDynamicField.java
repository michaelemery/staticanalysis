package init;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * Check initialisation of a field via dynamic invocation of a field set.
 */
public class InvokeDynamicField {

    Object foo;

    InvokeDynamicField(Object object) throws Throwable {
        getSetterMethodHandle().invoke(this, object);
        this.foo.toString();
    }

    static MethodHandle getSetterMethodHandle() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        return lookup.findSetter(InvokeDynamicField.class, "foo", Object.class);
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Throwable {
        new InvokeDynamicField(new Object());
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Throwable {
        new InvokeDynamicField(null);
    }
}
