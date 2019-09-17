package generic;

import java.lang.reflect.Method;

/**
 *  generic example of setting a field via reflective method return. It is also a case of aliasing.
 */
public class ReflectMethod {
    Object foo;

    Object getObject(Object object) {
        return object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     *  may result as a FP
     */
    public static void setFooToNonNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Method getObjectMethod =
                i.getClass().getDeclaredMethod("getObject", Object.class);
        i.foo = getObjectMethod.invoke(i, new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Exception {
        ReflectMethod i = new ReflectMethod();
        Method getObjectMethod =
                i.getClass().getDeclaredMethod("getObject", Object.class);
        i.foo = getObjectMethod.invoke(i, (Object) null);
        i.foo.toString();
    }
}
