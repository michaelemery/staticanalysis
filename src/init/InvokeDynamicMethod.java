package init;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Check initialisation of a field via dynamic invocation of a static method.
 */
public class InvokeDynamicMethod {

    Object foo;

    InvokeDynamicMethod(Object object) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(Object.class, Object.class);
        MethodHandle getObjectMethodHandle = lookup.findStatic(InvokeDynamicMethod.class,
                "getObject", methodType);
        this.foo = getObjectMethodHandle.invoke(object);
    }

    static Object getObject(Object object) {
        return object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Throwable {
        new InvokeDynamicMethod(new Object()).foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Throwable {
        new InvokeDynamicMethod(null).foo.toString();
    }
}
