package checker.nullness;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Assign a null reference via dynamic constructor invocation.
 */
public class InvokeDynamicConstructor {

    Object o;

    InvokeDynamicConstructor(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(void.class, Object.class);
        MethodHandle mh = lookup.findConstructor(InvokeDynamicConstructor.class, mt);
        InvokeDynamicConstructor i;

        /* safe: set object to non-null */
        i = (InvokeDynamicConstructor) mh.invoke("safe");
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        i = (InvokeDynamicConstructor) mh.invoke(null);
        System.out.println(i.o.toString());  // NullPointerException
    }
}
