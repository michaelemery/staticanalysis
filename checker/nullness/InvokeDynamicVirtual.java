package checker.nullness;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Assign a null reference via dynamic virtual (non-static) method invocation.
 */
public class InvokeDynamicVirtual {

    Object o;

    InvokeDynamicVirtual(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(void.class, Boolean.class);
        java.lang.invoke.MethodHandle mh =
                lookup.findVirtual(InvokeDynamicVirtual.class, "set", mt);
        InvokeDynamicVirtual i = new InvokeDynamicVirtual("init");

        /* safe: set object to non-null */
        mh.invoke(i, true);
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        mh.invoke(i, null);
        System.out.println(i.o.toString());  // NullPointerException
    }

    void set(Boolean safe) {
        this.o = safe ? "safe" : null;
    }
}
