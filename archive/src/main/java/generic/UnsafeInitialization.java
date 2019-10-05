package generic;

import java.lang.reflect.Field;

/**
 *  allocate an empty instance of a given class directly on the heap, ignoring field initialization and constructors.
 */
public class UnsafeInitialization {
    Object foo;
    Object bar=new Object();


    public static sun.misc.Unsafe getUnsafe() {
        sun.misc.Unsafe unsafe = null;
        try {
            Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);

            unsafe = (sun.misc.Unsafe) f.get(null);
        } catch (Exception e) {
        }
        return unsafe;
    }
    /**
     * a FN if it is NOT reported. otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void allocateEmptyInstance1() throws Exception{
        UnsafeInitialization i= (UnsafeInitialization)getUnsafe().allocateInstance(UnsafeInitialization.class);
        i.bar.toString();
    }

    /**
     * It is a TP because the initial state of UnsafeInitialization.foo is null
     * @throws java.lang.NullPointerException
     */
    public static void allocateEmptyInstance2() throws Exception{
        UnsafeInitialization i= (UnsafeInitialization)getUnsafe().allocateInstance(UnsafeInitialization.class);
        i.foo.toString();
    }
}
