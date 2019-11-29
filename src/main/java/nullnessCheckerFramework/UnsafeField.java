package nullnessCheckerFramework;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Check nullness of field set via sun.misc.Unsafe.
 */
public class UnsafeField {
    @org.checkerframework.checker.nullness.qual.Nullable
    Object foo;

    private static Unsafe getUnsafe() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    /**
     * False Positive (FP) if checker reports null warning.
     */
    public static void setFooToNonNull() throws Exception {
        UnsafeField i = new UnsafeField();
        getUnsafe().putObject(
                i, getUnsafe().objectFieldOffset(
                        UnsafeField.class.getDeclaredField("foo")), new Object());
    }

    /**
     * True Positive (TP) if checker reports null warning, else False Negative (FN).
     *
     * @throws NullPointerException
     */
    public static void setFooToNull() throws Exception {
        UnsafeField i = new UnsafeField();
        getUnsafe().putObject(
                i, getUnsafe().objectFieldOffset(
                        UnsafeField.class.getDeclaredField("foo")), null);
    }
}
