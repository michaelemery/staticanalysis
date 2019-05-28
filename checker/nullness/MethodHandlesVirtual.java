package checker.nullness;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Assignment of a null reference via method handles (virtual).
 */
public class MethodHandlesVirtual {

    Object o;

    MethodHandlesVirtual(Object obj) {
        this.o = obj;
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(void.class, Boolean.class);
        java.lang.invoke.MethodHandle mh =
                lookup.findVirtual(MethodHandlesVirtual.class, "set", mt);
        MethodHandlesVirtual i = new MethodHandlesVirtual("init");

        /* safe: set object to non-null */
        mh.invoke(i, true);
        System.out.println(i.o.toString());  // safe

        /* unsafe: set object to null */
        mh.invoke(i, true);
        System.out.println(i.o.toString());  // NullPointerException
    }

    void set(Boolean safe) {
        this.o = safe ? "safe" : null;
    }
}
