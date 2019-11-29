package nullnessJavax;

/**
 * Check nullness of field set via dynamic invocation of setter method.
 */
public class InvokeDynamic {

    @javax.annotation.Nullable
    Object getFoo(Object foo) {
        return foo;
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() {
        InvokeDynamic i = new InvokeDynamic();
        java.util.function.Function<Object,Object> c = foo -> i.getFoo(foo);
        Object foo=c.apply(new Object());
        foo.toString();

    }

    /**
     * a FN if it is NOT reported, otherwise a TP
     *
     * @throws NullPointerException
     */
    public static void setFooToNull() {
        InvokeDynamic i = new InvokeDynamic();
        java.util.function.Function<Object,Object> c = foo -> i.getFoo(foo);
        Object foo=c.apply(null);
        foo.toString();
    }
}
