package generic;

import java.lang.reflect.Field;

/**
 *  init an object via unsafe.
 *
 *  may result as a FP
 */
public class UnsafeInitialization {

    Foo foo;

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

    public static void allocateInstance() throws Exception{
        UnsafeInitialization i =new UnsafeInitialization();
        i.foo =(Foo)getUnsafe().allocateInstance(Foo.class);
        i.foo.toString();
    }

    public class Foo{
    }
}
