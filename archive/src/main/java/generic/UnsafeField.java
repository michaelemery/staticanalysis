package generic;

import java.lang.reflect.Field;

/**
 *  example of using unsafe api to set the field
 */
public class UnsafeField {

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
     * a FP if it is reported. otherwise a TP
     */
    public static void setFooToNotNull() throws Exception{
        UnsafeField i= new UnsafeField();
        getUnsafe().putObject(i,getUnsafe().objectFieldOffset(UnsafeField.class.getDeclaredField("foo")), new Object());
        i.foo.toString();
    }

    /**
     *  a FN if it is NOT reported, otherwise a TP
     * @throws java.lang.NullPointerException
     */
    public static void setBarToNull() throws Exception{
        UnsafeField i= new UnsafeField();
        getUnsafe().putObject(i,getUnsafe().objectFieldOffset(UnsafeField.class.getDeclaredField("bar")), null);
        i.bar.toString();
    }
}
