package nullness;

/**
 * Check nullness of field set via dynamic invocation of setter method.
 */
public class InvokeDynamic {

    Object foo = new Object();

    void setFoo(Object foo) {
        this.foo = foo;
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() {
        InvokeDynamic i = new InvokeDynamic();
        java.util.function.Consumer<Object> c = foo -> i.setFoo(new Object());
        c.accept(new Object());
        i.foo.toString();
    }

    /**
     * a FN if it is NOT reported, otherwise a TP
     *
     * @throws NullPointerException
     */
    public static void setFooToNull() {
        InvokeDynamic i = new InvokeDynamic();
        java.util.function.Consumer<Object> c = foo -> i.setFoo(null);
        c.accept(new Object());
        i.foo.toString();
    }
}
