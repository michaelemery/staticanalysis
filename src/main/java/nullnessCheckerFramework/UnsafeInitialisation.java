package nullnessCheckerFramework;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Allocate an empty instance of a class directly on the heap via sun.misc.Unsafe.
 */
public class UnsafeInitialisation {
    @org.checkerframework.checker.nullness.qual.Nullable
    Object foo;

    UnsafeInitialisation() {
        this.foo = new Object();
    }

    private static Unsafe getUnsafe() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() {
        new UnsafeInitialisation().foo.toString();
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     *
     * @throws NullPointerException
     */
    public static void setFooToNull() throws Exception {
        UnsafeInitialisation i = (UnsafeInitialisation) getUnsafe().
                allocateInstance(UnsafeInitialisation.class);
        i.foo.toString();
    }
}
