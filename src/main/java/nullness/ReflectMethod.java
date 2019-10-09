package nullness;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.lang.reflect.Method;

/**
 * Check nullness of field set via reflection method invocation.
 */
public class ReflectMethod {

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
                i.getClass().getDeclaredMethod("getObject");
        @NonNull Object foo = new Object();
        foo = getObjectMethod.invoke(i);
        foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Method getObjectMethod =
                i.getClass().getDeclaredMethod("getNull");
        @NonNull Object foo = new Object();
        foo = getObjectMethod.invoke(i);
        foo.toString();
    }
}
