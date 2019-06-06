package checker.nullness;

import java.lang.invoke.MethodHandle;
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
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle h = l.findVirtual(InvokeDynamicVirtual.class, "set", t);
        InvokeDynamicVirtual i = new InvokeDynamicVirtual("init");

        /* safe: set object to non-null */
        h.invoke(i, "safe");

        /* unsafe: set object to null */
        h.invoke(i, null);
    }

    void set(Object obj) {
        this.o = obj;
        System.out.println(this.o.toString());
    }
}
