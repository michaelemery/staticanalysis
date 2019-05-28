package checker.nullness;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Assignment of a null reference via method handles constructor.
 */
public class MethodHandlesConstructor {

    Object o;

    MethodHandlesConstructor(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(void.class, Object.class);
        MethodHandle mh = lookup.findConstructor(MethodHandlesConstructor.class, mt);
        MethodHandlesConstructor i;

        /* safe: set object to non-null */
        i = (MethodHandlesConstructor) mh.invoke("safe");
        System.out.println(i.o.toString());

        /* unsafe: set object to null */
        i = (MethodHandlesConstructor) mh.invoke(null);
        System.out.println(i.o.toString());
    }
}
