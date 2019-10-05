package generic;

/**
 *  generic example of setting a field via reflective field access.
 */
public class ReflectField {

    Object foo;
    Object bar =new Object();

    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNonNull() throws Exception {
        ReflectField i = new ReflectField();
        ReflectField.class.getDeclaredField("foo").set(i, new Object());
        i.foo.toString();
    }

    /**
     *  a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() throws Exception {
        ReflectField i = new ReflectField();
        ReflectField.class.getDeclaredField("bar").set(i, null);
        i.bar.toString();
    }
}
