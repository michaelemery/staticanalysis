package nullness;

/**
 * Check nullness for field set via reflection field access.
 */
public class ReflectField {

    Object foo;

    ReflectField() {
        this.foo = new Object();
    }

    /**
     * Field set to non-null never throws NullPointerException.
     */
    public static void setFooToNonNull() throws Exception {
        ReflectField i = new ReflectField();
        ReflectField.class.getDeclaredField("foo").set(i, new Object());
        i.foo.toString();
    }

    /**
     * Field set to null always throws NullPointerException.
     *
     * @throws NullPointerException Checker should warn on compile.
     */
    public static void setFooToNull() throws Exception {
        ReflectField i = new ReflectField();
        ReflectField.class.getDeclaredField("foo").set(i, null);
        i.foo.toString();
    }
}
