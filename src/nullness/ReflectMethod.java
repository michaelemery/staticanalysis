package nullness;

import java.lang.reflect.Method;

/**
 * Check nullness of field set via reflection method invocation.
 */
public class ReflectMethod {

    Object foo;

    Object getObject(Object object) {
        return object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Class<?> C = i.getClass();
        Method getObjectMethod = C.getDeclaredMethod("getObject", Object.class);
        i.foo = getObjectMethod.invoke(i, new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Class<?> C = i.getClass();
        Method getObjectMethod = C.getDeclaredMethod("getObject", Object.class);
        i.foo = getObjectMethod.invoke(i, (Object) null);
        i.foo.toString();
    }
}
