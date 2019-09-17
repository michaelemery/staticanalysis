package generic;

import java.lang.reflect.Field;

/**
 *  example of using unsafe api to set the field
 */
public class UnsafeField {

    Object foo;

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
     * may result as a FP
     * @throws Exception
     */
    public static void setFooToNotNull() throws Exception{
        UnsafeField i= new UnsafeField();
        getUnsafe().putObject(i,getUnsafe().objectFieldOffset(UnsafeField.class.getDeclaredField("foo")), new Object());
        i.foo.toString();
    }

    /**
     *  throw NullPointerException
     * @throws Exception
     */
    public static void setFooToNull() throws Exception{
        UnsafeField i= new UnsafeField();
        getUnsafe().putObject(i,getUnsafe().objectFieldOffset(UnsafeField.class.getDeclaredField("foo")), null);
        i.foo.toString();
    }
}
