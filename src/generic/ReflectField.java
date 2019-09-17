package generic;

/**
 *  generic example of setting a field via reflective field access.
 */
public class ReflectField {

    Object foo;

    /**
     * Field set to non-null never throws NullPointerException.
     *  may result as a FP
     */
    public static void setFooToNonNull() throws Exception {
        ReflectField i = new ReflectField();
        ReflectField.class.getDeclaredField("foo").set(i, new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     */
    public static void setFooToNull() throws Exception {
        ReflectField i = new ReflectField();
        ReflectField.class.getDeclaredField("foo").set(i, null);
        i.foo.toString();
    }
}
