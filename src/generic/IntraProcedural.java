package generic;

/**
 * Check nullness for field set via direct value assignment.
 */
public class IntraProcedural {

    Object foo;
    Object bar=new Object();

    /**
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNonNull() {
        IntraProcedural i = new IntraProcedural();
        i.foo = new Object();
        i.foo.toString();
    }

    /**
     *  a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() {
        IntraProcedural i = new IntraProcedural();
        i.bar = null;
        i.bar.toString();
    }
}
