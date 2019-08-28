package init;

import java.lang.reflect.Field;

/**
 * Initialisation of field set via reflective field access.
 */
public class ReflectField {

    Object foo;

    ReflectField(Object object) throws NoSuchFieldException, IllegalAccessException {
        Class<?> C = this.getClass();
        Field objectField = C.getDeclaredField("foo");
        objectField.set(this, object);
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Exception {
        new ReflectField(new Object()).foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     *
     * @throws NullPointerException Checker should warn on compile.
     */
    public static void setFooToNull() throws Exception {
        new ReflectField(null).foo.toString();
    }
}
