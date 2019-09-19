package generic;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Check nullness for field set via direct value assignment.
 */
public class IntraProcedural {

    @NonNull Object foo;// must be non null
    @Nullable Object bar= new Object(); //either null or non null
    @Nullable Object bar2; //either null or non null


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

    public static void setBar2ToNonNull() {
        IntraProcedural i = new IntraProcedural();
        i.bar2 = new Object();
        i.bar2.toString();
    }
}
