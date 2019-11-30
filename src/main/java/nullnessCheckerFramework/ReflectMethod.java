package nullnessCheckerFramework;

import java.lang.reflect.Method;

/**
 * Check nullness of local object set via reflection method invocation.
 */
public class ReflectMethod {

    @org.checkerframework.checker.nullness.qual.Nullable
    Object getObject(Object object) {
        return object;
    }

    /**
     * Local object set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Method getObjectMethod =
                i.getClass().getDeclaredMethod("getObject", Object.class);
        Object foo = getObjectMethod.invoke(i, new Object());
        foo.toString();
    }

    /**
     * Local object set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Method getObjectMethod =
                i.getClass().getDeclaredMethod("getObject", Object.class);
        Object foo = getObjectMethod.invoke(i, (Object) null);
        foo.toString();
    }
}
