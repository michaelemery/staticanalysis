package nullness;

import java.lang.reflect.Method;

/**
 * Check nullness for field set via reflection method invocation.
 */
public class ReflectMethod {

    Object foo;

    ReflectMethod() {
        this.foo = new Object();
    }

    static Object getObject(Object object) {
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
     *
     * @throws NullPointerException Checker should warn on compile.
     */
    public static void setFooToNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Class<?> C = i.getClass();
        Method getObjectMethod = C.getDeclaredMethod("getObject", Object.class);
        i.foo = getObjectMethod.invoke(i, (Object) null);
        i.foo.toString();
    }
}
