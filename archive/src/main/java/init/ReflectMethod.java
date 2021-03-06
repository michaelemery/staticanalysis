package init;

import java.lang.reflect.Method;

/**
 * Check initialisation of field set via reflective method return.
 */
public class ReflectMethod {

    Object foo;

    ReflectMethod(Object object) throws Exception {
        Method getObject =
                this.getClass().getDeclaredMethod("getObject", Object.class);
        this.foo = getObject.invoke(null, object);
    }

    static Object getObject(Object object) {
        return object;
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Exception {
        new ReflectMethod(new Object()).foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Exception {
        new ReflectMethod(null).foo.toString();
    }
}
