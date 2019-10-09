package nullness;

import java.lang.reflect.Method;

/**
 * Check nullness of field set via reflection method invocation.
 */
public class ReflectMethod {

    Object foo;

    Object getObject() {
        return new Object();
    }

    Object getNull() {
        return null;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Method getObjectMethod =
                i.getClass().getDeclaredMethod("getObject", Object.class);
        i.foo = getObjectMethod.invoke(i);
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Method getObjectMethod =
                i.getClass().getDeclaredMethod("getNull", Object.class);
        i.foo = getObjectMethod.invoke(i);
        i.foo.toString();
    }
}
